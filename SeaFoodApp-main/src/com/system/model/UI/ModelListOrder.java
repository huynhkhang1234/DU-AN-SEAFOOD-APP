/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.model.UI;

import javax.swing.Icon;

/**
 *
 * @author HP
 */
public class ModelListOrder{
    private String maMA;
    private String tenMA;
    private double giaTien;
    private String loaiMA;
    private int soLuong;
    private int soBan;
    private int maHoaDon;

    public ModelListOrder() {
    }

    public ModelListOrder(String maMA, String tenMA, double giaTien, String loaiMA, int soLuong, int soBan, int maHoaDon) {
        this.maMA = maMA;
        this.tenMA = tenMA;
        this.giaTien = giaTien;
        this.loaiMA = loaiMA;
        this.soLuong = soLuong;
        this.soBan = soBan;
        this.maHoaDon = maHoaDon;
    }

    public String getMaMA() {
        return maMA;
    }

    public void setMaMA(String maMA) {
        this.maMA = maMA;
    }

    public String getTenMA() {
        return tenMA;
    }

    public void setTenMA(String tenMA) {
        this.tenMA = tenMA;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public String getLoaiMA() {
        return loaiMA;
    }

    public void setLoaiMA(String loaiMA) {
        this.loaiMA = loaiMA;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public int getSoBan() {
        return soBan;
    }

    public void setSoBan(int soBan) {
        this.soBan = soBan;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    
}
