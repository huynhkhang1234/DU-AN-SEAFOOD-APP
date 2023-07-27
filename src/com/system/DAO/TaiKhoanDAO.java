package com.system.DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.system.JDBC_SQL_Server.JDBC;
import com.system.inventorysoftware.LogIn.FinalValue;
import com.system.model.code.TaiKhoan;

public class TaiKhoanDAO extends DAO<TaiKhoan, Object> {

    String insertTaiKhoan = "insert into TaiKhoan() values (?,?,?,?,?)";
    String deleteTaiKhoan = "delete TaiKhoan where MaNhanVien = ?";
    String updateTaiKhoan = "update TaiKhoan set TenDangNhap = ?, MatKhau = ?, MaChucVu = ?, NgayTao = ? where MaNhanVien = ?";
    String selectAllTaiKhoan = "select * from TaiKhoan";
    String selectByTaiKhoan = "select * from TaiKhoan where MaNhanVien = ?";
    String selecByNameLogin = "select * from TaiKhoan where TenDangNhap like ?";

    @Override
    public void insert(TaiKhoan entity) {
        JDBC.update(insertTaiKhoan, entity.getTenDangNhap(),
                entity.getMatKhau(), entity.getNgayTao(),
                entity.getMaNhanVien(), entity.getMaChucVu(), entity.isTinhTrang());
    }

    @Override
    public void update(TaiKhoan entity) {
        JDBC.update(updateTaiKhoan, entity.getTenDangNhap(),entity.getMatKhau(), entity.getMaChucVu(),entity.getNgayTao(),entity.getMaNhanVien());
    }

    @Override
    public void delete(Object key) {
        JDBC.update(deleteTaiKhoan, key);
    }

    @Override
    public List<TaiKhoan> selectAll() {
        return this.selectBySql(selectAllTaiKhoan);
    }

    @Override
    public TaiKhoan selectByID(Object key) {
        List<TaiKhoan> list = this.selectBySql(selectByTaiKhoan, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<TaiKhoan> selectBySql(String sql, Object... args) {
        List<TaiKhoan> list = new ArrayList<TaiKhoan>();
        try {
            ResultSet rs = JDBC.query(sql, args);
            while (rs.next()) {
                TaiKhoan tk = new TaiKhoan();
                tk.setSTT(rs.getInt("STT"));
                tk.setTenDangNhap(rs.getString("TenDangNhap"));
                tk.setMatKhau(rs.getString("MatKhau"));
                tk.setNgayTao(rs.getDate("NgayTao"));
                tk.setMaNhanVien(rs.getString("MaNhanVien"));
                tk.setMaChucVu(rs.getString("MaChucVu"));
                tk.setTinhTrang(rs.getBoolean("TinhTrang"));
                list.add(tk);
            }
            rs.getStatement().getConnection().close();// laấy những câu hỏi sql và đóng kết nối
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<TaiKhoan> selectBykeywordName(String keyword) {
        String sql = "SELECT * FROM TaiKhoan WHERE TenDangNhap LIKE ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }
    
    
     public List<TaiKhoan> selectBykeywordDate(String keyword) {
        String sql = "SELECT * FROM TaiKhoan WHERE NgayTao LIKE ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }
    ///
    public TaiKhoan selectByNameLogin(String key) {
        List<TaiKhoan> list = this.selectBySql(selecByNameLogin, key);// có hoặc có tham số
        if (list.isEmpty()) {
            return null; // trả về nếu ko có
        }
        return list.get(0);// lấy cái đầu tiên
    }
    
    
    /// update mật khẩu thôi
    public void updatePassWord(TaiKhoan entity) {
        String sql = "update TaiKhoan set MatKhau = ? where MaNhanVien = ?";
        JDBC.update(sql,FinalValue.passWord,entity.getMaNhanVien());
    }
    
     public TaiKhoan selectCheckNameLogin(String key) {
        String sql = "select * from TaiKhoan where tenDangNhap like  ?";
        List<TaiKhoan> list = this.selectBySql(sql, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }


    
}
