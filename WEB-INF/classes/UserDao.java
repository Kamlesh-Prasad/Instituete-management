package dao;
import java.sql.*;
import dao.DriverConnection;
import bean.UserBean;
import java.util.ArrayList;
import java.util.List;
public class UserDao{

public static List<UserBean> getAllRecords()
{
  List<UserBean> list=new ArrayList<UserBean>();
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("SELECT * FROM USERDATA");
    ResultSet rs=pst.executeQuery();
    while(rs.next())
    {
      UserBean bean=new UserBean();
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
    System.out.println("UserDao: Error"+e);
  }
  return list;
}

public static UserBean getRecords(String firstname)
{
  UserBean bean=new UserBean();
  ResultSet rs=null;
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("SELECT * FROM USERDATA WHERE FIRSTNAME=?");
    pst.setString(1,firstname);
    rs=pst.executeQuery();
    if (rs!=null)
    {
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
      return null;
    con.close();
    System.out.println("UserDao getRecords() By= "+firstname);
    System.out.println("Database Disconnected");
    System.out.println("getRecords() bean= "+bean);
  }
  catch(Exception e){
    System.out.println("UserDao: Error"+e);
  }
  return bean;
}

public static UserBean getRecordByID(int id)
{
  UserBean bean=new UserBean();
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("SELECT * FROM USERDATA WHERE ID=?");
    pst.setInt(1,id);
    ResultSet rs=pst.executeQuery();
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
      System.out.println("UserDao Bean= "+bean.getStatus());
    }
    con.close();
    System.out.println("UserDao getRecordByID() By= "+id);
    System.out.println("Database Disconnected of getRecordByID");
      System.out.println("getRecordByMobile() bean= "+bean);
  }
  catch(Exception e){
    System.out.println("UserDao: Error"+e);
  }
  return bean;
}

public static UserBean getRecordByUsername(String username)
{
  UserBean bean=new UserBean();
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("SELECT * FROM USERDATA WHERE USERNAME=?");
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
    System.out.println("UserDao getRecordsByUsername() By= "+username);
    System.out.println("Database Disconnected");
      System.out.println("getRecordByUsername() bean= "+bean);
  }
  catch(Exception e){
    System.out.println("UserDao: Error"+e);
  }
  return bean;
}

public static int removeUser(int userid){
  int status=0;
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("DELETE USERDATA WHERE ID=?");
    pst.setInt(1,userid);
    status=pst.executeUpdate();
    con.close();
    System.out.println("Database close of removeUser()");
  }
  catch(Exception e){System.out.println(e);}
  return status;
}

public static int update(UserBean bean){
  int status=0;
  System.out.println("UserDao update() id="+bean.getID());
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("UPDATE USERDATA SET FIRSTNAME=?,LASTNAME=?,EMAIL=?,MOBILE=?,ADDRESS=?,PLACE=?,USERNAME=?,PASSWORD=? WHERE ID=?");
    pst.setString(1,bean.getFirstName());
    pst.setString(2,bean.getLastName());
    pst.setString(3,bean.getEmail());
    pst.setString(4,bean.getMobile());
    pst.setString(5,bean.getAddress());
    pst.setString(6,bean.getPlace());
    pst.setString(7,bean.getUsername());
    pst.setString(8,bean.getPassword());
    pst.setInt(9,bean.getID());
    status=pst.executeUpdate();
    con.close();
    System.out.println("Database close of update");
  }
  catch(Exception e){System.out.println(e);}
  return status;
}

public static boolean createAccount()
{
  boolean status=true;
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("CREATE TABLE USERDATA (ID NUMBER(12),FIRSTNAME VARCHAR2(20),LASTNAME VARCHAR2(20),EMAIL VARCHAR2(50),MOBILE VARCHAR2(20),ADDRESS VARCHAR2(20),PLACE VARCHAR2(20),USERNAME VARCHAR2(20),PASSWORD VARCHAR2(20))");
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
  int count=10000;
  System.out.println("Before count="+count);
  try
  {
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("SELECT * FROM USERDATA");
    ResultSet rs=pst.executeQuery();
    while(rs.next())
    {
    count=rs.getInt(1);
    }
      con.close();
  }
  catch (Exception e)
  {
    System.out.println("Exception of getLastID() of UserDao");
    System.out.println(e);
  }
  System.out.println("After count="+count);
  return count+1;
}

}//class
