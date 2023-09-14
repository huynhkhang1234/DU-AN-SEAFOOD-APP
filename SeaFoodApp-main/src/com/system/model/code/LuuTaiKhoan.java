/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.model.code;

/**
 *
 * @author ADMIN
 */
public class LuuTaiKhoan {
    private String tenDangNhap , MatKhau;

    public LuuTaiKhoan() {
    }

    public LuuTaiKhoan(String tenDangNhap, String MatKhau) {
        this.tenDangNhap = tenDangNhap;
        this.MatKhau = MatKhau;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
        this.tenDangNhap = tenDangNhap;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
    }

    @Override
    public String toString() {
        return getTenDangNhap() + ","+getMatKhau();
    }
    
}
