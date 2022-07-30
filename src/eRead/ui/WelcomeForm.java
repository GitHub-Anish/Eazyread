package eRead.ui;


public class WelcomeForm extends javax.swing.JFrame {

    /**
     * Creates new form WelcomeForm
     */
    public WelcomeForm() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        pnlTitle = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        bAdmin = new javax.swing.JButton();
        bLibrarian = new javax.swing.JButton();
        bSearch = new javax.swing.JButton();
        bStudent = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(null);

        pnlTitle.setBackground(new java.awt.Color(153, 153, 255));
        pnlTitle.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText(" WELCOME TO EAZYREAD");
        pnlTitle.add(jLabel1);
        jLabel1.setBounds(230, 10, 300, 40);

        getContentPane().add(pnlTitle);
        pnlTitle.setBounds(0, 0, 740, 70);

        jPanel1.setLayout(null);

        bAdmin.setText("ADMIN");
        bAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAdminActionPerformed(evt);
            }
        });
        jPanel1.add(bAdmin);
        bAdmin.setBounds(180, 120, 160, 40);

        bLibrarian.setText("LIBRARIAN");
        bLibrarian.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bLibrarianActionPerformed(evt);
            }
        });
        jPanel1.add(bLibrarian);
        bLibrarian.setBounds(40, 190, 190, 40);

        bSearch.setText("SEARCH BOOK");
        bSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSearchActionPerformed(evt);
            }
        });
        jPanel1.add(bSearch);
        bSearch.setBounds(280, 270, 180, 40);

        bStudent.setText("STUDENT");
        bStudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStudentActionPerformed(evt);
            }
        });
        jPanel1.add(bStudent);
        bStudent.setBounds(280, 190, 180, 40);

        jButton1.setText("STUDENT REGISTRATION");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(40, 270, 190, 40);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(480, 330, 0, 0);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eRead/ui/welpic_1.jpg"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 10, 710, 480);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 60, 740, 490);

        setSize(new java.awt.Dimension(684, 578));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void bAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAdminActionPerformed
            // TODO add your handling code here:
        try
        {
            
            LoginDlg lgn = new LoginDlg();
            lgn.setVisible(true);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
            
    }//GEN-LAST:event_bAdminActionPerformed

    private void bLibrarianActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bLibrarianActionPerformed
        // TODO add your handling code here:
         try
        {
            
            LoginDlg lgn = new LoginDlg();
            lgn.setVisible(true);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }//GEN-LAST:event_bLibrarianActionPerformed

    private void bSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSearchActionPerformed
        // TODO add your handling code here:
        ViewBookDlg view = new ViewBookDlg();
        view.setVisible(true);
        
    }//GEN-LAST:event_bSearchActionPerformed

    private void bStudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStudentActionPerformed
        // TODO add your handling code here:
        LoginDlg lgn = new LoginDlg();
        lgn.setVisible(true);
    }//GEN-LAST:event_bStudentActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        AddStudentDlg ads = new AddStudentDlg();
        ads.setVisible(true);
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
            java.util.logging.Logger.getLogger(WelcomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WelcomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WelcomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WelcomeForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WelcomeForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAdmin;
    private javax.swing.JButton bLibrarian;
    private javax.swing.JButton bSearch;
    private javax.swing.JButton bStudent;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel pnlTitle;
    // End of variables declaration//GEN-END:variables
}
