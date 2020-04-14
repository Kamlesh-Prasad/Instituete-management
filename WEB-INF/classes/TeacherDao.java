package dao;
import java.sql.*;
import dao.DriverConnection;
import bean.TeacherBean;
import java.util.ArrayList;
import java.util.List;
public class TeacherDao{

public static List<TeacherBean> getAllRecords()
{
  List<TeacherBean> list=new ArrayList<TeacherBean>();
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("SELECT * FROM TEACHERDATA");
    ResultSet rs=pst.executeQuery();
    while(rs.next())
    {
      TeacherBean bean=new TeacherBean();
      bean.setID(rs.getInt(1));
      bean.setFirstName(rs.getString(2));
      bean.setLastName(rs.getString(3));
      bean.setEmail(rs.getString(4));
      bean.setMobile(rs.getString(5));
      bean.setAddress(rs.getString(6));
      bean.setInstitute(rs.getString(7));
      bean.setSubject(rs.getString(8));
      bean.setQualification(rs.getString(9));
      bean.setExperience(rs.getString(10));
      bean.setDob(rs.getString(11));
      bean.setSalary(rs.getString(12));
      bean.setActivity(rs.getString(13));
      list.add(bean);
    }
    con.close();
    System.out.println("Database Disconnected");
  }
  catch(Exception e){
    System.out.println("TeacherDao: Error"+e);
  }
  return list;
}


public static TeacherBean getRecordById(int teacherid)
{
  TeacherBean bean=new TeacherBean();
  ResultSet rs=null;
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("SELECT * FROM TEACHERDATA WHERE ID=?");
    pst.setInt(1,teacherid);
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
        bean.setInstitute(rs.getString(7));
        bean.setSubject(rs.getString(8));
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
      System.out.println("TeacherDao Bean= "+bean.getStatus());
    }

    con.close();
    System.out.println("TeacherDao getRecordById() By= "+teacherid);
    System.out.println("Database Disconnected of getRecordById()");
  }
  catch(Exception e){
    System.out.println("getRecordById(): Error"+e);
  }
  return bean;
}

public static TeacherBean getRecordByFirstName(String firstname)
{
  TeacherBean bean=new TeacherBean();
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("SELECT * FROM TEACHERDATA WHERE FIRSTNAME=?");
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
      bean.setInstitute(rs.getString(7));
      bean.setSubject(rs.getString(8));
      bean.setQualification(rs.getString(9));
      bean.setExperience(rs.getString(10));
      bean.setDob(rs.getString(11));
      bean.setSalary(rs.getString(12));
      bean.setActivity(rs.getString(13));
    }
    con.close();
    System.out.println("TeacherDao getRecords() By= "+firstname);
    System.out.println("Database Disconnected");
  }
  catch(Exception e){
    System.out.println("TeacherDao: Error"+e);
  }
  return bean;
}

public static TeacherBean getRecordByMobile(String mobile)
{
  TeacherBean bean=new TeacherBean();
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("SELECT * FROM TEACHERDATA WHERE MOBILE=?");
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
      bean.setInstitute(rs.getString(7));
      bean.setSubject(rs.getString(8));
      bean.setQualification(rs.getString(9));
      bean.setExperience(rs.getString(10));
      bean.setDob(rs.getString(11));
      bean.setSalary(rs.getString(12));
      bean.setActivity(rs.getString(13));
    }
    con.close();
    System.out.println("TeacherDao getRecordByMobile() By= "+mobile);
    System.out.println("Database Disconnected");
  }
  catch(Exception e){
    System.out.println("TeacherDao: Error"+e);
  }
  return bean;
}

public static TeacherBean getRecordByUsername(String username)
{
  TeacherBean bean=new TeacherBean();
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("SELECT * FROM TEACHERDATA WHERE USERNAME=?");
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
      bean.setInstitute(rs.getString(7));
      bean.setSubject(rs.getString(8));
      bean.setQualification(rs.getString(9));
      bean.setExperience(rs.getString(10));
      bean.setDob(rs.getString(11));
      bean.setSalary(rs.getString(12));
      bean.setActivity(rs.getString(13));
    }
    con.close();
    System.out.println("TeacherDao getRecordsByUsername() By= "+username);
    System.out.println("Database Disconnected");
  }
  catch(Exception e){
    System.out.println("TeacherDao: Error"+e);
  }
  return bean;
}

public static int update(TeacherBean bean){
  int status=0;
  System.out.println("TeacherDao update() id="+bean.getID());
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("UPDATE TEACHERDATA SET FIRSTNAME=?,LASTNAME=?,EMAIL=?,MOBILE=?,ADDRESS=?,INSTITUTE=?,SUBJECT=?,QUALIFICATION=?,EXPERIENCE=?,DOB=?,SALARY=?,ACTIVITY=? WHERE ID=?");
    pst.setString(1,bean.getFirstName());
    pst.setString(2,bean.getLastName());
    pst.setString(3,bean.getEmail());
    pst.setString(4,bean.getMobile());
    pst.setString(5,bean.getAddress());
    pst.setString(6,bean.getInstitute());
    pst.setString(7,bean.getSubject());
    pst.setString(8,bean.getQualification());
    pst.setString(9,bean.getExperience());
    pst.setString(10,bean.getDob());
    pst.setString(11,bean.getSalary());
    pst.setString(12,bean.getActivity());
    pst.setInt(13,bean.getID());
    status=pst.executeUpdate();
    System.out.println("TeacherDao update() status="+status);
    con.close();
    System.out.println("Database close of update");
  }
  catch(Exception e){System.out.println(e);}
  return status;
}



public static int removeTeacher(int teacherid){
  int status=0;
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("DELETE FROM TEACHERDATA WHERE ID=?");
    pst.setInt(1,teacherid);
    status=pst.executeUpdate();
    con.close();
    System.out.println("TeacherDao removeTeacher() status="+status);
    System.out.println("Database close of removeTeacher()");
  }
  catch(Exception e){System.out.println(e);}
  return status;
}

public static boolean createAccount()
{
  boolean status=true;
  try{
    Connection con=DriverConnection.getConnection();
    PreparedStatement pst=con.prepareStatement("CREATE TABLE TEACHERDATA (ID NUMBER(12),FIRSTNAME VARCHAR2(20),LASTNAME VARCHAR2(20),EMAIL VARCHAR2(50),MOBILE VARCHAR2(20),ADDRESS VARCHAR2(20),INSTITUTE VARCHAR2(50),SUBJECT VARCHAR2(20),QUALIFICATION VARCHAR2(20),EXPERIENCE VARCHAR2(20),DOB VARCHAR2(20),SALARY VARCHAR2(20),ACTIVITY VARCHAR2(20))");
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
    PreparedStatement pst=con.prepareStatement("SELECT * FROM TEACHERDATA");
    ResultSet rs=pst.executeQuery();
    while(rs.next())
    {
    count=rs.getInt(1);
    }
      con.close();
  }
  catch (Exception e)
  {
    System.out.println("Exception of getLastID() of TeacherDao");
    System.out.println(e);
  }
  System.out.println("Before count="+count);
  return count+1;
}


public static int insertData(TeacherBean bean)
{
  String query="INSERT INTO TEACHERDATA(ID,FIRSTNAME,LASTNAME,EMAIL,MOBILE,ADDRESS,INSTITUTE,SUBJECT,QUALIFICATION,EXPERIENCE,DOB,SALARY,ACTIVITY)VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
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
pst.setString(7,bean.getInstitute());
pst.setString(8,bean.getSubject());
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
    System.out.println("Exception of insertData() of RegisterTeacher "+e);
  if (!TeacherDao.createAccount())
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
      pst.setString(7,bean.getInstitute());
      pst.setString(8,bean.getSubject());
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
