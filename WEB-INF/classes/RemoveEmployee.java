package com;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.List;
import bean.EmployeeBean;
import dao.EmployeeDao;
public class RemoveEmployee extends HttpServlet{
  public void init()
  {

  }
  public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();
    int employeeid=Integer.parseInt(req.getParameter("employeeid"));
    System.out.println("RemoveEmployee employeeid="+employeeid);
    int status=EmployeeDao.removeEmployee(employeeid);
    if(status!=0)
    {
        res.sendRedirect("showemployee");
        System.out.println("Successfully Removed");
    }
    else
    {
      RequestDispatcher rd=req.getRequestDispatcher("/removeemployeeform");
      rd.include(req,res);
    }
  }//method

  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    doPost(req,res);
  }
}
