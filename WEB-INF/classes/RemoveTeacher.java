package com;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.List;
import bean.TeacherBean;
import dao.TeacherDao;
public class RemoveTeacher extends HttpServlet{
  public void init()
  {

  }
  public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();
    int teacherid=Integer.parseInt(req.getParameter("teacherid"));
    System.out.println("RemoveTeacher teacherid="+teacherid);
    int status=TeacherDao.removeTeacher(teacherid);
    if(status!=0)
    {
        res.sendRedirect("showteacher");
        System.out.println("Successfully Removed");
    }
    else
    {
      RequestDispatcher rd=req.getRequestDispatcher("/removeteacherform");
      rd.include(req,res);
    }
  }//method

  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    doPost(req,res);
  }
}
