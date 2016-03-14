using System;
using System.Collections.Generic;
using System.Linq;
using System.ComponentModel.DataAnnotations;
using System.Web;

namespace MVCAnalytics.Models
{
    public class Employee
    {
        public int EmpId { get; set; }

        
        public string EmpName { get; set; }

        public string ContactNumber { get; set; }

        public string Address { get; set; }
    }
}