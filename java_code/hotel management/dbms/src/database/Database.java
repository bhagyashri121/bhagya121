/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

/**
 *
 * @author arghya das
 */
import java.sql.*;
public class Database
{
	public static void main(String args[])
	{
		Connection conn=null;
		String driver,usr,passwd,jdbcUrl,create_table,insert;
		Statement stmt;
		PreparedStatement pstmt;
                                      int ret,room; 
		try
		{
			driver="oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);
			jdbcUrl="jdbc:oracle:thin:@localhost:1521:ORCL";
			usr="arghya";
			passwd="pass";
			System.out.println("Connecting to database........");
			conn=DriverManager.getConnection(jdbcUrl,usr,passwd);
			stmt=conn.createStatement();
			System.out.println("Creating guest table....");
			create_table="create table guest"+
			"(id number primary key,"+
			"name varchar2(50) not null,"+
                                                          "address varchar2(100) not null,"+
			"contact number not null,"+
			"arrival date not null,"+
			"noar number not null,"+
			"nosr number not null,"+
                                                          "tr number not null,"+
			"checkedout char(1) not null"+
			")";
			ret=stmt.executeUpdate(create_table);
			System.out.println("Creating price table....");
			create_table="create table price"+
			"(id number primary key,"+
			"cost number(4) not null"+
                                                          ")";
			ret=stmt.executeUpdate(create_table);
			System.out.println("Creating room table....");
			create_table="create table room"+
			"(no number(3) primary key,"+
			"p_id number references price(id),"+
                                                          "check_in char(1) not null"+
                                                          ")";
			ret=stmt.executeUpdate(create_table);
                                                          System.out.println("Creating map table....");
			create_table="create table map"+
			"(gid number references guest(id),"+
			"rno number(3) references room(no),"+
                                                          "departure date,"+
                                                          "primary key(gid,rno)"+
                                                          ")";
			ret=stmt.executeUpdate(create_table);
                                                          System.out.println("Creating food table....");
			create_table="create table food"+
			"(id number primary key,"+
			"name varchar2(50) not null unique,"+
                                                          "cost number not null"+
                                                          ")";
			ret=stmt.executeUpdate(create_table);
                                                          System.out.println("Creating res table....");
			create_table="create table res"+
			"(rno number references room(no),"+
			"fid number references food(id),"+
                                                          "paid char(1) not null,"+
                                                          "primary key(rno,fid)"+
                                                          ")";
			ret=stmt.executeUpdate(create_table);
                                                          System.out.println("Creating employee table....");
			create_table="create table employee"+
			"(id number primary key,"+
			"name varchar2(50) not null,"+
                                                          "login varchar2(10) not null unique,"+
                                                          "password varchar2(10) not null"+
                                                          ")";
			ret=stmt.executeUpdate(create_table);
                                                          System.out.println("Inserting data to food table.............");
                                                          insert = "insert into food values(?,?,?)";
                                                          pstmt=conn.prepareStatement(insert);
                                                          pstmt.setInt(1,1);
                                                          pstmt.setString(2,"Chicken Manchurian");
                                                          pstmt.setInt(3,150);
                                                          pstmt.executeUpdate();
                                                          pstmt.setInt(1,2);
                                                          pstmt.setString(2,"French Fries");
                                                          pstmt.setInt(3,50);
			pstmt.executeUpdate();
                                                          pstmt.setInt(1,3);
                                                          pstmt.setString(2,"Kadai Paneer");
                                                          pstmt.setInt(3,120);
			pstmt.executeUpdate();
                                                          System.out.println("Inserting data to employee table.............");
                                                          insert = "insert into employee values(?,?,?,?)";
                                                          pstmt=conn.prepareStatement(insert);
                                                          pstmt.setInt(1,1);
                                                          pstmt.setString(2,"Abir Atarthy");
                                                          pstmt.setString(3,"atarthy");
                                                          pstmt.setString(4,"123");
                                                          pstmt.executeUpdate();
                                                          System.out.println("Inserting data to price table.............");
                                                          insert="insert into price values(?,?)";
			pstmt=conn.prepareStatement(insert);
                                                          pstmt.setInt(1,1);
                                                          pstmt.setInt(2,1000);
                                                          pstmt.executeUpdate();
                                                          pstmt.setInt(1,2);
                                                          pstmt.setInt(2,1200);
                                                          pstmt.executeUpdate();
                                                          pstmt.setInt(1,3);
                                                          pstmt.setInt(2,1500);
                                                          pstmt.executeUpdate();
			System.out.println("Inserting data to room table.............");
			insert="insert into room values(?,?,?)";
			pstmt=conn.prepareStatement(insert);
			for(int i=1;i<=3;++i){
                                                                for(int j=1;j<=10;++j){
                                                                    room=((i*100)+j);
                                                                    pstmt.setInt(1,room);
                                                                    pstmt.setInt(2,i);
                                                                    pstmt.setString(3,"F");
                                                                    pstmt.executeUpdate();
                                                                }
                                                         }
                                                         stmt.close();
                                                         pstmt.close();
		}
		catch(SQLException se)
		{
			se.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
