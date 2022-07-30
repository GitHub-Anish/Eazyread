package eRead.db;


import eRead.entity.Book;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class BookDAO {
    
     private static String CREATESQL = "create table book(bookId varchar(100)  primary key not null, bookName varchar(100) not null, author varchar(100), stock varchar(100),status varchar(100) )";
     private static String INSERTSQL = "insert into book values(?,?,?,?,?)";
     private static String CHECKSTOCK = "select stock from book where bookId = ?";
     private static String UPDATESTOCK ="update book set stock = ? where bookId = ?";
     
     private static String UPDATESTATUS ="update book set status = ? where bookId = ?";
     
     
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
    public static void insert(Book book) throws Exception {
         Connection con = null;
        PreparedStatement pStmt = null;
        try {
            con = DbConnection.getConnection();
            pStmt = con.prepareStatement(INSERTSQL);
            pStmt.setString(1, book.getBookId());
            pStmt.setString(2, book.getBookName());
            pStmt.setString(3, book.getAuthor());
            pStmt.setString(4, book.getStock());
            pStmt.setString(5, book.getStatus());
            pStmt.executeUpdate();

        } catch (Exception ex) {
            throw ex;
        } finally {
            pStmt.close();
            con.close();
        }

    }
     public static String checkStock(String bookId)throws Exception
    {
        Connection con = null;
        PreparedStatement pStmt = null;
        try {
            con = DbConnection.getConnection();
            pStmt = con.prepareStatement(CHECKSTOCK);
            pStmt.setString(1, bookId);
            ResultSet rs = pStmt.executeQuery();
            if(!rs.next())
                return "-1";
            
            else
                return (rs.getString(1));
            
                
        }
        catch(Exception ex)
        {
            throw ex;
        }   
        
    }
    public static List<Book> searchAuthor(String author) throws Exception {
        Connection con = null;
        PreparedStatement pStmt = null;
        try {
            con = DbConnection.getConnection();
            
            // pStmt.setString(1, author);
             pStmt = con.prepareStatement("select * from book where author like '%" + author + "%'");
            ResultSet rs = pStmt.executeQuery();
            List<Book> bookList = new ArrayList<>();
            while (rs.next()) {
                Book usr = new Book();
                usr.setBookId(rs.getString(1));
                usr.setBookName(rs.getString(2));
                usr.setAuthor(rs.getString(3));
                usr.setStock(rs.getString(4));
                usr.setStatus(rs.getString(5));
                bookList.add(usr);
            }
            return bookList;
        } catch (Exception ex) {
            //ex.printStackTrace();
            throw ex;
        } finally {
            pStmt.close();
            con.close();
        }

    }
     
     public static void  updateBook(String bookId , String stock)
     {
        Connection con = null;
        PreparedStatement pStmt = null;
        try {
            con = DbConnection.getConnection();
            pStmt = con.prepareStatement(UPDATESTOCK);
            pStmt.setString(1, stock);
            pStmt.setString(2, bookId);
            pStmt.executeUpdate();
            
        }
        catch(Exception ex)
        {
            //ex.printStackTrace();
        }   
     }
    public static void updateStatus(String bookId ,String status)
    {
        Connection con = null;
        PreparedStatement pStmt = null;
        try 
        {
           con = DbConnection.getConnection();
            pStmt = con.prepareStatement(UPDATESTATUS);
            pStmt.setString(1, status);
            pStmt.setString(2, bookId);
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
            //e.printStackTrace();
        }
    }
}
