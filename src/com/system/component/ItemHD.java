/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.component;

import com.system.customSwing.Designed.MyPanel;
import com.system.method.Format_Money;
import java.awt.Color;

import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author Tran Thi Hong Tham
 */
public class ItemHD extends MyPanel {

//    private String title;
    private double giaTien;
    int soBan;
    int maDonHang;
    private Icon iconAnTaiBan = new ImageIcon(getClass().getResource("/com/system/icon/icon_AnTaiBan.png"));
    private Icon iconMangDi = new ImageIcon(getClass().getResource("/com/system/icon/icon_TakeAway.png"));
    ;
    private Color colorAnTaiBan = new Color(127, 255, 127);
    private Color colorMangDi = new Color(255, 255, 8);

    PanelThanhToan pnl;

    public JLabel getLblGiaTien() {
        return lblGiaTien;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public int getSoBan() {
        return soBan;
    }

    public void setSoBan(int soBan) {
        this.soBan = soBan;
    }

    public int getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(int maDonHang) {
        this.maDonHang = maDonHang;
    }

    public PanelThanhToan getPnl() {
        return pnl;
    }

    public ItemHD(int soBan, double giaTien, String hinhThuc, int maDonHang) {
        initComponents();
        setSize(350, 189);
        this.giaTien = giaTien;
        this.maDonHang = maDonHang;
        this.soBan = soBan;
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        setRoundTopLeft(20);
        setRoundTopRight(20);
        setRoundBottomLeft(20);
        setRoundBottomRight(20);

        lblGiaTien.setText(Format_Money.formatMoney(this.giaTien));
        if (hinhThuc.equalsIgnoreCase("bàn") || soBan != 0) {
            lblTenBan.setText("Bàn số: " + this.soBan);
            lblIcon.setIcon(iconAnTaiBan);
            lblIcon.setBackground(colorAnTaiBan);
        } else {
            lblTenBan.setText("HĐ - " + this.maDonHang);
            lblIcon.setIcon(iconMangDi);
            lblIcon.setBackground(colorMangDi);
        }
        
//        
    }

    public void addEventThanhToan(String nameEvent, MouseListener event) {
        if (nameEvent.equalsIgnoreCase("thanh toán")) {
            btnThanhToan.addMouseListener(event);
        } else if (nameEvent.contains("xem chi tiết")) {
            btnXemDonHang.addMouseListener(event);
        }
    }
    
    public PanelThanhToan showThanhToan() {
            
            return pnl;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myPanel1 = new com.system.customSwing.Designed.MyPanel();
        lblTenBan = new javax.swing.JLabel();
        lblIcon = new javax.swing.JLabel();
        myPanel2 = new com.system.customSwing.Designed.MyPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        lblGiaTien = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnThanhToan = new com.system.customSwing.Designed.MyButton_02();
        btnXemDonHang = new com.system.customSwing.Designed.MyButton_02();

        setBackground(new java.awt.Color(153, 153, 153));
        setColorBackgound(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(306, 191));

        myPanel1.setBackground(new java.awt.Color(255, 255, 255));
        myPanel1.setColorBackgound(new java.awt.Color(255, 255, 255));
        myPanel1.setRoundTopLeft(20);
        myPanel1.setRoundTopRight(20);

        lblTenBan.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTenBan.setText("Bàn số - 01");

        lblIcon.setBackground(new java.awt.Color(127, 255, 127));
        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/icon/icon_AnTaiBan.png"))); // NOI18N
        lblIcon.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblIcon.setOpaque(true);

        javax.swing.GroupLayout myPanel1Layout = new javax.swing.GroupLayout(myPanel1);
        myPanel1.setLayout(myPanel1Layout);
        myPanel1Layout.setHorizontalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblTenBan, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        myPanel1Layout.setVerticalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblTenBan, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        myPanel2.setRoundBottomLeft(10);
        myPanel2.setRoundBottomRight(10);

        jPanel1.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Thời gian:");

        lblGiaTien.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        lblGiaTien.setForeground(new java.awt.Color(51, 51, 51));
        lblGiaTien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblGiaTien.setText("100, 000 VNĐ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblGiaTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(17, 17, 17))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGiaTien, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 10, 0));

        btnThanhToan.setForeground(new java.awt.Color(0, 204, 51));
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnThanhToan.setRoundBottomLeft(15);
        btnThanhToan.setRoundBottomRight(15);
        btnThanhToan.setRoundTopLeft(15);
        btnThanhToan.setRoundTopRight(15);
        jPanel2.add(btnThanhToan);

        btnXemDonHang.setForeground(new java.awt.Color(0, 204, 51));
        btnXemDonHang.setText("Xem đơn hàng");
        btnXemDonHang.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnXemDonHang.setRoundBottomLeft(15);
        btnXemDonHang.setRoundBottomRight(15);
        btnXemDonHang.setRoundTopLeft(15);
        btnXemDonHang.setRoundTopRight(15);
        jPanel2.add(btnXemDonHang);

        javax.swing.GroupLayout myPanel2Layout = new javax.swing.GroupLayout(myPanel2);
        myPanel2.setLayout(myPanel2Layout);
        myPanel2Layout.setHorizontalGroup(
            myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addGap(10, 10, 10))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        myPanel2Layout.setVerticalGroup(
            myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(myPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(myPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(myPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(myPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.system.customSwing.Designed.MyButton_02 btnThanhToan;
    private com.system.customSwing.Designed.MyButton_02 btnXemDonHang;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lblGiaTien;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblTenBan;
    private com.system.customSwing.Designed.MyPanel myPanel1;
    private com.system.customSwing.Designed.MyPanel myPanel2;
    // End of variables declaration//GEN-END:variables

}
