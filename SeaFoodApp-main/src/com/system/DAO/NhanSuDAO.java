package com.system.DAO;

import com.System.inventorysoftware.LogIn.FinalValue;
import com.system.JDBC_SQL_Server.JDBC;
import com.system.model.code.NhanSu;
import com.system.model.code.TaiKhoan;
import com.system.utils.DataContains;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class NhanSuDAO extends DAO<NhanSu, Object> {

    String insertNhanSu = "insert into NhanSu values (?,?,?,?,?,?,?,?,?,?,?,?)";
    String deleteNhanSu = "delete NhanSu where MaNhanVien like ?";
    String updateNhanSu = "UPDATE NhanSu set MaChucVu = ?,  HoVaTen = ?, GioiTinh = ?, SDT = ?, BacLuong = ?, NgaySinh = ?, Email = ?, DiaChi = ?, Luong = ?, Img = ?, tinhTrang = ? where MaNhanVien like ?";
    String selectAllNhanSu = "select * from NhanSu";
    String selectByNhanSu = "select * from NhanSu where MaNhanVien like ?";

    @Override
    public void insert(NhanSu entity) {
        JDBC.update(insertNhanSu, entity.getMaNhanVien(), entity.getMaChucVu(),
                entity.getHoVaTen(), entity.getGioiTinh(), entity.getSoDienThoai(),
                entity.getBacLuong(), entity.getNgaySinh(), entity.getEmail(),
                entity.getDiaChi(), entity.getLuong(), entity.getImg(), entity.isTinhTrang());
    }

    @Override
    public void update(NhanSu entity) {
        JDBC.update(updateNhanSu, entity.getMaChucVu(), entity.getHoVaTen(), entity.getGioiTinh(), entity.getSoDienThoai(),
                entity.getBacLuong(), entity.getNgaySinh(), entity.getEmail(),
                entity.getDiaChi(), entity.getLuong(), entity.getImg(), entity.isTinhTrang(), entity.getMaNhanVien());
    }

    @Override
    public void delete(Object key) {
        JDBC.update(deleteNhanSu, key);
    }

    @Override
    public List<NhanSu> selectAll() {
        return this.selectBySql(selectAllNhanSu);
    }

    @Override
    public NhanSu selectByID(Object key) {
        List<NhanSu> list = this.selectBySql(selectByNhanSu, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @Override
    protected List<NhanSu> selectBySql(String sql, Object... args) {
        List<NhanSu> list = new ArrayList<NhanSu>();
        try {
            ResultSet rs = JDBC.query(sql, args);
            while (rs.next()) {
                try {
                    NhanSu ns = new NhanSu();
                    ns.setMaNhanVien(rs.getString("MaNhanVien"));
                    ns.setMaChucVu(rs.getString("MaChucVu"));
                    ns.setHoVaTen(rs.getString("HoVaTen"));
                    ns.setGioiTinh(rs.getString("GioiTinh"));
                    ns.setSoDienThoai(rs.getString("SDT"));
                    ns.setBacLuong(rs.getDouble("BacLuong"));
                    ns.setNgaySinh(rs.getDate("NgaySinh"));
                    ns.setEmail(rs.getString("Email"));
                    ns.setDiaChi(rs.getString("DiaChi"));
                    ns.setLuong(rs.getDouble("Luong"));
                    ns.setImg(rs.getString("Img"));
                    ns.setTinhTrang(rs.getBoolean("TinhTrang"));
                    list.add(ns);
                } catch (Exception e) {
                    System.out.println("Lỗi truy vấn truy dữ liệu");
                }
            }
            rs.getStatement().getConnection().close();// laấy những câu hỏi sql và đóng kết nối
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public List<NhanSu> selectBykeywordName(String keyword) {
        String sql = "SELECT * FROM NhanSu WHERE HoVaTen LIKE ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }

    public List<NhanSu> selectBykeywordPhone(String keyword) {
        String sql = "SELECT * FROM NhanSu WHERE SDT LIKE ?";
        return this.selectBySql(sql, "%" + keyword + "%");
    }

    public void insertTK() {
        NhanSu ns = new NhanSu();
        String sql = "insert into TaiKhoan(MaNhanVien) values(?)";
        System.out.println(DataContains.maCV + "test ma");
        JDBC.update(sql, DataContains.maCV);
    }
    
     public NhanSu selectCheckGmail(Object key) {
        String sql = "select * from NhanSu where Email like ?";
        List<NhanSu> list = this.selectBySql(sql, key);
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    } /// update mật khẩu thôi
    public void updatePassWord(TaiKhoan entity) {
        String sql = "update TaiKhoan set MatKhau = ? where MaNhanVien = ?";
        System.out.println(FinalValue.passWord);
        JDBC.update(sql,FinalValue.passWord,entity.getMaNhanVien());
        
    }
}
