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
public class ModelItemFood{
    private int maTA;
    private String tenTA;
    private double giaTien;
    private String loaiTA;
    private Icon image;

    public ModelItemFood() {
    }

    public ModelItemFood(int maTA, String tenTA, double giaTien, String loaiTA, Icon image) {
        this.maTA = maTA;
        this.tenTA = tenTA;
        this.giaTien = giaTien;
        this.loaiTA = loaiTA;
        this.image = image;
    }

    public int getMaTA() {
        return maTA;
    }

    public void setMaTA(int maTA) {
        this.maTA = maTA;
    }

    public String getTenTA() {
        return tenTA;
    }

    public void setTenTA(String tenTA) {
        this.tenTA = tenTA;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public String getLoaiTA() {
        return loaiTA;
    }

    public void setLoaiTA(String loaiTA) {
        this.loaiTA = loaiTA;
    }

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }
    
    
    
}
