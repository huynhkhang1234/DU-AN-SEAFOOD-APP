/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.customSwing.Table.icon;

import java.awt.Color;
import java.awt.Component;
import java.util.Objects;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author HP
 */
public class TextAreaCell extends JTextArea implements TableCellRenderer  {
    
    public TextAreaCell() {
        setWrapStyleWord(true);
        setLineWrap(true);
        setOpaque(true);
        setBorder(new EmptyBorder(8, 22, 5, 5));
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        setText(Objects.toString(value, ""));
        setBackground(Color.white);
       // Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    this.setBackground(Color.WHITE);
                    setBorder(new EmptyBorder(10, 21, 10, 10));
//                setBorder(noFocusBorder);
                    if (isSelected) {
                    this.setForeground(new Color(51, 51, 51));
                    this.setBackground(new Color(220, 220, 220));
                } else {
                    this.setForeground(new Color(0, 0, 0));
                    this.setBackground(Color.white);
                }
        return this;
    }
    
}
