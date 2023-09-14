/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.model.UI;

import java.awt.Color;
import javax.swing.Icon;

/**
 *
 * @author HP
 */
public class ModelItemCardStatistic {
    private String tenThongKe;
    private double soTienThongKe;
    private int soLuongHoaDon;
    private String hinhThuc;
    private Icon iconThongKe;
    private Color color1;
    private Color color2;

    public ModelItemCardStatistic() {
    }

    public ModelItemCardStatistic(String tenThongKe, double soTienThongKe, int soLuongHoaDon, String hinhThuc, Icon iconThongKe, Color color1, Color color2) {
        this.tenThongKe = tenThongKe;
        this.soTienThongKe = soTienThongKe;
        this.soLuongHoaDon = soLuongHoaDon;
        this.hinhThuc = hinhThuc;
        this.iconThongKe = iconThongKe;
        this.color1 = color1;
        this.color2 = color2;
    }

    public String getTenThongKe() {
        return tenThongKe;
    }

    public void setTenThongKe(String tenThongKe) {
        this.tenThongKe = tenThongKe;
    }

    public double getSoTienThongKe() {
        return soTienThongKe;
    }

    public void setSoTienThongKe(double soTienThongKe) {
        this.soTienThongKe = soTienThongKe;
    }

    public int getSoLuongHoaDon() {
        return soLuongHoaDon;
    }

    public void setSoLuongHoaDon(int soLuongHoaDon) {
        this.soLuongHoaDon = soLuongHoaDon;
    }

    public String getHinhThuc() {
        return hinhThuc;
    }

    public void setHinhThuc(String hinhThuc) {
        this.hinhThuc = hinhThuc;
    }

    public Icon getIconThongKe() {
        return iconThongKe;
    }

    public void setIconThongKe(Icon iconThongKe) {
        this.iconThongKe = iconThongKe;
    }

    public Color getColor1() {
        return color1;
    }

    public void setColor1(Color color1) {
        this.color1 = color1;
    }

    public Color getColor2() {
        return color2;
    }

    public void setColor2(Color color2) {
        this.color2 = color2;
    }

    
}
