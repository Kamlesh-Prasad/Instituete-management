package com;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.List;
import bean.TeacherBean;
import dao.TeacherDao;
public class UpdateTeacher extends HttpServlet{
  public void init()
  {

  }
  public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();
    String id=req.getParameter("teacherid");
    String firstname=req.getParameter("firstname");
    String lastname=req.getParameter("lastname");
    String email=req.getParameter("email");
    String mobile=req.getParameter("mobile");
    String address=req.getParameter("address");
    String institute=req.getParameter("institute");
    String subject=req.getParameter("subject");
    String qualification=req.getParameter("qualification");
    String experience=req.getParameter("experience");
    String dob=req.getParameter("dob");
    String salary=req.getParameter("salary");
    String activity=req.getParameter("activity");

    TeacherBean bean=new TeacherBean();
    bean.setID(Integer.parseInt(id));
    bean.setFirstName(firstname);
    bean.setLastName(lastname);
    bean.setEmail(email);
    bean.setMobile(mobile);
    bean.setAddress(address);
    bean.setInstitute(institute);
    bean.setSubject(subject);
    bean.setQualification(qualification);
    bean.setExperience(experience);
    bean.setDob(dob);
    bean.setSalary(salary);
    bean.setActivity(activity);

    System.out.println(firstname);
    System.out.println(lastname);
    System.out.println(email);
    System.out.println(mobile);
    System.out.println(address);
    System.out.println(institute);
    System.out.println(subject);
    System.out.println(qualification);
    System.out.println(experience);
    System.out.println(dob);
    System.out.println(salary);
    System.out.println(activity);
    System.out.println("UpdateTeacher set All Atribute in TeacherBean");
    System.out.println();
    if (id!=null&&!id.equals(""))
     {
       int status=TeacherDao.update(bean);
       System.out.println("Status of UpdateTeacher="+status);
       if(status!=0)
       {
           res.sendRedirect("showteacher");
           System.out.println("Successfully Updated");
       }
    }
    else
    {
      RequestDispatcher rd=req.getRequestDispatcher("/updateteacherform");
      rd.include(req,res);
    }
  }//method

  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    doPost(req,res);
  }
}
