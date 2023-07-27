/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.component;

import com.system.method.Format_Money;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelThanhToan extends JPanel {

    String maDonHang;
    double tienNhan;
    double tienTT;
    double tienThua;
    int soBan;

    public PanelThanhToan(String maDonHang, int soBan, double tienThanhToan) {
        initComponents();
        setOpaque(false);
        setFocusCycleRoot(true);
        setVisible(false);
        setFocusable(true);
        addMouseListener(new MouseAdapter() {
        });

        this.maDonHang = maDonHang;
        this.tienTT = tienThanhToan;
        this.tienNhan = tienThanhToan;
        this.tienThua = tienNhan - tienTT;
        this.soBan = soBan;

        txtDaNhan.setEditable(false);
        setData();
        clickBtn();
    }

    private void setData() {
        if (soBan == 0) {
            lblBan.setText("Hóa đơn - " + this.maDonHang);
        } else {
            lblBan.setText("Bàn số- " + this.soBan);
        }

        lblTong.setText("Tổng: " + this.tienTT);
        lblThanhToan.setText(Format_Money.formatMoney(tienTT));
        txtDaNhan.setText(Format_Money.formatMoney(this.tienNhan));
        lblTitlTienThua.setText(Format_Money.formatMoney(this.tienThua));
    }

    public void addEventForXNTT(ActionListener event) {
        btnXacNhanThanhToan.addActionListener(event);
    }
    
    private void clickBtn() {
        JButton list[] = {btn0, btn00, btn000, btn_1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};
        
        for (JButton btn : list) { 
            btn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (txtDaNhan.getText() == null || txtDaNhan.getText().isEmpty()) {
                        txtDaNhan.setText("0");
                    }
                    String tienNhap = txtDaNhan.getText().replace("  VNĐ", "").replace(" ", "").replace(",", "");
                    if (Double.parseDouble(tienNhap) == tienNhan) {
                        txtDaNhan.setText("");
                    }
                    txtDaNhan.setText(txtDaNhan.getText() + btn.getText());
                }
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        lblBan = new javax.swing.JLabel();
        lblTong = new javax.swing.JLabel();
        btnXacNhanThanhToan = new com.system.customSwing.Designed.MyButton_02();
        myPanel1 = new com.system.customSwing.Designed.MyPanel();
        btn_1 = new com.system.customSwing.Designed.MyButton_02();
        btn2 = new com.system.customSwing.Designed.MyButton_02();
        btn3 = new com.system.customSwing.Designed.MyButton_02();
        btn4 = new com.system.customSwing.Designed.MyButton_02();
        btn5 = new com.system.customSwing.Designed.MyButton_02();
        btn6 = new com.system.customSwing.Designed.MyButton_02();
        btn7 = new com.system.customSwing.Designed.MyButton_02();
        btn8 = new com.system.customSwing.Designed.MyButton_02();
        btn9 = new com.system.customSwing.Designed.MyButton_02();
        btn0 = new com.system.customSwing.Designed.MyButton_02();
        btn00 = new com.system.customSwing.Designed.MyButton_02();
        btn000 = new com.system.customSwing.Designed.MyButton_02();
        btnXoa = new com.system.customSwing.Designed.MyButton_02();
        myPanel2 = new com.system.customSwing.Designed.MyPanel();
        myButton_021 = new com.system.customSwing.Designed.MyButton_02();
        myButton_022 = new com.system.customSwing.Designed.MyButton_02();
        myButton_023 = new com.system.customSwing.Designed.MyButton_02();
        myButton_024 = new com.system.customSwing.Designed.MyButton_02();
        myButton_025 = new com.system.customSwing.Designed.MyButton_02();
        myButton_026 = new com.system.customSwing.Designed.MyButton_02();
        myButton_027 = new com.system.customSwing.Designed.MyButton_02();
        myPanel3 = new com.system.customSwing.Designed.MyPanel();
        lblTitleDaNhan = new javax.swing.JLabel();
        lblTitleTT = new javax.swing.JLabel();
        lblTitlTienThua = new javax.swing.JLabel();
        txtDaNhan = new com.system.customSwing.TextField_01.TextFieldSuggestion();
        lblThanhToan = new javax.swing.JLabel();
        lblTienThua = new javax.swing.JLabel();
        myButton_0213 = new com.system.customSwing.Designed.MyButton_02();

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jPanel3.setBackground(new java.awt.Color(255, 102, 102));

        lblBan.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        lblBan.setForeground(new java.awt.Color(255, 255, 255));
        lblBan.setText("Bàn");

        lblTong.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        lblTong.setForeground(new java.awt.Color(255, 255, 255));
        lblTong.setText("Tổng");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(lblBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(143, 143, 143)
                .addComponent(lblTong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(91, 91, 91))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblBan, javax.swing.GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
            .addComponent(lblTong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        btnXacNhanThanhToan.setBackground(new java.awt.Color(69, 209, 134));
        btnXacNhanThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnXacNhanThanhToan.setText("Xác nhận thanh toán");
        btnXacNhanThanhToan.setEffectColor(new java.awt.Color(230, 230, 230));
        btnXacNhanThanhToan.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        btnXacNhanThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXacNhanThanhToanActionPerformed(evt);
            }
        });

        myPanel1.setBackground(new java.awt.Color(204, 255, 204));
        myPanel1.setColorBackgound(new java.awt.Color(204, 255, 204));
        myPanel1.setRoundBottomLeft(20);
        myPanel1.setRoundBottomRight(20);
        myPanel1.setRoundTopLeft(20);
        myPanel1.setRoundTopRight(20);
        myPanel1.setLayout(new java.awt.GridLayout(5, 3, 5, 5));

        btn_1.setText("1");
        btn_1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_1ActionPerformed(evt);
            }
        });
        myPanel1.add(btn_1);

        btn2.setText("2");
        btn2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        myPanel1.add(btn2);

        btn3.setText("3");
        btn3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        myPanel1.add(btn3);

        btn4.setText("4");
        btn4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        myPanel1.add(btn4);

        btn5.setText("5");
        btn5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        myPanel1.add(btn5);

        btn6.setText("5");
        btn6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });
        myPanel1.add(btn6);

        btn7.setText("7");
        btn7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        myPanel1.add(btn7);

        btn8.setText("8");
        btn8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        myPanel1.add(btn8);

        btn9.setText("9");
        btn9.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        myPanel1.add(btn9);

        btn0.setText("0");
        btn0.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        myPanel1.add(btn0);

        btn00.setText("00");
        btn00.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        myPanel1.add(btn00);

        btn000.setText("000");
        btn000.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        myPanel1.add(btn000);

        btnXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/icon/icons8_Clear_Symbol_50px_2.png"))); // NOI18N
        myPanel1.add(btnXoa);

        myPanel2.setColorBackgound(new java.awt.Color(153, 153, 255));
        myPanel2.setRoundBottomLeft(20);
        myPanel2.setRoundBottomRight(20);
        myPanel2.setRoundTopLeft(20);
        myPanel2.setRoundTopRight(20);
        myPanel2.setLayout(new java.awt.GridLayout(7, 3, 5, 5));

        myButton_021.setBackground(new java.awt.Color(102, 102, 255));
        myButton_021.setForeground(new java.awt.Color(255, 255, 255));
        myButton_021.setText("Tiền mặt");
        myButton_021.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        myPanel2.add(myButton_021);

        myButton_022.setText("ShoppePay");
        myButton_022.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        myPanel2.add(myButton_022);

        myButton_023.setText("ICB");
        myButton_023.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        myPanel2.add(myButton_023);

        myButton_024.setText("VISA");
        myButton_024.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        myPanel2.add(myButton_024);

        myButton_025.setText("Master");
        myButton_025.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        myPanel2.add(myButton_025);

        myButton_026.setText("ATM");
        myButton_026.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        myPanel2.add(myButton_026);

        myButton_027.setText("Khác...");
        myButton_027.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        myPanel2.add(myButton_027);

        myPanel3.setBackground(new java.awt.Color(255, 255, 255));
        myPanel3.setColorBackgound(new java.awt.Color(255, 255, 255));
        myPanel3.setRoundBottomLeft(20);
        myPanel3.setRoundBottomRight(20);
        myPanel3.setRoundTopLeft(20);
        myPanel3.setRoundTopRight(20);

        lblTitleDaNhan.setBackground(new java.awt.Color(204, 204, 204));
        lblTitleDaNhan.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        lblTitleDaNhan.setText("Đã nhận");

        lblTitleTT.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        lblTitleTT.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitleTT.setText("Thanh toán");

        lblTitlTienThua.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        lblTitlTienThua.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTitlTienThua.setText("Tiền thừa");

        txtDaNhan.setText("0 VNĐ");
        txtDaNhan.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        txtDaNhan.setRoundBottomLeft(20);
        txtDaNhan.setRoundBottomRight(20);
        txtDaNhan.setRoundTopLeft(20);
        txtDaNhan.setRoundTopRight(20);

        lblThanhToan.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lblThanhToan.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblThanhToan.setText("0 VNĐ");

        lblTienThua.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lblTienThua.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTienThua.setText("0 VNĐ");

        javax.swing.GroupLayout myPanel3Layout = new javax.swing.GroupLayout(myPanel3);
        myPanel3.setLayout(myPanel3Layout);
        myPanel3Layout.setHorizontalGroup(
            myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(myPanel3Layout.createSequentialGroup()
                        .addComponent(txtDaNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(lblThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(myPanel3Layout.createSequentialGroup()
                        .addComponent(lblTitleDaNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(197, 197, 197)
                        .addComponent(lblTitleTT)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitlTienThua, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTienThua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        myPanel3Layout.setVerticalGroup(
            myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel3Layout.createSequentialGroup()
                .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTitleTT)
                            .addComponent(lblTitleDaNhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTitlTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(3, 3, 3)
                        .addGroup(myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblTienThua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(myPanel3Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(txtDaNhan, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)))
                .addGap(5, 5, 5))
        );

        myButton_0213.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/customSwing/ShowNotify/icon_closeNotify.png"))); // NOI18N
        myButton_0213.setRoundBottomLeft(10);
        myButton_0213.setRoundBottomRight(10);
        myButton_0213.setRoundTopLeft(10);
        myButton_0213.setRoundTopRight(10);
        myButton_0213.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton_0213ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(myPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(myPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXacNhanThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(myPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(40, 40, 40)
                .addComponent(myButton_0213, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(myPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(myPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(btnXacNhanThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(myPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(32, 32, 32))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(myButton_0213, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnXacNhanThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXacNhanThanhToanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXacNhanThanhToanActionPerformed

    private void btn_1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_1ActionPerformed

    private void myButton_0213ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton_0213ActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_myButton_0213ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn6ActionPerformed

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(new Color(50, 50, 50));
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
        g2.fillRect(0, 0, getWidth(), getHeight());
        g2.setComposite(AlphaComposite.SrcOver);
        super.paintComponent(g);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.system.customSwing.Designed.MyButton_02 btn0;
    private com.system.customSwing.Designed.MyButton_02 btn00;
    private com.system.customSwing.Designed.MyButton_02 btn000;
    private com.system.customSwing.Designed.MyButton_02 btn2;
    private com.system.customSwing.Designed.MyButton_02 btn3;
    private com.system.customSwing.Designed.MyButton_02 btn4;
    private com.system.customSwing.Designed.MyButton_02 btn5;
    private com.system.customSwing.Designed.MyButton_02 btn6;
    private com.system.customSwing.Designed.MyButton_02 btn7;
    private com.system.customSwing.Designed.MyButton_02 btn8;
    private com.system.customSwing.Designed.MyButton_02 btn9;
    private com.system.customSwing.Designed.MyButton_02 btnXacNhanThanhToan;
    private com.system.customSwing.Designed.MyButton_02 btnXoa;
    private com.system.customSwing.Designed.MyButton_02 btn_1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblBan;
    private javax.swing.JLabel lblThanhToan;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTitlTienThua;
    private javax.swing.JLabel lblTitleDaNhan;
    private javax.swing.JLabel lblTitleTT;
    private javax.swing.JLabel lblTong;
    private com.system.customSwing.Designed.MyButton_02 myButton_021;
    private com.system.customSwing.Designed.MyButton_02 myButton_0213;
    private com.system.customSwing.Designed.MyButton_02 myButton_022;
    private com.system.customSwing.Designed.MyButton_02 myButton_023;
    private com.system.customSwing.Designed.MyButton_02 myButton_024;
    private com.system.customSwing.Designed.MyButton_02 myButton_025;
    private com.system.customSwing.Designed.MyButton_02 myButton_026;
    private com.system.customSwing.Designed.MyButton_02 myButton_027;
    private com.system.customSwing.Designed.MyPanel myPanel1;
    private com.system.customSwing.Designed.MyPanel myPanel2;
    private com.system.customSwing.Designed.MyPanel myPanel3;
    private com.system.customSwing.TextField_01.TextFieldSuggestion txtDaNhan;
    // End of variables declaration//GEN-END:variables

    


}
