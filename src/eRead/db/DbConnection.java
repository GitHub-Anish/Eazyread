package eRead.db;
import java.sql.*;

public class DbConnection {
    
    
        private static String driverClass = "com.mysql.cj.jdbc.Driver";
        private static String conUrl = "jdbc:mysql:///easyreaddb";
        public static Connection getConnection() throws Exception{
            Class.forName(driverClass);
            Connection con = DriverManager.getConnection(conUrl,"root","root");
            return con;
            
            }
            public static void main(String args[])
            {
                   try
                   {
                       System.out.println("con:"+getConnection());
                       
                               
                   }
                   catch(Exception e){
                       e.printStackTrace();
                       System.out.print("GfG1");
                   }
                        
            }
                
    }
    

