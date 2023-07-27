/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.component;

import com.system.customSwing.Designed.Button;
import com.system.customSwing.Designed.MyPanel;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author HP
 */
public class cardMenuDashboard extends MyPanel {

    private String nameTitle = "";
    private Color color = new Color(255, 255, 255);
    private Color colorSelected = new Color(255, 204, 102);
    private Icon icon;
    
    private final Icon icon1 = new ImageIcon(getClass().getResource("/com/system/icon/MenuFood/icon_MonKhaiVi.png"));
    private final Icon icon2 = new ImageIcon(getClass().getResource("/com/system/icon/MenuFood/icon_MonChinh.png"));
    private final Icon icon3 = new ImageIcon(getClass().getResource("/com/system/icon/MenuFood/icon_MonTrangMieng.png"));
    private final Icon icon4 = new ImageIcon(getClass().getResource("/com/system/icon/MenuFood/icon_DoUongCoCon.png"));
    private final Icon icon5 = new ImageIcon(getClass().getResource("/com/system/icon/MenuFood/icon_DoUongKhac.png"));

    public Button getBtn() {
        return btnIcon;
    }

    public JLabel getTitle() {
        return lblTitle;
    }

    public String getNameTitle() {
        return nameTitle;
    }

    public void setNameTitle(String nameTitle) {
        this.nameTitle = nameTitle;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColorSelected() {
        return colorSelected;
    }

    public void setColorSelected(Color colorSelected) {
        this.colorSelected = colorSelected;
    }

    public Icon getIcon() {
        return icon;
    }

    public void setIcon(Icon icon) {
        this.icon = icon;
    }
    
    

    public cardMenuDashboard(String name) {
        initComponents();
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setRoundBottomLeft(20);
        setRoundBottomRight(20);
        setRoundTopLeft(20);
        setRoundTopRight(20);
        setColorBackgound(new Color(51, 51, 51, 50));
        
        this.nameTitle = name;
        lblTitle.setText(nameTitle);
        if (name.contains("khai vị")) {
            btnIcon.setIcon(icon1);
        } else if (name.contains("chính")) {
            btnIcon.setIcon(icon2);
        } else if (name.contains("tráng miệng̣")) {
            btnIcon.setIcon(icon3);
        } else if (name.contains("có cồṇ")) {
            btnIcon.setIcon(icon4);
        } else {
            btnIcon.setIcon(icon5);
        }
        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                lblTitle.setForeground(new Color(230, 137, 16));
                super.mouseEntered(e); 
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lblTitle.setForeground(new Color(51, 51, 51));
                super.mouseExited(e); 
            }
        });
    }
    
    public void addEventClick(MouseEvent event) {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                super.mouseClicked(event); 
            }
            
        });
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnIcon = new com.system.customSwing.Designed.Button();
        lblTitle = new javax.swing.JLabel();

        setOpaque(false);

        btnIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/icon/MenuFood/icon_MonKhaiVi.png"))); // NOI18N

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblTitle.setText("Món khai vị");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(btnIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addComponent(lblTitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(btnIcon, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.system.customSwing.Designed.Button btnIcon;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration//GEN-END:variables
}
