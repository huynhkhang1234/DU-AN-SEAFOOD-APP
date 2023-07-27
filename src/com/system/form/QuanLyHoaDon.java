/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.form;

import com.system.DAO.DatBanDAO;
import com.system.DAO.DonHangChiTietDAO;
import com.system.DAO.DonHangDAO;
import com.system.PrintBill.PrintBill;
import com.system.component.Header;
import com.system.component.ItemBan;
import com.system.component.ItemHD;
import com.system.component.ItemTaoHoaDon;
import com.system.component.PanelThanhToan;
import com.system.customSwing.Designed.WrapLayout;
import com.system.customSwing.ScrollBar.ScrollBar;
import com.system.customSwing.ShowNotify.PanelLoading;
import com.system.method.MessageNotify;
import com.system.model.code.DatBan;
import com.system.model.code.DonHang;
import com.system.model.code.DonHangChiTiet;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

/**
 *
 * @author Tran Thi Hong Tham
 */
public class QuanLyHoaDon extends javax.swing.JPanel {

    private DatBanDAO daoDB;
    private DonHangDAO daoDH;
    private DonHangChiTietDAO daoDHCT;
    private List<ItemHD> listItem = new ArrayList<>();
    private List<ItemBan> listItemBan = new ArrayList<>();
    private List<PanelThanhToan> listPnl = new ArrayList<>();

    private ItemTaoHoaDon itemTaoHD = new ItemTaoHoaDon();

    private boolean checkPrint = true;

    private MessageNotify ms = new MessageNotify();

    public JPanel getPnlChuaHoaDon() {
        return pnlChuaHoaDon;
    }

    public JPanel getPnlChuaItemBan() {
        return pnlChuaItemBan;
    }

    public List<ItemHD> getListItem() {
        return listItem;
    }

    public List<ItemBan> getListItemBan() {
        return listItemBan;
    }

    public QuanLyHoaDon() {
        initComponents();
        init();
    }

    private void init() {
        pnlChuaHoaDon.setLayout(new WrapLayout(WrapLayout.LEFT, 20, 20));
        pnlChuaItemBan.setLayout(new WrapLayout(WrapLayout.LEFT, 20, 20));
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        scroll.setVerticalScrollBar(new ScrollBar());

        daoDH = new DonHangDAO();
        daoDB = new DatBanDAO();
        daoDHCT = new DonHangChiTietDAO();

        btnChuyenBan.setEnabled(false);
        btnGopBan.setEnabled(false);
        btnInBill.setEnabled(false);
        btnTachBan.setEnabled(false);
        btnThemMon.setEnabled(false);
    }

    private MouseListener EventForItemHD(JLayeredPane background, Header header, ItemHD item, DonHang dh, QuanLyDatMon qldm, QuanLyDatBan qldb, QuanLyThongKe qltk, MainForm main, PanelLoading pnlLoading) {
        MouseListener event = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PanelThanhToan pnl = new PanelThanhToan(item.getMaDonHang() + "", item.getSoBan(), item.getGiaTien());
                background.setLayer(pnl, JLayeredPane.POPUP_LAYER);
                background.add(pnl, "pos 0 0 100% 100%");
                pnl.setVisible(true);
                pnl.addEventForXNTT(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            dh.setGioRa(header.getLblDate().getText() + " " + header.getLblTime().getText());
                            daoDH.update(dh);
                            checkPrint = PrintBill.printBill(dh);

                            // bắt đầu dùng sau 1.5 giây
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    pnlLoading.setVisible(true);
                                    try {
                                        if (checkPrint) {
                                            daoDHCT.deleteByMaDonHang(dh.getMaDonHang());
                                            if (dh.getSoBan() == 0) {
                                                daoDH.delete(dh.getMaDonHang());
                                            } else if (dh.getSoBan() != 0 && dh.getTongTienThanhToan() != 0) {
                                                DonHang test = new DonHang();
                                                test.setSoBan(dh.getSoBan());
                                                test.setTongTienThanhToan(0);
                                                test.setMaDonHang(dh.getMaDonHang());
                                                daoDH.update(test);
                                                List<DatBan> listDB = daoDB.selectBySoBan(dh.getSoBan());
                                                if (listDB != null) {
                                                    for (DatBan db : listDB) {
                                                        if (db.getMaKhachHang().equalsIgnoreCase(dh.getMaKhachHang())) {
                                                            daoDB.delete(db.getMaKhachHang());
                                                        }
                                                    }
                                                }
                                            }
                                            addDataToList(background, header, qldm, qldb, qltk, main, pnlLoading);
                                            pnl.setVisible(false);
                                            ms.showNotify(header.getLblThongBao(), "Đã in hóa đơn thành công", MessageNotify.MessageType.SUCCESS);
                                            qldm.setDefault();
                                            loadForm();
                                            qldb.fillTable();
                                            qltk.init();
                                        }
                                        // bắt đầu dùng sau 1.5 giây
                                        Thread.sleep(1500);
                                        pnlLoading.setVisible(false);
                                        // hàn để đóng fram chính main.

                                    } catch (InterruptedException ex) {
                                        ex.printStackTrace();
                                    }

                                }
                            }).start();

                        } catch (FileNotFoundException ex) {
                            ex.printStackTrace();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                }
                );
            }
        };
        return event;
    }

    private MouseListener EventForItemHD(ItemHD item, QuanLyDatMon qldm, MainForm main) {
        MouseListener event = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (item.getSoBan() != 0) {
                    DonHang dh = daoDH.selectBySoBan(item.getSoBan());
                    qldm.setForm("số bàn", dh, main);
                } else {
                    DonHang dh = daoDH.selectByID(item.getMaDonHang());
                    qldm.setForm("hóa đơn", dh, main);
                }
            }

        };
        return event;
    }

    public void addDataToList(JLayeredPane background, Header header, QuanLyDatMon qldm, QuanLyDatBan qldb, QuanLyThongKe qltk, MainForm main, PanelLoading pnlLoading) {
        clearList();

        List<DonHang> listDH = daoDH.selectAll();
        for (DonHang dh : listDH) {
            List<DonHangChiTiet> list = daoDHCT.selectByMaDonHang(dh.getMaDonHang());
            if (list != null) {
                if (dh.getSoBan() == 0 || (dh.getTongTienThanhToan() != 0 && list.get(0).getGiaTien() != 0)) {
                    ItemHD item = new ItemHD(dh.getSoBan(), dh.getTongTienThanhToan(), dh.getSoBan() == 0 ? "mang đi" : "ăn tại bàn", dh.getMaDonHang());
                    item.addEventThanhToan("thanh toán", EventForItemHD(background, header, item, dh, qldm, qldb, qltk, main, pnlLoading));
                    item.addEventThanhToan("xem chi tiết", EventForItemHD(item, qldm, main));
                    listItem.add(item);
                }
            }
            if (dh.getSoBan() != 0 && (dh.getTongTienThanhToan() != 0 || dh.getTongTienThanhToan() == 0)) {
                ItemBan item = new ItemBan(dh.getSoBan(), dh.getTongTienThanhToan(), (dh.getTongTienThanhToan() == 0 && dh.getMaKhachHang() == null) ? "bàn trống" : dh.getMaKhachHang() != null ? "đã đặt" : "có khách");
                item.addDAToDH(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        qldm.setComboBox(item.getSoBan());
                        main.showForm(qldm);
                        super.mouseClicked(e);
                    }

                });
                listItemBan.add(item);
            }
        }
        loadForm();
    }

    public void loadForm() {
        pnlChuaHoaDon.add(itemTaoHD);
        itemTaoHD.setVisible(true);
        if (listItem != null && listItemBan != null) {
            for (ItemHD item : listItem) {
                pnlChuaHoaDon.add(item);
            }

            for (ItemBan item : listItemBan) {
                pnlChuaItemBan.add(item);
            }
            pnlChuaHoaDon.repaint();
            pnlChuaItemBan.repaint();
            pnlChuaHoaDon.revalidate();
            pnlChuaItemBan.revalidate();
        }
    }

    public void clearList() {
        listItem.clear();
        listItemBan.clear();

        for (Component comp : pnlChuaHoaDon.getComponents()) {
            comp.setVisible(false);
        }

        for (Component comp : pnlChuaItemBan.getComponents()) {
            comp.setVisible(false);
        }
    }

    public void addEventHD(String nameEvent, MouseListener event) {
        for (ItemHD item : listItem) {
            item.addEventThanhToan(nameEvent, event);
        }
    }

    public void addEventTaoHD(ActionListener event) {
        itemTaoHD.addEventForCreatHD(event);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        myTabbedPane1 = new com.system.customSwing.Designed.MyTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlChuaHoaDon = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        pnlChuaItemBan = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnChuyenBan = new com.system.customSwing.Designed.MyButton_01();
        btnThemMon = new com.system.customSwing.Designed.MyButton_01();
        btnGopBan = new com.system.customSwing.Designed.MyButton_01();
        btnInBill = new com.system.customSwing.Designed.MyButton_01();
        btnTachBan = new com.system.customSwing.Designed.MyButton_01();

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setBackground(new java.awt.Color(240, 224, 192));
        setOpaque(false);

        myTabbedPane1.setBackground(new java.awt.Color(255, 102, 102));

        jPanel2.setBackground(new java.awt.Color(255, 51, 51));
        jPanel2.setForeground(new java.awt.Color(255, 102, 102));

        jScrollPane1.setBorder(null);
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlChuaHoaDon.setBackground(new java.awt.Color(234, 241, 248));

        javax.swing.GroupLayout pnlChuaHoaDonLayout = new javax.swing.GroupLayout(pnlChuaHoaDon);
        pnlChuaHoaDon.setLayout(pnlChuaHoaDonLayout);
        pnlChuaHoaDonLayout.setHorizontalGroup(
            pnlChuaHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1132, Short.MAX_VALUE)
        );
        pnlChuaHoaDonLayout.setVerticalGroup(
            pnlChuaHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 446, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(pnlChuaHoaDon);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );

        myTabbedPane1.addTab("Hóa đơn", jPanel2);

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        pnlChuaItemBan.setBackground(new java.awt.Color(234, 241, 248));

        javax.swing.GroupLayout pnlChuaItemBanLayout = new javax.swing.GroupLayout(pnlChuaItemBan);
        pnlChuaItemBan.setLayout(pnlChuaItemBanLayout);
        pnlChuaItemBanLayout.setHorizontalGroup(
            pnlChuaItemBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1149, Short.MAX_VALUE)
        );
        pnlChuaItemBanLayout.setVerticalGroup(
            pnlChuaItemBanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 446, Short.MAX_VALUE)
        );

        scroll.setViewportView(pnlChuaItemBan);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll)
        );

        myTabbedPane1.addTab("Danh sách bàn", jPanel3);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        btnChuyenBan.setText("Chuyển bàn");
        btnChuyenBan.setBorderColor(new java.awt.Color(102, 0, 0));
        btnChuyenBan.setColorClick(new java.awt.Color(153, 153, 153));
        btnChuyenBan.setColorOver(new java.awt.Color(255, 255, 255));
        btnChuyenBan.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N

        btnThemMon.setText("Thêm món cho bàn");
        btnThemMon.setBorderColor(new java.awt.Color(102, 0, 0));
        btnThemMon.setColorClick(new java.awt.Color(153, 153, 153));
        btnThemMon.setColorOver(new java.awt.Color(255, 255, 255));
        btnThemMon.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N

        btnGopBan.setText("Gộp bàn");
        btnGopBan.setBorderColor(new java.awt.Color(102, 0, 0));
        btnGopBan.setColorClick(new java.awt.Color(153, 153, 153));
        btnGopBan.setColorOver(new java.awt.Color(255, 255, 255));
        btnGopBan.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N

        btnInBill.setText("In Bill cho bếp");
        btnInBill.setBorderColor(new java.awt.Color(102, 0, 0));
        btnInBill.setColorClick(new java.awt.Color(153, 153, 153));
        btnInBill.setColorOver(new java.awt.Color(255, 255, 255));
        btnInBill.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N

        btnTachBan.setText("Tách bàn");
        btnTachBan.setBorderColor(new java.awt.Color(102, 0, 0));
        btnTachBan.setColorClick(new java.awt.Color(153, 153, 153));
        btnTachBan.setColorOver(new java.awt.Color(255, 255, 255));
        btnTachBan.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnChuyenBan, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(btnGopBan, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(btnTachBan, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(btnInBill, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addComponent(btnThemMon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemMon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGopBan, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChuyenBan, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnInBill, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTachBan, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(myTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(5, 5, 5))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(myTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 494, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.system.customSwing.Designed.MyButton_01 btnChuyenBan;
    private com.system.customSwing.Designed.MyButton_01 btnGopBan;
    private com.system.customSwing.Designed.MyButton_01 btnInBill;
    private com.system.customSwing.Designed.MyButton_01 btnTachBan;
    private com.system.customSwing.Designed.MyButton_01 btnThemMon;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private com.system.customSwing.Designed.MyTabbedPane myTabbedPane1;
    private javax.swing.JPanel pnlChuaHoaDon;
    private javax.swing.JPanel pnlChuaItemBan;
    private javax.swing.JScrollPane scroll;
    // End of variables declaration//GEN-END:variables

}
