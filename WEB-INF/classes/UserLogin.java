package com;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
public class UserLogin extends HttpServlet{
  Connection con=null;
  PreparedStatement pst=null;
  ResultSet rs=null;
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
    PrintWriter out=res.getWriter();
    String username=req.getParameter("username");
    String userpassword=req.getParameter("userpassword");
    if(validateUser(username,userpassword))
    {
      res.setContentType("text/html");
      RequestDispatcher rd=req.getRequestDispatcher("/UserHome.html");
      rd.include(req,res);
      System.out.println("successfull data access");
      System.out.println("<h1>Admin Name:</h1>"+username);
      System.out.println("<br><br><h1>User Password: </h1>"+userpassword);

    }
    else
    {
      RequestDispatcher rd=req.getRequestDispatcher("/index.html");
      rd.include(req,res);
    }
  }
  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    doPost(req,res);
  }

  public boolean validateUser(String username,String password)
	{
			try{
        pst=con.prepareStatement("SELECT * FROM USERDATA WHERE USERNAME=? AND PASSWORD=?");
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
}
