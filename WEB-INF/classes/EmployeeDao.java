package dao;
import java.sql.*;
import dao.DriverConnection;
import bean.EmployeeBean;
import java.util.ArrayList;
import java.util.List;
public class EmployeeDao{

public static List<EmployeeBean> getAllRecords()
{
  List<EmployeeBean> list=new ArrayList<EmployeeBean>();
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("SELECT * FROM EMPLOYEEDATA");
    ResultSet rs=pst.executeQuery();
    while(rs.next())
    {
      EmployeeBean bean=new EmployeeBean();
      bean.setID(rs.getInt(1));
      bean.setFirstName(rs.getString(2));
      bean.setLastName(rs.getString(3));
      bean.setEmail(rs.getString(4));
      bean.setMobile(rs.getString(5));
      bean.setAddress(rs.getString(6));
      bean.setDepartment(rs.getString(7));
      bean.setPost(rs.getString(8));
      bean.setQualification(rs.getString(9));
      bean.setExperience(rs.getString(10));
      bean.setDob(rs.getString(11));
      bean.setSalary(rs.getString(12));
      bean.setActivity(rs.getString(13));
      list.add(bean);
    }
    con.close();
    System.out.println("Database Disconnected getAllRecords()");
  }
  catch(Exception e){
    System.out.println("EmployeeDao getAllRecords(): Error"+e);
  }
  return list;
}


public static EmployeeBean getRecordById(int employeeid)
{
  EmployeeBean bean=new EmployeeBean();
  ResultSet rs=null;
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("SELECT * FROM EMPLOYEEDATA WHERE ID=?");
    pst.setInt(1,employeeid);
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
        bean.setDepartment(rs.getString(7));
        bean.setPost(rs.getString(8));
        bean.setQualification(rs.getString(9));
        bean.setExperience(rs.getString(10));
        bean.setDob(rs.getString(11));
        bean.setSalary(rs.getString(12));
        bean.setActivity(rs.getString(13));
      }
    }
    else
    {
      bean.setStatus(false);
      System.out.println("EmployeeDao Bean= "+bean.getStatus());
    }

    con.close();
    System.out.println("EmployeeDao getRecords() By= "+employeeid);
    System.out.println("Database Disconnected of getRecords()");
  }
  catch(Exception e){
    System.out.println("EmployeeDao getRecords(): Error"+e);
  }
  System.out.println("EmployeeDao Bean= "+bean.getStatus());
  return bean;
}

public static EmployeeBean getRecordByFirstName(String firstname)
{
  EmployeeBean bean=new EmployeeBean();
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("SELECT * FROM EMPLOYEEDATA WHERE FIRSTNAME=?");
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
      bean.setDepartment(rs.getString(7));
      bean.setPost(rs.getString(8));
      bean.setQualification(rs.getString(9));
      bean.setExperience(rs.getString(10));
      bean.setDob(rs.getString(11));
      bean.setSalary(rs.getString(12));
      bean.setActivity(rs.getString(13));
    }
    con.close();
    System.out.println("EmployeeDao getRecordByFirstName() By= "+firstname);
    System.out.println("Database Disconnected of getRecordByFirstName() ");
  }
  catch(Exception e){
    System.out.println("EmployeeDao getRecordByFirstName(): Error"+e);
  }
  return bean;
}

public static EmployeeBean getRecordByMobile(String mobile)
{
  EmployeeBean bean=new EmployeeBean();
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("SELECT * FROM EMPLOYEEDATA WHERE MOBILE=?");
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
      bean.setDepartment(rs.getString(7));
      bean.setPost(rs.getString(8));
      bean.setQualification(rs.getString(9));
      bean.setExperience(rs.getString(10));
      bean.setDob(rs.getString(11));
      bean.setSalary(rs.getString(12));
      bean.setActivity(rs.getString(13));
    }
    con.close();
    System.out.println("EmployeeDao getRecordByMobile() By= "+mobile);
    System.out.println("Database Disconnected of getRecordByMobile()");
  }
  catch(Exception e){
    System.out.println("EmployeeDao getRecordByMobile(): Error"+e);
  }
  return bean;
}

public static EmployeeBean getRecordByUsername(String username)
{
  EmployeeBean bean=new EmployeeBean();
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("SELECT * FROM EMPLOYEEDATA WHERE USERNAME=?");
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
      bean.setDepartment(rs.getString(7));
      bean.setPost(rs.getString(8));
      bean.setQualification(rs.getString(9));
      bean.setExperience(rs.getString(10));
      bean.setDob(rs.getString(11));
      bean.setSalary(rs.getString(12));
      bean.setActivity(rs.getString(13));
    }
    con.close();
    System.out.println("EmployeeDao getRecordsByUsername() By= "+username);
    System.out.println("Database Disconnected of getRecordByUsername()");
  }
  catch(Exception e){
    System.out.println("EmployeeDao getRecordByUsername(): Error"+e);
  }
  return bean;
}

public static int update(EmployeeBean bean){
  int status=0;
  System.out.println("EmployeeDao update() id="+bean.getID());
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("UPDATE EMPLOYEEDATA SET FIRSTNAME=?,LASTNAME=?,EMAIL=?,MOBILE=?,ADDRESS=?,DEPARTMENT=?,POST=?,QUALIFICATION=?,EXPERIENCE=?,DOB=?,SALARY=?,ACTIVITY=? WHERE FIRSTNAME=?");
    pst.setString(1,bean.getFirstName());
    pst.setString(2,bean.getLastName());
    pst.setString(3,bean.getEmail());
    pst.setString(4,bean.getMobile());
    pst.setString(5,bean.getAddress());
    pst.setString(6,bean.getDepartment());
    pst.setString(7,bean.getPost());
    pst.setString(8,bean.getQualification());
    pst.setString(9,bean.getExperience());
    pst.setString(10,bean.getDob());
    pst.setString(11,bean.getSalary());
    pst.setString(12,bean.getActivity());
    pst.setString(13,bean.getFirstName());
    status=pst.executeUpdate();
    System.out.println("EmployeeDao update() status="+status);
    con.close();
    System.out.println("Database close of update()");
  }
  catch(Exception e){System.out.println(e);}
  return status;
}



public static int removeEmployee(int employeeid){
  int status=0;
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("DELETE FROM EMPLOYEEDATA WHERE ID=?");
    pst.setInt(1,employeeid);
    status=pst.executeUpdate();
    con.close();
    System.out.println("EmployeeDao removeEmployee() status="+status);
    System.out.println("Database close of removeEmployee()");
  }
  catch(Exception e){System.out.println(e);}
  return status;
}

public static boolean createAccount()
{
  boolean status=true;
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("CREATE TABLE EMPLOYEEDATA (ID NUMBER(12),FIRSTNAME VARCHAR2(20),LASTNAME VARCHAR2(20),EMAIL VARCHAR2(50),MOBILE VARCHAR2(20),ADDRESS VARCHAR2(20),DEPARTMENT VARCHAR2(50),POST VARCHAR2(20),QUALIFICATION VARCHAR2(20),EXPERIENCE VARCHAR2(20),DOB VARCHAR2(20),SALARY VARCHAR2(20),ACTIVITY VARCHAR2(20))");
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
    PreparedStatement pst=con.prepareStatement("SELECT * FROM EMPLOYEEDATA");
    ResultSet rs=pst.executeQuery();
    while(rs.next())
    {
    count=rs.getInt(1);
    }
      con.close();
  }
  catch (Exception e)
  {
    System.out.println("Exception of getLastID() of EmployeeDao");
    System.out.println(e);
  }
  System.out.println("After count="+count);
  return count+1;
}


public static int insertData(EmployeeBean bean)
{
  String query="INSERT INTO EMPLOYEEDATA(ID,FIRSTNAME,LASTNAME,EMAIL,MOBILE,ADDRESS,DEPARTMENT,POST,QUALIFICATION,EXPERIENCE,DOB,SALARY,ACTIVITY)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
try
{
Connection con=DriverConnection.getConnection();
PreparedStatement pst=con.prepareStatement(query);
pst.setInt(1,bean.getID());
pst.setString(2,bean.getFirstName());
pst.setString(3,bean.getLastName());
pst.setString(4,bean.getEmail());
pst.setString(5,bean.getMobile());
pst.setString(6,bean.getAddress());
pst.setString(7,bean.getDepartment());
pst.setString(8,bean.getPost());
pst.setString(9,bean.getQualification());
pst.setString(10,bean.getExperience());
pst.setString(11,bean.getDob());
pst.setString(12,bean.getSalary());
pst.setString(13,bean.getActivity());
int count=pst.executeUpdate();
return count;
}
catch (SQLException e)
{
    System.out.println("Exception of insertData() of RegisterEmployee "+e);
  if (!EmployeeDao.createAccount())
   {
    System.out.println("Table Created");
    try {
      Connection con=DriverConnection.getConnection();
      PreparedStatement pst=con.prepareStatement(query);
      pst.setInt(1,bean.getID());
      pst.setString(2,bean.getFirstName());
      pst.setString(3,bean.getLastName());
      pst.setString(4,bean.getEmail());
      pst.setString(5,bean.getMobile());
      pst.setString(6,bean.getAddress());
      pst.setString(7,bean.getDepartment());
      pst.setString(8,bean.getPost());
      pst.setString(9,bean.getQualification());
      pst.setString(10,bean.getExperience());
      pst.setString(11,bean.getDob());
      pst.setString(12,bean.getSalary());
      pst.setString(13,bean.getActivity());
      int count=pst.executeUpdate();
      return count;
    }
    catch(Exception e1){}
  }
  else
  {
    System.out.println("Table Already Exists");
  }

}
return 0;
}


}//class
