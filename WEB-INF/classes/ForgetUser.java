package com;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ForgetUser{
  Connection con=null;
  PreparedStatement pst=null;
  ResultSet rs=null;

  public void init()
  {
    try{
      Class.forName("oracle.jdbc.driver.OracleDriver");
      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
    }
    catch(Exception e)
    {System.out.println(e);}
  }

  public void doPost(HttpServletRequest res,HttpServletResponse res)throws ServletException,IOException
  {
    PrintWriter out=res.getWriter();
    res.setContentType("text/html");
    String firstname=req.getParameter("firstname");
    String email=req.getParameter("email");
    String mobile=req.getParameter("mobile");

    if(SearchUser(firstname,email,mobile))
    {
      RequestDispatcher rd=req.getRequestDispatcher("/UserDashboard.html");
      rd.include(req,res);
    }
    else
    {
      RequestDispatcher rd=req.getRequestDispatcher("/UserLogin.html");
      rd.include(req,res);
    }
  }

  public void doGet(HttpServletRequest res,HttpServletResponse res)throws ServletException,IOException
  {
    doPost(req,res);
  }


  public ResultSet SearchUser(String firstname,String email,String mobile)
  {
    try{

      if(con!=null)
      {
        pst=con.prepareStatement("SELECT * FROM USERDATA WHERE FIRSTNAME=? OR EMAIL=? OR MOBILE=?");
        pst.setString(1,firstname);
        pst.setString(2,email);
        pst.setString(3,mobile);
        ResultSet rs=pst.executeQuery();
        return rs;
      }
      }
    catch(Exception e){
      System.out.println(e);
    }
  }
}
