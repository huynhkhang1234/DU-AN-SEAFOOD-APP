
package com.system.model.code;

import java.util.Date;


public class TaiKhoan {
    int STT;
    private String tenDangNhap;
    private String matKhau;
    private Date ngayTao;
    private String maNhanVien;
    private String maChucVu;
    private boolean tinhTrang;

    public TaiKhoan() {
    }

    public TaiKhoan(int STT, String tenDangNhap, String matKhau, Date ngayTao, String maNhanVien, String maChucVu, boolean tinhTrang) {
        this.STT = STT;
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
        this.ngayTao = ngayTao;
        this.maNhanVien = maNhanVien;
        this.maChucVu = maChucVu;
        this.tinhTrang = tinhTrang;
    }

    public int getSTT() {
        return STT;
    }

    public void setSTT(int STT) {
        this.STT = STT;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
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

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    
}
