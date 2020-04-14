package com;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.List;
import bean.EmployeeBean;
import dao.EmployeeDao;
public class RemoveEmployeeForm extends HttpServlet{
  public void init()
  {

  }
  public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();
    int employeeid=Integer.parseInt(req.getParameter("employeeid"));
    System.out.println("RemoveEmployeeForm() Employeeid= "+employeeid);
    EmployeeBean bean=null;
    boolean status;
      if(employeeid!=0)
      {
        bean=EmployeeDao.getRecordById(employeeid);
      }
      System.out.println("RemoveEmployeeForm Bean= "+bean.getStatus());
      status=bean.getStatus();

      if(status)
      {
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
        out.println("<h4><b> MR. "+bean.getFirstName().toUpperCase()+" "+bean.getLastName().toUpperCase()+"</b></h4>");
        out.println("<h5>Email ID: "+bean.getEmail()+"</h5>");
        out.println("<h5>Mobile :"+bean.getMobile()+"</h5>");
        out.println("<h5>Address :"+bean.getAddress()+"</h5>");
        out.println("<h5>Department :"+bean.getDepartment()+"</h5>");
        out.println("<h5>Post :"+bean.getPost()+"</h5>");
        out.println("<h5>Qualification :"+bean.getQualification()+"</h5>");
        out.println("<h5>Experience :"+bean.getExperience()+"</h5>");
        out.println("</div>");//w3-twothird
        out.println("</div>");//w3-row
        out.println("</div>");//content
        out.println("<div class='register'>");
        out.println("<form action='removeemployee' method='post'>");
        out.println("<input type='hidden' id='employeeid' name='employeeid' value="+bean.getID()+">");
        out.println("<input type='submit' id='remove' value='Remove'>");
        out.println("</form>");
        out.println("</div>");
        out.println("</div>");//container

      out.println("<div class='footer'>");
      out.println("<a href='#'>www.apsu.ac.in</a>");
      out.println("</div>");
      out.println("</body>");
      out.println("</html>");
      //RequestDispatcher rd=req.getRequestDispatcher("/removeEmployee");
      //rd.forward(req,res);  goto direct send req and res to RemoveEmployee
      }
      else
      {
      RequestDispatcher rd=req.getRequestDispatcher("/RemoveEmployee.html");
      rd.include(req,res);
      }
  }//method

  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    doPost(req,res);
  }
}
