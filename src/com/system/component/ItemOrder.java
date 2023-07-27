/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.component;

import com.system.method.Format_Money;
import com.system.model.UI.ModelListOrder;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author HP
 */
public class ItemOrder extends javax.swing.JPanel {

    private ModelListOrder dataOrder;
    private int soLuong;
    private double giaSP;
    private double thanhTien;

    public ModelListOrder getDataOrder() {
        return dataOrder;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public double getGiaSP() {
        return giaSP;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public ItemOrder() {
        initComponents();
        setBorder(new EmptyBorder(5, 5, 5, 5));
        
        init();
    }

    private void init() {
        // Set các giá trị về ban đầu
        txtSoLuong.setText("1");
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Chỉnh hiệu ứng khi rê chuột vào
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(new Color(96, 96, 96, 50));
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(new Color(240, 240, 240));
                super.mouseExited(e);
            }
        });

        btnTangSoLuong.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                soLuong = soLuong + 1;
                txtSoLuong.setText(soLuong + "");
                setMoney();
                super.mouseClicked(e); 
            }
        });

        btnGiamSoLuong.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (soLuong == 1) {
                    btnGiamSoLuong.setEnabled(false);
                } else {
                    soLuong = soLuong - 1;
                    txtSoLuong.setText(soLuong + "");
                    setMoney();
                }
                super.mouseClicked(e);
            }
        });
        
    }

    // set dữ liệu quan trọng cho việc tính toán
    public void setDataOrder(ModelListOrder data) {
        this.dataOrder = data;
        this.soLuong = data.getSoLuong();
        this.giaSP = data.getGiaTien();
        this.thanhTien = giaSP * soLuong;

        lblTenMA.setText(data.getTenMA());
        lblGiaMA.setText(Format_Money.formatMoney(data.getGiaTien()));
        txtSoLuong.setText(data.getSoLuong() + "");
        lblThanhTien.setText(Format_Money.formatMoney(thanhTien));
    }

    // tính thành tiền khi số lwuognj thay đổi
    private void setMoney() {
        thanhTien = soLuong * giaSP;
        lblThanhTien.setText(Format_Money.formatMoney(thanhTien));
    }
    
    public void addEventDeleteOrder(ActionListener event) {
        btnDelete.addActionListener(event);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTenMA = new javax.swing.JLabel();
        lblGiaMA = new javax.swing.JLabel();
        btnTangSoLuong = new com.system.customSwing.Designed.MyButton_02();
        txtSoLuong = new com.system.customSwing.TextField_01.TextFieldSuggestion();
        btnGiamSoLuong = new com.system.customSwing.Designed.MyButton_02();
        btnDelete = new com.system.customSwing.Designed.MyButton_02();
        jSeparator1 = new javax.swing.JSeparator();
        lblThanhTien = new javax.swing.JLabel();

        lblTenMA.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTenMA.setText("Tên món ăn nè");

        lblGiaMA.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lblGiaMA.setForeground(new java.awt.Color(131, 131, 131));
        lblGiaMA.setText("Giá món ăn");

        btnTangSoLuong.setBackground(new java.awt.Color(0, 0, 0));
        btnTangSoLuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/icon/plus.png"))); // NOI18N
        btnTangSoLuong.setRoundBottomLeft(0);
        btnTangSoLuong.setRoundBottomRight(0);
        btnTangSoLuong.setRoundTopLeft(0);

        txtSoLuong.setText("1");
        txtSoLuong.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txtSoLuong.setRoundBottomLeft(0);
        txtSoLuong.setRoundBottomRight(0);
        txtSoLuong.setRoundTopLeft(50);
        txtSoLuong.setRoundTopRight(30);
        txtSoLuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongActionPerformed(evt);
            }
        });

        btnGiamSoLuong.setBackground(new java.awt.Color(0, 0, 0));
        btnGiamSoLuong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/icon/subtract.png"))); // NOI18N
        btnGiamSoLuong.setRoundBottomLeft(0);
        btnGiamSoLuong.setRoundTopLeft(0);
        btnGiamSoLuong.setRoundTopRight(0);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/icon/trash.png"))); // NOI18N
        btnDelete.setRoundBottomLeft(30);
        btnDelete.setRoundBottomRight(30);
        btnDelete.setRoundTopLeft(30);
        btnDelete.setRoundTopRight(30);

        lblThanhTien.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lblThanhTien.setForeground(new java.awt.Color(51, 51, 51));
        lblThanhTien.setText("Thành tiền");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGiaMA, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                            .addComponent(lblTenMA, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(2, 2, 2)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                        .addGap(0, 0, 0)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnTangSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGiamSoLuong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblThanhTien, javax.swing.GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblThanhTien, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTangSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(btnGiamSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(lblTenMA, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7)
                        .addComponent(lblGiaMA, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtSoLuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.system.customSwing.Designed.MyButton_02 btnDelete;
    private com.system.customSwing.Designed.MyButton_02 btnGiamSoLuong;
    private com.system.customSwing.Designed.MyButton_02 btnTangSoLuong;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblGiaMA;
    private javax.swing.JLabel lblTenMA;
    private javax.swing.JLabel lblThanhTien;
    private com.system.customSwing.TextField_01.TextFieldSuggestion txtSoLuong;
    // End of variables declaration//GEN-END:variables
}
