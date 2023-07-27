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
public class ModelItemDrink{
    private int maDU;
    private String tenDU;
    private double giaTien;
    private String loaiDU;
    private Icon image;

    public ModelItemDrink() {
    }

    public ModelItemDrink(int maDU, String tenDU, double giaTien, String loaiDU, Icon image) {
        this.maDU = maDU;
        this.tenDU = tenDU;
        this.giaTien = giaTien;
        this.loaiDU = loaiDU;
        this.image = image;
    }

    public int getMaDU() {
        return maDU;
    }

    public void setMaDU(int maDU) {
        this.maDU = maDU;
    }

    public String getTenDU() {
        return tenDU;
    }

    public void setTenDU(String tenDU) {
        this.tenDU = tenDU;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public String getLoaiDU() {
        return loaiDU;
    }

    public void setLoaiDU(String loaiDU) {
        this.loaiDU = loaiDU;
    }

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }
    
    
    
}
