package com;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import dao.AdminDao;
import dao.DriverConnection;
public class CreateAccount extends HttpServlet{
Connection con=null;
PreparedStatement pst=null;
  public void init()
  {
    try{
      con=DriverConnection.getConnection();
      boolean status=AdminDao.createAccount();
      if(status)
      System.out.println("Table Created");
      else
      System.out.println("Table Already Created");
  }
    catch(Exception e)
    {System.out.println(e);}
  }

  public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    PrintWriter out=res.getWriter();
    String firstname=req.getParameter("firstname");
    String lastname=req.getParameter("lastname");
    String email=req.getParameter("email");
    String mobile=req.getParameter("mobile");
    String address=req.getParameter("address");
    String place=req.getParameter("place");
    String username=req.getParameter("username");
    String password=req.getParameter("password");
    int count=insertData(1212,firstname,lastname,email,mobile,address,place,username,password);
    System.out.println("count="+count);
    if(count==1)
    {
      System.out.println("Data successfully stored");
      RequestDispatcher rd=req.getRequestDispatcher("/index.html");
      rd.include(req,res);
    }
    else
    {
      RequestDispatcher rd=req.getRequestDispatcher("/RegisterAdmin1.html");
      rd.include(req,res);
    }
  }

  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    doPost(req,res);
  }

  public int insertData(int id,String fn,String ln,String email,String mb,String add,String place,String uname,String pass)
	{
	try
	{
	pst=con.prepareStatement("INSERT INTO ADMINDATA(ID,FIRSTNAME,LASTNAME,EMAIL,MOBILE,ADDRESS,PLACE,USERNAME,PASSWORD)VALUES(?,?,?,?,?,?,?,?,?)");
	pst.setInt(1,id);
	pst.setString(2,fn);
	pst.setString(3,ln);
	pst.setString(4,email);
	pst.setString(5,mb);
  pst.setString(6,add);
  pst.setString(7,place);
	pst.setString(8,uname);
	pst.setString(9,pass);
	int count=pst.executeUpdate();
	return count;
	}
	catch (SQLException e)
	{
		System.out.println(e);
	}
	return 0;
	}
}
