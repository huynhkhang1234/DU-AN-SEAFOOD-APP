/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.component;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class PanelAddItem extends javax.swing.JPanel {
    
    private String nameTitle;
    private String content;
    private DefaultTableModel tblmodel = new DefaultTableModel();

    public PanelAddItem(DefaultTableModel model, String nameTitle, String content) {
        initComponents();
        setOpaque(false);
        setFocusCycleRoot(true);
        setVisible(false);
        setFocusable(true);
        addMouseListener(new MouseAdapter() {
        });
        
        this.nameTitle = nameTitle;
        this.content = content;
        this.tblmodel = model;
        
        init(this.tblmodel, this.nameTitle, this.content);
    }
    
    public void init(DefaultTableModel model, String nameTitle, String content) {
        lblNameNotify.setText(this.nameTitle);
        lblContent.setText(this.content);
        
        setDataToTable(this.tblmodel);
    }
    
    
    public void setDataToTable(DefaultTableModel model) {
        
        tbl.getTbl().setModel(model);
        
        tbl.getTbl().getColumnModel().getColumn(0).setMaxWidth(100);
        tbl.getTbl().getColumnModel().getColumn(2).setMaxWidth(100);
        tbl.getTbl().setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
    }
    
    public void addEventButtonOK(ActionListener event) {
        btnOK.addActionListener(event);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myPanel1 = new com.system.customSwing.Designed.MyPanel();
        lblNameNotify = new javax.swing.JLabel();
        lblContent = new javax.swing.JLabel();
        tbl = new com.system.customSwing.Designed.MyTable();
        btnOK = new com.system.customSwing.Designed.MyButton_01();
        btnHuy = new com.system.customSwing.Designed.MyButton_01();

        myPanel1.setColorBackgound(java.awt.Color.white);
        myPanel1.setRoundBottomLeft(30);
        myPanel1.setRoundBottomRight(30);
        myPanel1.setRoundTopLeft(30);
        myPanel1.setRoundTopRight(30);

        lblNameNotify.setFont(new java.awt.Font("SansSerif", 1, 24)); // NOI18N
        lblNameNotify.setForeground(new java.awt.Color(51, 51, 51));
        lblNameNotify.setText("Thêm món ăn");

        lblContent.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblContent.setText("Bạn có chắc chắn muốn thêm các món ăn này vào bàn không?");

        btnOK.setText("OK");
        btnOK.setBorderColor(new java.awt.Color(18, 138, 62));
        btnOK.setColorOver(new java.awt.Color(221, 221, 221));
        btnOK.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        btnOK.setRadius(50);

        btnHuy.setText("Hủy");
        btnHuy.setBorderColor(new java.awt.Color(192, 25, 25));
        btnHuy.setColorOver(new java.awt.Color(221, 221, 221));
        btnHuy.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        btnHuy.setRadius(50);
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout myPanel1Layout = new javax.swing.GroupLayout(myPanel1);
        myPanel1.setLayout(myPanel1Layout);
        myPanel1Layout.setHorizontalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(lblNameNotify))
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblContent, javax.swing.GroupLayout.DEFAULT_SIZE, 557, Short.MAX_VALUE)
                            .addComponent(tbl, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGap(113, 113, 113)
                        .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        myPanel1Layout.setVerticalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblNameNotify)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblContent, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbl, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnOK, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(48, Short.MAX_VALUE)
                .addComponent(myPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnHuyActionPerformed

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
    private com.system.customSwing.Designed.MyButton_01 btnHuy;
    private com.system.customSwing.Designed.MyButton_01 btnOK;
    private javax.swing.JLabel lblContent;
    private javax.swing.JLabel lblNameNotify;
    private com.system.customSwing.Designed.MyPanel myPanel1;
    private com.system.customSwing.Designed.MyTable tbl;
    // End of variables declaration//GEN-END:variables
}
