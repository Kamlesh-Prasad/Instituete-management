package com;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.List;
import bean.AdminBean;
import dao.AdminDao;
public class UpdateAdmin extends HttpServlet{
  public void init()
  {

  }
  public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();
    String adminid=req.getParameter("adminid");
    String firstname=req.getParameter("firstname");
    String lastname=req.getParameter("lastname");
    String email=req.getParameter("email");
    String mobile=req.getParameter("mobile");
    String address=req.getParameter("address");
    String place=req.getParameter("place");
    String username=req.getParameter("username");
    String password=req.getParameter("password");

    AdminBean bean=new AdminBean();
    bean.setID(Integer.parseInt(adminid));
    bean.setFirstName(firstname);
    bean.setLastName(lastname);
    bean.setEmail(email);
    bean.setMobile(mobile);
    bean.setAddress(address);
    bean.setPlace(place);
    bean.setUsername(username);
    bean.setPassword(password);
  
    if (adminid!=null&&!adminid.equals(""))
     {
       int status=AdminDao.update(bean);
       System.out.println("Status of UpdateAdmin="+status);

       if(status!=0)
       {
            res.sendRedirect("showadmin");
           System.out.println("Successfully Updated");
       }
       else
       {
         RequestDispatcher rd=req.getRequestDispatcher("/updateadminform");
         rd.include(req,res);
       }
    }
    else
    {
      RequestDispatcher rd=req.getRequestDispatcher("/updateadminform");
      rd.include(req,res);
    }
  }//method

  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    doPost(req,res);
  }
}
