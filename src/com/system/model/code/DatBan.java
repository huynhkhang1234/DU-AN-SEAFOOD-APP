
package com.system.model.code;

import java.util.Date;


public class DatBan {
    private String maKhachHang;
    private String tenKhachHang;
    private String soDienThoai;
    int soBan;
    private Date ngayDen;
    private String thoiGian;
    double tienCoc;
    private String ghiChu;
    private boolean tinhTrang;

    public DatBan() {
    }

    public DatBan(String maKhachHang, String tenKhachHang, String soDienThoai, int soBan, Date ngayDen, String thoiGian, double tienCoc, String ghiChu, boolean tinhTrang) {
        this.maKhachHang = maKhachHang;
        this.tenKhachHang = tenKhachHang;
        this.soDienThoai = soDienThoai;
        this.soBan = soBan;
        this.ngayDen = ngayDen;
        this.thoiGian = thoiGian;
        this.tienCoc = tienCoc;
        this.ghiChu = ghiChu;
        this.tinhTrang = tinhTrang;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return tenKhachHang;
    }

    public void setTenKhachHang(String tenKhachHang) {
        this.tenKhachHang = tenKhachHang;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public int getSoBan() {
        return soBan;
    }

    public void setSoBan(int soBan) {
        this.soBan = soBan;
    }

    public Date getNgayDen() {
        return ngayDen;
    }

    public void setNgayDen(Date ngayDen) {
        this.ngayDen = ngayDen;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public double getTienCoc() {
        return tienCoc;
    }

    public void setTienCoc(double tienCoc) {
        this.tienCoc = tienCoc;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }


}
