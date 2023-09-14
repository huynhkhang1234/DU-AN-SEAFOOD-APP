/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.component;

import com.system.customSwing.Designed.MyButton_02;
import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JLabel;

/**
 *
 * @author HP
 */
public class PanelCofirm extends javax.swing.JPanel {

    public MyButton_02 getBtnCancel() {
        return btnCancel;
    }

    public MyButton_02 getBtnCloseNotify() {
        return btnCloseNotify;
    }

    public MyButton_02 getBtnYes() {
        return btnYes;
    }

    public JLabel getLblContentNotify() {
        return lblContentNotify;
    }

    public JLabel getLblTitle() {
        return lblTitle;
    }
    
    public PanelCofirm(String title, String content) {
        initComponents();
        lblTitle.setText(title);
        lblContentNotify.setText(content);
        setOpaque(false);
        setFocusCycleRoot(true);
        setVisible(false);
        setFocusable(true);
        addMouseListener(new MouseAdapter() {
        });
    }
    
    public void addEventButtonOK(ActionListener event) {
        btnYes.addActionListener(event);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myPanel1 = new com.system.customSwing.Designed.MyPanel();
        btnCloseNotify = new com.system.customSwing.Designed.MyButton_02();
        lblIcon = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblContentNotify = new javax.swing.JLabel();
        btnYes = new com.system.customSwing.Designed.MyButton_02();
        btnCancel = new com.system.customSwing.Designed.MyButton_02();

        myPanel1.setColorBackgound(new java.awt.Color(255, 255, 255));
        myPanel1.setRoundBottomLeft(30);
        myPanel1.setRoundBottomRight(30);
        myPanel1.setRoundTopLeft(30);
        myPanel1.setRoundTopRight(30);

        btnCloseNotify.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/customSwing/ShowNotify/icon_closeNotify.png"))); // NOI18N
        btnCloseNotify.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseNotifyActionPerformed(evt);
            }
        });

        lblIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/customSwing/ShowNotify/icon_warning.png"))); // NOI18N

        lblTitle.setFont(new java.awt.Font("SansSerif", 1, 17)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(255, 51, 51));
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Xóa thông tin !!!");

        lblContentNotify.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        lblContentNotify.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblContentNotify.setText("Bạn có chắc chắn muốn xóa không ?");

        btnYes.setBackground(new java.awt.Color(44, 227, 177));
        btnYes.setForeground(new java.awt.Color(255, 255, 255));
        btnYes.setText("Có, tôi muốn xóa");
        btnYes.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        btnYes.setRoundBottomLeft(10);
        btnYes.setRoundBottomRight(10);
        btnYes.setRoundTopLeft(10);
        btnYes.setRoundTopRight(10);

        btnCancel.setBackground(new java.awt.Color(204, 204, 204));
        btnCancel.setForeground(new java.awt.Color(255, 255, 255));
        btnCancel.setText("Hủy thao tác");
        btnCancel.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        btnCancel.setRoundBottomLeft(10);
        btnCancel.setRoundBottomRight(10);
        btnCancel.setRoundTopLeft(10);
        btnCancel.setRoundTopRight(10);
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout myPanel1Layout = new javax.swing.GroupLayout(myPanel1);
        myPanel1.setLayout(myPanel1Layout);
        myPanel1Layout.setHorizontalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCloseNotify, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTitle)
                    .addComponent(lblIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnYes, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addGap(53, 53, 53)
                .addComponent(btnCancel, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblContentNotify, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        myPanel1Layout.setVerticalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(btnCloseNotify, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitle)
                .addGap(5, 5, 5)
                .addComponent(lblContentNotify, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnYes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(myPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(myPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCloseNotifyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseNotifyActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCloseNotifyActionPerformed

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed

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
    private com.system.customSwing.Designed.MyButton_02 btnCancel;
    private com.system.customSwing.Designed.MyButton_02 btnCloseNotify;
    private com.system.customSwing.Designed.MyButton_02 btnYes;
    private javax.swing.JLabel lblContentNotify;
    private javax.swing.JLabel lblIcon;
    private javax.swing.JLabel lblTitle;
    private com.system.customSwing.Designed.MyPanel myPanel1;
    // End of variables declaration//GEN-END:variables
}
