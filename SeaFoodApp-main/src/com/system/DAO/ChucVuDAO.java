package com.system.DAO;

import com.system.JDBC_SQL_Server.JDBC;
import com.system.model.code.ChucVu;
import com.system.utils.MsgBox;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ChucVuDAO extends DAO<ChucVu, Object> {

    String insertChucVu = "insert into ChucVu values (?,?,?)";
    String deleteChucVu = "delete ChucVu where MaChucVu like ?";
    String updateChucVu = "update ChucVu set TenChucVu = ?, LuongCoBan = ? where MaChucVu like ?";
    String selectAllChucVu = "select * from ChucVu";
    String selectByChucVu = "select * from ChucVu where MaChucVu like ?";

    @Override
    public void insert(ChucVu entity) {
        JDBC.update(insertChucVu, entity.getMaChucVu(), entity.getTenChucVu(), entity.getLuongCoBan());
    }

    @Override
    public void update(ChucVu entity) {
        JDBC.update(updateChucVu, entity.getTenChucVu(), entity.getLuongCoBan(), entity.getMaChucVu());
    }

    @Override
    public void delete(Object key) {
        JDBC.update(deleteChucVu, key);
    }

    @Override
    public List<ChucVu> selectAll() {
        return this.selectBySql(selectAllChucVu);
    }

    @Override
    public ChucVu selectByID(Object key) {
        List<ChucVu> list = this.selectBySql(selectByChucVu, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<ChucVu> selectBySql(String sql, Object... args) {
        List<ChucVu> list = new ArrayList<ChucVu>();
        try {
            ResultSet rs = JDBC.query(sql, args);
            while (rs.next()) {
                ChucVu cv = new ChucVu();
                cv.setMaChucVu(rs.getString("MaChucVu"));
                cv.setTenChucVu(rs.getString("TenChucVu"));
                cv.setLuongCoBan(rs.getDouble("LuongCoBan"));

                list.add(cv);
            }
            rs.getStatement().getConnection().close();// laấy những câu hỏi sql và đóng kết nối
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ChucVu> selectBykeywordName(String keyword) {
        String sql = "SELECT * FROM ChucVu WHERE TenChucVu LIKE ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }
   
    public List<ChucVu> selectBykeywordPhone(String keyword) {
        String sql = "SELECT * FROM ChucVu WHERE LuongCoBan LIKE ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }
}
