/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.main;

import com.system.DAO.ChucVuDAO;
import com.system.DAO.NhanSuDAO;
import com.system.DAO.TaiKhoanDAO;
import com.system.customSwing.ShowNotify.PanelLoading;
import com.system.model.code.ChucVu;
import com.system.model.code.LuuTaiKhoan;
import com.system.model.code.NhanSu;
import com.system.model.code.TaiKhoan;
import com.system.utils.Auth;
import com.system.utils.MsgBox;
import com.system.utils.XImage;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLayeredPane;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author 0917c
 */
public class DangNhap extends javax.swing.JFrame {

    // khai báo khởi tạo đối tượng
    private PanelLoading pnlLoading;
    private MigLayout layout;
    Main main = new Main();

    public DangNhap() {
        initComponents();
        this.icon2.setVisible(false);
        icon1.setCursor(new Cursor(Cursor.HAND_CURSOR));
        icon2.setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblQuenMatKhau.setCursor(new Cursor(Cursor.HAND_CURSOR));
        init();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JLayeredPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTenDangNhap = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JPasswordField();
        lblIconUser = new javax.swing.JLabel();
        lblIconMK = new javax.swing.JLabel();
        lblQuenMatKhau = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        icon1 = new javax.swing.JLabel();
        icon2 = new javax.swing.JLabel();
        btnDangNhap = new com.system.customSwing.Designed.MyButton_02();
        btnThoat = new com.system.customSwing.Designed.MyButton_02();
        lblQuenMatKhau1 = new javax.swing.JLabel();
        chkTaiKhoan = new com.system.customSwing.Designed.MyCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/icon/undraw_building_websites_i78t.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 102));
        jLabel2.setText("QUẢN LÝ NHÀ HÀNG");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addComponent(jLabel1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 681, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jPanel2.setBackground(new java.awt.Color(102, 102, 255));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("XIN CHÀO !");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("ĐĂNG NHẬP TÀI KHOẢN CỦA BẠN");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Username :");

        txtTenDangNhap.setBackground(new java.awt.Color(102, 102, 255));
        txtTenDangNhap.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtTenDangNhap.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Password :");

        txtMatKhau.setBackground(new java.awt.Color(102, 102, 255));
        txtMatKhau.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txtMatKhau.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txtMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMatKhauActionPerformed(evt);
            }
        });

        lblIconUser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/icon/icons8_Account_50px.png"))); // NOI18N

        lblIconMK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/icon/icons8_Secure_50px.png"))); // NOI18N

        lblQuenMatKhau.setForeground(new java.awt.Color(255, 255, 255));
        lblQuenMatKhau.setText("QUÊN MẬT KHẨU ?");
        lblQuenMatKhau.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuenMatKhauMouseClicked(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Liên hệ số điện thoại : 0909888999");

        icon1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/icon/eye.png"))); // NOI18N
        icon1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                icon1MouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                icon1MousePressed(evt);
            }
        });

        icon2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/icon/no-preview.png"))); // NOI18N
        icon2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                icon2MousePressed(evt);
            }
        });

        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.setEffectColor(new java.awt.Color(123, 121, 121));
        btnDangNhap.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnDangNhap.setRoundBottomLeft(25);
        btnDangNhap.setRoundBottomRight(25);
        btnDangNhap.setRoundTopLeft(25);
        btnDangNhap.setRoundTopRight(25);
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });

        btnThoat.setForeground(new java.awt.Color(255, 51, 51));
        btnThoat.setText("Thoát");
        btnThoat.setEffectColor(new java.awt.Color(123, 121, 121));
        btnThoat.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnThoat.setRoundBottomLeft(25);
        btnThoat.setRoundBottomRight(25);
        btnThoat.setRoundTopLeft(25);
        btnThoat.setRoundTopRight(25);
        btnThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThoatMouseClicked(evt);
            }
        });
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        lblQuenMatKhau1.setForeground(new java.awt.Color(255, 255, 255));
        lblQuenMatKhau1.setText("THAY ĐỔI MẬT KHẨU ?");
        lblQuenMatKhau1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblQuenMatKhau1MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblQuenMatKhau1MouseEntered(evt);
            }
        });

        chkTaiKhoan.setBackground(new java.awt.Color(255, 102, 102));
        chkTaiKhoan.setForeground(new java.awt.Color(255, 255, 255));
        chkTaiKhoan.setText("Ghi nhớ tôi");
        chkTaiKhoan.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(70, 70, 70))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblIconMK)
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(chkTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(icon1)
                            .addComponent(icon2))))
                .addGap(20, 20, 20))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(47, 47, 47)
                            .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(jLabel3))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jLabel5))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(69, 69, 69)
                                .addComponent(lblQuenMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(lblQuenMatKhau1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblIconUser)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addComponent(jLabel3)
                .addGap(16, 16, 16)
                .addComponent(jLabel5)
                .addGap(99, 99, 99)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(lblIconUser))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, 0)
                        .addComponent(txtTenDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(64, 64, 64)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(0, 0, 0)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(icon1)
                            .addComponent(icon2)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(lblIconMK)
                        .addGap(8, 8, 8)))
                .addComponent(chkTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblQuenMatKhau)
                    .addComponent(lblQuenMatKhau1))
                .addGap(56, 56, 56)
                .addComponent(jLabel8)
                .addContainerGap())
        );

        background.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        background.setLayer(jPanel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblQuenMatKhauMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMatKhauMouseClicked
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pnlLoading.setVisible(true);
                    Thread.sleep(2000);
                    new QuenMatKhau("Quên mật khẩu").setVisible(true);
                    Dispose();
                    pnlLoading.setVisible(false);
                } catch (InterruptedException ex) {
                    Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();

    }//GEN-LAST:event_lblQuenMatKhauMouseClicked

    private void icon1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon1MouseEntered

    }//GEN-LAST:event_icon1MouseEntered

    private void icon1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon1MousePressed
        icon2.setVisible(true);
        icon1.setVisible(false);
        txtMatKhau.setEchoChar((char) 0);
    }//GEN-LAST:event_icon1MousePressed

    private void icon2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_icon2MousePressed
        icon1.setVisible(true);
        icon2.setVisible(false);
        txtMatKhau.setEchoChar('*');
    }//GEN-LAST:event_icon2MousePressed

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed

        this.dangNhap();

    }//GEN-LAST:event_btnDangNhapActionPerformed

    private void btnThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThoatMouseClicked
        //  System.exit(0);
    }//GEN-LAST:event_btnThoatMouseClicked

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        if (MsgBox.confirm(this, "Bạn có chắc chắn muốn thoát ?")) {
            System.err.println();
        }
    }//GEN-LAST:event_btnThoatActionPerformed

    private void txtMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMatKhauActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMatKhauActionPerformed

    private void lblQuenMatKhau1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMatKhau1MouseClicked
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pnlLoading.setVisible(true);
                    Thread.sleep(2000);
                    
                    new QuenMatKhau("Đổi mật khẩu").setVisible(true);
                    Dispose();
                    pnlLoading.setVisible(false);
                } catch (InterruptedException ex) {
                    Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }//GEN-LAST:event_lblQuenMatKhau1MouseClicked

    private void lblQuenMatKhau1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblQuenMatKhau1MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblQuenMatKhau1MouseEntered

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
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DangNhap().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane background;
    private com.system.customSwing.Designed.MyButton_02 btnDangNhap;
    private com.system.customSwing.Designed.MyButton_02 btnThoat;
    private com.system.customSwing.Designed.MyCheckBox chkTaiKhoan;
    private javax.swing.JLabel icon1;
    private javax.swing.JLabel icon2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblIconMK;
    private javax.swing.JLabel lblIconUser;
    private javax.swing.JLabel lblQuenMatKhau;
    private javax.swing.JLabel lblQuenMatKhau1;
    private javax.swing.JPasswordField txtMatKhau;
    private javax.swing.JTextField txtTenDangNhap;
    // End of variables declaration//GEN-END:variables
      private void dangNhap() {
        TaiKhoanDAO daoTK = new TaiKhoanDAO();
        ChucVuDAO daoCV = new ChucVuDAO();
        NhanSuDAO daoNS = new NhanSuDAO();
        String tenDangNhap = txtTenDangNhap.getText();
        String matKhau = txtMatKhau.getText();
        TaiKhoan tk = daoTK.selectByNameLogin(tenDangNhap);
        try {
            if (tenDangNhap.isEmpty() || matKhau.isEmpty()) {
                MsgBox.alert(this, "Đăng nhập thất bại ! Vui lòng thử lại");
                if (tenDangNhap.isEmpty() && matKhau.isEmpty()) {
                    MsgBox.alert(this, "Vui lòng nhập thông tin tên đăng nhập hoặc mật khẩu ?");
                } else if (tenDangNhap.isEmpty()) {
                    MsgBox.alert(this, "Vui lòng nhập thông tin tên đăng nhập ?");
                } else if (matKhau.isEmpty()) {
                    MsgBox.alert(this, "Vui lòng nhập thông tin mật khẩu");
                }
            } else if (tk == null) {
                MsgBox.alert(this, "Thông tin đăng nhập chưa chính xác ?");
            } else if (!matKhau.equals(tk.getMatKhau())) {
                MsgBox.alert(this, "Thông tin mật khẩu chưa chính xác ?");
            } else {// trường hợp đăng nhập thành công
                // gán vào tên tài khoản đăng nhập
                Auth.user = tk;
                // thông tin mã chức vụ khi đăng nhập
                Auth.maChucVu = tk.getMaChucVu();
                //lấy tên chức vụ khi đăng nhập
                ChucVu chucVu = daoCV.selectByID(Auth.maChucVu);
                //  Auth.tenChucVu = daoCV.selectByID(Auth.maChucVu);
                Auth.tenChucVu = chucVu.getTenChucVu();
                NhanSu ns = daoNS.selectByID(Auth.user.getMaNhanVien());
                // set ten nhân viên
                Auth.tenNhanVien = ns.getHoVaTen();
                //set giá trị mã nhân viêb
                Auth.maNhanVien = ns.getMaNhanVien();
                // set giá trị qua main
                main.getHeader().getLblUser().setText(Auth.tenNhanVien);
                // sét giá trị tên chức vào main          
                main.getHeader().getLblRole().setText(Auth.tenChucVu);
                // set hình ảnh đăng nhập vào trong
                Auth.anhDaiDien = ns.getImg();               
                if (Auth.anhDaiDien == null) {
                   
                    if (ns.getGioiTinh().equalsIgnoreCase("nam")) {
                        
                        main.getHeader().getLblAvatarMain().setIcon(XImage.readNotPath("AnhMacDinh", "AnhNhanVien.png"));
                    } else {
                        main.getHeader().getLblAvatarMain().setIcon(XImage.readNotPath("AnhMacDinh", "AnhNhanVienNu.png"));
                    }
                } else {
                    main.getHeader().getLblAvatarMain().setIcon(XImage.readNotPath("AnhNhanSu",Auth.anhDaiDien));
                }
                // gán lại gia trị vai trò
                Auth.vaiTro = chucVu.getMaChucVu();
                // khi đăng nhập thành công thì add vào file
                if (chkTaiKhoan.isSelected()) {
                    this.writeToFile();
                }
                // tắt cái frame đi hiện main lên
                this.LoadingDaTa();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /// đọc file vào file date
    public void writeToFile() {
        List<LuuTaiKhoan> list = new ArrayList<LuuTaiKhoan>();
        LuuTaiKhoan tk = new LuuTaiKhoan(txtTenDangNhap.getText(), txtMatKhau.getText());
        list.add(tk);
        try {
            FileWriter fw = new FileWriter("taiKhoan.txt");// thêm contructer dc nửa
            BufferedWriter bw = new BufferedWriter(fw);
            for (LuuTaiKhoan s : list) {
                bw.write(s.toString());
            }
            bw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println("Thông tin tài khoản mới đăng nhập");
        }
    }

    public void readFile() {
        try {
            FileReader fr = new FileReader("taiKhoan.txt");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while (true) {
                line = br.readLine();
                if (line == null) {
                    break;
                }
                String txt[] = line.split(",");
                txtTenDangNhap.setText(txt[0]);
                txtMatKhau.setText(txt[1]);
            }
        } catch (Exception ex) {
            System.out.println("Bạn chưa đăng nhập tài khoản ");
        }
    }

    private void Dispose() {
        this.dispose();

    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(255, 255, 255));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        g2.dispose();
        super.paint(g);
    }

    private void init() {
        this.setLocationRelativeTo(null);
        repaint();
        pnlLoading = new PanelLoading();
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        background.setLayout(layout);
        background.setLayer(pnlLoading, JLayeredPane.POPUP_LAYER);
        background.add(pnlLoading, "pos 0 0 100% 100%");
        chkTaiKhoan.setSelected(true);
        /// hàm đọc file trong dăng nhập
        this.readFile();
        
        lblQuenMatKhau1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(new Cursor(Cursor.HAND_CURSOR));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                super.mouseExited(e); 
            }
            
        });
    }

    // hàn để xoay vòng cái dữ liệu để đăng nhập vào frame chính.
    private void LoadingDaTa() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pnlLoading.setVisible(true);
                    Thread.sleep(4000);
                    main.setVisible(true);
                    Dispose();
                    pnlLoading.setVisible(false);
                } catch (InterruptedException ex) {
                    Logger.getLogger(DangNhap.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();
    }
}
