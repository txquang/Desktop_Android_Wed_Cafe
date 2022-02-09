//-------------------------------------------------------Xong------------------------------------------------
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class DangNhap extends javax.swing.JFrame 
{

    /**
     * Creates new form DangNhap
     */
    int d = 0;
    int clg = 0;
    String MaNV = "", MaBP = "";
    Statement truyvan;
    java.sql.Connection conn;
    
    public void LoadDB()
    {
        CT_ConnetDB x =new CT_ConnetDB();
        conn = x.ConnetDB();
        try {
            truyvan = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        } catch (SQLException ex) {
            Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    public DangNhap() 
    {
        initComponents();
        LoadDB();
    }

    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        DangNhapBT = new javax.swing.JButton();
        ThoatBT = new javax.swing.JButton();
        TKTF = new javax.swing.JTextField();
        MKTF = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng Nhập");
        setAlwaysOnTop(true);

        jPanel1.setBackground(new java.awt.Color(204, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icons8-user-16.png"))); // NOI18N
        jLabel1.setText("Tài Khoản");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 0));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icons8-password-16.png"))); // NOI18N
        jLabel2.setText("Mật Khẩu");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 0, 0));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Đăng Nhập");

        DangNhapBT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DangNhapBT.setForeground(new java.awt.Color(153, 51, 0));
        DangNhapBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icons8-login-20.png"))); // NOI18N
        DangNhapBT.setText("Đăng Nhập");
        DangNhapBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DangNhapBTActionPerformed(evt);
            }
        });

        ThoatBT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ThoatBT.setForeground(new java.awt.Color(255, 51, 51));
        ThoatBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icons8-close-window-20.png"))); // NOI18N
        ThoatBT.setText("Thoát");
        ThoatBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThoatBTActionPerformed(evt);
            }
        });

        TKTF.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TKTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TKTFActionPerformed(evt);
            }
        });

        MKTF.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        MKTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MKTFActionPerformed(evt);
            }
        });
        MKTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                MKTFKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Trần Xuân Quang-18I3");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(MKTF, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(TKTF, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(DangNhapBT)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ThoatBT, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 32, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TKTF, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MKTF, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DangNhapBT)
                    .addComponent(ThoatBT))
                .addGap(32, 32, 32)
                .addComponent(jLabel4))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void DangNhapBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DangNhapBTActionPerformed
        // TODO add your handling code here:
        Login();
    }//GEN-LAST:event_DangNhapBTActionPerformed

    private void ThoatBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThoatBTActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_ThoatBTActionPerformed

    private void MKTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_MKTFKeyReleased
        // TODO add your handling code here:
         if (evt.getKeyCode() == KeyEvent.VK_ENTER)
        {
            Login();
        }
    }//GEN-LAST:event_MKTFKeyReleased

    private void MKTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MKTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MKTFActionPerformed

    private void TKTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TKTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TKTFActionPerformed

    
    public void Login() // Ham login
    {
        clg++;
        if (clg > 3) 
        {
            JOptionPane.showMessageDialog(rootPane, "Bạn đã nhập sai quá nhiều!!! ",
                    "Thông báo", JOptionPane.WARNING_MESSAGE);
            setVisible(false);
        } 
        else 
        {
            try 
            {
                ResultSet rs = truyvan.executeQuery("select TaiKhoan, MatKhau, MaNV from TaiKhoan");//thueu nhan vien nghi MaBP=BPOT

                while ( rs.next() ) 
                {

                    if (  (rs.getString(1).trim().equals(TKTF.getText()) && ( rs.getString(2).trim().equals(MKTF.getText())) )  ) 
                    {
//                        JOptionPane.showMessageDialog(rootPane, "Đăng nhập thành công ! ",
//                                "Notification", JOptionPane.WARNING_MESSAGE);
                        setVisible(false);
                        d++;
                        MaNV = rs.getString(3).trim();        
                    
                    }
                    if (d >= 1)
                    {
                        VaoForm();
                        break;
                    }

                }

                if (d == 0) 
                {
                    JOptionPane.showMessageDialog(rootPane, "Tài khoản hoặc mật khẩu không chính xác ! ",
                            "Thông báo", JOptionPane.WARNING_MESSAGE);
                    MKTF.setText("");
                }

            } catch (SQLException ex) 
            {
                System.out.println(ex);
            }

        }
       
        
    }
    public void VaoForm()
    {
        String TenNV = "";
        if ( MaNV.length() > 0) 
        {
            try 
            {
                ResultSet rs = truyvan.executeQuery("select MaBP, HoTen from NhanVien where MaNV='"+MaNV+"' ");
                while (rs.next()) 
                {
                    MaBP  = rs.getString(1).trim();
                    TenNV = rs.getString(2).trim();
                }

            } 
            catch (Exception e) 
            {
                System.err.println(e);
            }
        } 
        if( MaBP.equals("BPQL") )
        {
          
            CT_DangNhap N = new CT_DangNhap(MaNV, TenNV);
            Quan_Ly_NV C = new Quan_Ly_NV(N);
            this.dispose();
            C.setVisible(true);
        }
        else
            if( MaBP.equals("BPTN") || MaBP.equals("BPKT") )
            {
                CT_DangNhap N = new CT_DangNhap(MaNV, TenNV);
                Form_Chinh C = new Form_Chinh(N);
                this.dispose();
                C.setVisible(true);
            }
               
            else
                JOptionPane.showMessageDialog(rootPane, "Tài khoản Không có quyền đăng nhập ! ",
                            "Thông báo", JOptionPane.WARNING_MESSAGE);
    }
            
    public static void main(String args[]) 
    {
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
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new DangNhap().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DangNhapBT;
    private javax.swing.JPasswordField MKTF;
    private javax.swing.JTextField TKTF;
    private javax.swing.JButton ThoatBT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
