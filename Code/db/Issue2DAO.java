
package eRead.db;

import static eRead.db.BookDAO.create;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.table.DefaultTableModel;


public class Issue2DAO {
    private static String CREATESQL = "create table ReservationItem(reserveId varchar(100)  primary key not null,BookId varchar(100),Date_of_Issue varchar(100),Date_of_Return varchar(100))";
    private static String INSERTSQL = "insert into ReservationItem values(?,?,?,?)" ;
    private static String RESERVATION = "select * from ReservationItem where reserveId = ?";
    private static String RETURNBOOK = "DELETE from ReservationItem where reserveId = ?";
    private static String FINESQL = "select Date_of_Issue,Date_Of_Return from ReservationItem where reserveId = ?";
    
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
   public static void insert(String reservationId ,String bookId ,String dateOfIssue ,String dateOfReturn )throws Exception
    {
        Connection con = null;
        PreparedStatement pStmt = null;
        try {
            con = DbConnection.getConnection();
            pStmt = con.prepareStatement(INSERTSQL);
            pStmt.setString(1, reservationId);
            pStmt.setString(2, bookId);
            pStmt.setString(3, dateOfIssue);
            pStmt.setString(4, dateOfReturn);
            
            pStmt.executeUpdate();
        }
        catch(Exception ex)
        {
            //ex.printStackTrace();
        }
        finally {
            pStmt.close();
            con.close();
        }
    }
    public static DefaultTableModel resrvation(String[] reservationId)throws Exception
    {
        Connection con = null;
        PreparedStatement pStmt = null;
        try {
            con = DbConnection.getConnection();
            pStmt = con.prepareStatement(RESERVATION);
            DefaultTableModel dtm = new DefaultTableModel(new String[]{"Book Name", "Date of Issue","Date of return"},0);
            int i = 0;
            while(reservationId[i]!= null)
            {     
                pStmt.setString(1, reservationId[i]);
                ResultSet rs = pStmt.executeQuery();
                while(rs.next())
                {
                    dtm.addRow(new Object[]{rs.getString(2),rs.getString(3),rs.getString(4)});
                }
                i++;
                System.out.println(reservationId[i]);
                
            }
            return dtm;
            
            
        } catch (Exception ex) {
            //ex.printStackTrace();
            throw ex;
            
        } finally {
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
                String reservationId = bookId + studentId;
                pStmt.setString(1, reservationId);
                pStmt.executeUpdate();
        
            }
        catch(Exception ex)
        {
            //ex.printStackTrace();
        }
    }
    public static String fineIssueDay(String bookId,String studentId)throws Exception
    {
        Connection con = null;
        PreparedStatement pStmt = null;
            try 
            {
                 
                con = DbConnection.getConnection();
                pStmt = con.prepareStatement(FINESQL);
                String reservationId = bookId + studentId;
                pStmt.setString(1, reservationId);
                ResultSet rs = pStmt.executeQuery();
                String issDate = null;
                while(rs.next())
                {
                 issDate = rs.getString(1);
                 
                 
                }
                return issDate;
            }
            catch(Exception ex)
            {
                throw ex;
            }
            
        
    }
    public static String fineReturnDay(String bookId,String studentId)throws Exception
    {
        Connection con = null;
        PreparedStatement pStmt = null;
            try 
            {
                 
                con = DbConnection.getConnection();
                pStmt = con.prepareStatement(FINESQL);
                String reservationId = bookId + studentId;
                pStmt.setString(1, reservationId);
                ResultSet rs = pStmt.executeQuery();
                String retDate = null;
                while(rs.next())
                {
                 retDate = rs.getString(2);
                 System.out.println(retDate);
                 
                }
                return retDate;
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
