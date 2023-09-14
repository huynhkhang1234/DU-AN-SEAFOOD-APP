
package com.system.model.code;

import java.util.Date;

public class NhanSu {
    private String maNhanVien;
    private String maChucVu;
    private String hoVaTen;
    private String gioiTinh;
    private String soDienThoai;
    double bacLuong;
    private Date ngaySinh;
    private String email;
    private String diaChi;
    double luong;
    private String img;
    private boolean tinhTrang;

    public NhanSu() {
    }

    public NhanSu(String maNhanVien, String maChucVu, String hoVaTen, String gioiTinh, String soDienThoai, double bacLuong, Date ngaySinh, String email, String diaChi, double luong, String img, boolean tinhTrang) {
        this.maNhanVien = maNhanVien;
        this.maChucVu = maChucVu;
        this.hoVaTen = hoVaTen;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.bacLuong = bacLuong;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.diaChi = diaChi;
        this.luong = luong;
        this.img = img;
        this.tinhTrang = tinhTrang;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public String getMaChucVu() {
        return maChucVu;
    }

    public void setMaChucVu(String maChucVu) {
        this.maChucVu = maChucVu;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public double getBacLuong() {
        return bacLuong;
    }

    public void setBacLuong(double bacLuong) {
        this.bacLuong = bacLuong;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    
      
}
