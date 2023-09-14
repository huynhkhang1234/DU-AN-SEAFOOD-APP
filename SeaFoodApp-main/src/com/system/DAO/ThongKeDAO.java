/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.DAO;

import com.system.JDBC_SQL_Server.JDBC;
import com.system.utils.FormatMoney;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class ThongKeDAO {

    public List<Object[]> getHoaDonChiTiet(int thang, int nam) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_ThongKeHoaDonChiTiet (?, ?)}";
                rs = JDBC.query(sql, thang, nam);
                int index = 1;
                while (rs.next()) {
                    Object[] model = {index++, rs.getInt("MaHoaDon"), rs.getString("MaNhanVien"), rs.getString("MaKhachHang"), rs.getDate("NgayBan"), rs.getInt("SoBan"),
                        rs.getString("TenDoAnVaDoUong"), rs.getInt("SoLuong"), rs.getDouble("ThanhTien"), rs.getString("GhiChu"), rs.getString("MaDonHang")};
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Object[]> getSoLuongHoaDon(int thang, int nam) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "{call sp_TongHopHoaDon (?, ?)}";
                rs = JDBC.query(sql, thang, nam);

                int index = 1;
                while (rs.next()) {
                    Object[] model = {index++, rs.getInt("SoBan") == 0 ? "Mang đi" : "Bàn số: " + rs.getInt("SoBan"),
                        rs.getInt("SoLuongHoaDon"), rs.getDate("NgayBan"), FormatMoney.formatMoney(rs.getDouble("TongTien"))};
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Object[]> getTongTienMangDi(int thang, int nam) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "SELECT COUNT(hd.SoBan) AS 'SoLuong', SUM(hd.TongThanhTien) AS 'TongTien'\n"
                        + "	    FROM dbo.HoaDon hd \n"
                        + "		WHERE CONVERT(VARCHAR, MONTH(NgayBan)) LIKE ? AND \n"
                        + "			  CONVERT(VARCHAR, YEAR(NgayBan)) LIKE ? AND \n"
                        + "			  hd.SoBan = 0";
                rs = JDBC.query(sql, thang, nam);

                while (rs.next()) {
                    Object[] model = {rs.getInt("SoLuong"), rs.getDouble("TongTien")};
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public List<Object[]> getTongTienTaiBan(int thang, int nam) {
        List<Object[]> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                String sql = "SELECT COUNT(hd.SoBan) AS 'SoLuong', SUM(hd.TongThanhTien) AS 'TongTien'\n"
                        + "	    FROM dbo.HoaDon hd \n"
                        + "		WHERE CONVERT(VARCHAR, MONTH(NgayBan)) LIKE ? AND \n"
                        + "			  CONVERT(VARCHAR, YEAR(NgayBan)) LIKE ? AND \n"
                        + "			  hd.SoBan != 0";
                rs = JDBC.query(sql, thang, nam);

                while (rs.next()) {
                    Object[] model = {rs.getInt("SoLuong"), rs.getDouble("TongTien")};
                    list.add(model);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
