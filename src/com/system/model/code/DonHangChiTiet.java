package com.system.model.code;

public class DonHangChiTiet {
    int STT;
    int maDonHang;
    private String maDoAn;
    private String maDoUong;
    int soLuong;
    double giaTien;
    double thanhTien;

    public DonHangChiTiet() {
    }

    public DonHangChiTiet(int STT, int maDonHang, String maDoAn, String maDoUong, int soLuong, double giaTien, double thanhTien) {
        this.STT = STT;
        this.maDonHang = maDonHang;
        this.maDoAn = maDoAn;
        this.maDoUong = maDoUong;
        this.soLuong = soLuong;
        this.giaTien = giaTien;
        this.thanhTien = thanhTien;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public int getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(int maDonHang) {
        this.maDonHang = maDonHang;
    }

    public String getMaDoAn() {
        return maDoAn;
    }

    public void setMaDoAn(String maDoAn) {
        this.maDoAn = maDoAn;
    }

    public String getMaDoUong() {
        return maDoUong;
    }

    public void setMaDoUong(String maDoUong) {
        this.maDoUong = maDoUong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGiaTien() {
        return giaTien;
    }

    public void setGiaTien(double giaTien) {
        this.giaTien = giaTien;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }

   
    
}
