package com.system.model.code;

import java.util.Date;

public class HoaDon {
    int maHoaDon;
    double tongThanhTien;
    double tienNhan;
    private Date ngayBan;
    int soBan;
    private String gioVao;
    private String gioRa;
    private String ghiChu;
    private String maNhanVien;
    int maDonHang;
    private String maKhachHang;

    public HoaDon() {
    }

    public HoaDon(int maHoaDon, double tongThanhTien, double tienNhan, Date ngayBan, int soBan, String gioVao, String gioRa, String ghiChu, String maNhanVien, int maDonHang, String maKhachHang) {
        this.maHoaDon = maHoaDon;
        this.tongThanhTien = tongThanhTien;
        this.tienNhan = tienNhan;
        this.ngayBan = ngayBan;
        this.soBan = soBan;
        this.gioVao = gioVao;
        this.gioRa = gioRa;
        this.ghiChu = ghiChu;
        this.maNhanVien = maNhanVien;
        this.maDonHang = maDonHang;
        this.maKhachHang = maKhachHang;
    }

    public int getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(int maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public double getTongThanhTien() {
        return tongThanhTien;
    }

    public void setTongThanhTien(double tongThanhTien) {
        this.tongThanhTien = tongThanhTien;
    }

    public double getTienNhan() {
        return tienNhan;
    }

    public void setTienNhan(double tienNhan) {
        this.tienNhan = tienNhan;
    }

    public Date getNgayBan() {
        return ngayBan;
    }

    public void setNgayBan(Date ngayBan) {
        this.ngayBan = ngayBan;
    }

    public int getSoBan() {
        return soBan;
    }

    public void setSoBan(int soBan) {
        this.soBan = soBan;
    }

    public String getGioVao() {
        return gioVao;
    }

    public void setGioVao(String gioVao) {
        this.gioVao = gioVao;
    }

    public String getGioRa() {
        return gioRa;
    }

    public void setGioRa(String gioRa) {
        this.gioRa = gioRa;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public int getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(int maDonHang) {
        this.maDonHang = maDonHang;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }
    
    
}
