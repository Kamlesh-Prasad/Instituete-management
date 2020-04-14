package com;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.List;
import bean.UserBean;
import dao.UserDao;
public class ShowUser extends HttpServlet{
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
    out.println("<title>All Users</title>");
    out.println("<link rel='stylesheet' href='./U-Style3.css'/>");
    out.println("<link rel='stylesheet' href='./resourses/lib/w3.css'>");
    out.println("<script src='./popup.js' charset='utf-8'></script>");
    out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");

    out.println("</head>");
    out.println("<body>");
    out.println("<div class='nav-top'>");
    out.println("<a id='home' href='./Userbuild.html'>Home</a>");
    out.println("<a id='login' href='./AdminHome.html'>Admin</a>");
    out.println("</div>");
    out.println("<div class='side-nav'><ul class='s-menu'>");
    out.println("<li><a href=RegisterUser.html>Register</a></li>");
    out.println("<li><a href=showuser>View Users</a></li>");
    out.println("<li><a href=SearchUser.html>Search User</a></li>");
    out.println("<li><a href=UpdateUser.html>Update User</a></li>");
    out.println("<li><a href=RemoveUser.html>Remove Users</a></li>");
    out.println("<li><a onclick='popup()'>Users Activities</a></li>");
    out.println("<li><a onclick='popup()'>Available Users</a></li>");
    out.println("<li><a onclick='popup()'>Removed Users</a></li>");
    out.println("<li><a onclick='popup()'>User Responsbility</a></li>");
    out.println("<li><a onclick='popup()'>Users Data Control</a></li>");
    out.println("</ul>");
    out.println("</div>");
    out.println("<div class='containter'>");

    out.println("<table id='usertable'>");
    out.println("<tr>");
    out.println("<th>ID</th>");
    out.println("<th>First Name</th>");
    out.println("<th>last Name</th>");
    out.println("<th>Email</th>");
    out.println("<th>Mobile</th>");
    out.println("<th>Address</th>");
    out.println("<th>Place</th>");
    out.println("<th>Username</th>");
    out.println("<th>Password</th>");
    out.println("</tr>");
    List<UserBean> list=UserDao.getAllRecords();
    for (UserBean bean:list) {
      out.print("<tr><td>"+bean.getID()+"</td><td>"+bean.getFirstName()+"</td><td>"+bean.getLastName()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getMobile()+"</td><td>"+bean.getAddress()+"</td><td>"+bean.getPlace()+"</td><td>"+bean.getUsername()+"</td><td>"+bean.getPassword()+"</td></tr>");
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
