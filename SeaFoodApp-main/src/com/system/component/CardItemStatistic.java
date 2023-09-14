/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.component;

import com.system.method.Format_Money;
import com.system.model.UI.ModelItemCardStatistic;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public class CardItemStatistic extends JPanel {

    private Color colorGradient;
    private ModelItemCardStatistic data;

    public ModelItemCardStatistic getData() {
        return data;
    }

    public Color getColorGradient() {
        return colorGradient;
    }

    public void setColorGradient(Color colorGradient) {
        this.colorGradient = colorGradient;
    }

    public CardItemStatistic() {
        initComponents();
        init();

    }

    private void init() {
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBackground(new Color(40, 199, 213));
        colorGradient = new Color(76, 132, 254);
    }
    // set dữ ;iệu, số liệu thống kê, cho các card thống kê này
    public void setData(ModelItemCardStatistic data) {
        this.data = data;
        lblTenThongSo.setText(data.getTenThongKe());
        lblThongSo.setText(Format_Money.formatMoney(data.getSoTienThongKe()));
        lblSoLuong.setText("Số lượng: " + data.getSoLuongHoaDon());
        lblThoiGian.setText("Thời hạn: "); // này để làm thêm sau này
        setBackground(data.getColor1());
        colorGradient = data.getColor2();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblThongSo = new javax.swing.JLabel();
        lblTenThongSo = new javax.swing.JLabel();
        lblThoiGian = new javax.swing.JLabel();
        lblSoLuong = new javax.swing.JLabel();

        lblThongSo.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        lblThongSo.setForeground(new java.awt.Color(255, 255, 255));
        lblThongSo.setText("1,000, 000 VNĐ");

        lblTenThongSo.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        lblTenThongSo.setForeground(new java.awt.Color(255, 255, 255));
        lblTenThongSo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTenThongSo.setText("Doanh thu");

        lblThoiGian.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblThoiGian.setForeground(new java.awt.Color(255, 255, 255));
        lblThoiGian.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblThoiGian.setText("Tháng trước");

        lblSoLuong.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        lblSoLuong.setForeground(new java.awt.Color(255, 255, 255));
        lblSoLuong.setText("Số lượng: 15");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(64, 64, 64)
                        .addComponent(lblThoiGian, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblThongSo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTenThongSo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(lblTenThongSo)
                .addGap(10, 10, 10)
                .addComponent(lblThongSo, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents
@Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gra = new GradientPaint(0, getHeight(), getBackground(), getWidth(), 0, colorGradient);
        g2.setPaint(gra);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        super.paintComponent(g);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblSoLuong;
    private javax.swing.JLabel lblTenThongSo;
    private javax.swing.JLabel lblThoiGian;
    private javax.swing.JLabel lblThongSo;
    // End of variables declaration//GEN-END:variables
}
