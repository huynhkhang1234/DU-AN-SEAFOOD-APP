
package com.system.model.code;


public class HoaDonChiTiet {
    int STT;
    int maHoaDon;
    private String tenDoAnVaDoUong;
    int soLuong;
    double gia;
    double thanhTien;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int STT, int maHoaDon, String tenDoAnVaDoUong, int soLuong, double gia, double thanhTien) {
        this.STT = STT;
        this.maHoaDon = maHoaDon;
        this.tenDoAnVaDoUong = tenDoAnVaDoUong;
        this.soLuong = soLuong;
        this.gia = gia;
        this.thanhTien = thanhTien;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getTenDoAnVaDoUong() {
        return tenDoAnVaDoUong;
    }

    public void setTenDoAnVaDoUong(String tenDoAnVaDoUong) {
        this.tenDoAnVaDoUong = tenDoAnVaDoUong;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public double getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(double thanhTien) {
        this.thanhTien = thanhTien;
    }
    
    
}
