package com;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.List;
import bean.AdminBean;
import dao.AdminDao;
public class SearchAdmin extends HttpServlet{
  public void init()
  {

  }
  public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();
    String adminid=req.getParameter("adminid");
    String firstname=req.getParameter("firstname");
    String username=req.getParameter("username");
    AdminBean bean=null;

    System.out.println("SearchAdmin  adminid= "+adminid);
    if(firstname!=null&&!firstname.equals("")||adminid!=null&&!adminid.equals("")||username!=null&&!username.equals(""))
    {
      if(firstname!=null&&!firstname.equals(""))
      {
        System.out.println("SearchAdmin() firstname= "+firstname);
        bean=AdminDao.getRecords(firstname);
      }
      if(adminid!=null&&!adminid.equals(""))
      {
        int aid=Integer.parseInt(adminid);
        System.out.println("SearchAdmin() mobile= "+aid);
        bean=AdminDao.getRecordById(aid);
      }
      if(username!=null&&!username.equals(""))
      {
        System.out.println("SearchAdmin() username= "+username);
        bean=AdminDao.getRecordByUsername(username);
      }

      out.println("<!DOCTYPE html>");
      out.println("<html>");
      out.println("<head>");
      out.println("<title>Search Admin</title>");
      out.println("<link rel='stylesheet' href='./style3.css'/>");
      out.println("<link rel='stylesheet' href='./resourses/lib/w3.css'>");
      out.println("<meta name='viewport' content='width=device-width, initial-scale=1'>");
      out.println("</head>");
      out.println("<body>");
      out.println("<div class='nav-top'>");
      out.println("<a id='home' href='./AdminBuild.html'>Home</a>");
      out.println("<a id='login' href='./AdminHome.html'>Admin</a>");
      out.println("</div>");
      out.println("<div class='side-nav'><ul class='s-menu'>");
      out.println("<li><a href=RegisterAdmin.html>Register</a></li>");
      out.println("<li><a href=showadmin>View Admins</a></li>");
      out.println("<li><a href=SearchAdmin.html>Search Admin</a></li>");
      out.println("<li><a href=UpdateAdmin.html>Update Admin</a></li>");
      out.println("<li><a href=RemoveAdmin.html>Remove Admins</a></li>");
      out.println("<li><a href=AdminActivity.html>Admins Activities</a></li>");
      out.println("<li><a href=ViewAdmin.html>Available Admins</a></li>");
      out.println("<li><a href=RemovedAdmin.html>Removed Admin</a></li>");
      out.println("<li><a href=AdminResponsible.html>Admin Responsbility</a></li>");
      out.println("<li><a href=AdminControl.html>Admins Data Control</a></li>");
      out.println("</ul>");
      out.println("</div>");
      out.println("<div class='containter'>");
      out.println("<div class='w3-content'>");
      out.println("<div class='w3-row w3-margin w3-card-12'>");
      if (bean.getFirstName().equals("")||bean.getFirstName()!=null||bean.getMobile().equals("")||bean.getMobile()!=null)
       {
         if (bean.getFirstName().equals("Kamlesh")||bean.getFirstName().equals("KAMLESH")||bean.getMobile().equals("7869471711"))
          {
            out.println("<div class='w3-third'>");
            out.println("<img src='./img/kamlesh.jpg' style='width:85%; max-height:300px'>");
            out.println("</div>");//w3-third
         }

         if (bean.getFirstName().equals("Krishna")||bean.getFirstName().equals("KRISHNA")||bean.getMobile().equals("9907473956"))
         {
         out.println("<div class='w3-third'>");
         out.println("<img src='./img/Krshna.jpg' style='width:85%; max-height:300px'>");
         out.println("</div>");//w3-third
        }

        if (bean.getFirstName().equals("Ajeet")||bean.getFirstName().equals("AJEET")||bean.getMobile().equals("9907473957"))
        {
        out.println("<div class='w3-third'>");
        out.println("<img src='./img/Ajeet.jpg' style='width:85%; max-height:300px'>");
        out.println("</div>");//w3-third
       }

       if (bean.getFirstName().equals("Sandeep")||bean.getFirstName().equals("SANDEEP")||bean.getMobile().equals("8602220499"))
       {
       out.println("<div class='w3-third'>");
       out.println("<img src='./img/Sandeep.jpg' style='width:85%; max-height:300px'>");
       out.println("</div>");//w3-third
      }

      if (bean.getFirstName().equals("Indraneel")||bean.getFirstName().equals("INDRANEEL")||bean.getMobile().equals("9907473958"))
      {
      out.println("<div class='w3-third'>");
      out.println("<img src='./img/Indraneel.jpg' style='width:85%; max-height:300px'>");
      out.println("</div>");//w3-third
     }

     if (bean.getFirstName().equals("Satish")||bean.getFirstName().equals("SATISH")||bean.getMobile().equals("8602691052"))
     {
     out.println("<div class='w3-third'>");
     out.println("<img src='./img/Satish.jpg' style='width:85%; max-height:300px'>");
     out.println("</div>");//w3-third
    }

    if (bean.getFirstName().equals("Indraneel")||bean.getFirstName().equals("INDRANEEL")||bean.getMobile().equals("9907473959"))
    {
    out.println("<div class='w3-third'>");
    out.println("<img src='./img/Indraneel.jpg' style='width:85%; max-height:300px'>");
    out.println("</div>");//w3-third
   }
      }
      else
      {
        out.println("<div class='w3-third'>");
        out.println("<img src='./img/PersonIcon.png' style='width:85%; max-height:300px'>");
        out.println("</div>");//w3-third
        out.println("<div class='footer'>");
        out.println("<a href='www.apsu.ac.in'>www.apsu.ac.in</a>");
        out.println("</div>");
      }
      out.println("<div class='w3-twothird w3-container'>");
      out.println("<h2> MR. "+bean.getFirstName().toUpperCase()+" "+bean.getLastName().toUpperCase()+"</h3>");
      out.println("<h3>Email ID: "+bean.getEmail()+"</h3>");
      out.println("<h3>Mobile :"+bean.getMobile()+"</h3>");
      out.println("<h3>Address :"+bean.getAddress()+"</h3>");
      out.println("<h3>Place :"+bean.getPlace()+"</h3>");
      out.println("<h3>Username :"+bean.getUsername()+"  Password :"+bean.getPassword());
      out.println("</div>");//w3-twothird
      out.println("</div>");//w3-row
      out.println("</div>");//content

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
        out.print("<tr><td>"+bean.getID()+"</td><td>"+bean.getFirstName()+"</td><td>"+bean.getLastName()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getMobile()+"</td><td>"+bean.getAddress()+"</td><td>"+bean.getPlace()+"</td><td>"+bean.getUsername()+"</td><td>"+bean.getPassword()+"</td></tr>");
      out.println("</table><br>");
      out.println("</div>");//container
      out.println("<div class='footer'>");
      out.println("<a href='www.apsu.ac.in'>www.apsu.ac.in</a>");
      out.println("</div>");
      out.println("</body>");
      out.println("</html>");
      }
      else
      {
      RequestDispatcher rd=req.getRequestDispatcher("/SearchAdmin.html");
      rd.include(req,res);
      }
  }//method

  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    doPost(req,res);
  }
}
