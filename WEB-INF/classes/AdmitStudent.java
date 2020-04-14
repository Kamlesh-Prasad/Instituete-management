
package com;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import dao.StudentDao;
import bean.StudentBean;
public class AdmitStudent extends HttpServlet{
  Connection con=null;
  PreparedStatement pst=null;
  public void init()
  {
  }

  public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    PrintWriter out=res.getWriter();

    int id=StudentDao.getLastID();
    int rollno=StudentDao.getLastRollno();
    String firstname=req.getParameter("firstname");
    String midilename=req.getParameter("midilename");
    String lastname=req.getParameter("lastname");
    String fathername=req.getParameter("fathername");
    String mothername=req.getParameter("mothername");
    String dob=req.getParameter("dob");
    String gender=req.getParameter("gender");
    String category=req.getParameter("category");
    String age=req.getParameter("age");
    String email=req.getParameter("email");
    String mobile=req.getParameter("mobile");
    String pincode=req.getParameter("pincode");
    String city=req.getParameter("city");
    String state=req.getParameter("state");
    String nationality=req.getParameter("nationality");
    String address1=req.getParameter("address1");
    String address2=req.getParameter("address2");
    String medium=req.getParameter("medium");
    String bloodgroup=req.getParameter("bloodgroup");
    String lastschool=req.getParameter("lastschool");
    String year=req.getParameter("year");
    String lastclass=req.getParameter("lastclass");
    String newclass=req.getParameter("class");
    String section=req.getParameter("section");
    String group=req.getParameter("group");

    StudentBean bean=new StudentBean();
    bean.setID(id);
    bean.setRollno(rollno);
    bean.setFirstName(firstname);
    bean.setMidName(midilename);
    bean.setLastName(lastname);
    bean.setFatherName(fathername);
    bean.setMotherName(mothername);
    bean.setDob(dob);
    bean.setGender(gender);
    bean.setCategory(category);
    bean.setAge(age);
    bean.setEmail(email);
    bean.setMobile(mobile);
    bean.setPincode(pincode);
    bean.setCity(city);
    bean.setState(state);
    bean.setNationality(nationality);
    bean.setAddress1(address1);
    bean.setAddress2(address2);
    bean.setMedium(medium);
    bean.setBloodgroup(bloodgroup);
    bean.setLastInstituteName(lastschool);
    bean.setLastInstituteYear(year);
    bean.setLastInstituteClass(lastclass);
    bean.setAdmitClass(newclass);
    bean.setSection(section);
    bean.setGroup(group);

    int count=StudentDao.insertData(bean);
    System.out.println("count="+count);
    if(count==1)
    {
      System.out.println("Data successfully stored");
      RequestDispatcher rd=req.getRequestDispatcher("/showStudent");
      rd.include(req,res);
    }
    else
    {
      RequestDispatcher rd=req.getRequestDispatcher("/Admission.html");
      rd.include(req,res);
    }
  }

  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    doPost(req,res);
  }
}
