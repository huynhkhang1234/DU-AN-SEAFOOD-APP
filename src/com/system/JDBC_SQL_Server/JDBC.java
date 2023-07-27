/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.JDBC_SQL_Server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author ADMIN
 */
public class JDBC {

    private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private static String dburl = "jdbc:sqlserver://localhost:1433;databaseName=QuanLiNhaHangHaiSan";
    private static String user = "sa";
    private static String pass = "123";

    static {
        try {
            Class.forName(driver);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * phương thức này nhận vào câu lệnh SQL và 1 mảng không hạn chế phần tử,
     * các đối tượng đưa vào dấu?
     *
     * @param sql
     * @param args
     * @return
     * @throws SQLException
     */
    public static PreparedStatement getStmt(String sql, Object... args) throws SQLException {
        Connection conn = DriverManager.getConnection(dburl, user, pass);
        PreparedStatement stmt;
        // nếu như câu lệnh sql bắt đầu bởi dấu ngoặc nhọn
        // thì câu lệnh sql đó là lời gọi thủ tục lưu
        if (sql.trim().startsWith("{")) {
            stmt = conn.prepareCall(sql); // lời gọi thủ tục lưu
        } else {
            stmt = conn.prepareStatement(sql); // lời gọi câu lệnh sql bth
        }
        // dùng vòng lặp for chạy từ 0 cho đến hết danh sách tham số
        // và cứ mỗi tham số như vậy thì nó lấy cái giá trị tham số đó
        // và nó set vào cái vị trí i + 1

        for (int i = 0; i < args.length; i++) {
            stmt.setObject(i + 1, args[i]);
        }
        return stmt;
    }

    /**
     * phương thức này dùng chung cho các câu lệnh sql Truy vấn nhận vào câu
     * lệnh sql và 1 mảng không hạn chế các phần tử ?
     *
     * @param sql nhận vào câu lệnh sql
     * @param args mảng không giới hạn phận tử đại diện ?
     * @return trả về tập kết quả sau khi truy vấn
     * @throws SQLException
     */
    public static ResultSet query(String sql, Object... args) throws SQLException {
        PreparedStatement stmt = JDBC.getStmt(sql, args);
        return stmt.executeQuery();
    }

    /**
     * phương thức này dùng khi chúng ta muốn lấy 1 giá trị trong bảng
     *
     * @param sql câu lệnh sql
     * @param args danh sách các tham số đại diện cho dấu ?
     * @return trả về vị trí đầu tiên nếu như tìm thấy ngược lại null
     */
    public static Object value(String sql, Object... args) {
        try {
            ResultSet rs = JDBC.query(sql, args);
            if (rs.next()) {
                return rs.getObject(0);
            }
            rs.getStatement().getConnection().close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;

    }

    /**
     *
     * @param sql
     * @param args
     * @return trả về số cột bị ảnh hưởng khi cập nhật
     */
    public static int update(String sql, Object... args) {
        try {
            PreparedStatement stmt = getStmt(sql, args);
            try {
                return stmt.executeUpdate();
            } finally {
                stmt.getConnection().close();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public static void main(String[] args) throws SQLException {
        // JDBC jdbc = new JDBC();
        try {
            Connection conn = DriverManager.getConnection(dburl, user, pass);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
