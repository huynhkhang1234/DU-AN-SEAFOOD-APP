
package com.system.DAO;

import com.system.JDBC_SQL_Server.JDBC;
import com.system.model.code.DonHangChiTiet;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DonHangChiTietDAO extends DAO<DonHangChiTiet, Object>{
    
    String insertDonHangChiTiet = "insert into DonHangChiTiet values (?, ?, ?, ?, ?, ?)";
    String deleteDonHangChiTiet = "delete DonHangChiTiet where STT = ?";
    String updateDonHangChiTiet = "update DonHangChiTiet set MaDonHang = ?, MaDoAn = ?, MaDoUong = ?, SoLuong = ?, GiaTien = ?, ThanhTien = ? where STT = ?";
    String selectAllDonHangChiTiet = "select * from DonHangChiTiet";
    String selectByDonHangChiTiet = "select * from DonHangChiTiet where STT = ?";
    String selectByMaDonHang = "SELECT MaDonHang, MaDoAn, MaDoUong, SUM(SoLuong) AS 'SoLuong', GiaTien, SUM(ThanhTien) AS 'ThanhTien' FROM dbo.DonHangChiTiet\n" +
                               "GROUP BY MaDonHang, MaDoAn, MaDoUong, SoLuong, GiaTien, ThanhTien\n" +
                               "HAVING MaDonHang = ?\n" +
                               "ORDER BY MaDoAn DESC";
    String deleteDonHangChiTietByMaDonHang = "delete DonHangChiTiet where MaDonHang = ?";

    @Override
    public void insert(DonHangChiTiet entity) {
        JDBC.update(insertDonHangChiTiet, entity.getMaDonHang(), entity.getMaDoAn(),
                entity.getMaDoUong(), entity.getSoLuong(), entity.getGiaTien(),
                entity.getThanhTien());
    }

    @Override
    public void update(DonHangChiTiet entity) {
        JDBC.update(insertDonHangChiTiet, entity.getMaDonHang(), entity.getMaDoAn(),
                entity.getMaDoUong(), entity.getSoLuong(), entity.getGiaTien(),
                entity.getThanhTien(), entity.getSTT());
    }

    @Override
    public void delete(Object key) {
        JDBC.update(deleteDonHangChiTiet, key);
    }
    
    public void deleteByMaDonHang(Object key) {
        JDBC.update(deleteDonHangChiTietByMaDonHang, key);
    }

    @Override
    public List<DonHangChiTiet> selectAll() {
        return this.selectBySql(selectAllDonHangChiTiet);
    }

    @Override
    public DonHangChiTiet selectByID(Object key) {
        List<DonHangChiTiet> list = this.selectBySql(selectByDonHangChiTiet, key);
        if (list.isEmpty()) {
            return null; 
        }
        return list.get(0);
    }
    
    public List<DonHangChiTiet> selectByMaDonHang(Object key) {
        List<DonHangChiTiet> list = this.selectBySql(selectByMaDonHang, key);
        if (list.isEmpty()) {
            return null; 
        }
        return list;
    }

    @Override
    protected List<DonHangChiTiet> selectBySql(String sql, Object... args) {
        List<DonHangChiTiet> list = new ArrayList<DonHangChiTiet>();
        try {
            ResultSet rs = JDBC.query(sql, args);
            while (rs.next()) {
                DonHangChiTiet dhct = new DonHangChiTiet();
                if (!sql.contains("GROUP BY")) {
                    dhct.setSTT(rs.getInt("STT"));
                }
                dhct.setSTT(0);
                dhct.setMaDonHang(rs.getInt("MaDonHang"));
                dhct.setMaDoAn(rs.getString("MaDoAn"));
                dhct.setMaDoUong(rs.getString("MaDoUong"));
                dhct.setSoLuong(rs.getInt("SoLuong"));
                dhct.setGiaTien(rs.getDouble("GiaTien"));
                dhct.setThanhTien(rs.getDouble("ThanhTien"));
                
                                       
                list.add(dhct);
            }
            rs.getStatement().getConnection().close();// laấy những câu hỏi sql và đóng kết nối
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
