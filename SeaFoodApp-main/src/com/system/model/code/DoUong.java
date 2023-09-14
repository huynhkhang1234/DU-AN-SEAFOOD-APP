package com.system.model.code;


public class DoUong {
    private String maDoUong;
    private String tenDoUong;
    double giaDoUong;
    double giaGoc;
    private boolean tinhTrang;
    private String img;
    private String maLoaiThucDon;

    public DoUong() {
    }

    public DoUong(String maDoUong, String tenDoUong, double giaDoUong, double giaGoc, boolean tinhTrang, String img, String maLoaiThucDon) {
        this.maDoUong = maDoUong;
        this.tenDoUong = tenDoUong;
        this.giaDoUong = giaDoUong;
        this.giaGoc = giaGoc;
        this.tinhTrang = tinhTrang;
        this.img = img;
        this.maLoaiThucDon = maLoaiThucDon;
    }

    public String getMaDoUong() {
        return maDoUong;
    }

    public void setMaDoUong(String maDoUong) {
        this.maDoUong = maDoUong;
    }

    public String getTenDoUong() {
        return tenDoUong;
    }

    public void setTenDoUong(String tenDoUong) {
        this.tenDoUong = tenDoUong;
    }

    public double getGiaDoUong() {
        return giaDoUong;
    }

    public void setGiaDoUong(double giaDoUong) {
        this.giaDoUong = giaDoUong;
    }

    public double getGiaGoc() {
        return giaGoc;
    }

    public void setGiaGoc(double giaGoc) {
        this.giaGoc = giaGoc;
    }

    public boolean isTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getMaLoaiThucDon() {
        return maLoaiThucDon;
    }

    public void setMaLoaiThucDon(String maLoaiThucDon) {
        this.maLoaiThucDon = maLoaiThucDon;
    }

    
    
}
