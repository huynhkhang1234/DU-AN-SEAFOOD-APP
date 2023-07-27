package com.system.DAO;

import com.system.JDBC_SQL_Server.JDBC;
import com.system.model.code.DoUong;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DoUongDAO extends DAO<DoUong, Object> {

    String insertDoUong = "insert into DoUong values(?,?,?,?,?,?,?)";
    String deleteDoUong = "delete DoUong where MaDoUong like ?";
    String updateDoUong = "update DoUong set TenDoUong = ?, GiaDoUong = ?, GiaGoc = ?, TinhTrang = ?, img = ?, MaLoaiThucDon = ? where MaDoUong like ?";
    String selectAllDoUong = "select * from doUong where TinhTrang = 1";
    String selectByMaLoaiThucDonUong = "select * from DoUong where MaLoaiThucDon like  ?";
    String selectByDoUong = "select * from DoUong where MaDoUong like ?";
    String selectByTenDoUong = "select * from DoUong where TenDoUong like ?";

    @Override
    public void insert(DoUong entity) {
        JDBC.update(insertDoUong, entity.getMaDoUong(), entity.getTenDoUong(),
                entity.getGiaDoUong(), entity.getGiaGoc(), entity.isTinhTrang(),
                entity.getImg(), entity.getMaLoaiThucDon());
    }

    @Override
    public void update(DoUong entity) {
        JDBC.update(updateDoUong, entity.getTenDoUong(),
                entity.getGiaDoUong(), entity.getGiaGoc(), entity.isTinhTrang(),
                entity.getImg(), entity.getMaLoaiThucDon(), entity.getMaDoUong());
    }

    @Override
    public void delete(Object key) {
        JDBC.update(deleteDoUong, key);
    }

    @Override
    public List<DoUong> selectAll() {
        return this.selectBySql(selectAllDoUong);
    }

    @Override
    public DoUong selectByID(Object key) {
        List<DoUong> list = this.selectBySql(selectByDoUong, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<DoUong> selectByMaLoaiThucDonUong(Object key) {
        List<DoUong> list = this.selectBySql(selectByMaLoaiThucDonUong, key);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
    
    public List<DoUong> selectByIDTenDoUong(Object key) {
        List<DoUong> list = this.selectBySql(selectByTenDoUong, "%"+key+"%");
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    protected List<DoUong> selectBySql(String sql, Object... args) {
        List<DoUong> list = new ArrayList<DoUong>();
        try {
            ResultSet rs = JDBC.query(sql, args);
            while (rs.next()) {
                DoUong DoUong = new DoUong();
                DoUong.setMaDoUong(rs.getString("MaDoUong"));
                DoUong.setTenDoUong(rs.getString("TenDoUong"));
                DoUong.setGiaDoUong(rs.getDouble("GiaDoUong"));
                DoUong.setGiaGoc(rs.getDouble("GiaGoc"));
                DoUong.setTinhTrang(rs.getBoolean("TinhTrang"));
                DoUong.setImg(rs.getString("Img"));
                DoUong.setMaLoaiThucDon(rs.getString("MaLoaiThucDon"));

                list.add(DoUong);
            }
            rs.getStatement().getConnection().close();// laấy những câu hỏi sql và đóng kết nối
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
