
package com.system.model.code;

public class DoAn {
    private String maDoAn;
    private String tenDoAn;
    double giaDoAn;
    double giaGoc;
    private boolean tinhTrang;
    private String img;
    private String maLoaiThucDon;

    public DoAn() {
    }

    public DoAn(String maDoAn, String tenDoAn, double giaDoAn, double giaGoc, boolean tinhTrang, String img, String maLoaiThucDon) {
        this.maDoAn = maDoAn;
        this.tenDoAn = tenDoAn;
        this.giaDoAn = giaDoAn;
        this.giaGoc = giaGoc;
        this.tinhTrang = tinhTrang;
        this.img = img;
        this.maLoaiThucDon = maLoaiThucDon;
    }

    public String getMaDoAn() {
        return maDoAn;
    }

    public void setMaDoAn(String maDoAn) {
        this.maDoAn = maDoAn;
    }

    public String getTenDoAn() {
        return tenDoAn;
    }

    public void setTenDoAn(String tenDoAn) {
        this.tenDoAn = tenDoAn;
    }

    public double getGiaDoAn() {
        return giaDoAn;
    }

    public void setGiaDoAn(double giaDoAn) {
        this.giaDoAn = giaDoAn;
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
