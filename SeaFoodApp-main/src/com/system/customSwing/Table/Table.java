/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.customSwing.Table;

import java.awt.Color;
import java.awt.Component;
import com.system.customSwing.ScrollBar.ScrollBar;
import com.system.customSwing.Table.icon.TextAreaCell;
import com.system.customSwing.Table.TableHeader;
import com.system.customSwing.Table_Advance.TableCustom;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

public class Table extends JTable {

    public Table() {
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setSelectionForeground(new Color(51, 51, 51));
        setSelectionBackground(new Color(246, 250, 253));
        setRowHeight(40);
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "    ");
                header.setBorder(new EmptyBorder(10, 20, 15, 10));
                return header;
            }
        });
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean bln1, int i, int i1) {
                Component com = super.getTableCellRendererComponent(jtable, o, selected, bln1, i, i1);
                com.setBackground(Color.WHITE);
                setBorder(new EmptyBorder(10, 21, 10, 10));
//                setBorder(noFocusBorder);
                if (selected) {
                    com.setForeground(new Color(51, 51, 51));
                } else {
                    com.setForeground(new Color(0, 0, 0));
                }
                return com;
            }
        });

    }

    public static void apply(Table tbl, TableCustom.TableType type, int hoverRow) {
        TableCellRenderer cellRender;
        if (type == TableCustom.TableType.DEFAULT) {
            cellRender = new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                    Component com = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                    com.setBackground(Color.WHITE);
                    setBorder(new EmptyBorder(10, 21, 10, 10));
                    if (isSelected) {
                    com.setForeground(new Color(102, 102, 102));
                    com.setBackground(new Color(246, 250, 253));
                } else {
                    com.setForeground(new Color(0, 0, 0));
                }
                    return com;
                }

            };
        } else {
            cellRender = new TextAreaCell();
            tbl.setDefaultRenderer(Object.class, cellRender);
            tbl.setSelectionForeground(new Color(51, 51, 51));
            tbl.setSelectionBackground(new Color(246, 250, 253));
        }
        
    }

    public static enum TableType {
        MULTI_LINE, DEFAULT
    }

    public void fixTable(JScrollPane scroll) {
        scroll.setBorder(null);
        scroll.setVerticalScrollBar(new ScrollBar());
        scroll.getVerticalScrollBar().setBackground(Color.WHITE);
        scroll.getViewport().setBackground(Color.WHITE);
        JPanel p = new JPanel();
        p.setBackground(Color.WHITE);
        scroll.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
    }
}
