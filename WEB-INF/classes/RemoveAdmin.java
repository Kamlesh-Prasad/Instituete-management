package com;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.List;
import bean.AdminBean;
import dao.AdminDao;
public class RemoveAdmin extends HttpServlet{
  public void init()
  {

  }
  public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();

    int adminid=Integer.parseInt(req.getParameter("adminid"));
    int status=AdminDao.removeAdmin(adminid);
    if(status==1)
    {
        res.sendRedirect("showadmin");
        System.out.println("Successfully Removed");
    }
    else
    {
      RequestDispatcher rd=req.getRequestDispatcher("/removeadminform");
      rd.include(req,res);
    }
  }//method

  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    doPost(req,res);
  }
}
