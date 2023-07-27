package com.system.DAO;

import com.system.JDBC_SQL_Server.JDBC;
import com.system.model.code.DatBan;
import com.system.utils.Auth;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DatBanDAO extends DAO<DatBan, Object> {

    String insertDatBan = "insert into DatBan values (?,?,?,?,?,?,?,?,?)";
    String deleteDatBan = "delete DatBan where MaKhachHang = ?";
    String updateDatBan = "update DatBan set TenKhachHang=?, SoBan = ?, SoDienThoai = ?, ThoiGian = ?, TienCoc =?,TinhTrang = ?, NgayDen =?, GhiChu=? where MaKhachHang = ?";
    String selectAllDatBan = "select * from DatBan";
    String selectByDatBan = "select * from DatBan where MaKhachHang = ?";
    String selectBySoBan = "select * from DatBan where SoBan = ?   order by ThoiGian desc";

    @Override
    public void insert(DatBan entity) {
        JDBC.update(insertDatBan, entity.getMaKhachHang(), entity.getTenKhachHang(),
                entity.getSoDienThoai(), entity.getSoBan(), entity.getNgayDen(), entity.getThoiGian(),
                entity.getTienCoc(), entity.getGhiChu(), entity.isTinhTrang()
        );
    }

    @Override
    public void update(DatBan entity) {
        JDBC.update(updateDatBan, entity.getTenKhachHang(),
                entity.getSoBan(), entity.getSoDienThoai(), entity.getThoiGian(), entity.getTienCoc(),
                entity.isTinhTrang(), entity.getNgayDen(), entity.getGhiChu(), entity.getMaKhachHang());

    }

    @Override
    public void delete(Object key) {
        JDBC.update(deleteDatBan, key);
    }

    @Override
    public List<DatBan> selectAll() {
        return this.selectBySql(selectAllDatBan);
    }

    @Override
    public DatBan selectByID(Object key) {
        List<DatBan> list = this.selectBySql(selectByDatBan, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    public List<DatBan> selectBySoBan(Object key) {
        List<DatBan> list = this.selectBySql(selectBySoBan, key);
        if (list.isEmpty()) {
            return null;
        }
        return list;
    }
    
    public DatBan selectbyIdSoBan(Object key) {
        List<DatBan> list = this.selectBySql(selectBySoBan, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<DatBan> selectBySql(String sql, Object... args) {
        List<DatBan> list = new ArrayList<DatBan>();
        try {
            ResultSet rs = JDBC.query(sql, args);
            while (rs.next()) {
                DatBan db = new DatBan();
                db.setMaKhachHang(rs.getString("MaKhachHang"));
                db.setTenKhachHang(rs.getString("TenKhachHang"));
                db.setSoDienThoai(rs.getString("SoDienThoai"));
                db.setSoBan(rs.getInt("SoBan"));
                db.setNgayDen(rs.getDate("NgayDen"));
                db.setThoiGian(rs.getString("ThoiGian"));
                db.setTienCoc(rs.getDouble("TienCoc"));
                db.setGhiChu(rs.getString("GhiChu"));
                db.setTinhTrang(rs.getBoolean("TinhTrang"));

                list.add(db);
            }
            rs.getStatement().getConnection().close();// laấy những câu hỏi sql và đóng kết nối
            return list;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public List<DatBan> selectBykeyword(String keyword) {

        String sql = "SELECT * FROM DatBan WHERE TenKhachHang LIKE ?";

        return this.selectBySql(sql, "%" + keyword + "%");

    }
//    public List<DatBan> selectBykeyword(String keyword) {
//       
//        String sql = "SELECT * FROM DatBan WHERE SoDienThoai LIKE ?";
//        return this.selectBySql(sql, "%" + keyword + "%");
//    
//    }

    public void DatBanKhachHang() {
        DatBan db = new DatBan();
        String sql = "update DonHang set MaKhachHang = ? where SoBan = ? ";
        JDBC.update(sql, Auth.maKhachHang, Auth.soBan);
    }

}
