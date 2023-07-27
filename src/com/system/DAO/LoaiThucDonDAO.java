
package com.system.DAO;

import com.system.JDBC_SQL_Server.JDBC;
import com.system.model.code.LoaiThucDon;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LoaiThucDonDAO extends DAO<LoaiThucDon, Object>{
    
    String insertLoaiThucDon = "insert into LoaiThucDon values(?,?,?)";
    String deleteLoaiThuc = "delete LoaiThucDon where MaLoaiThucDon like ?";
    String updateLoaiThucDon = "update LoaiThucDon set TenLoaiThucDon = ?, ThuocLoai = ? where MaLoaiThucDon like ?";
    String selectAllLoaiThucDon = "select * from LoaiThucDon";
    String selectByLoaiThucDon = "select * from LoaiThucDon where MaLoaiThucDon like ?";
    String selectByThuocLoai = "select * from LoaiThucDon where ThuocLoai like ?";

    @Override
    public void insert(LoaiThucDon entity) {
        JDBC.update(insertLoaiThucDon, entity.getMaLoaiThucDon(), entity.getTenLoaiThucDon(), entity.getThuocLoai());
    }

    @Override
    public void update(LoaiThucDon entity) {
        JDBC.update(updateLoaiThucDon, entity.getTenLoaiThucDon(), entity.getThuocLoai(), entity.getMaLoaiThucDon());
    }

    @Override
    public void delete(Object key) {
        JDBC.update(deleteLoaiThuc, key);
    }

    @Override
    public List<LoaiThucDon> selectAll() {
        return this.selectBySql(selectAllLoaiThucDon);
    }

    @Override
    public LoaiThucDon selectByID(Object key) {
        List<LoaiThucDon> list = this.selectBySql(selectByLoaiThucDon, key);
        if (list.isEmpty()) {
            return null; 
        }
        return list.get(0);
    }
    
    public List<LoaiThucDon> selectByThuocLoai(Object key) {
        List<LoaiThucDon> list = this.selectBySql(selectByThuocLoai, key);
        if (list.isEmpty()) {
            return null; 
        }
        return list;
    }

    @Override
    protected List<LoaiThucDon> selectBySql(String sql, Object... args) {
        List<LoaiThucDon> list = new ArrayList<LoaiThucDon>();
        try {
            ResultSet rs = JDBC.query(sql, args);
            while (rs.next()) {
                LoaiThucDon ltd = new LoaiThucDon();
                ltd.setMaLoaiThucDon(rs.getString("MaLoaiThucDon"));
                ltd.setTenLoaiThucDon(rs.getString("TenLoaiThucDon"));
                ltd.setThuocLoai(rs.getString("ThuocLoai"));
                                       
                list.add(ltd);
            }
            rs.getStatement().getConnection().close();// laấy những câu hỏi sql và đóng kết nối
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
