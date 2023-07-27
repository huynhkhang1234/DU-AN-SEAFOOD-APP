
package com.system.model.code;


public class DonHang {
    int maDonHang;
    private String maNhanVien;
    private String maKhachHang;
    private String ghiChu;
    private String gioVao;
    private String gioRa;
    int soBan;
    double TongTienThanhToan;

    public DonHang() {
    	
    }

    public DonHang(int maDonHang, String maNhanVien, String maKhachHang, String ghiChu, String gioVao, String gioRa, int soBan, double TongTienThanhToan) {
        this.maDonHang = maDonHang;
        this.maNhanVien = maNhanVien;
        this.maKhachHang = maKhachHang;
        this.ghiChu = ghiChu;
        this.gioVao = gioVao;
        this.gioRa = gioRa;
        this.soBan = soBan;
        this.TongTienThanhToan = TongTienThanhToan;
    }

    public int getMaDonHang() {
        return maDonHang;
    }

    public void setMaDonHang(int maDonHang) {
        this.maDonHang = maDonHang;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
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

    public int getSoBan() {
        return soBan;
    }

    public void setSoBan(int soBan) {
        this.soBan = soBan;
    }

    public double getTongTienThanhToan() {
        return TongTienThanhToan;
    }

    public void setTongTienThanhToan(double TongTienThanhToan) {
        this.TongTienThanhToan = TongTienThanhToan;
    }

    @Override
    public String toString() {
        return "" + getSoBan();
    }
}
