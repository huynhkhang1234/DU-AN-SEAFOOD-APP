
package com.system.DAO;

import com.system.JDBC_SQL_Server.JDBC;
import com.system.model.code.DatBan;
import com.system.model.code.DonHang;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class DonHangDAO extends DAO<DonHang, Object>{
    
    String insertDonHang = "insert into DonHang values (?, ?, ?, ?, ?, ?, ?)";
    String deleteDonHang = "delete DonHang where MaDonHang = ?";
    String updateDonHang = "update DonHang set MaNhanVien = ?, MaKhachHang = ?, GhiChu = ?, GioVao = ?, GioRa = ?, SoBan = ?, TongTienThanhToan = ? where MaDonHang = ?";
    String updateThanhTienByMaDonHang = "UPDATE DonHang set TongTienThanhToan = ? where MaDonHang = ?";
    String updateThanhTienBySoBan = "UPDATE DonHang set TongTienThanhToan = ? where MaKhachHang = ?";
    String selectAllDonHang = "select * from DonHang";
    String selectByDonHang = "select * from DonHang where MaDonHang = ?";
    String selectBySoBan = "select * from DonHang where SoBan = ?";
    
    

    @Override
    public void insert(DonHang entity) {
        JDBC.update(insertDonHang, entity.getMaNhanVien(), entity.getMaKhachHang(), entity.getGhiChu(),
                entity.getGioVao(), entity.getGioRa(), entity.getSoBan(), entity.getTongTienThanhToan());
    }

    @Override
    public void update(DonHang entity) {
        JDBC.update(updateDonHang, entity.getMaNhanVien(), entity.getMaKhachHang(), entity.getGhiChu(),
                entity.getGioVao(), entity.getGioRa(), entity.getSoBan(), entity.getTongTienThanhToan(), entity.getMaDonHang());
    }
    
    public void updateTongThanhTien(DonHang entity) {
        JDBC.update(updateThanhTienByMaDonHang, entity.getTongTienThanhToan(), entity.getMaDonHang());
    }
    
    public void updateTongThanhTien(DatBan entity) {
        JDBC.update(updateThanhTienBySoBan, entity.getTienCoc(), entity.getMaKhachHang());
    }

    @Override
    public void delete(Object key) {
        JDBC.update(deleteDonHang, key);
    }

    @Override
    public List<DonHang> selectAll() {
        return this.selectBySql(selectAllDonHang);
    }

    @Override
    public DonHang selectByID(Object key) {
        List<DonHang> list = this.selectBySql(selectByDonHang, key);
        if (list.isEmpty()) {
            return null; 
        }
        return list.get(0);
    }
    
    public DonHang selectBySoBan(Object key) {
        List<DonHang> list = this.selectBySql(selectBySoBan, key);
        if (list.isEmpty()) {
            return null; 
        }
        return list.get(0);
    }

    @Override
    protected List<DonHang> selectBySql(String sql, Object... args) {
        List<DonHang> list = new ArrayList<DonHang>();
        try {
            ResultSet rs = JDBC.query(sql, args);
            while (rs.next()) {
                DonHang dh = new DonHang();
                dh.setMaDonHang(rs.getInt("MaDonHang"));
                dh.setMaNhanVien(rs.getString("MaNhanVien"));
                dh.setMaKhachHang(rs.getString("MaKhachHang"));
                dh.setGhiChu(rs.getString("GhiChu"));
                dh.setGhiChu(rs.getString("GioVao"));
                dh.setGhiChu(rs.getString("GioRa"));
                dh.setSoBan(rs.getInt("SoBan"));
                dh.setTongTienThanhToan(rs.getDouble("TongTienThanhToan"));
                                          
                list.add(dh);
            }
            rs.getStatement().getConnection().close();// laấy những câu hỏi sql và đóng kết nối
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
