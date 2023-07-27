/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.form;

import com.system.DAO.DatBanDAO;
import com.system.DAO.DonHangDAO;
import com.system.model.code.DatBan;
import com.system.model.code.DonHang;
import com.system.utils.Auth;
import com.system.utils.FormatMoney;
import com.system.utils.MsgBox;
import com.system.utils.XDate;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class QuanLyDatBan extends javax.swing.JPanel {

    DefaultTableModel tblModel;
    DatBanDAO daoDB = new DatBanDAO();
    public static int row = -1;

    public QuanLyDatBan() {
        initComponents();
        init();
    }

    private void init() {
        this.fillTable();
        // sử kiện click chuột vào table
        this.clickTable();
        this.setIDAuto("KH", tblDatBan.getTbl());
    }

    public void fillTable() {
        tblModel = new DefaultTableModel();
        tblModel.setColumnCount(0);
        tblModel.addColumn("Mã Khách hàng");
        tblModel.addColumn("Tên Khách Hàng");
        tblModel.addColumn("Số điện thoại");
        tblModel.addColumn("Số Bàn");
        tblModel.addColumn("Ngày");
        tblModel.addColumn("Thời gian");
        tblModel.addColumn("Tiền Cọc");
        tblModel.addColumn("Ghi chú");
        tblModel.addColumn("Tình trạng");
        tblDatBan.setRowCount(0);
        try {
            List<DatBan> list = daoDB.selectAll();// lưu cái cở sở dự liệu về ái list mà ở trong nhân viên
            for (DatBan entity : list) {
                tblModel.addRow(new Object[]{
                    entity.getMaKhachHang(), entity.getTenKhachHang(), entity.getSoDienThoai(), entity.getSoBan(),
                    entity.getNgayDen(), entity.getThoiGian(), FormatMoney.formatMoney(entity.getTienCoc()), entity.getGhiChu(), entity.isTinhTrang()});
            }

            tblDatBan.getTbl().setModel(tblModel);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void clickTable() {
        try {

            tblDatBan.getTbl().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //lấy dữ liệu ở dòng đã chọn
                    QuanLyDatBan.row = tblDatBan.getTbl().getSelectedRow();
                    txtMaKH.setEnabled(false);
                    edit();
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void edit() {
        String maDB = (String) tblDatBan.getValueAt(row, 0);
        DatBan model = daoDB.selectByID(maDB);
        if (model != null) {
            this.setForm(model);
        }
    }

    private void setForm(DatBan model) {
        txtMaKH.setText(model.getMaKhachHang());
        txtTenKH.setText(model.getTenKhachHang());
        txtSDT.setText(model.getSoDienThoai());
        txtSoBan.setText(String.valueOf(model.getSoBan()));
        txtThoiGian.setText(model.getThoiGian());
        txtNgayTao.getTxt().setText(XDate.SimpleDateFormat(model.getNgayDen()));
        txtTienCoc.setText(FormatMoney.formatMoney(model.getTienCoc()));
        if (model.isTinhTrang() == true) {
            rdoDaTT.setSelected(true);
        } else {
            rdoChuaTT.setSelected(true);
        }
        txtGhiChu.getTextArea1().setText(model.getGhiChu());
        //set dữ liệu lưu vào biến
        Auth.maKhachHang = txtMaKH.getText();
        Auth.soBan = txtSoBan.getText();
    }

    // ham lay du lieu len form
    public DatBan getForm(DatBan model) throws ParseException {
        model.setMaKhachHang(txtMaKH.getText());
        model.setTenKhachHang(txtTenKH.getText());
        model.setSoDienThoai(txtSDT.getText());
        model.setSoBan(Integer.parseInt(txtSoBan.getText()));
        model.setThoiGian(txtThoiGian.getText());
        String ngayDen = txtNgayTao.getTxt().getText();
        //định dạng lại kiểu ngày thôi
        Date date = new SimpleDateFormat("dd-MM-yyyy").parse(ngayDen);
        model.setNgayDen(date);
        // định dạng lại tiền
        String tienCoc = FormatMoney.formatReplace(txtTienCoc.getText());
        model.setTienCoc(Double.parseDouble(FormatMoney.formatVND(tienCoc)));
        if (rdoDaTT.isSelected()) {
            model.setTinhTrang(true);
        }
        if (rdoChuaTT.isSelected()) {
            model.setTinhTrang(false);
        }
        model.setGhiChu(txtGhiChu.getTextArea1().getText());
        return model;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTenKH = new com.system.customSwing.TextField_01.TextFieldSuggestion();
        txtSoBan = new com.system.customSwing.TextField_01.TextFieldSuggestion();
        txtSDT = new com.system.customSwing.TextField_01.TextFieldSuggestion();
        jLabel5 = new javax.swing.JLabel();
        txtThoiGian = new com.system.customSwing.TextField_01.TextFieldSuggestion();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtNgayTao = new com.system.customSwing.Designed.MyCalendar();
        jLabel8 = new javax.swing.JLabel();
        txtGhiChu = new com.system.customSwing.Designed.MyTextArea();
        rdoChuaTT = new com.system.customSwing.Designed.MyRadioButton();
        rdoDaTT = new com.system.customSwing.Designed.MyRadioButton();
        jLabel9 = new javax.swing.JLabel();
        txtMaKH = new com.system.customSwing.TextField_01.TextFieldSuggestion();
        jLabel10 = new javax.swing.JLabel();
        txtTienCoc = new com.system.customSwing.TextField_01.TextFieldSuggestion();
        pnlChuaTable = new com.system.customSwing.Designed.MyPanel();
        txtTimKiem = new com.system.customSwing.TextField_01.TextFieldSuggestion();
        btnTimKiem = new com.system.customSwing.Designed.MyButton_01();
        tblDatBan = new com.system.customSwing.Designed.MyTable();
        myPanel1 = new com.system.customSwing.Designed.MyPanel();
        btnClear = new com.system.customSwing.Designed.MyButton_01();
        btnADD = new com.system.customSwing.Designed.MyButton_01();
        btnUpdate = new com.system.customSwing.Designed.MyButton_01();
        btnDelete = new com.system.customSwing.Designed.MyButton_01();
        btnSave = new com.system.customSwing.Designed.MyButton_01();
        jLabel1 = new javax.swing.JLabel();

        setOpaque(false);

        jPanel1.setOpaque(false);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel2.setText("Tên khách hàng:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel3.setText("Số điện thoại:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel4.setText("Số bàn:");

        txtTenKH.setOpaque(true);

        txtSoBan.setOpaque(true);
        txtSoBan.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSoBanFocusLost(evt);
            }
        });

        txtSDT.setOpaque(true);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel5.setText("Hình thức:");

        txtThoiGian.setOpaque(true);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel6.setText("Thời gian:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel7.setText("Ngày:");

        txtNgayTao.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel8.setText("Ghi chú:");

        txtGhiChu.setBackground(new java.awt.Color(255, 255, 255));
        txtGhiChu.setOpaque(true);

        rdoChuaTT.setBackground(new java.awt.Color(255, 0, 0));
        buttonGroup1.add(rdoChuaTT);
        rdoChuaTT.setText("Chưa thanh toán");
        rdoChuaTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoChuaTTMouseClicked(evt);
            }
        });

        rdoDaTT.setBackground(new java.awt.Color(255, 51, 51));
        buttonGroup1.add(rdoDaTT);
        rdoDaTT.setText("Đã thanh toán");
        rdoDaTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rdoDaTTMouseClicked(evt);
            }
        });
        rdoDaTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoDaTTActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel9.setText("Mã khách hàng:");

        txtMaKH.setOpaque(true);
        txtMaKH.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaKHFocusLost(evt);
            }
        });
        txtMaKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMaKHKeyReleased(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        jLabel10.setText("Tiền cọc:");

        txtTienCoc.setOpaque(true);
        txtTienCoc.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtTienCocFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTienCocFocusLost(evt);
            }
        });
        txtTienCoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTienCocMouseClicked(evt);
            }
        });
        txtTienCoc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTienCocKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(8, 8, 8)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(64, 64, 64)
                                .addComponent(rdoDaTT, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rdoChuaTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtTienCoc, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(67, 67, 67)
                                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(61, 61, 61)
                                .addComponent(txtThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(75, 75, 75)
                                .addComponent(txtSoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(11, 11, 11)
                                .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 2, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel2))
                    .addComponent(txtTenKH, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel4))
                    .addComponent(txtSoBan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtThoiGian, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTienCoc, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel7))
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(6, 6, 6))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdoDaTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rdoChuaTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 88, Short.MAX_VALUE))
                    .addComponent(txtGhiChu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        txtTimKiem.setOpaque(true);
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });
        txtTimKiem.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtTimKiemKeyReleased(evt);
            }
        });

        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        tblDatBan.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                tblDatBanAncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        tblDatBan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDatBanMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlChuaTableLayout = new javax.swing.GroupLayout(pnlChuaTable);
        pnlChuaTable.setLayout(pnlChuaTableLayout);
        pnlChuaTableLayout.setHorizontalGroup(
            pnlChuaTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlChuaTableLayout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 286, Short.MAX_VALUE)
                .addGap(36, 36, 36)
                .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
            .addGroup(pnlChuaTableLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tblDatBan, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );
        pnlChuaTableLayout.setVerticalGroup(
            pnlChuaTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlChuaTableLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(tblDatBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(pnlChuaTableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(25, 25, 25))
        );

        myPanel1.setLayout(new java.awt.GridLayout(1, 0, 30, 0));

        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/icon/icons8-available-updates-70.png"))); // NOI18N
        btnClear.setRadius(20);
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });
        myPanel1.add(btnClear);

        btnADD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/icon/icons8-add-64.png"))); // NOI18N
        btnADD.setRadius(20);
        btnADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnADDActionPerformed(evt);
            }
        });
        myPanel1.add(btnADD);

        btnUpdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/icon/icons8-edit-64.png"))); // NOI18N
        btnUpdate.setRadius(20);
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });
        myPanel1.add(btnUpdate);

        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/icon/icons8-remove-64.png"))); // NOI18N
        btnDelete.setRadius(20);
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        myPanel1.add(btnDelete);

        btnSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/icon/icons8-save-64.png"))); // NOI18N
        btnSave.setRadius(20);
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });
        myPanel1.add(btnSave);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlChuaTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(myPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlChuaTable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(myPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ĐẶT BÀN");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(1, 1, 1))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed


    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void rdoDaTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoDaTTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdoDaTTActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed

        try {
            // TODO add your handling code here:
            Clear();
        } catch (ParseException ex) {
            Logger.getLogger(QuanLyDatBan.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnClearActionPerformed

    private void tblDatBanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDatBanMouseClicked


    }//GEN-LAST:event_tblDatBanMouseClicked

    private void tblDatBanAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_tblDatBanAncestorAdded

    }//GEN-LAST:event_tblDatBanAncestorAdded

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed

    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnADDActionPerformed

    }//GEN-LAST:event_btnADDActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed

    }//GEN-LAST:event_btnDeleteActionPerformed

    private void rdoDaTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoDaTTMouseClicked

        RDO();
    }//GEN-LAST:event_rdoDaTTMouseClicked

    private void rdoChuaTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rdoChuaTTMouseClicked

        RDO();
    }//GEN-LAST:event_rdoChuaTTMouseClicked

    private void txtTimKiemKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTimKiemKeyReleased
        this.Search();
        if (txtTimKiem.getText().equals("")) {
            this.fillTable();
        }
    }//GEN-LAST:event_txtTimKiemKeyReleased

    private void txtTienCocKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTienCocKeyReleased
        setTextMoney(txtTienCoc);
        txtTienCoc.setBackground(Color.white);
        if (txtTienCoc.getText().trim() != null) {
            txtTienCoc.setText(txtTienCoc.getText().trim().replace(" VNĐ", ""));
        }
    }//GEN-LAST:event_txtTienCocKeyReleased

    private void txtTienCocMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTienCocMouseClicked

    }//GEN-LAST:event_txtTienCocMouseClicked

    private void txtTienCocFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTienCocFocusLost
        if (txtTienCoc.getText().length() > 0) {
            String tienCoc = FormatMoney.formatMoney(Double.parseDouble(FormatMoney.formatReplace(txtTienCoc.getText())));
            txtTienCoc.setText(tienCoc);
        }
    }//GEN-LAST:event_txtTienCocFocusLost

    private void txtTienCocFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTienCocFocusGained
        String tienCoc = FormatMoney.formatVND(txtTienCoc.getText());
        txtTienCoc.setText(tienCoc);
    }//GEN-LAST:event_txtTienCocFocusGained

    private void txtMaKHFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaKHFocusLost

    }//GEN-LAST:event_txtMaKHFocusLost

    private void txtSoBanFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSoBanFocusLost
//        try {
//            double soBan = Double.parseDouble(txtSoBan.getText().replaceAll(",", ""));
//            if (soBan <= 0) {
//                MsgBox.alert(this, "Vui lòng nhập số bàn đúng định dạng");
//            }
//        } catch (NumberFormatException ex) {
//            MsgBox.alert(this, "Vui lòng nhập số bàn đúng định dạng");
//        }

    }//GEN-LAST:event_txtSoBanFocusLost

    private void txtMaKHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMaKHKeyReleased
//        String maKhachHang = txtMaKH.getText();
//        DatBan db = daoDB.selectByID(maKhachHang);
//        if (db != null) {
//            MsgBox.alert(this, "Mã khách hàng đã tồn tại ! Vui lòng nhập lại");
//            txtMaKH.requestFocus();
//            txtMaKH.setText("");
//        } else if (maKhachHang.length() > 10) {
//            MsgBox.alert(this, "Mã khách hàng vượt quá giới hạn !");
//            txtMaKH.setText(maKhachHang.substring(0, 10));
//        }
    }//GEN-LAST:event_txtMaKHKeyReleased

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        if (MsgBox.confirm(this, "Bạn có chắc chắn muốn đặt bàn ?")) {
            daoDB.DatBanKhachHang();
            QuanLyHoaDon qlhd = new QuanLyHoaDon();
            qlhd.loadForm();
            MsgBox.alert(this,"Lưu thành công");
        }

    }//GEN-LAST:event_btnSaveActionPerformed

    private void Search() {
        try {
            String keyword = txtTimKiem.getText();
            List<DatBan> list = daoDB.selectBykeyword(keyword);
            tblModel.setRowCount(0);
            if (list != null) {
                System.out.println(list.size());
                for (DatBan entity : list) {
                    tblModel.addRow(new Object[]{
                        entity.getMaKhachHang(), entity.getTenKhachHang(), entity.getSoDienThoai(), entity.getSoBan(),
                        entity.getNgayDen(), entity.getThoiGian(), entity.getTienCoc(), entity.getGhiChu(), entity.isTinhTrang()
                    });
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void RDO() {
        if (rdoDaTT.isSelected() == true) {
            txtGhiChu.getTextArea1().setText("");
            txtGhiChu.getTextArea1().setText("Đã thanh toán\n" + txtGhiChu.getTextArea1().getText());
        } else if (rdoChuaTT.isSelected() == true) {
            txtGhiChu.getTextArea1().setText("");
            txtGhiChu.getTextArea1().setText("Chưa thanh toán\n" + txtGhiChu.getTextArea1().getText());
        } else {

        }
    }

    // phước thức dùng để xóa code
    public void delete() {
        if (tblDatBan.getTbl().getSelectedRow() >= 0) {
            String madb = (String) tblDatBan.getValueAt(this.row, 0);
            if (MsgBox.confirm(this, "Bạn chắc chắn muốn xóa ?")) {
                try {
                    DonHangDAO daoDH = new DonHangDAO();
                    DatBan db = daoDB.selectByID(madb);
                    db.setTienCoc(0);
                    daoDH.updateTongThanhTien(db);
                    
                    daoDB.delete(madb);
                    this.fillTable();
                    Clear();
                    MsgBox.alert(this, "Xóa thành công!");
                } catch (Exception e) {
                    MsgBox.alert(this, "Xóa thất bại!");
                }//
            }
        } else {
            MsgBox.alert(this, "Vui lòng thêm thông tin vào danh sách");
        }
    }

    public void Clear() throws ParseException {
        row = -1;
        txtMaKH.setEnabled(true);
        txtMaKH.setText("");
        txtTenKH.setText("");
        txtSoBan.setText("");
        txtSDT.setText("");
        txtThoiGian.setText("");
        txtNgayTao.getTxt().setText("7-12-2022");
        txtTienCoc.setText("");
        txtGhiChu.getTextArea1().setText("Đã thanh toán");
        rdoDaTT.setSelected(true);
        setIDAuto("KH", tblDatBan.getTbl());
    }

    public void insert() throws ParseException {
        if (Error()) {
            try {
                if (checkTimeTable()) {
                    DatBan qlnv = new DatBan();
                    DatBan model = getForm(qlnv);
                    if (MsgBox.confirm(this, "Bạn có chắc chắn muốn thêm khách hàng mới ?")) {
                        String maKH = txtMaKH.getText();
                        DatBan db = daoDB.selectByID(maKH);
                        if (db != null) {
                            MsgBox.alert(this, "Mã khách hàng đã tồn tại ! Vui lòng nhập thông tin chính xác ");
                            txtMaKH.requestFocus();
                            txtMaKH.setText("");
                        } else if (maKH.length() > 10) {
                            MsgBox.alert(this, "Mã chức vụ vượt quá giới hạn !");
                            txtMaKH.setText(maKH.substring(0, 10));
                        } else {

                            daoDB.insert(model);
                            this.fillTable();
                            this.Clear();
                            MsgBox.alert(this, "Thêm mới thành công!");

                        }

                    }
                }
            } catch (HeadlessException e) {
                MsgBox.alert(this, "Thêm mới thất bại!");
            }
        }
    }

    public void update() throws ParseException {
        if (row == -1) {
            MsgBox.alert(this, "Chọn thông tin muốn thay đổi");
        } else if (txtTenKH.getText().matches("[0-9]") == true) {
            MsgBox.alert(this, "Vui lòng nhập đúng thông tin Tên khách hàng");
            txtTenKH.requestFocus();
        } else if (txtTenKH.getText().matches("[0-9][0-9]") == true) {
            MsgBox.alert(this, "Vui lòng nhập đúng thông tin Tên khách hàng");
            txtTenKH.requestFocus();
        } else if (txtTenKH.getText().matches("[0-9][0-9][0-9]") == true) {
            MsgBox.alert(this, "Vui lòng nhập đúng thông tin Tên khách hàng");
            txtTenKH.requestFocus();
        } else if (txtTenKH.getText().matches("[0-9][0-9][0-9][0-9]") == true) {
            MsgBox.alert(this, "Vui lòng nhập đúng thông tin Tên khách hàng");
            txtTenKH.requestFocus();
        } else if (txtTenKH.getText().matches("[0-9][0-9][0-9][0-9][0-9]") == true) {
            MsgBox.alert(this, "Vui lòng nhập đúng thông tin Tên khách hàng");
            txtTenKH.requestFocus();
        } else if (txtSDT.getText().matches("0[0-9]{9}") == false) {
            MsgBox.alert(this, "Vui lòng nhập thông tin số điện thoại đúng định dạng");
            txtSDT.requestFocus();
        } else if (txtSoBan.getText().matches("[0-3][0-9]") == false) {
            MsgBox.alert(this, "Vui lòng nhập thông tin Số Bàn đúng định dạng");
            txtSoBan.requestFocus();
        } else if (txtThoiGian.getText().matches("[0-9][0-9]:[0-6][0-5]") == false) {
            MsgBox.alert(this, "Vui lòng nhập thông tin Thời gian đúng định dạng");
            txtThoiGian.requestFocus();
        } else if (txtTienCoc.getText().trim().replace(",", "").matches("[a-zA-Z ]+")) {
            MsgBox.alert(this, "Vui lòng nhập đúng định dạng tiền");
            txtTienCoc.requestFocus();
        } // Sau khi bắt lỗi
        else {
            DatBan model = new DatBan();
            try {
                getForm(model);
            } catch (ParseException ex) {
                Logger.getLogger(QuanLyDatBan.class.getName()).log(Level.SEVERE, null, ex);
            }
            if (MsgBox.confirm(this, "Bạn có chắc chắn muốn cập nhật thông tin?")) {
                daoDB.update(model);
                this.fillTable();
                this.Clear();
                MsgBox.alert(this, "Cập nhật thành công!");
            }
        }
    }


    public boolean Error() {
        if (txtMaKH.getText().equals("")) {
            MsgBox.alert(this, "Mã khách hàng trống");
            txtMaKH.requestFocus();
            return false;
        } else if (txtMaKH.getText().matches("[A-Z][A-Z][0-9][0-9][0-9]") == false) {
            MsgBox.alert(this, "Vui lòng nhập thông tin số Mã Khách Hàng đúng định dạng");
            txtMaKH.requestFocus();
            return false;
        } else if (txtTenKH.getText().equals("")) {
            MsgBox.alert(this, "Tên khách hàng trống");
            txtTenKH.requestFocus();
            return false;
        } else if (txtTenKH.getText().equals("^[0-9]+$") == true) {
            MsgBox.alert(this, "Tên khách hàng chưa đúng định dạng");
            txtTenKH.requestFocus();
            return false;
        } else if (txtSDT.getText().equals("")) {
            MsgBox.alert(this, "Số điện thoại trống");
            txtSDT.requestFocus();
            return false;
        } else if (txtSDT.getText().matches("0[0-9]{9}") == false) {
            MsgBox.alert(this, "Vui lòng nhập thông tin số điện thoại đúng định dạng");
            txtSDT.requestFocus();
            return false;
        } else if (txtSoBan.getText().equals("")) {
            MsgBox.alert(this, "Số bàn trống");
            txtSoBan.requestFocus();
            return false;
        } else if (txtSoBan.getText().matches("[3-9][1-9]") == true) {
            MsgBox.alert(this, "Số bàn tối đa là 30");
            txtSoBan.requestFocus();
            return false;
        } else if (txtSoBan.getText().matches("[0-3][0-9]") == false) {
            MsgBox.alert(this, "Vui lòng nhập thông tin Số Bàn đúng định dạng\n ví dụ: 01");
            txtSoBan.requestFocus();
            return false;
        } else if (txtThoiGian.getText().equals("")) {
            MsgBox.alert(this, "Thời gian trống");
            txtThoiGian.requestFocus();
            return false;
        } else if (txtThoiGian.getText().matches("[2-9][2-9]:[1-6][0-5]") == true) {

            MsgBox.alert(this, "Quán chỉ phục vụ các đơn đặt bàn đến 22:00");
            txtThoiGian.requestFocus();
            return false;
        } else if (txtThoiGian.getText().matches("[2-9][2-9]:[0][1-9]") == true) {

            MsgBox.alert(this, "Quán chỉ phục vụ các đơn đặt bàn đến 22:00");
            txtThoiGian.requestFocus();
            return false;
        } else if (txtThoiGian.getText().matches("[0][1-6]:[0-9][0-5]") == true) {

            MsgBox.alert(this, "Quán chỉ phục vụ các đơn đặt bàn từ 07:00");
            txtThoiGian.requestFocus();
            return false;
        } else if (txtThoiGian.getText().matches("[0-2][0-9]:[0-6][0-5]") == false) {
            MsgBox.alert(this, "Vui lòng nhập thông tin Thời gian đúng định dạng\n Ví dụ: 12:00");
            txtThoiGian.requestFocus();
            return false;
        } else if (txtTienCoc.getText().equals("")) {
            MsgBox.alert(this, "Tiền cọc trống");
            txtTienCoc.requestFocus();
            return false;
        } else if (txtTienCoc.getText().trim().replace(",", "").matches("[a-zA-Z ]+") == true) {
            System.out.println(txtTienCoc.getText().trim().replace(",", ""));
            MsgBox.alert(this, "Vui lòng nhập dúng định dạng tiền ?");
            txtTienCoc.requestFocus();
            return false;
        } else if (rdoDaTT.isSelected() == false && rdoChuaTT.isSelected() == false) {
            MsgBox.alert(this, "Hình thức trống");
            rdoChuaTT.setSelected(true);
            txtGhiChu.getTextArea1().setText("Chưa thanh toán");
            return false;
        }
        return true;

    }

    // hàm định dạng tiền
    public void setTextMoney(javax.swing.JTextField txt) {
        try {
            String so = txt.getText().trim().replace(",", "");
            if (Double.parseDouble(so) >= 1000000000) {
                so = new StringBuilder(so).insert(so.length() - 3, ",").insert(so.length() - 6, ",").insert(so.length() - 9, ",").toString();
                txt.setText(so);
            } else if (Double.parseDouble(so) >= 1000000) {
                so = new StringBuilder(so).insert(so.length() - 3, ",").insert(so.length() - 6, ",").toString();
                txt.setText(so);
            } else if (Double.parseDouble(so) >= 1000) {
                so = new StringBuilder(so).insert(so.length() - 3, ",").toString();
                txt.setText(so);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void addEvent(String name, ActionListener event) {
        if (name.contains("thêm")) {
            btnADD.addActionListener(event);
        } else if (name.contains("sửa")) {
            btnUpdate.addActionListener(event);
        } else if (name.contains("xóa")) {
            btnDelete.addActionListener(event);
        } else if (name.contains("luu")) {
            btnSave.addActionListener(event);
        }
    }
    
     private boolean checkTimeTable() {
        try {
            String MaBan = txtSoBan.getText();
            DatBan datBan2 = daoDB.selectbyIdSoBan(MaBan);
            if (datBan2 != null) {
                int thoiGiantruoc = Integer.parseInt(datBan2.getThoiGian().substring(0, 2));
                int thoiGianSau = Integer.parseInt(txtThoiGian.getText().substring(0, 2));
                if (thoiGianSau - thoiGiantruoc < 2) {
                    MsgBox.alert(this, "Thời gian đặt bàn chưa hợp lí ! Vui lòng lựa chọn lại");
                    txtThoiGian.requestFocus();
                    return false;
                } else if (thoiGianSau - thoiGiantruoc >= 2) {
                    return true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public void setIDAuto(String name, JTable tbl) {
        if (tbl.getRowCount() == 0) {
            txtMaKH.setText(name + "001");
        }
        List<Integer> listSo = new ArrayList<>();
        for (int i = 0; i < tbl.getRowCount(); i++) {
            if (tbl.getValueAt(i, 0).toString().contains(name)) {
                int so = Integer.parseInt(tbl.getValueAt(i, 0).toString().replace(name, "").trim());
                listSo.add(so);
            }
        }

        for (int i = 1; i < tbl.getRowCount() + 2; i++) {
            for (Integer so : listSo) {
                if (i != so) {
                    txtMaKH.setText(name + "00" + i);
                    if (i > 9) {
                        txtMaKH.setText(name + "0" + i);
                    }

                }
            }
        }

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.system.customSwing.Designed.MyButton_01 btnADD;
    private com.system.customSwing.Designed.MyButton_01 btnClear;
    private com.system.customSwing.Designed.MyButton_01 btnDelete;
    private com.system.customSwing.Designed.MyButton_01 btnSave;
    private com.system.customSwing.Designed.MyButton_01 btnTimKiem;
    private com.system.customSwing.Designed.MyButton_01 btnUpdate;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private com.system.customSwing.Designed.MyPanel myPanel1;
    private com.system.customSwing.Designed.MyPanel pnlChuaTable;
    private com.system.customSwing.Designed.MyRadioButton rdoChuaTT;
    private com.system.customSwing.Designed.MyRadioButton rdoDaTT;
    private com.system.customSwing.Designed.MyTable tblDatBan;
    private com.system.customSwing.Designed.MyTextArea txtGhiChu;
    private com.system.customSwing.TextField_01.TextFieldSuggestion txtMaKH;
    private com.system.customSwing.Designed.MyCalendar txtNgayTao;
    private com.system.customSwing.TextField_01.TextFieldSuggestion txtSDT;
    private com.system.customSwing.TextField_01.TextFieldSuggestion txtSoBan;
    private com.system.customSwing.TextField_01.TextFieldSuggestion txtTenKH;
    private com.system.customSwing.TextField_01.TextFieldSuggestion txtThoiGian;
    private com.system.customSwing.TextField_01.TextFieldSuggestion txtTienCoc;
    private com.system.customSwing.TextField_01.TextFieldSuggestion txtTimKiem;
    // End of variables declaration//GEN-END:variables

}
