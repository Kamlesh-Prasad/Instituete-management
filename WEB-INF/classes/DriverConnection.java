package dao;
import java.sql.*;
public class DriverConnection{
  static Connection con;
  public static Connection getConnection()
  {
    try{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system");
      }
      catch(Exception e)
      {
        System.out.println(e);
      }
      return con;
  }

}
