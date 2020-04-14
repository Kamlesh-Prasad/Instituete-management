package com;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.List;
import bean.UserBean;
import dao.UserDao;
public class RemoveUser extends HttpServlet{
  public void init()
  {

  }
  public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();

    int userid=Integer.parseInt(req.getParameter("userid"));
    int status=UserDao.removeUser(userid);
    if(status!=0)
    {
        res.sendRedirect("showuser");
        System.out.println("Successfully Removed");
    }
    else
    {
      RequestDispatcher rd=req.getRequestDispatcher("/removeuserform");
      rd.include(req,res);
    }
  }//method

  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    doPost(req,res);
  }
}
