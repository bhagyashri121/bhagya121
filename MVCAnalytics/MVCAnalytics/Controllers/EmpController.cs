using MVCAnalytics.Models;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Web;
using System.Web.Mvc;


namespace MVCAnalytics.Controllers
{
    public class EmpController : Controller
    {
        private SqlConnection con;
        private void connection()
        {
            string constr = ConfigurationManager.ConnectionStrings["MyCon"].ToString();
            con = new SqlConnection(constr);
        }

        //
        // GET: /Emp/
        public ActionResult Index()
        {
            connection();
            List<Employee> EmployeeList = new List<Employee>();
            SqlCommand com = new SqlCommand("GetEmployeeDetails", con);
            com.CommandType = CommandType.StoredProcedure;
            SqlDataAdapter da = new SqlDataAdapter(com);
            DataTable dt = new DataTable();
            con.Open();
            da.Fill(dt);
            con.Close();

            //Bind Employeegeneric list using LINQ 
            EmployeeList = (from DataRow dr in dt.Rows
                            select new Employee()
                               {
                                   EmpId = Convert.ToInt32(dr["EmpId"]),
                                   EmpName = Convert.ToString(dr["EmpName"]),
                                   ContactNumber = Convert.ToString(dr["ContactNumber"]),
                                   Address = Convert.ToString(dr["Address"]),
                               }).ToList();

            ViewBag.Message = TempData["Message"];

            return View(EmployeeList);

        }


        //
        // GET: /Emp/Details/5
        public ActionResult Details(int id)
        {
            connection();
            List<Employee> EmployeeList = new List<Employee>();
            SqlCommand com = new SqlCommand("GetEmployeeDetails", con);
            com.CommandType = CommandType.StoredProcedure;
            SqlDataAdapter da = new SqlDataAdapter(com);
            DataTable dt = new DataTable();
            con.Open();
            da.Fill(dt);
            con.Close();
            EmployeeList = (from DataRow dr in dt.Rows
                            select new Employee()
                            {
                                EmpId = Convert.ToInt32(dr["EmpId"]),
                                EmpName = Convert.ToString(dr["EmpName"]),
                                ContactNumber = Convert.ToString(dr["ContactNumber"]),
                                Address = Convert.ToString(dr["Address"]),
                            }).ToList();

            Employee EmployeeDetails = new Employee();
            EmployeeDetails = EmployeeList.Find(Emp => Emp.EmpId == id);

            return View(EmployeeDetails);

        }

        //
        // GET: /Emp/Create
        public ActionResult Create()
        {
            return View();
        }

        //
        // POST: /Emp/Create
        [HttpPost]
        public ActionResult Create(Employee employee)
        {
            try
            {
                // TODO: Add insert logic here

                connection();
                SqlCommand com = new SqlCommand("spGetMVCAnalytics1", con);
                com.CommandType = CommandType.StoredProcedure;
                com.Parameters.AddWithValue("@EmpId", employee.EmpId);
                com.Parameters.AddWithValue("@EmpName", employee.EmpName);
                com.Parameters.AddWithValue("@Address", employee.Address);
                com.Parameters.AddWithValue("@ContactNumber", employee.ContactNumber);

                con.Open();
                int i = com.ExecuteNonQuery();
                con.Close();
                if (i < 1)
                {
                    ViewBag.Message = "Successfully Created";
                }
                else
                {
                    ViewBag.Message = "Failed";
                    return RedirectToAction("Create");
                }

                return RedirectToAction("Create");
            }
            catch
            {
                return View();
            }
        }

        //
        // GET: /Emp/Edit/5
        public ActionResult Edit(int id)
        {
            connection();
            List<Employee> EmployeeList = new List<Employee>();
            SqlCommand com = new SqlCommand("GetEmployeeDetails", con);
            com.CommandType = CommandType.StoredProcedure;
            SqlDataAdapter da = new SqlDataAdapter(com);
            DataTable dt = new DataTable();
            con.Open();
            da.Fill(dt);
            con.Close();

            //Bind Employeegeneric list using LINQ 
            EmployeeList = (from DataRow dr in dt.Rows
                            select new Employee()
                            {
                                EmpId = Convert.ToInt32(dr["EmpId"]),
                                EmpName = Convert.ToString(dr["EmpName"]),
                                ContactNumber = Convert.ToString(dr["ContactNumber"]),
                                Address = Convert.ToString(dr["Address"]),
                            }).ToList();

            Employee EmployeeDetails = new Employee();
            EmployeeDetails = EmployeeList.Find(Emp => Emp.EmpId == id);

            return View(EmployeeDetails);

        }

        //
        // POST: /Emp/Edit/5
        [HttpPost]
        public ActionResult Edit(int id, Employee empEdit)
        {
            try
            {
                // TODO: Add insert logic here

                connection();
                SqlCommand com = new SqlCommand("spGetMVCAnalyticsEdit", con);
                com.CommandType = CommandType.StoredProcedure;
                com.Parameters.AddWithValue("@EmpId", empEdit.EmpId);
                com.Parameters.AddWithValue("@EmpName", empEdit.EmpName);
                com.Parameters.AddWithValue("@Address", empEdit.Address);
                com.Parameters.AddWithValue("@ContactNumber", empEdit.ContactNumber);
                con.Open();

                int i = com.ExecuteNonQuery();
                con.Close();
                if (i < 1)
                {
                    TempData["Message"] = "Successfully Updated";
                }
                else
                {
                    TempData["Message"] = "Failed";
                    return RedirectToAction("Index");
                }

                return RedirectToAction("Index");
            }
            catch
            {
                return View();
            }
        }

        //
        // GET: /Emp/Delete/5    
        public ActionResult Delete(int EmpId)
        {
            
            try
            {
                // TODO: Add delete logic here
                connection();
                SqlCommand com = new SqlCommand("spGetMVCAnalyticsDelete", con);
                com.CommandType = CommandType.StoredProcedure;
                com.Parameters.AddWithValue("@EmpId", EmpId);
                con.Open();
                int i = com.ExecuteNonQuery();
                con.Close();

                if (i < 1)
                {
                    TempData["Message"] = "Successfully Deleted";
                }
                else
                {
                    TempData["Message"] = "Failed";
                    return RedirectToAction("Index");
                }

                return RedirectToAction("Index");

            }

            catch(Exception x)
            {
                return RedirectToAction("Index");
            }
        }
    }
}
  
