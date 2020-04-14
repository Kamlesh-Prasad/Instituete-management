package dao;
import java.sql.*;
import dao.DriverConnection;
import bean.AdminBean;
import java.util.ArrayList;
import java.util.List;
public class AdminDao{

public static List<AdminBean> getAllRecords()
{
  List<AdminBean> list=new ArrayList<AdminBean>();
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("SELECT * FROM ADMINDATA");
    ResultSet rs=pst.executeQuery();
    while(rs.next())
    {
      AdminBean bean=new AdminBean();
      bean.setID(rs.getInt(1));
      bean.setFirstName(rs.getString(2));
      bean.setLastName(rs.getString(3));
      bean.setEmail(rs.getString(4));
      bean.setMobile(rs.getString(5));
      bean.setAddress(rs.getString(6));
      bean.setPlace(rs.getString(7));
      bean.setUsername(rs.getString(8));
      bean.setPassword(rs.getString(9));
      list.add(bean);
    }
    con.close();
    System.out.println("Database Disconnected");
  }
  catch(Exception e){
    System.out.println("AdminDao: Error"+e);
  }
  return list;
}


public static AdminBean getRecordById(int adminid)
{
  AdminBean bean=new AdminBean();
  ResultSet rs=null;
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("SELECT * FROM ADMINDATA WHERE ID=?");
    pst.setInt(1,adminid);
    rs=pst.executeQuery();

    if (rs!=null)
    {
      bean.setStatus(true);
      while(rs.next())
      {
        bean.setID(rs.getInt(1));
        bean.setFirstName(rs.getString(2));
        bean.setLastName(rs.getString(3));
        bean.setEmail(rs.getString(4));
        bean.setMobile(rs.getString(5));
        bean.setAddress(rs.getString(6));
        bean.setPlace(rs.getString(7));
        bean.setUsername(rs.getString(8));
        bean.setPassword(rs.getString(9));
      }
    }
    else
    {
      bean.setStatus(false);
      System.out.println("AdminDao Bean= "+bean.getStatus());
    }

    con.close();
    System.out.println("AdminDao getRecords() By= "+adminid);
    System.out.println("Database Disconnected");
  }
  catch(Exception e){
    System.out.println("AdminDao: Error"+e);
  }
  System.out.println("AdminDao Bean= "+bean.getStatus());
  return bean;
}

public static AdminBean getRecords(String firstname)
{
  AdminBean bean=new AdminBean();
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("SELECT * FROM ADMINDATA WHERE FIRSTNAME=?");
    pst.setString(1,firstname);
    ResultSet rs=pst.executeQuery();
    while(rs.next())
    {
      bean.setID(rs.getInt(1));
      bean.setFirstName(rs.getString(2));
      bean.setLastName(rs.getString(3));
      bean.setEmail(rs.getString(4));
      bean.setMobile(rs.getString(5));
      bean.setAddress(rs.getString(6));
      bean.setPlace(rs.getString(7));
      bean.setUsername(rs.getString(8));
      bean.setPassword(rs.getString(9));
    }
    con.close();
    System.out.println("AdminDao getRecords() By= "+firstname);
    System.out.println("Database Disconnected");
  }
  catch(Exception e){
    System.out.println("AdminDao: Error"+e);
  }
  return bean;
}

public static AdminBean getRecordByMobile(String mobile)
{
  AdminBean bean=new AdminBean();
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("SELECT * FROM ADMINDATA WHERE MOBILE=?");
    pst.setString(1,mobile);
    ResultSet rs=pst.executeQuery();
    while(rs.next())
    {
      bean.setID(rs.getInt(1));
      bean.setFirstName(rs.getString(2));
      bean.setLastName(rs.getString(3));
      bean.setEmail(rs.getString(4));
      bean.setMobile(rs.getString(5));
      bean.setAddress(rs.getString(6));
      bean.setPlace(rs.getString(7));
      bean.setUsername(rs.getString(8));
      bean.setPassword(rs.getString(9));
    }
    con.close();
    System.out.println("AdminDao getRecordByMobile() By= "+mobile);
    System.out.println("Database Disconnected");
  }
  catch(Exception e){
    System.out.println("AdminDao: Error"+e);
  }
  return bean;
}

public static AdminBean getRecordByUsername(String username)
{
  AdminBean bean=new AdminBean();
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("SELECT * FROM ADMINDATA WHERE USERNAME=?");
    pst.setString(1,username);
    ResultSet rs=pst.executeQuery();
    while(rs.next())
    {
      bean.setID(rs.getInt(1));
      bean.setFirstName(rs.getString(2));
      bean.setLastName(rs.getString(3));
      bean.setEmail(rs.getString(4));
      bean.setMobile(rs.getString(5));
      bean.setAddress(rs.getString(6));
      bean.setPlace(rs.getString(7));
      bean.setUsername(rs.getString(8));
      bean.setPassword(rs.getString(9));
    }
    con.close();
    System.out.println("AdminDao getRecordsByUsername() By= "+username);
    System.out.println("Database Disconnected");
  }
  catch(Exception e){
    System.out.println("AdminDao: Error"+e);
  }
  return bean;
}

public static int update(AdminBean bean){
  int status=0;
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("UPDATE ADMINDATA SET FIRSTNAME=?,LASTNAME=?,EMAIL=?,MOBILE=?,ADDRESS=?,PLACE=?,USERNAME=?,PASSWORD=? WHERE FIRSTNAME=?");
    pst.setString(1,bean.getFirstName());
    pst.setString(2,bean.getLastName());
    pst.setString(3,bean.getEmail());
    pst.setString(4,bean.getMobile());
    pst.setString(5,bean.getAddress());
    pst.setString(6,bean.getPlace());
    pst.setString(7,bean.getUsername());
    pst.setString(8,bean.getPassword());
    pst.setString(9,bean.getFirstName());
    status=pst.executeUpdate();
    con.close();
    System.out.println("Database close of update");
  }
  catch(Exception e){System.out.println(e);}
  return status;
}



public static int removeAdmin(int adminid){
  int status=0;
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("DELETE ADMINDATA WHERE ID=?");
    pst.setInt(1,adminid);
    status=pst.executeUpdate();
    con.close();
    System.out.println("Database close of removeAdmin()");
  }
  catch(Exception e){System.out.println(e);}
  return status;
}

public static boolean createAccount()
{
  boolean status=true;
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("CREATE TABLE ADMINDATA (ID NUMBER(12),FIRSTNAME VARCHAR2(20),LASTNAME VARCHAR2(20),EMAIL VARCHAR2(50) NOT NULL ENABLE,MOBILE VARCHAR2(20) NOT NULL ENABLE,ADDRESS VARCHAR2(20),PLACE VARCHAR2(20),USERNAME VARCHAR2(20),PASSWORD VARCHAR2(20))");
    status=pst.execute();
    con.close();
    System.out.println("Database close of createAccount()");
    System.out.println("status of createAccount= "+status);
    return status;
  }
  catch(Exception e)
  {
    System.out.println("Exception of createAccount()");
    System.out.println(e);
    return true;
  }
}

public static int getLastID()
{
  int count=10001;
  System.out.println("Before count="+count);
  try
  {
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("SELECT * FROM ADMINDATA");
    ResultSet rs=pst.executeQuery();
    while(rs.next())
    {
    count=rs.getInt(1);
    }
      con.close();
  }
  catch (Exception e)
  {
    System.out.println("Exception of getLastID() of AdminDao");
    System.out.println(e);
  }
  System.out.println("Before count="+count);
  return count+1;
}

}//class
