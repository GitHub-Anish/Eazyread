
package eRead.ui;

import eRead.db.UserDAO;
import eRead.entity.User;


public class AddStudentDlg extends javax.swing.JDialog {

    /**
     * Creates new form AddStudentDlg
     */
    public AddStudentDlg(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    AddStudentDlg() {
        initComponents();
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tName = new javax.swing.JTextField();
        tStudentId = new javax.swing.JTextField();
        tRegister = new javax.swing.JButton();
        tPassword = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setText("New Student");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(180, 20, 170, 22);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 500, 70);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Name :");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 90, 70, 30);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Student Id :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(140, 130, 100, 40);

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Password :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(140, 180, 90, 30);
        getContentPane().add(tName);
        tName.setBounds(290, 90, 120, 30);
        getContentPane().add(tStudentId);
        tStudentId.setBounds(290, 140, 120, 30);

        tRegister.setText("Register");
        tRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tRegisterActionPerformed(evt);
            }
        });
        getContentPane().add(tRegister);
        tRegister.setBounds(310, 290, 110, 23);
        getContentPane().add(tPassword);
        tPassword.setBounds(290, 190, 120, 30);

        jButton1.setText("Cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(140, 290, 80, 23);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(410, 270, 0, 0);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/eRead/ui/userpic_1.jpg"))); // NOI18N
        getContentPane().add(jLabel6);
        jLabel6.setBounds(0, 60, 500, 350);

        setSize(new java.awt.Dimension(515, 427));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tRegisterActionPerformed
        // TODO add your handling code here:
            try
        {
           
            String userId,password,role,name;
            userId = tStudentId.getText();
            password = String.valueOf(tPassword.getPassword());
            name= tName.getText();
            role= "Student";
            if((userId.indexOf(" ") != -1) || userId.length()== 0 )
            {
                javax.swing.JOptionPane.showMessageDialog(this, "Invalid Student id");
                
            }
            else if((password.indexOf(" ") != -1) || password.length()== 0  )
            {
                javax.swing.JOptionPane.showMessageDialog(this, "Invalid password");
                
            }
            else
            {   
                System.out.println(password+"turtu");
                User userdetails = new User(); 
                userdetails.setUserId(userId);
                userdetails.setPassword(password );
                userdetails.setName(name);
                userdetails.setRole(role);
                UserDAO u = new UserDAO();
                u.insert(userdetails);
                javax.swing.JOptionPane.showMessageDialog(this, "Student Details Added");
                tPassword.setText("");
                tStudentId.setText("");
                tName.setText("");
            }
          
            
            
            
        }
        catch(Exception e)
        {
          javax.swing.JOptionPane.showMessageDialog(this, "Student id alreay exists");
          tPassword.setText("");
          tStudentId.setText("");
          tName.setText("");
        }
           
        
    }//GEN-LAST:event_tRegisterActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
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
            java.util.logging.Logger.getLogger(AddStudentDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddStudentDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddStudentDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddStudentDlg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddStudentDlg dialog = new AddStudentDlg(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField tName;
    private javax.swing.JPasswordField tPassword;
    private javax.swing.JButton tRegister;
    private javax.swing.JTextField tStudentId;
    // End of variables declaration//GEN-END:variables
}
