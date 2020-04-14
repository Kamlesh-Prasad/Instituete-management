package com;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class AdminLogin extends HttpServlet{
  Connection con=null;
  PreparedStatement pst=null;
  ResultSet rs=null;
  ResultSetMetaData rsmd=null;
public void init()
{
  System.out.println("Inside init()");
  try
  {
  Class.forName("oracle.jdbc.driver.OracleDriver");
  con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
  System.out.println("Database Connected");
  }
  catch (Exception e)
  {
    System.out.println(e);
  }
}
public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
res.setContentType("text/html");
PrintWriter out=res.getWriter();
out.println("<!DOCTYPE html>");
out.println("<html>");
out.println("<head>");
out.println("<title>Admin Panel</title>");
out.println("<link rel='stylesheet' href='./Admin/Resourses/style1.css'/>");
out.println("<link rel='stylesheet' href='./Admin/Resourses/style2.css'/>");
out.println("</head>");
out.println("<body>");
String adminname=req.getParameter("adminname");
String adminpassword=req.getParameter("adminpassword");

if(validateAdmin(adminname,adminpassword))
{
  RequestDispatcher rd=req.getRequestDispatcher("/AdminHome.html");
  rd.include(req,res);
  System.out.println("Data accessed");
  System.out.println("Admin Name: "+adminname);
  System.out.println("Password: "+adminpassword);
}
else
{
  RequestDispatcher rd=req.getRequestDispatcher("/index.html");
  rd.include(req,res);
}
out.println("</body>");
out.println("</html>");
}
public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{
  doPost(req,res);
}

public boolean validateAdmin(String username,String password)
{
    try{
      pst=con.prepareStatement("SELECT * FROM ADMINDATA WHERE USERNAME=? AND PASSWORD=?");
      pst.setString(1,username);
      pst.setString(2,password);
      rs=pst.executeQuery();
      if (rs.next())
      return true;
    }
    catch(Exception e)
    {e.printStackTrace();}
    return false;
}
}//class
