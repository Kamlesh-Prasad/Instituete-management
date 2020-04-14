package com;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.List;
import bean.UserBean;
import dao.UserDao;
public class UpdateUser extends HttpServlet{
  public void init()
  {

  }
  public void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    res.setContentType("text/html");
    PrintWriter out=res.getWriter();
    String userid=req.getParameter("userid");
    String firstname=req.getParameter("firstname");
    String lastname=req.getParameter("lastname");
    String email=req.getParameter("email");
    String mobile=req.getParameter("mobile");
    String address=req.getParameter("address");
    String place=req.getParameter("place");
    String username=req.getParameter("username");
    String password=req.getParameter("password");


        System.out.println(firstname);
        System.out.println(lastname);
        System.out.println(email);
        System.out.println(mobile);
        System.out.println(address);
        System.out.println(place);
        System.out.println(username);
        System.out.println(password);


    UserBean bean=new UserBean();
    bean.setID(Integer.parseInt(userid));
    bean.setFirstName(firstname);
    bean.setLastName(lastname);
    bean.setEmail(email);
    bean.setMobile(mobile);
    bean.setAddress(address);
    bean.setPlace(place);
    bean.setUsername(username);
    bean.setPassword(password);
    if (userid!=null&&!userid.equals(""))
     {
       int status=UserDao.update(bean);
       System.out.println("Status of UpdateUser="+status);

       if(status!=0)
       {
            res.sendRedirect("showuser");
           System.out.println("Successfully Updated");
       }
       else
       {
         RequestDispatcher rd=req.getRequestDispatcher("/updateuserform");
         rd.include(req,res);
       }
    }
    else
    {
      RequestDispatcher rd=req.getRequestDispatcher("/updateuserform");
      rd.include(req,res);
    }
  }//method

  public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
  {
    doPost(req,res);
  }
}
