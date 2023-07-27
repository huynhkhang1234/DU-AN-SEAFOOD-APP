/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.component;

import com.system.customSwing.Designed.MyPanel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;

/**
 *
 * @author Tran Thi Hong Tham
 */
public class ItemTaoHoaDon extends MyPanel {

    /**
     * Creates new form ItemHD1
     */
    public ItemTaoHoaDon() {
        initComponents();
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setColorBackgound(new Color(255, 255, 255));
    
        setRoundTopLeft(35);
        setRoundTopRight(35);
    }
    
    public void addEventForCreatHD(ActionListener event) {
        btnCreatHD.addActionListener(event);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnCreatHD = new com.system.customSwing.Designed.MyButton_02();

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jLabel2.setText("Tạo đơn hàng");

        btnCreatHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/icon/icon_TaoDonHang.png"))); // NOI18N
        btnCreatHD.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(97, 97, 97)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCreatHD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(118, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCreatHD, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.system.customSwing.Designed.MyButton_02 btnCreatHD;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
