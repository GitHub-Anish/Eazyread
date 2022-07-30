
package eRead.ui;

import eRead.db.BookDAO;
import eRead.entity.Book;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class ViewBookDlg extends javax.swing.JDialog {

    /**
     * Creates new form ViewBookDlg
     */
    public ViewBookDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    ViewBookDlg() {
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

        jLabel4 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        tAuthor = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tTable = new javax.swing.JTable();
        C = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("SEARCH BOOK");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(220, 10, 270, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 640, 60);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("AUTHOR :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 140, 70, 30);

        tAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tAuthorActionPerformed(evt);
            }
        });
        getContentPane().add(tAuthor);
        tAuthor.setBounds(140, 140, 370, 30);

        jButton1.setText("GO");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(530, 140, 60, 30);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(490, 390, 0, 0);

        tTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "BOOK ID", "AUTHOR", "STATUS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tTable);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(50, 200, 540, 120);

        C.setText("HOME");
        C.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CActionPerformed(evt);
            }
        });
        getContentPane().add(C);
        C.setBounds(500, 80, 90, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eRead/ui/viewpic.jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(4, 64, 640, 370);

        setSize(new java.awt.Dimension(658, 473));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tAuthorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tAuthorActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String author = tAuthor.getText();
        try
        {
            List<Book> bookList =BookDAO.searchAuthor(author);
            DefaultTableModel dtm = new DefaultTableModel(new String[]{"BOOK NAME","AUTHOR","STATUS"},0);
            if(bookList.size() == 0)
            {
                javax.swing.JOptionPane.showMessageDialog(this, "No matching found");
                
            } 
            else
            {
            
        
                for (Book usr : bookList)
                {
                    dtm.addRow(new Object[]{usr.getBookName(),usr.getAuthor(),usr.getStatus()});
                }
                tTable.setModel(dtm);
            }    
        
        }
        catch(Exception ex)
        {
           // ex.printStackTrace();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CActionPerformed
        // TODO add your handling code here:
        
        this.dispose();
    }//GEN-LAST:event_CActionPerformed

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
            java.util.logging.Logger.getLogger(ViewBookDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBookDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBookDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBookDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ViewBookDlg dialog = new ViewBookDlg(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton C;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField tAuthor;
    private javax.swing.JTable tTable;
    // End of variables declaration//GEN-END:variables
}
