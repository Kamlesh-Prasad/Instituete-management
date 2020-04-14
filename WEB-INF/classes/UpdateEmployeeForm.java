package com;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.List;
import bean.EmployeeBean;
import dao.EmployeeDao;
public class UpdateEmployeeForm extends HttpServlet{
  public void init()
  {

  }
  public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();
    int employeeid=Integer.parseInt(req.getParameter("employeeid"));
    EmployeeBean bean=null;
    boolean status;
      if(employeeid!=0)
      {
        System.out.println("SearchEmployee() employeeid= "+employeeid);
        bean=EmployeeDao.getRecordById(employeeid);
      }
      System.out.println("UpdateEmployeeForm Bean= "+bean.getStatus());
      status=bean.getStatus();
      if(status)
      {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>All Employee</title>");
      out.println("<link rel='stylesheet' href='./E-Style6.css'/>");
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
      out.println("<div class='register'>");
      out.println("<form action='updateemployee' method='post'>");
      out.println("<label>First Name</label>");
      out.println("<input type='text' id='firstname' name='firstname' value="+bean.getFirstName()+">");
      out.println("<label>Last Name</label>");
      out.println("<input type='text' id='lastname' name='lastname' value="+bean.getLastName()+">");
      out.println("<br>");
      out.println("<label>Email-ID</label>");
      out.println("<input type='email' id='email' name='email' value="+bean.getEmail()+">");
      out.println("<label>Mobile</label>");
      out.println("<input type='number' id='mobile' name='mobile' value="+bean.getMobile()+">");
      out.println("<br>");
      out.println("<label for='lname'>Address</label>");
      out.println("<input type='text' id='address' name='address' value="+bean.getAddress()+">");
      out.println("<label for='lname'>Department</label>");
      out.println("<input type='text' id='department' name='department' value="+bean.getDepartment()+">");
      out.println("<br>");
      out.println("<label for='lname'>Posts</label>");
      out.println("<input type='text' id='post' name='post' value="+bean.getPost()+">");
      out.println("<label for='lname'>Qualification&nbsp;&nbsp;</label>");
      out.println("<input type='text' id='qualification' name='qualification' value="+bean.getQualification()+">");
      out.println("<br>");
      out.println("<label for='lname'>Experience</label>");
      out.println("<input type='text' id='experience' name='experience' value="+bean.getExperience()+">");
      out.println("<label for='lname'>Date of Birth</label>");
      out.println("<input type='text' id='dob' name='dob' value="+bean.getDob()+">");
      out.println("<br>");
      out.println("<label for='lname'>Salary</label>");
      out.println("<input type='text' id='salary' name='salary' value="+bean.getSalary()+">");
      out.println("<label for='lname'>Activity</label>");
      out.println("<input type='text' id='activity' name='activity' value="+bean.getActivity()+">");
      out.println("<br>");
      out.println("<br>");
      out.println("<input type='submit' id='submit' value='Update'>");
      out.println("<input type='reset' id='Reset' value='Reset'>");
      out.println("</form>");
      out.println("</div>");
      out.println("</div>");
      out.println("<div class='footer'>");
      out.println("<a href='#'>www.apsu.ac.in</a>");
      out.println("</div>");
      out.println("</body>");
      out.println("</html>");
      }
      else
      {
      RequestDispatcher rd=req.getRequestDispatcher("/UpdateEmployee.html");
      rd.include(req,res);
      }
  }//method

  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    doPost(req,res);
  }
}
