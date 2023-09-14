package com.system.utils;

import com.system.model.code.TaiKhoan;

public class Auth {

    // lấy tên của tài khoản đăng nhập
    public static String tenNhanVien = "";
    public static TaiKhoan user = null;
    public static String tenChucVu ;
    public static String maChucVu;
    public static String anhDaiDien ;
    public static String vaiTro = "nhanVien";
    public static String maNhanVien;
    // lưu mã khách hàng để thêm đơn hàng
    public static String maKhachHang;
    public static String soBan;
    
    
    
    public static void clear() {
        Auth.user = null;
    }

    public static boolean isLogin() {
        return Auth.user != null;
    }
    public static boolean isManager(){
        System.out.println(vaiTro);
        if(vaiTro.contains("QL")){
            return true;
        }
        return false;
    }
}
