
package eRead.ui;

import eRead.db.BookDAO;
import eRead.db.UserDAO;
import eRead.db.Issue2DAO;
import eRead.db.IssueDAO;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;


public class IssueDlg extends javax.swing.JDialog {

    /**
     * Creates new form issueDlg
     */
    public IssueDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    IssueDlg() {
        initComponents();
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tBookId = new javax.swing.JTextField();
        bSubmit = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        tStudentId = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("        Issue Book");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(210, 10, 200, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 650, 70);

        jPanel2.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Book Id :");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(160, 120, 90, 20);
        jPanel2.add(tBookId);
        tBookId.setBounds(370, 120, 130, 30);

        bSubmit.setText("Issue");
        bSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSubmitActionPerformed(evt);
            }
        });
        jPanel2.add(bSubmit);
        bSubmit.setBounds(270, 240, 120, 23);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Student Id :");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(160, 170, 100, 30);
        jPanel2.add(tStudentId);
        tStudentId.setBounds(370, 170, 130, 30);

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setText("Home");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);
        jButton1.setBounds(549, 20, 70, 40);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eRead/ui/issuepic_1.jpg"))); // NOI18N
        jPanel2.add(jLabel5);
        jLabel5.setBounds(0, 0, 650, 450);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 70, 650, 450);

        setSize(new java.awt.Dimension(666, 555));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSubmitActionPerformed
        // TODO add your handling code here:
        String bookId , studentId ;
        
        bookId = tBookId.getText();
        studentId = tStudentId.getText();
       // GregorianCalendar clr = (GregorianCalendar)GregorianCalendar.getInstance();
        long millis = System.currentTimeMillis();
        java.sql.Date dateofIssue,dateofReturn,actualDateOfReturn;
        dateofIssue= new java.sql.Date(millis);
        dateofReturn = new java.sql.Date(millis);
        String dateofIssue1 = dateofIssue.toString();
        dateofReturn.setDate(dateofIssue.getDate()+14);
        String dateofReturn1 = dateofReturn.toString();
        
        
        try
        {
           if(UserDAO.checkUserId(studentId))
           {
                if((IssueDAO.checkNoBooks(studentId)) < 3)
                {
                
                        String stock = BookDAO.checkStock(bookId);
                        if("0".equalsIgnoreCase(stock))
                        {
                                javax.swing.JOptionPane.showMessageDialog(this, "Book is not avilable");
                        } 
                        else
                        {
                            if(Integer.parseInt(stock) >= 1)
                            {
                                int newStock = Integer.parseInt(stock) -1 ;
                                BookDAO.updateBook(bookId, Integer.toString(newStock));
                                String reservationId = bookId + studentId;
                                IssueDAO.insert(reservationId, studentId);
                               // String i = clr.getTime().toString();
                                //clr.add((GregorianCalendar.DATE), 14);
                
                                Issue2DAO.insert(reservationId, bookId,dateofIssue1,dateofReturn1);
                                System.out.println(dateofIssue);
                                System.out.println(dateofReturn);
                                System.out.println(bookId);
               
                                if(newStock == 0)
                                {    
                    
                                    try
                                    {
                                        BookDAO.updateStatus(bookId, "Not Available");
                                        
                        
                        
                                    }
                                    catch(Exception ex)
                                    {
                                        //ex.printStackTrace();
                                    }
                                }
                                
                                 javax.swing.JOptionPane.showMessageDialog(this, "Book issued");
                                tBookId.setText("");
                                tStudentId.setText("");
                
                            }
                            else
                            {
                                javax.swing.JOptionPane.showMessageDialog(this, "Book is not avilable");
                                tBookId.setText("");
                                tStudentId.setText("");
                            }   
            
                        }
                }
                else
                {
                    javax.swing.JOptionPane.showMessageDialog(this, "Already 3 book issued");
                    tBookId.setText("");
                    tStudentId.setText("");
                }    
           }
           else
           {
              javax.swing.JOptionPane.showMessageDialog(this, "Invalid Student");
              tBookId.setText("");
               tStudentId.setText("");
           }    
          
        }
        catch(Exception ex)
        {
           javax.swing.JOptionPane.showMessageDialog(this, "Student is already holding this book"); 
           tBookId.setText("");
           tStudentId.setText("");
        }
        
        

        
        
      
       
        
        
    }//GEN-LAST:event_bSubmitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        LibrarianDlg ld = new  LibrarianDlg();
        ld.setVisible(true);
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(IssueDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IssueDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IssueDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IssueDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                IssueDlg dialog = new IssueDlg(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bSubmit;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField tBookId;
    private javax.swing.JTextField tStudentId;
    // End of variables declaration//GEN-END:variables
}