package com.system.DAO;

import com.system.JDBC_SQL_Server.JDBC;
import com.system.model.code.DoAn;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DoAnDAO extends DAO<DoAn, Object> {

    String insertDoAn = "insert into DoAn values(?,?,?,?,?,?,?)";
    String deleteDoAn = "delete DoAn where MaDoAn like ?";
    String updateDoAn = "update DoAn set TenDoAn = ?, GiaDoAn = ?, GiaGoc = ?, TinhTrang = ?, img = ?, MaLoaiThucDon = ? where MaDoAn like ?";
    String selectAllDoAn = "select * from DoAn where TinhTrang = 1";
    String selectByMaLoaiThucDonAn = "select * from DoAn where MaLoaiThucDon like  ?";
    String selectByDoAn = "select * from DoAn where MaDoAn like ?";
    String selectByTenDoAn = "select * from DoAn where TenDoAn like ?";

    @Override
    public void insert(DoAn entity) {
        JDBC.update(insertDoAn, entity.getMaDoAn(), entity.getTenDoAn(),
                entity.getGiaDoAn(), entity.getGiaGoc(),
                entity.isTinhTrang(), entity.getImg(),
                entity.getMaLoaiThucDon());
    }

    @Override
    public void update(DoAn entity) {
        JDBC.update(updateDoAn, entity.getTenDoAn(), entity.getGiaDoAn(),
                entity.getGiaGoc(), entity.isTinhTrang(), entity.getImg(),
                entity.getMaLoaiThucDon(), entity.getMaDoAn());
    }

    @Override
    public void delete(Object key) {
        JDBC.update(deleteDoAn, key);
    }

    @Override
    public List<DoAn> selectAll() {
        return this.selectBySql(selectAllDoAn);
    }

    @Override
    public DoAn selectByID(Object key) {
        List<DoAn> list = this.selectBySql(selectByDoAn, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<DoAn> selectByMaLoaiThucDonAn(Object key) {
        List<DoAn> list = this.selectBySql(selectByMaLoaiThucDonAn, key);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    public List<DoAn> selectByTenDoAn(Object key) {
        List<DoAn> list = this.selectBySql(selectByTenDoAn, "%" + key + "%");
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }

    @Override
    protected List<DoAn> selectBySql(String sql, Object... args) {
        List<DoAn> list = new ArrayList<DoAn>();
        try {
            ResultSet rs = JDBC.query(sql, args);

            while (rs.next()) {
                DoAn DoAn = new DoAn();
                DoAn.setMaDoAn(rs.getString("MaDoAn"));
                DoAn.setTenDoAn(rs.getString("TenDoAn"));
                DoAn.setGiaDoAn(rs.getDouble("GiaDoAn"));
                DoAn.setGiaGoc(rs.getDouble("GiaGoc"));
                DoAn.setTinhTrang(rs.getBoolean("TinhTrang"));
                DoAn.setImg(rs.getString("Img"));
                DoAn.setMaLoaiThucDon(rs.getString("MaLoaiThucDon"));

                list.add(DoAn);
            }
            rs.getStatement().getConnection().close();// laấy những câu hỏi sql và đóng kết nối
            return list;
        } catch (Exception e) {
            return list;
            
        }
    }

}
