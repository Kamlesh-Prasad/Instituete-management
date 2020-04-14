package com;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.List;
import bean.UserBean;
import dao.UserDao;
public class UpdateUserForm extends HttpServlet{
  public void init()
  {

  }
  public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();
    String userid=req.getParameter("userid");
    System.out.println("SearchUser() userid= "+userid);
    UserBean bean=null;
      if(userid!=null&&!userid.equals(""))
      {
        int uid=Integer.parseInt(userid);
        System.out.println("SearchUser() userid= "+uid);
        bean=UserDao.getRecordByID(uid);

        System.out.println(bean.getID());
        System.out.println(bean.getFirstName());
        System.out.println(bean.getLastName());
        System.out.println(bean.getEmail());
        System.out.println(bean.getMobile());
        System.out.println(bean.getUsername());
        System.out.println(bean.getPassword());
        System.out.println(bean.getAddress());
        System.out.println(bean.getPlace());


        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>All User</title>");
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
        out.println("<div class='register'>");
        out.println("<form action='updateuser' method='post'>");
        out.println("<input type='hidden' id='fname' name='userid' value="+bean.getID()+">");
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
      RequestDispatcher rd=req.getRequestDispatcher("/UpdateUser.html");
      rd.include(req,res);
      }
  }//method

  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    doPost(req,res);
  }
}
