package com;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.List;
import bean.UserBean;
import dao.UserDao;
public class RemoveUserForm extends HttpServlet{
  public void init()
  {

  }
  public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();
    String userid=req.getParameter("userid");
    UserBean bean=null;
    boolean status;
      if(userid!=null&&!userid.equals(""))
      {
        int uid=Integer.parseInt(userid);
        bean=UserDao.getRecordByID(uid);
        System.out.println("RemoveUserForm Bean= "+bean.getStatus());
        status=bean.getStatus();
        if(status)
        {
          out.println("<!DOCTYPE html>");
          out.println("<html>");
          out.println("<head>");
          out.println("<title>Remove User</title>");
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
          out.println("<th>Last Name</th>");
          out.println("<th>Email</th>");
          out.println("<th>Mobile</th>");
          out.println("<th>Address</th>");
          out.println("<th>Place</th>");
          out.println("<th>Username</th>");
          out.println("<th>Password</th>");
          out.println("</tr>");
          out.print("<tr><td>"+bean.getID()+"</td><td>"+bean.getFirstName()+"</td><td>"+bean.getLastName()+"</td><td>"+bean.getEmail()+"</td><td>"+bean.getMobile()+"</td><td>"+bean.getAddress()+"</td><td>"+bean.getPlace()+"</td><td>"+bean.getUsername()+"</td><td>"+bean.getPassword()+"</td></tr>");
          out.println("</table>");
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

            if (bean.getFirstName().equals("Ajeet")||bean.getFirstName().equals("AJEET")||bean.getMobile().equals("9907473956"))
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

          if (bean.getFirstName().equals("Indraneel")||bean.getFirstName().equals("INDRANEEL")||bean.getMobile().equals("9907473956"))
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

        if (bean.getFirstName().equals("Indraneel")||bean.getFirstName().equals("INDRANEEL")||bean.getMobile().equals("9907473956"))
        {
        out.println("<div class='w3-third'>");
        out.println("<img src='./img/Indraneel.jpg' style='width:85%; max-height:300px'>");
        out.println("</div>");//w3-third
        }

        if (bean.getFirstName().equals("Ansh")||bean.getFirstName().equals("ANSH")||bean.getMobile().equals("8602691052"))
        {
        out.println("<div class='w3-third'>");
        out.println("<img src='./img/Ansh.jpg' style='width:85%; max-height:300px'>");
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
          out.println("<div class='register'>");
          out.println("<form action='removeuser' method='post'>");
          out.println("<input type='hidden' id='fname' name='userid' value="+bean.getID()+">");
          out.println("<input type='submit' id='remove' value='Remove'>");
          out.println("</form>");
          out.println("</div>");
          out.println("</div>");
          out.println("<div class='footer'>");
          out.println("<a href='#'>www.apsu.ac.in</a>");
          out.println("</div>");
          out.println("</body>");
          out.println("</html>");
          //RequestDispatcher rd=req.getRequestDispatcher("/removeuser");
          //rd.forward(req,res);  goto direct send req and res to RemoveUser
          }
        }
      else
      {
      RequestDispatcher rd=req.getRequestDispatcher("/RemoveUser.html");
      rd.include(req,res);
      }
  }//method

  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    doPost(req,res);
  }
}
