package com;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.List;
import bean.EmployeeBean;
import dao.EmployeeDao;
public class UpdateEmployee extends HttpServlet{
  public void init()
  {

  }
  public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();

    String firstname=req.getParameter("firstname");
    String lastname=req.getParameter("lastname");
    String email=req.getParameter("email");
    String mobile=req.getParameter("mobile");
    String address=req.getParameter("address");
    String department=req.getParameter("department");
    String post=req.getParameter("post");
    String qualification=req.getParameter("qualification");
    String experience=req.getParameter("experience");
    String dob=req.getParameter("dob");
    String salary=req.getParameter("salary");
    String activity=req.getParameter("activity");

    EmployeeBean bean=new EmployeeBean();

    bean.setFirstName(firstname);
    bean.setLastName(lastname);
    bean.setEmail(email);
    bean.setMobile(mobile);
    bean.setAddress(address);
    bean.setDepartment(department);
    bean.setPost(post);
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
    System.out.println(department);
    System.out.println(post);
    System.out.println(qualification);
    System.out.println(experience);
    System.out.println(dob);
    System.out.println(salary);
    System.out.println(activity);
    System.out.println("UpdateEmployee set All Atribute in EmployeeBean");
    System.out.println();
    int status=EmployeeDao.update(bean);
    System.out.println("Status of UpdateEmployee="+status);
    if(status!=0)
    {
        res.sendRedirect("showemployee");
        System.out.println("Successfully Updated");
    }
    else
    {
      RequestDispatcher rd=req.getRequestDispatcher("/updateemployeeform");
      rd.include(req,res);
    }
  }//method

  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    doPost(req,res);
  }
}
