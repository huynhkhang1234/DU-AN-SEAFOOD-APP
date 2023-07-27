/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.component;

import com.system.customSwing.Designed.MyTable;
import com.system.method.Format_Money;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author HP
 */
public class ItemBan extends MyTable {
    private String title;
    private double giaTien;
    private int soBan;
    private Color colorBanTrong = new Color(220, 220, 220);
    private Color colorCoKhach = new Color(225, 77, 59);
    private Color colorDatBan = new Color(92, 226, 95);

    public String getTitle() {
        return title;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public int getSoBan() {
        return soBan;
    }

    public ItemBan(int soBan, double giaTien, String hinhThuc) {
        initComponents();
        setOpaque(false);
        this.title = "Số bàn " + soBan;
        this.giaTien = giaTien;
        this.soBan = soBan;
        
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        lblSoBan.setText(title);
        lblGiaTien.setText(Format_Money.formatMoney(this.giaTien));
        
        // Contatins là tìm kí tự có trong câu
        if (this.giaTien != 0) {
            lblHinhThuc.setText("Bàn có khách");
            pnl.setColorBackgound(colorCoKhach);
        }
        
        if (hinhThuc.contains("có")) {
            lblHinhThuc.setText("Bàn có khách");
            pnl.setColorBackgound(colorCoKhach);
        } else if (hinhThuc.contains("đặt")) {
            lblHinhThuc.setText("Bàn đã đặt");
            pnl.setColorBackgound(colorDatBan);
        } else {
            lblHinhThuc.setText("Bàn trống");
            pnl.setColorBackgound(colorBanTrong);
        }
        
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblSoBan.setForeground(new Color(51, 51, 51, 80));
                super.mouseEntered(e); 
            }

            @Override
            public void mouseExited(MouseEvent e) {
               lblSoBan.setForeground(new Color(51, 51, 51));
                super.mouseExited(e); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
        
    }
    
    public void addDAToDH(MouseListener event) {
        this.addMouseListener(event);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl = new com.system.customSwing.Designed.MyPanel();
        lblHinhThuc = new javax.swing.JLabel();
        myPanel2 = new com.system.customSwing.Designed.MyPanel();
        lblSoBan = new javax.swing.JLabel();
        lblGiaTien = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(306, 191));

        pnl.setBackground(new java.awt.Color(220, 220, 220));
        pnl.setColorBackgound(new java.awt.Color(220, 220, 220));
        pnl.setRoundTopLeft(15);
        pnl.setRoundTopRight(15);

        lblHinhThuc.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        lblHinhThuc.setForeground(new java.awt.Color(51, 51, 51));
        lblHinhThuc.setText("Bàn trống");

        javax.swing.GroupLayout pnlLayout = new javax.swing.GroupLayout(pnl);
        pnl.setLayout(pnlLayout);
        pnlLayout.setHorizontalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHinhThuc)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlLayout.setVerticalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHinhThuc)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        myPanel2.setColorBackgound(new java.awt.Color(255, 255, 255));
        myPanel2.setRoundBottomLeft(15);
        myPanel2.setRoundBottomRight(15);

        lblSoBan.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        lblSoBan.setText("Bàn số 01");

        lblGiaTien.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lblGiaTien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/icon/icon_Tien.png"))); // NOI18N
        lblGiaTien.setText("100,000 VNĐ");

        javax.swing.GroupLayout myPanel2Layout = new javax.swing.GroupLayout(myPanel2);
        myPanel2.setLayout(myPanel2Layout);
        myPanel2Layout.setHorizontalGroup(
            myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel2Layout.createSequentialGroup()
                .addGroup(myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblGiaTien))
                    .addGroup(myPanel2Layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(lblSoBan)))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        myPanel2Layout.setVerticalGroup(
            myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblGiaTien)
                .addGap(32, 32, 32)
                .addComponent(lblSoBan)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(myPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(myPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblGiaTien;
    private javax.swing.JLabel lblHinhThuc;
    private javax.swing.JLabel lblSoBan;
    private com.system.customSwing.Designed.MyPanel myPanel2;
    private com.system.customSwing.Designed.MyPanel pnl;
    // End of variables declaration//GEN-END:variables
}
