/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.customSwing.Designed;

import com.raven.datechooser.DateChooser;
import com.system.customSwing.TextField_01.TextFieldSuggestion;
import java.awt.BorderLayout;

/**
 *
 * @author HP
 */
public class MyCalendar extends javax.swing.JPanel {

    private DateChooser dateChooser1;
    private TextFieldSuggestion txt = new TextFieldSuggestion();

    public DateChooser getDateChooser1() {
        return dateChooser1;
    }

    public void setDateChooser1(DateChooser dateChooser1) {
        this.dateChooser1 = dateChooser1;
    }

    public TextFieldSuggestion getTxt() {
        return txt;
    }

    public void setTxt(TextFieldSuggestion txt) {
        this.txt = txt;
    }
    
    public MyCalendar() {
        initComponents();
        txt.setSize(100, 50);
        dateChooser1 = new DateChooser();
        dateChooser1.setVisible(true);
        dateChooser1.setTextRefernce(txt);
        setLayout(new BorderLayout());
        add(txt);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 203, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}