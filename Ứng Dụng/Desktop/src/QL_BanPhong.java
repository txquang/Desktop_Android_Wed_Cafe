
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Vu Anh Tai
 */
public class QL_BanPhong extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form QL_BanPhong
     */
    public String MaBan, TenBan, MaKhuVuc, TrangThai;
    public QL_BanPhong() {
        initComponents();
        LoadDB();
        SoDoBan();
        SuaSPBT.setVisible(false);
        XoaSPBT1.setVisible(false);
        ANSPBT.setVisible(false);
        TTSPBT.setVisible(false);
    }
    //
    java.sql.Connection conn;
    Statement truyvan;
    ResultSet rs,rs1;
    
    public void LoadDB()
    {
        try
	{   
            CT_ConnetDB x =new CT_ConnetDB();
            conn = x.ConnetDB();
            truyvan = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
        }
        catch (SQLException e)
        {
            JOptionPane.showMessageDialog(null, "Kết nối sql thất bại");  
        }
    }
    
    public void SoDoBan()
    {
        int TrangThai;
        String html;
        SoDoBanPN.setVisible(false);
        SoDoBanPN.removeAll();
        try 
        {
            rs=truyvan.executeQuery("SELECT SoBan, NoUse, KV.MaKV, TenBan, KV.TenKV\n" +
                                    "   FROM BanPhong BP full join KhuVuc KV\n" +
                                    "		on BP.MaKV = KV.MaKV");
            while (rs.next())
            {
                html = "<html>"
                        + "<div style=\"text-align: center;\"><span style=\" color: #008000; font-size: 120%;\"><strong>"+rs.getString(4)+"</strong></span></div>\n" +
                           "<div style=\"text-align: center;\"><strong><span style=\"color: #ff6600;\">"+"<span style=\"color: #808080;\">"+rs.getString(5)+"</span></span></strong></div>"
                        + "</html>" ;
                JButton button = new JButton(html);//lay ten ban
                
                
                TrangThai =Integer.parseInt(rs.getString(2).trim());
                switch(TrangThai) {
                    case 0:
                      // con trong
                      button.setBackground( new Color(191, 239, 255));
                      break;
                    case 1:
                      // dang su dung
                      button.setBackground( new Color(255, 255, 153)); 
                      break;
                    case 2:
                      // an ban
                      button.setBackground( Color.gray); 
                      break;
                    case 3:
                      // thoi tiet
                        button.setBackground( Color.PINK); 
                      break;
                    case 4:
                      // thoi tiet
                       button.setBackground( Color.RED); 
                      break;
                    default:
                      // code block
                  }
                button.setName(rs.getString(2)+"-"+rs.getString(4)+"-"+rs.getString(3));//lay trạng thái va ten
                button.setActionCommand(rs.getString(1));
                button.addActionListener( this);
                SoDoBanPN.add(button); 
	    }
        } 
        catch (Exception e) 
        {
            System.err.println(e);
            
        }
        SoDoBanPN.setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String S = e.getActionCommand();//lấy ma ban
        JButton o = (JButton)e.getSource();
        System.err.println(S);
        
        String[] parts = o.getName().split("-");
        String part1 = parts[0]; // 004
        String part2 = parts[1]; // 034556
        String part3 = parts[2];
        //System.err.println(part1);//trạng thái
        //System.err.println(part2);  //ten bàn
        //System.err.println(part3);//ma khu vuc
        
        TenBanTF.setText(part2);
        KhuVucTF.setText(part3);
        
        MaBan = S;
        TrangThai = part1;
        TenBan = part2;
        MaKhuVuc = part3;
        
        
       switch(Integer.parseInt(TrangThai)) {
                    case 0:
                      // con trong
                        SuaSPBT.setVisible(true);
                        XoaSPBT1.setText("XÓA BÀN");
                        XoaSPBT1.setVisible(true);
                        ANSPBT.setVisible(true);
                        TTSPBT.setVisible(true);
                        break;
                    case 1:
                      // dang su dung
                        SuaSPBT.setVisible(true);
                        XoaSPBT1.setVisible(false);
                        ANSPBT.setVisible(false);
                        TTSPBT.setVisible(true);
                      break;
                    case 2:
                      // an ban
                        SuaSPBT.setVisible(true);
                        XoaSPBT1.setText("KHÔI PHỤC");
                        XoaSPBT1.setVisible(true);
                        ANSPBT.setVisible(false); 
                      break;
                    case 3:
                      // thoi tiet
                        SuaSPBT.setVisible(true);
                        XoaSPBT1.setText("XÓA BÀN");
                        XoaSPBT1.setVisible(true);
                        ANSPBT.setVisible(true); 
                      break;
                    case 4:
                      // xóa
                       SuaSPBT.setVisible(true);
                       XoaSPBT1.setText("KHÔI PHỤC");
                       XoaSPBT1.setVisible(true);
                      break;
                    default:
       }
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        TenBanTF = new javax.swing.JTextField();
        ThemSPBT = new javax.swing.JButton();
        SuaSPBT = new javax.swing.JButton();
        TTSPBT = new javax.swing.JButton();
        ANSPBT = new javax.swing.JButton();
        XoaSPBT1 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        KhuVucTF = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        SoDoBanPN = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel29.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(51, 153, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("Tên Bàn");

        TenBanTF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        TenBanTF.setForeground(new java.awt.Color(204, 0, 0));

        ThemSPBT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ThemSPBT.setForeground(new java.awt.Color(102, 0, 0));
        ThemSPBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icons8-add-20 (1).png"))); // NOI18N
        ThemSPBT.setText("THÊM BÀN");
        ThemSPBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ThemSPBTActionPerformed(evt);
            }
        });

        SuaSPBT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        SuaSPBT.setForeground(new java.awt.Color(102, 0, 0));
        SuaSPBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icons8-edit-20 (2).png"))); // NOI18N
        SuaSPBT.setText("SỬA BÀN");
        SuaSPBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuaSPBTActionPerformed(evt);
            }
        });

        TTSPBT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        TTSPBT.setForeground(new java.awt.Color(255, 51, 51));
        TTSPBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icons8-delete-20.png"))); // NOI18N
        TTSPBT.setText("THỜI TIẾT");
        TTSPBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TTSPBTActionPerformed(evt);
            }
        });

        ANSPBT.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        ANSPBT.setForeground(new java.awt.Color(102, 0, 0));
        ANSPBT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icons8-edit-20 (2).png"))); // NOI18N
        ANSPBT.setText("ẨN BÀN");
        ANSPBT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ANSPBTActionPerformed(evt);
            }
        });

        XoaSPBT1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        XoaSPBT1.setForeground(new java.awt.Color(255, 51, 51));
        XoaSPBT1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Anh/icons8-delete-20.png"))); // NOI18N
        XoaSPBT1.setText("XÓA BÀN");
        XoaSPBT1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XoaSPBT1ActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(51, 153, 255));
        jLabel30.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel30.setText("Khu Vực");

        KhuVucTF.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        KhuVucTF.setForeground(new java.awt.Color(204, 0, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(XoaSPBT1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SuaSPBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ThemSPBT, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(TenBanTF)
                    .addComponent(jLabel29, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ANSPBT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(TTSPBT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(KhuVucTF)
                    .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TenBanTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel30)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(KhuVucTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ThemSPBT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(SuaSPBT)
                .addGap(18, 18, 18)
                .addComponent(XoaSPBT1)
                .addGap(16, 16, 16)
                .addComponent(ANSPBT)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TTSPBT)
                .addContainerGap())
        );

        SoDoBanPN.setLayout(new java.awt.GridLayout(4, 3, 5, 5));
        jScrollPane1.setViewportView(SoDoBanPN);

        jLabel17.setBackground(new java.awt.Color(255, 255, 255));
        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(51, 153, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Danh Sách Bàn Phòng");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 383, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ThemSPBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ThemSPBTActionPerformed
        // TODO add your handling code here:
       if( TenBan.equalsIgnoreCase(TenBanTF.getText().trim()) )//trùng tên
           JOptionPane.showMessageDialog(this, "Tên bàn Không được trùng nhau");
       else
       {
           CT_TaoMa cT_TaoMa = new CT_TaoMa();
           String MaBan1 = "SB"+cT_TaoMa.TaoHoaDon();
           
           
           String sql = "INSERT BanPhong "
                   + "([SoBan] ,[MaKV] ,[MaBG], [NoUse], [TenBan]) VALUES (?,?,?,?,?)";
           
        try 
        {
            
            PreparedStatement ps = conn.prepareStatement(sql);
           
            ps.setString(1, MaBan1);
            ps.setString(2, KhuVucTF.getText().trim());
            ps.setString(3, "BGNT");
            ps.setString(5, TenBanTF.getText().trim());
            ps.setInt(4, 0);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Bàn "+TenBanTF.getText().trim()+" Đã Được Tạo");
            
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Tạo Hóa Đơn Thất Bại"+e);
        }
       }
       
    }//GEN-LAST:event_ThemSPBTActionPerformed

    private void SuaSPBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuaSPBTActionPerformed
        // TODO add your handling code here:
        String Sql = "UPDATE BanPhong\n" +
                    "	SET MaKV = '"+KhuVucTF.getText().trim()+"',\n" +
                    "	    TenBan = '"+TenBanTF.getText().trim()+"'\n" +    
                    "WHERE SoBan = '"+this.MaBan+"'";
        try 
        {
            PreparedStatement ps = conn.prepareStatement(Sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Lưu Thành Công");
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
        SoDoBan();
       
    }//GEN-LAST:event_SuaSPBTActionPerformed

    private void TTSPBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TTSPBTActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_TTSPBTActionPerformed

    private void XoaSPBT1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XoaSPBT1ActionPerformed
        // TODO add your handling code here:
        String Sql = "";
        if( TrangThai.equals("4") || TrangThai.equals("2") )
        {
            Sql = "UPDATE BanPhong\n" +
                    "	SET NoUse = '0'\n" +                      
                    "WHERE SoBan = '"+this.MaBan+"'";
        }
        if( TrangThai.equals("0") )
        {
            Sql = "UPDATE BanPhong\n" +
                    "	SET NoUse = '4'\n" +                      
                    "WHERE SoBan = '"+this.MaBan+"'";
        }
        
        try 
        {
            PreparedStatement ps = conn.prepareStatement(Sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Lưu Thành Công");
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
        SoDoBan();
    }//GEN-LAST:event_XoaSPBT1ActionPerformed

    private void ANSPBTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ANSPBTActionPerformed
        // TODO add your handling code here:
        String Sql = "UPDATE BanPhong\n" +
                    "	SET NoUse = '2'\n" +                      
                    "WHERE SoBan = '"+this.MaBan+"'";
        try 
        {
            PreparedStatement ps = conn.prepareStatement(Sql);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Lưu Thành Công");
        } catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, e);
        }
        SoDoBan();
        
    }//GEN-LAST:event_ANSPBTActionPerformed

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
            java.util.logging.Logger.getLogger(QL_BanPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QL_BanPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QL_BanPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QL_BanPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QL_BanPhong().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ANSPBT;
    private javax.swing.JTextField KhuVucTF;
    private javax.swing.JPanel SoDoBanPN;
    private javax.swing.JButton SuaSPBT;
    private javax.swing.JButton TTSPBT;
    private javax.swing.JTextField TenBanTF;
    private javax.swing.JButton ThemSPBT;
    private javax.swing.JButton XoaSPBT1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    
}
