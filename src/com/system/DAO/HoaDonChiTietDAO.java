
package com.system.DAO;

import com.system.JDBC_SQL_Server.JDBC;
import com.system.model.code.HoaDonChiTiet;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class HoaDonChiTietDAO extends DAO<HoaDonChiTiet, Object>{
    
    String insertHoaDonChiTiet = "insert into HoaDonChiTiet values(?,?,?,?,?)";
    String deleteHoaDonChiTiet = "delete HoaDonChiTiet where STT = ?";
    String updateHoaDonChiTiet = "update HoaDonChiTiet set MaHoaDon = ?, TenDoAnVaDoUong = ?, SoLuong = ?, Gia = ?, ThanhTien = ? where MaHoaDon = ?";
    String selectAllHoaDonChiTiet = "select * from HoaDonChiTiet";
    String selectByHoaDonChiTiet = "select * from HoaDonChiTiet where STT = ?";
    

    @Override
    public void insert(HoaDonChiTiet entity) {
        JDBC.update(insertHoaDonChiTiet, entity.getMaHoaDon(), entity.getTenDoAnVaDoUong(),
                entity.getSoLuong(), entity.getGia(), entity.getThanhTien());
    }

    @Override
    public void update(HoaDonChiTiet entity) {
        JDBC.update(updateHoaDonChiTiet, entity.getMaHoaDon(), entity.getTenDoAnVaDoUong(),
                entity.getSoLuong(), entity.getGia(), entity.getThanhTien(), entity.getSTT());
    }

    @Override
    public void delete(Object key) {
        JDBC.update(deleteHoaDonChiTiet, key);
    }

    @Override
    public List<HoaDonChiTiet> selectAll() {
        return this.selectBySql(selectAllHoaDonChiTiet);
    }

    @Override
    public HoaDonChiTiet selectByID(Object key) {
         List<HoaDonChiTiet> list = this.selectBySql(selectByHoaDonChiTiet, key);
        if (list.isEmpty()) {
            return null; 
        }
        return list.get(0);
    }

    @Override
    protected List<HoaDonChiTiet> selectBySql(String sql, Object... args) {
         List<HoaDonChiTiet> list = new ArrayList<HoaDonChiTiet>();
        try {
            ResultSet rs = JDBC.query(sql, args);
            while (rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setSTT(rs.getInt("STT"));
                hdct.setMaHoaDon(rs.getInt("MaHoaDon"));
                hdct.setTenDoAnVaDoUong(rs.getString("tenDoAnVaDoUong"));
                hdct.setSoLuong(rs.getInt("SoLuong"));
                hdct.setGia(rs.getDouble("Gia"));
                hdct.setThanhTien(rs.getDouble("ThanhTien"));
                                            
                list.add(hdct);
            }
            rs.getStatement().getConnection().close();// laấy những câu hỏi sql và đóng kết nối
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
