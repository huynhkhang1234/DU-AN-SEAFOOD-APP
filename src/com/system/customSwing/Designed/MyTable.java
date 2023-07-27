/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.customSwing.Designed;

import com.system.customSwing.Table.Table;
import com.system.customSwing.Table_Advance.TableCustom;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class MyTable extends javax.swing.JPanel {

    private String tenBan;

    public DefaultTableModel tblModel = new DefaultTableModel();

    public MyPanel getPnlContain() {
        return pnlContain;
    }

    public JScrollPane getScroll() {
        return scroll;
    }

    public Table getTbl() {
        return tbl;
    }

    public String getTenBan() {
        return tenBan;
    }

    public void setTenBan(String tenBan) {
        this.tenBan = tenBan;
    }

    public MyTable() {
        initComponents();
        setOpaque(false);
        tbl.fixTable(scroll);
        com.system.customSwing.Table.Table.apply(tbl, TableCustom.TableType.MULTI_LINE, ERROR);
    }

    public void addRow(Object[] row) {
        tblModel.addRow(row);
    }

    public void addColumn(String... nameColumn) {
        if (nameColumn != null) {
            for (String s : nameColumn) {
                tblModel.addColumn(s);
            }
        }
    }

    public void setRowCount(int i) {
        tblModel.setRowCount(i);
    }

    public void setColumnCount(int i) {
        tblModel.setColumnCount(i);
    }

    public void getCountRow() {
        tbl.getRowCount();
    }

    public void getCountHeight() {
        tbl.getRowHeight();
    }

    public Object getValueAt(int row, int column) {
        return tbl.getValueAt(row, column);
    }

    public void setModel() {
        tbl.setModel(tblModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlContain = new com.system.customSwing.Designed.MyPanel();
        scroll = new javax.swing.JScrollPane();
        tbl = new com.system.customSwing.Table.Table();

        scroll.setBorder(null);
        scroll.setOpaque(false);

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Title 1"
            }
        ));
        scroll.setViewportView(tbl);

        javax.swing.GroupLayout pnlContainLayout = new javax.swing.GroupLayout(pnlContain);
        pnlContain.setLayout(pnlContainLayout);
        pnlContainLayout.setHorizontalGroup(
            pnlContainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 779, Short.MAX_VALUE)
        );
        pnlContainLayout.setVerticalGroup(
            pnlContainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlContainLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 237, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlContain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.system.customSwing.Designed.MyPanel pnlContain;
    private javax.swing.JScrollPane scroll;
    private com.system.customSwing.Table.Table tbl;
    // End of variables declaration//GEN-END:variables
}
