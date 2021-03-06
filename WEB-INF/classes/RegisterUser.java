package com;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import dao.UserDao;
public class RegisterUser extends HttpServlet{
  Connection con=null;
  PreparedStatement pst=null;
  public void init()
  {
    try{
      Class.forName("oracle.jdbc.driver.OracleDriver");
      con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
    System.out.println("Database Connected in RegisterUser");
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
    String username=req.getParameter("username");
    String password=req.getParameter("password");
    String address=req.getParameter("address");
    String place=req.getParameter("place");
    int id=UserDao.getLastID();
    int count=insertData(id,firstname,lastname,email,mobile,address,place,username,password);
    System.out.println("count="+count);
    if(count==1)
    {
      System.out.println("Data successfully stored");
      RequestDispatcher rd=req.getRequestDispatcher("/showuser");
      rd.include(req,res);
    }
    else
    {
      RequestDispatcher rd=req.getRequestDispatcher("/RegisterUser.html");
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
	pst=con.prepareStatement("INSERT INTO USERDATA(ID,FIRSTNAME,LASTNAME,EMAIL,MOBILE,ADDRESS,PLACE,USERNAME,PASSWORD)VALUES(?,?,?,?,?,?,?,?,?)");
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
    	System.out.println("Exception of insertData() of RegisterUser ");
    if (!UserDao.createAccount())
     {
      System.out.println("Table Created");
      try {
        pst=con.prepareStatement("INSERT INTO USERDATA(ID,FIRSTNAME,LASTNAME,EMAIL,MOBILE,ADDRESS,PLACE,USERNAME,PASSWORD)VALUES(?,?,?,?,?,?,?,?,?)");
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
      catch(Exception e1){}
    }
    else
    {
      System.out.println("Table Already Exists");
    }

	}
	return 0;
	}
}
