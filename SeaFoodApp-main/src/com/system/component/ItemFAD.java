/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.component;

import com.system.customSwing.Designed.MyPanel;
import com.system.method.Format_Money;
import com.system.model.UI.ModelItemDrink;
import com.system.model.UI.ModelItemFood;
import com.system.model.code.DoAn;
import com.system.model.code.DoUong;
import com.system.utils.XImage;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

/**
 *
 * @author HP
 */
public class ItemFAD extends MyPanel {

    private boolean selected;
    private DoAn dataDA;
    private DoUong dataDU;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        repaint();
    }

    public DoAn getDataDA() {
        return dataDA;
    }

    public DoUong getDataDU() {
        return dataDU;
    }

    public ItemFAD() {
        initComponents();
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        // set độ bo góc của Jpanel
        setRoundBottomLeft(25);
        setRoundBottomRight(25);
        setRoundTopLeft(25);
        setRoundTopRight(25);

        //setBackground(Color.white);
        setColorBackgound(Color.white);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                setBackground(new Color(203, 203, 203, 40));
                lblTenMonAn.setForeground(new Color(51, 51, 51));
                lblGiaTien.setBackground(new Color(8, 202, 63));
                lblGiaTien.setForeground(new Color(236, 236, 236));
                super.mouseEntered(e); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setBackground(new Color(255, 255, 255));
                lblTenMonAn.setForeground(new Color(123, 123, 123));
                lblGiaTien.setBackground(new Color(240, 240, 240));
                lblGiaTien.setForeground(new Color(51, 51, 51));
                super.mouseExited(e); //To change body of generated methods, choose Tools | Templates.
            }

        });
    }

    public void setDataFood(DoAn data) {
        this.dataDA = data;
        try {
            if (data.getImg() == null || data.getImg().isEmpty()) {
                data.setImg("AnhDoAn.png");
                File file = new File("DoAnVaDoUong//AnhMacDinh");
                pnlAnhMonAn.setToolTipText(data.getImg());
                pnlAnhMonAn.setImage(XImage.readNotPath(file.getAbsolutePath(), data.getImg()));
            } else {
                File file;
                if (data.getMaLoaiThucDon().equalsIgnoreCase("MKV")) {
                    file = new File("DoAnVaDoUong//AnhDoAn/KhaiVi//");
                } else if (data.getMaLoaiThucDon().equalsIgnoreCase("MC")) {
                    file = new File("DoAnVaDoUong//AnhDoAn/MonChinh//");
                } else {
                    file = new File("DoAnVaDoUong//AnhDoAn/MonTrangMieng//");
                }
                pnlAnhMonAn.setToolTipText(data.getImg());
                pnlAnhMonAn.setImage(XImage.readNotPath(file.getAbsolutePath(), data.getImg()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        lblTenMonAn.setText(data.getTenDoAn());
        lblGiaTien.setText(Format_Money.formatMoney(data.getGiaDoAn()));
    }

    public void setDataDrink(DoUong data) {
        this.dataDU = data;
        try {
            if (data.getImg() == null || data.getImg().isEmpty()) {
                data.setImg("AnhDoUong.png");
                File file = new File("DoAnVaDoUong//AnhMacDinh");
                pnlAnhMonAn.setToolTipText(data.getImg());
                pnlAnhMonAn.setImage(XImage.readNotPath(file.getAbsolutePath(), data.getImg()));
            } else {
                File file;
                if (data.getMaLoaiThucDon().equalsIgnoreCase("DUCG")) {
                    file = new File("DoAnVaDoUong//AnhDoUong/DoUongCoGa//");
                } else {
                    file = new File("DoAnVaDoUong//AnhDoUong/DoUongKhac//");
                }
                pnlAnhMonAn.setToolTipText(data.getImg());
                pnlAnhMonAn.setImage(XImage.readNotPath(file.getAbsolutePath(), data.getImg()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        lblTenMonAn.setText(data.getTenDoUong());
        lblGiaTien.setText(Format_Money.formatMoney(data.getGiaDoUong()));
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(242, 242, 242));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        if (selected) {
            g2.setColor(new Color(94, 156, 255));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        }
        g2.dispose();
        super.paint(g);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlAnhMonAn = new com.system.customSwing.Designed.MyPictureBox();
        lblTenMonAn = new javax.swing.JLabel();
        lblGiaTien = new javax.swing.JLabel();

        setOpaque(true);

        pnlAnhMonAn.setMinimumSize(null);
        pnlAnhMonAn.setPreferredSize(new java.awt.Dimension(140, 103));

        lblTenMonAn.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        lblTenMonAn.setForeground(new java.awt.Color(122, 122, 122));
        lblTenMonAn.setText("Tên món ăn");

        lblGiaTien.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        lblGiaTien.setForeground(new java.awt.Color(51, 51, 51));
        lblGiaTien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGiaTien.setText("1,000,000 VNĐ");
        lblGiaTien.setOpaque(true);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlAnhMonAn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblGiaTien, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTenMonAn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(pnlAnhMonAn, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(lblTenMonAn, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE)
                .addGap(2, 2, 2)
                .addComponent(lblGiaTien, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblGiaTien;
    private javax.swing.JLabel lblTenMonAn;
    private com.system.customSwing.Designed.MyPictureBox pnlAnhMonAn;
    // End of variables declaration//GEN-END:variables
}
