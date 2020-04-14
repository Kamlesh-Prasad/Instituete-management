package com;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import dao.EmployeeDao;
import bean.EmployeeBean;
public class RegisterEmployee extends HttpServlet{
  Connection con=null;
  PreparedStatement pst=null;
  public void init()
  {
  }

  public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    PrintWriter out=res.getWriter();

    int id=EmployeeDao.getLastID();
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

    bean.setID(id);
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

    int count=EmployeeDao.insertData(bean);
    System.out.println("count="+count);
    if(count==1)
    {
      System.out.println("Data successfully stored");
      RequestDispatcher rd=req.getRequestDispatcher("/showemployee");
      rd.include(req,res);
    }
    else
    {
      RequestDispatcher rd=req.getRequestDispatcher("/RegisterEmployee.html");
      rd.include(req,res);
    }
  }

  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    doPost(req,res);
  }


}
