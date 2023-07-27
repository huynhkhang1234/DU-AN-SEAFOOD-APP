
package com.system.DAO;

import com.system.JDBC_SQL_Server.JDBC;
import com.system.model.code.HoaDon;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class HoaDonDAO extends DAO<HoaDon, Object>{
    
    String insertHoaDon = "insert into HoaDon values (?,?,?,?,?,?,?,?,?,?)";
    String deleteHoaDon = "delete HoaDon where MaHoaDon = ?";
    String updateHoaDon = "update HoaDon set TongThanhTien = ?, TienNhan = ?, NgayBan = ?, SoBan = ?, GioVao = ?, GioRa = ?, GhiChu = ?, MaNhanVien = ?, MaDonHang = ?, MaKhachHang = ? where MaHoaDon = ?";
    String selectAllHoaDon = "select * from HoaDon";
    String selectByHoaDon = "select * from HoaDon where MaHoaDon = ?";
    String selcetByMaDonHang = "select * from HoaDon where MaDonHang = ?";

    @Override
    public void insert(HoaDon entity) {
        JDBC.update(insertHoaDon, entity.getTongThanhTien(), entity.getTienNhan(),
                entity.getNgayBan(), entity.getSoBan(), entity.getGioVao(),
                entity.getGioRa(), entity.getGhiChu(), entity.getMaNhanVien(),
                entity.getMaDonHang(), entity.getMaKhachHang());
    }

    @Override
    public void update(HoaDon entity) {
        JDBC.update(updateHoaDon, entity.getTongThanhTien(), entity.getTienNhan(),
                entity.getNgayBan(), entity.getSoBan(), entity.getGioVao(),
                entity.getGioRa(), entity.getGhiChu(), entity.getMaNhanVien(),
                entity.getMaDonHang(), entity.getMaKhachHang(), entity.getMaHoaDon());
    }

    @Override
    public void delete(Object key) {
        JDBC.update(deleteHoaDon, key);
    }

    @Override
    public List<HoaDon> selectAll() {
        return this.selectBySql(selectAllHoaDon);
    }

    @Override
    public HoaDon selectByID(Object key) {
         List<HoaDon> list = this.selectBySql(selectByHoaDon, key);
        if (list.isEmpty()) {
            return null; 
        }
        return list.get(0);
    }
  
    public HoaDon selectByMDH(Object key) {
         List<HoaDon> list = this.selectBySql(selcetByMaDonHang, key);
        if (list.isEmpty()) {
            return null; 
        }
        return list.get(0);
    }

    @Override
    protected List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<HoaDon>();
        try {
            ResultSet rs = JDBC.query(sql, args);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setMaHoaDon(rs.getInt("MaHoaDon"));
                hd.setTongThanhTien(rs.getDouble("TongThanhTien"));
                hd.setTienNhan(rs.getDouble("TienNhan"));
                hd.setNgayBan(rs.getDate("NgayBan"));
                hd.setSoBan(rs.getInt("SoBan"));
                hd.setGioVao(rs.getString("GioVao"));
                hd.setGioRa(rs.getString("GioRa"));
                hd.setGhiChu(rs.getString("GhiChu"));
                hd.setMaNhanVien(rs.getString("MaNhanVien"));
                hd.setMaDonHang(rs.getInt("MaDonHang"));
                hd.setMaKhachHang(rs.getString("MaKhachHang"));
                                          
                list.add(hd);
            }
            rs.getStatement().getConnection().close();// laấy những câu hỏi sql và đóng kết nối
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
    
}
