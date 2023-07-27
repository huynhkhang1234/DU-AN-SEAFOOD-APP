/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.customSwing.Table;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class TableHeader extends JTextArea {
    
    public TableHeader(String text) {
        super(text);
        setOpaque(true);
        setWrapStyleWord(true);
        setLineWrap(true);
        setBackground(Color.WHITE);
        setFont(new Font("sansserif", 1, 12));
        setForeground(new Color(102, 102, 102));
        setBorder(new EmptyBorder(10, 5, 10, 5));
    }
    
    @Override
    protected void paintComponent(Graphics grphcs) {
        super.paintComponent(grphcs);
        grphcs.setColor(new Color(230, 230, 230));
        grphcs.drawLine(0, getHeight() - 1, getWidth(), getHeight() - 1);
    }
    
}
