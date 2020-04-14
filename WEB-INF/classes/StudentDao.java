package dao;
import java.sql.*;
import dao.DriverConnection;
import bean.StudentBean;
import java.util.ArrayList;
import java.util.List;
public class StudentDao{
static String query="CREATE TABLE SDATA(ID NUMBER(10),ROLLNO VARCHAR2(30),FIRSTNAME VARCHAR2(30),MIDNAME VARCHAR2(20),LASTNAME VARCHAR2(30),FATHERNAME VARCHAR2(30),MOTHERNAME VARCHAR2(30),DOB VARCHAR2(11),GENDER VARCHAR2(10),CATEGORY VARCHAR2(5),AGE VARCHAR2(2),EMAIL VARCHAR2(40),MOBILE VARCHAR2(11),PINCODE VARCHAR2(7),CITY VARCHAR2(10),STATE VARCHAR2(40),NATIONALITY VARCHAR2(20),ADDRESS1 VARCHAR2(50),ADDRESS2 VARCHAR2(50),MEDIUM VARCHAR2(10),BLOODGROUP VARCHAR2(10),LASTINSTITUTENAME VARCHAR2(100),LASTINSTITUTEYEAR VARCHAR2(5),LASTINSTITUTECLASS VARCHAR2(10),ADMITEDCLASS VARCHAR2(10),SECTION VARCHAR2(10),GROUP VARCHAR2(20))";
  public static boolean createAccount()
  {
    boolean status=true;
    try{
      Connection con=DriverConnection.getConnection();
      PreparedStatement pst=con.prepareStatement(query);
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
    int count=1;
    System.out.println("Before count="+count);
    try
    {
      Connection con=DriverConnection.getConnection();
      PreparedStatement pst=con.prepareStatement("SELECT * FROM STUDENTDATA");
      ResultSet rs=pst.executeQuery();
      while(rs.next())
      {
      count=rs.getInt(1);
      }
        con.close();
    }
    catch (Exception e)
    {
      System.out.println("Exception of getLastID() of StudentDao");
      System.out.println(e);
    }
    System.out.println("Before count="+count);
    return count+1;
  }


  public static int getLastRollno()
  {
    int count=100000;
    System.out.println("Before count="+count);
    try
    {
      Connection con=DriverConnection.getConnection();
      PreparedStatement pst=con.prepareStatement("SELECT * FROM STUDENTDATA");
      ResultSet rs=pst.executeQuery();
      while(rs.next())
      {
      count=rs.getInt(2);
      }
        con.close();
    }
    catch (Exception e)
    {
      System.out.println("Exception of getLastID() of StudentDao");
      System.out.println(e);
    }
    System.out.println("Before count="+count);
    return count+1;
  }


  public static int insertData(StudentBean bean)
  {
    String query="INSERT INTO STUDENTDATA(ID,ROLLNO,FIRSTNAME,MIDNAME,LASTNAME,FATHERNAME,MOTHERNAME,DOB,GENDER,CATEGORY,AGE,EMAIL,MOBILE,PINCODE,CITY,STATE,NATIONALITY,ADDRESS1,ADDRESS2,MEDIUM,BLOODGROUP,LASTINSTITUTENAME,LASTINSTITUTEYEAR,LASTINSTITUTECLASS,ADMITEDCLASS,SECTION,GROUP)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
  try
  {
  Connection con=DriverConnection.getConnection();
  PreparedStatement pst=con.prepareStatement(query);
  pst.setInt(1,bean.getID());
  pst.setString(2,String.valueOf(bean.getRollno()));
  pst.setString(3,bean.getFirstName());
  pst.setString(4,bean.getMidName());
  pst.setString(5,bean.getLastName());
  pst.setString(6,bean.getFatherName());
  pst.setString(7,bean.getMotherName());
  pst.setString(8,bean.getDob());
  pst.setString(9,bean.getGender());
  pst.setString(10,bean.getCategory());
  pst.setString(11,bean.getAge());
  pst.setString(12,bean.getEmail());
  pst.setString(13,bean.getMobile());
  pst.setString(14,bean.getPincode());
  pst.setString(15,bean.getCity());
  pst.setString(16,bean.getState());
  pst.setString(17,bean.getNationality());
  pst.setString(18,bean.getAddress1());
  pst.setString(19,bean.getAddress2());
  pst.setString(20,bean.getMedium());
  pst.setString(21,bean.getBloodgroup());
  pst.setString(22,bean.getLastInstituteName());
  pst.setString(23,bean.getLastInstituteYear());
  pst.setString(24,bean.getLastInstituteClass());
  pst.setString(25,bean.getAdmintClass());
  pst.setString(26,bean.getSection());
  pst.setString(27,bean.getGroup());
  int count=pst.executeUpdate();
  return count;
  }
  catch (SQLException e)
  {
      System.out.println("Exception of insertData() of AdmitStudent "+e);
    if (!StudentDao.createAccount())
     {
      System.out.println("Table Created");
      try {
        Connection con=DriverConnection.getConnection();
        PreparedStatement pst=con.prepareStatement(query);
        pst.setInt(1,bean.getID());
        pst.setInt(2,bean.getRollno());
        pst.setString(3,bean.getFirstName());
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

/*
public static List<StudentBean> getAllRecords()
{
  List<StudentBean> list=new ArrayList<StudentBean>();
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("SELECT * FROM StudentDATA");
    ResultSet rs=pst.executeQuery();
    while(rs.next())
    {
      StudentBean bean=new StudentBean();
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
    System.out.println("StudentDao: Error"+e);
  }
  return list;
}


public static StudentBean getRecordById(int Studentid)
{
  StudentBean bean=new StudentBean();
  ResultSet rs=null;
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("SELECT * FROM StudentDATA WHERE ID=?");
    pst.setInt(1,Studentid);
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
      System.out.println("StudentDao Bean= "+bean.getStatus());
    }

    con.close();
    System.out.println("StudentDao getRecords() By= "+Studentid);
    System.out.println("Database Disconnected");
  }
  catch(Exception e){
    System.out.println("StudentDao: Error"+e);
  }
  System.out.println("StudentDao Bean= "+bean.getStatus());
  return bean;
}

public static StudentBean getRecords(String firstname)
{
  StudentBean bean=new StudentBean();
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("SELECT * FROM StudentDATA WHERE FIRSTNAME=?");
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
    System.out.println("StudentDao getRecords() By= "+firstname);
    System.out.println("Database Disconnected");
  }
  catch(Exception e){
    System.out.println("StudentDao: Error"+e);
  }
  return bean;
}

public static StudentBean getRecordByMobile(String mobile)
{
  StudentBean bean=new StudentBean();
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("SELECT * FROM StudentDATA WHERE MOBILE=?");
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
    System.out.println("StudentDao getRecordByMobile() By= "+mobile);
    System.out.println("Database Disconnected");
  }
  catch(Exception e){
    System.out.println("StudentDao: Error"+e);
  }
  return bean;
}

public static StudentBean getRecordByUsername(String username)
{
  StudentBean bean=new StudentBean();
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("SELECT * FROM StudentDATA WHERE USERNAME=?");
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
    System.out.println("StudentDao getRecordsByUsername() By= "+username);
    System.out.println("Database Disconnected");
  }
  catch(Exception e){
    System.out.println("StudentDao: Error"+e);
  }
  return bean;
}

public static int update(StudentBean bean){
  int status=0;
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("UPDATE StudentDATA SET FIRSTNAME=?,LASTNAME=?,EMAIL=?,MOBILE=?,ADDRESS=?,PLACE=?,USERNAME=?,PASSWORD=? WHERE FIRSTNAME=?");
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



public static int removeStudent(int Studentid){
  int status=0;
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("DELETE StudentDATA WHERE ID=?");
    pst.setInt(1,Studentid);
    status=pst.executeUpdate();
    con.close();
    System.out.println("Database close of removeStudent()");
  }
  catch(Exception e){System.out.println(e);}
  return status;
}



*/
}//class
