
package eRead.db;

import eRead.ui.LibrarianDlg;
import eRead.ui.AdminDlg;
import eRead.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class UserDAO {

    private static String CREATESQL = "create table user(userId varchar(100)  primary key not null,password varchar(100) not null, role varchar(100),name varchar(100) )";
    private static String INSERTSQL = "insert into user values(?,?,?,?)";
    private static String DELETELIBRARIAN = "delete  from user where userId = ?";
    private static String UPDATESQL = "";
    private static String READONESQL = "select * from user where userId = ?";
   // private static String READLIBID = "select userId ,name from user where role = Librarian";
    private static String READALLLIBRARIANS = "select * from user where role='LIBRARIAN'";
    private static String CHECKUSERID = "select * from user where userId = ?";

    public static void create() throws Exception {
        Connection con = null;
        PreparedStatement pStmt = null;
        try {
            con = DbConnection.getConnection();
            pStmt = con.prepareStatement(CREATESQL);
            pStmt.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            pStmt.close();
            con.close();
        }

    }

    public static void insert(User user) throws Exception {
        Connection con = null;
        PreparedStatement pStmt = null;
        try {
            con = DbConnection.getConnection();
            pStmt = con.prepareStatement(INSERTSQL);
            pStmt.setString(1, user.getUserId());
            pStmt.setString(2, user.getPassword());
            pStmt.setString(3, user.getRole());
            pStmt.setString(4, user.getName());
            pStmt.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            pStmt.close();
            con.close();
        }

    }

//    public static void readByUserId(String userid, String password) throws Exception {
//        Connection con = null;
//        PreparedStatement pStmt = null;
//        try {
//            con = DbConnection.getConnection();
//            pStmt = con.prepareStatement(READSQL);
//            pStmt.setString(1, userid);
//            ResultSet rs = pStmt.executeQuery();
//            if (rs.next()) {
//                User u = 
//                
//            }
////          String userPassword = rs.getString(1);
////          if(userPassword.equals(password))
////          {
////              String role = rs.getString(2);
////              if("Student".equalsIgnoreCase(role))
////              {
////                  //Student page display code
////              }
////              else if("Librarian".equalsIgnoreCase(role))
////              {
////                  LibrarianDlg lib = new LibrarianDlg();
////                  lib.setVisible(true);
////              }
////              else if("Admin".equalsIgnoreCase(role))
////              {
////                  AdminDlg adm = new AdminDlg();
////                  adm.setVisible(true);
////              }
////              else
////              {
////                  throw new Exception("!!!!!Invalid User Id or Password!!!!!");
////              }
////              
////              
////          }
////          else
////          {
////               throw new Exception("!!!!!Invalid User Id or Password!!!!!");
////          }
//
//        } catch (Exception ex) {
//            throw ex;
//        } finally {
//            pStmt.close();
//            con.close();
//        }
//
   // }
    public static User readOne(String userid) throws Exception {
        Connection con = null;
        PreparedStatement pStmt = null;
        try {
            con = DbConnection.getConnection();
            pStmt = con.prepareStatement(READONESQL);
            pStmt.setString(1, userid);
            ResultSet rs = pStmt.executeQuery();
          
            if (rs.next()) {
                User u = new User();
                u.setUserId(rs.getString(1));
                u.setPassword(rs.getString(2));
                u.setRole(rs.getString(3));
                u.setName(rs.getString(4));
                return u;
            } else {
                throw new Exception("Not Found!!");
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            pStmt.close();
            con.close();
        }
    }
    public static boolean checkUserId(String userId)throws Exception
    {
        Connection con = null;
        PreparedStatement pStmt = null;
        try 
        {
            con = DbConnection.getConnection();
            pStmt = con.prepareStatement(CHECKUSERID);
            pStmt.setString(1, userId);
            ResultSet rs = pStmt.executeQuery();
            if(rs.next())
                return true;
            else
                return false;
        
        }
        catch(Exception ex)
        {
            throw ex;
        }
    }
            
    

    public static List<User> readLibrarian() throws Exception {
        Connection con = null;
        PreparedStatement pStmt = null;
        try {
            con = DbConnection.getConnection();
            pStmt = con.prepareStatement(READALLLIBRARIANS);
            ResultSet rs = pStmt.executeQuery();
            List<User> librariansList = new ArrayList<>();
            while (rs.next()) {
                User usr = new User();
                usr.setUserId(rs.getString(1));
                usr.setPassword(rs.getString(2));
                usr.setRole(rs.getString(3));
                usr.setName(rs.getString(4));
                librariansList.add(usr);
            }
            return librariansList;
        } catch (Exception ex) {
            //ex.printStackTrace();
            throw ex;
        } finally {
            pStmt.close();
            con.close();
        }

    }
    public static void deleteLibrarian(String userId)
    {
        Connection con = null;
        PreparedStatement pStmt = null;
        try {
           
            con = DbConnection.getConnection();
           
            pStmt = con.prepareStatement(DELETELIBRARIAN);
             pStmt.setString(1, userId); 
            pStmt.executeUpdate();
             
        }
        catch(Exception ex)
        {
           //ex.printStackTrace(); 
        }
        
    }
   
    public static void main(String args[]) {
        try {
            create();
            System.out.println("Ok");
        } catch (Exception e) {
           // e.printStackTrace();
        }
    }

}
