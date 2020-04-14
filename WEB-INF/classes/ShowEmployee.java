package com;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.List;
import bean.EmployeeBean;
import dao.EmployeeDao;
public class ShowEmployee extends HttpServlet{
  public void init()
  {

  }
  public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();
    out.println("<!DOCTYPE html>");
    out.println("<html>");
    out.println("<head>");
    out.println("<title>All Employee</title>");
    out.println("<link rel='stylesheet' href='./E-Style5.css'/>");
    out.println("<link rel='stylesheet' href='./resourses/lib/w3.css'/>");
    out.println("<script src='./popup.js' charset='utf-8'></script>");
    out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
    out.println("</head>");
    out.println("<body>");
    out.println("<div class='nav-top'>");
    out.println("<a id='home' href='./Employee.html'>Home</a>");
    out.println("<a id='login' href='./AdminHome.html'>Admin</a>");
    out.println("</div>");
    out.println("<div class='side-nav'><ul class='s-menu'>");
    out.println("<li><a href=RegisterEmp.html>Register</a></li>");
    out.println("<li><a href=showemployee>View Employees</a></li>");
    out.println("<li><a href=SearchEmployee.html>Search Employee</a></li>");
    out.println("<li><a href=UpdateEmployee.html>Update Employee</a></li>");
    out.println("<li><a href=RemoveEmployee.html>Remove Employee</a></li>");
    out.println("<li><a onclick='popup()'>Employee Activities</a></li>");
    out.println("<li><a onclick='popup()'>Removed Employee</a></li>");
    out.println("<li><a onclick='popup()'>Available Employees</a></li>");
    out.println("<li><a onclick='popup()'>Employees Profile Status</a></li>");
    out.println("<li><a onclick='popup()'>Employee Salary Manage</a></li>");
    out.println("</ul>");
    out.println("</div>");
    out.println("<div class='containter'>");

    out.println("<table id='usertable'>");
    out.println("<tr>");
    out.println("<th>ID</th>");
    out.println("<th>FIRSTNAME</th>");
    out.println("<th>LASTNAME</th>");
    out.println("<th>EMAIL</th>");
    out.println("<th>MOBILE</th>");
    out.println("<th>ADDRESS</th>");
    out.println("<th>DEPARTMENT</th>");
    out.println("<th>POST</th>");
    out.println("<th>QUALIFICATION</th>");
    out.println("<th>EXPERIENCE</th>");
    out.println("<th>DOB</th>");
    out.println("<th>SALARY</th>");
    out.println("<th>ACTIVITY</th>");
    out.println("</tr>");
    List<EmployeeBean> list=EmployeeDao.getAllRecords();
    for (EmployeeBean bean:list) {
      out.print("<tr><td>"+bean.getID()+"</td><td>"+bean.getFirstName()+"</td><td>"+bean.getLastName()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getMobile()+"</td><td>"+bean.getAddress()+"</td><td>"+bean.getDepartment()+"</td><td>"+bean.getPost()+"</td><td>"+bean.getQualification());
      out.print("</td><td>"+bean.getExperience()+"</td><td>"+bean.getDob()+"</td><td>"+bean.getSalary()+"</td><td>"+bean.getActivity()+"</td><tr>");
  }
    out.println("</table>");
    out.println("</div>");
    out.println("<div class='footer'>");
    out.println("<a href='#'>www.apsu.ac.in</a>");
    out.println("</div>");
    out.println("</body>");
    out.println("</html>");
  }

  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    doPost(req,res);
  }
}
