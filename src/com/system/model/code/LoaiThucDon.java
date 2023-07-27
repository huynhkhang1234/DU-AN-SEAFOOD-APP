
package com.system.model.code;

public class LoaiThucDon {
    private String maLoaiThucDon;
    private String tenLoaiThucDon;
    private String thuocLoai;

    public LoaiThucDon() {
    }

    public LoaiThucDon(String maLoaiThucDon, String tenLoaiThucDon, String thuocLoai) {
        this.maLoaiThucDon = maLoaiThucDon;
        this.tenLoaiThucDon = tenLoaiThucDon;
        this.thuocLoai = thuocLoai;
    }

    public String getMaLoaiThucDon() {
        return maLoaiThucDon;
    }

    public void setMaLoaiThucDon(String maLoaiThucDon) {
        this.maLoaiThucDon = maLoaiThucDon;
    }

    public String getTenLoaiThucDon() {
        return tenLoaiThucDon;
    }

    public void setTenLoaiThucDon(String tenLoaiThucDon) {
        this.tenLoaiThucDon = tenLoaiThucDon;
    }

    public String getThuocLoai() {
        return thuocLoai;
    }

    public void setThuocLoai(String thuocLoai) {
        this.thuocLoai = thuocLoai;
    }
    
    @Override
    public String toString() {
        return getTenLoaiThucDon();
    }
}
