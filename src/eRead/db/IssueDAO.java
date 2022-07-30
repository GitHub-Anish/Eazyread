
package eRead.db;

import static eRead.db.BookDAO.create;
import eRead.entity.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class IssueDAO {
    private static String CREATESQL = "create table Reservation(reserveId varchar(100)  primary key not null,UserId varchar(100) )";
    private static String INSERTSQL = "insert into Reservation values(?,?)";
    private static String SEARCH = "select reserveId from Reservation where UserId= ?";
    private static String RETURNBOOK = "DELETE from Reservation where reserveId =?";
    private static String CHECKRETURN = "select * from Reservation where reserveId = ?";
    
    
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
    public static void insert(String reservationId ,String userId)throws Exception
    {
        Connection con = null;
        PreparedStatement pStmt = null;
        try {
            con = DbConnection.getConnection();
            pStmt = con.prepareStatement(INSERTSQL);
            pStmt.setString(1, reservationId);
            pStmt.setString(2, userId);
            pStmt.executeUpdate();
        }
        catch(Exception ex)
        {
            throw ex;
        }
        finally {
            pStmt.close();
            con.close();
        }
    }
    public static void returnBook(String bookId ,String studentId)
    {        
        
            Connection con = null;
            PreparedStatement pStmt = null;
            try 
            {
                con = DbConnection.getConnection();
                pStmt = con.prepareStatement(RETURNBOOK);
                System.out.println(pStmt);
                String reservationId = bookId + studentId;
                pStmt.setString(1, reservationId);
                pStmt.executeUpdate();
        
            }
        catch(Exception ex)
        {
            //ex.printStackTrace();
        }
    }
   
        public static String[] issuedBook(String studentId) throws Exception {
        Connection con = null;
        PreparedStatement pStmt = null;
        try {
            con = DbConnection.getConnection();
            pStmt = con.prepareStatement(SEARCH);
             pStmt.setString(1, studentId);
            ResultSet rs = pStmt.executeQuery();
            String[] issue = new String[4] ;
            int i=0;
            while (rs.next()) {
                issue[i] = rs.getString(1);
                i=i+1;
            }
            return issue;
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        } finally {
            pStmt.close();
            con.close();
        }

    }
    public static boolean checkReturn(String userId,String bookId)throws Exception
    {
        Connection con = null;
        PreparedStatement pStmt = null;
        try 
        {
            con = DbConnection.getConnection();
            pStmt = con.prepareStatement(CHECKRETURN);
            String res = bookId + userId;
            pStmt.setString(1,res);
            System.out.println(res);
            
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
    public static int checkNoBooks(String studentId)throws Exception
    {
        Connection con = null;
        PreparedStatement pStmt = null;
        try 
        {
            con = DbConnection.getConnection();
            pStmt = con.prepareStatement(SEARCH);
            pStmt.setString(1, studentId);
            ResultSet rs = pStmt.executeQuery();
            int count = 0 ;
            while(rs.next())
            {
                count=count +1;
            }
            return count;
        
        } 
        catch(Exception ex)
        {
           throw ex; 
        }
    }
    
    
    public static void main(String args[]) {
        try {
            create();
            System.out.println("Ok");
        } catch (Exception e) {
            //e.printStackTrace();
        }
    }
     
    
}
