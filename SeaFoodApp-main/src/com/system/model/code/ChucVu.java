
package com.system.model.code;

public class ChucVu {
    
    private String maChucVu;
    private String tenChucVu;
    private double luongCoBan;

    public ChucVu() {
    }

    public ChucVu(String maChucVu, String tenChucVu, double luongCoBan) {
        this.maChucVu = maChucVu;
        this.tenChucVu = tenChucVu;
        this.luongCoBan = luongCoBan;
    }

    public String getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(String maChucVu) {
        this.maChucVu = maChucVu;
    }

    public String getTenChucVu() {
        return tenChucVu;
    }

    public void setTenChucVu(String tenChucVu) {
        this.tenChucVu = tenChucVu;
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public void setLuongCoBan(double luongCoBan) {
        this.luongCoBan = luongCoBan;
    }

    @Override
    public String toString() {
        return getTenChucVu()+"("+maChucVu+")";
    }

    
    
}
