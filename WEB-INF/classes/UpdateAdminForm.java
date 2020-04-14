package com;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.List;
import bean.AdminBean;
import dao.AdminDao;
public class UpdateAdminForm extends HttpServlet{
  public void init()
  {

  }
  public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();
    String adminid=req.getParameter("adminid");
    AdminBean bean=null;
    boolean status;
      if(adminid!=null&&!adminid.equals(""))
      {
        int aid=Integer.parseInt(adminid);
        System.out.println("UpdateAdminForm adminid= "+aid);
        bean=AdminDao.getRecordById(aid);
      }
      System.out.println("UpdateAdminForm Bean= "+bean.getStatus());
      status=bean.getStatus();
      if(status)
      {
      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>All Admin</title>");
      out.println("<link rel='stylesheet' href='./style3.css'/>");
      out.println("<link rel='stylesheet' href='./resourses/lib/w3.css'>");
      out.println("<script src='./popup.js' charset='utf-8'></script>");
      out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
      out.println("</head>");
      out.println("<body>");
      out.println("<div class='nav-top'>");
      out.println("<a id='home' href='./AdminHome.html'>Home</a>");
      out.println("<a id='login' href='./'>Login</a>");
      out.println("</div>");
      out.println("<div class='side-nav'><ul class='s-menu'>");
      out.println("<li><a href=RegisterAdmin.html>Register</a></li>");
      out.println("<li><a href=showadmin>View Admins</a></li>");
      out.println("<li><a href=SearchAdmin.html>Search Admin</a></li>");
      out.println("<li><a href=UpdateAdmin.html>Update Admin</a></li>");
      out.println("<li><a href=RemoveAdmin.html>Remove Admins</a></li>");
      out.println("<li><a onclick='popup()'>Admins Activities</a></li>");
      out.println("<li><a onclick='popup()'>Available Admins</a></li>");
      out.println("<li><a onclick='popup()'>Removed Admin</a></li>");
      out.println("<li><a onclick='popup()'>Admin Responsbility</a></li>");
      out.println("<li><a onclick='popup()'>Admins Data Control</a></li>");
      out.println("</ul>");
      out.println("</div>");
      out.println("<div class='containter'>");
      out.println("<div class='register'>");
      out.println("<form action='updateadmin' method='post'>");
      out.println("<input type='hidden' id='fname' name='adminid' value="+bean.getID()+">");
      out.println("<label>First Name</label>");
      out.println("<input type='text' id='fname' name='firstname' value="+bean.getFirstName()+">");
      out.println("<label>Last Name</label>");
      out.println("<input type='text' id='fname' name='lastname' value="+bean.getLastName()+">");
      out.println("<br>");
      out.println("<label>Email-ID&nbsp;&nbsp;&nbsp;</label>");
      out.println("<input type='email' id='fname' name='email' value="+bean.getEmail()+">");
      out.println("<label>Mobile&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>");
      out.println("<input type='number' id='fname' name='mobile' value="+bean.getMobile()+">");
      out.println("<br>");
      out.println("<label>Username&nbsp;</label>");
      out.println("<input type='text' id='fname' name='username' value="+bean.getUsername()+">");
      out.println("<label>Password &nbsp;</label>");
      out.println("<input type='password' id='fname' name='password' value="+bean.getPassword()+">");
      out.println("<br>");
      out.println("<label>Address&nbsp;&nbsp;&nbsp;&nbsp;</label>");
      out.println("<input type='text' id='fname' name='address' value="+bean.getAddress()+">");
      out.println("<label>Place &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</label>");
      out.println("<input type='text' id='fname' name='place' value="+bean.getPlace()+">");
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
      RequestDispatcher rd=req.getRequestDispatcher("/UpdateAdmin.html");
      rd.include(req,res);
      }
  }//method

  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    doPost(req,res);
  }
}
