package com;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.List;
import bean.TeacherBean;
import dao.TeacherDao;
public class ShowTeacher extends HttpServlet{
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
    out.println("<title>All Teacher</title>");
    out.println("<link rel='stylesheet' href='./T-Style4.css'/>");
    out.println("<link rel='stylesheet' href='./resourses/lib/w3.css'/>");
    out.println("<script src='./popup.js' charset='utf-8'></script>");
    out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
    out.println("</head>");
    out.println("<body>");
    out.println("<div class='nav-top'>");
    out.println("<a id='home' href='./Teacher.html'>Home</a>");
    out.println("<a id='login' href='./AdminHome.html'>Admin</a>");
    out.println("</div>");
    out.println("<div class='side-nav'><ul class='s-menu'>");
    out.println("<li><a href=RegisterTeacher.html>Register</a></li>");
    out.println("<li><a href=showteacher>View Teachers</a></li>");
    out.println("<li><a href=SearchTeacher.html>Search Teacher</a></li>");
    out.println("<li><a href=UpdateTeacher.html>Update Teacher</a></li>");
    out.println("<li><a href=RemoveTeacher.html>Remove Teacher</a></li>");
    out.println("<li><a onclick='popup()'>Available Teachers</a></li>");
    out.println("<li><a onclick='popup()'>Removed Teacher</a></li>");
    out.println("<li><a onclick='popup()'>Teachers Activities</a></li>");
    out.println("<li><a onclick='popup()'>Teacher Responsbility</a></li>");
    out.println("<li><a onclick='popup()'>Teacher Salary Manage</a></li>");
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
    out.println("<th>INSTITUTE</th>");
    out.println("<th>SUBJECT</th>");
    out.println("<th>QUALIFICATION</th>");
    out.println("<th>EXPERIENCE</th>");
    out.println("<th>DOB</th>");
    out.println("<th>SALARY</th>");
    out.println("<th>ACTIVITY</th>");
    out.println("</tr>");
    List<TeacherBean> list=TeacherDao.getAllRecords();
    for (TeacherBean bean:list) {
      out.print("<tr><td>"+bean.getID()+"</td><td>"+bean.getFirstName()+"</td><td>"+bean.getLastName()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getMobile()+"</td><td>"+bean.getAddress()+"</td><td>"+bean.getInstitute()+"</td><td>"+bean.getSubject()+"</td><td>"+bean.getQualification());
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
