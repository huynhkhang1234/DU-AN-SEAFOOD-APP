/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.form;

import com.system.DAO.DatBanDAO;
import com.system.DAO.DoAnDAO;
import com.system.DAO.DoUongDAO;
import com.system.DAO.DonHangChiTietDAO;
import com.system.DAO.DonHangDAO;
import com.system.PrintBill.PrintBill;
import com.system.component.Header;
import com.system.component.ItemFAD;
import com.system.component.ItemOrder;
import com.system.component.cardMenuDashboard;
import com.system.customSwing.Designed.WrapLayout;
import com.system.customSwing.ScrollBar.ScrollBar;
import com.system.method.Format_Money;
import com.system.method.MessageNotify;
import com.system.model.UI.ModelListOrder;
import com.system.model.code.DatBan;
import com.system.model.code.DoAn;
import com.system.model.code.DoUong;
import com.system.model.code.DonHang;
import com.system.model.code.DonHangChiTiet;
import com.system.utils.Auth;
import java.awt.Component;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class QuanLyDatMon extends javax.swing.JPanel {

    private DoAnDAO doAnDAO = new DoAnDAO();
    private DoUongDAO daoDU = new DoUongDAO();
    private DonHangDAO daoDH = new DonHangDAO();
    private DatBanDAO daoDB = new DatBanDAO();
    private DonHangChiTiet dhct = new DonHangChiTiet();
    private DonHangChiTietDAO daoDHCT = new DonHangChiTietDAO();
    private List<ItemOrder> listOrder = new ArrayList<>();
    private MessageNotify ms = new MessageNotify();

    double tienSP;
    double tienGiam = 0;
    double tienTra;

    private Header header;

    public QuanLyDatMon(Header header) {
        initComponents();
        init();
        this.header = header;
    }

    private void init() {
        scroll.setVerticalScrollBar(new ScrollBar());
        scroll2.setVerticalScrollBar(new ScrollBar());
        scrollHeader.setHorizontalScrollBar(new ScrollBar());
        pnlContainOrder.setLayout(new WrapLayout(WrapLayout.LEFT, 3, 5));

        rdoAnTaiBan.setSelected(true);

        fillLoaiMonAn("Món khai vị", "Món chính", "Món tráng miệng", "Đồ uống có cồn", "Đồ uống khác");
        fillTable("ăn");
        fillTable("uống");
        fillComboBoxSoBan("fillter");
    }

    public void fillTable(String nameTable) {
        try {
            if (nameTable.contains("ăn")) {
                List<DoAn> list = doAnDAO.selectAll();
                for (DoAn entity : list) {
                    DoAn data = new DoAn(
                            entity.getMaDoAn(), entity.getTenDoAn(), entity.getGiaDoAn(), entity.getGiaGoc(), entity.isTinhTrang(), entity.getImg(), entity.getMaLoaiThucDon()
                    );
                    addFoodToMenu(data);
                }
            } else {
                List<DoUong> list = daoDU.selectAll();
                for (DoUong entity : list) {
                    DoUong data = new DoUong(
                            entity.getMaDoUong(), entity.getTenDoUong(), entity.getGiaDoUong(), entity.getGiaGoc(), entity.isTinhTrang(), entity.getImg(), entity.getMaLoaiThucDon()
                    );
                    addDrinkToMenu(data);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void fillLoaiMonAn(String... name) {
        for (int i = 0; i < name.length; i++) {
            themDLVaoLoaiMon(name[i]);
        }
    }

    public void themDLVaoLoaiMon(String name) {
        cardMenuDashboard cd = new cardMenuDashboard(name);
        pnlChuaLoaiMonAn.add(cd);
    }

    public void addFoodToMenu(DoAn data) {
        ItemFAD itemF = new ItemFAD();
        itemF.setDataFood(data);
        itemF.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Bắt sự kiện nếu click chuột trái vào
                if (SwingUtilities.isLeftMouseButton(e)) {
                    List<DonHangChiTiet> list;
                    DonHang dh;
                    if (rdoAnTaiBan.isSelected()) {
                        String soBan = cboSoBan.getSelectedItem().toString().substring(9).trim();
                        dh = daoDH.selectBySoBan(soBan);
                        list = daoDHCT.selectByMaDonHang(dh.getMaDonHang());
                    } else {
                        String maDonHang = cboSoBan.getSelectedItem().toString().substring(9).trim();
                        dh = daoDH.selectByID(maDonHang);
                        list = daoDHCT.selectByMaDonHang(maDonHang);
                    }

                    boolean check = true;
                    if (list != null) {
                        for (DonHangChiTiet dhct : list) {
                            if (dhct.getMaDoAn() == null && dhct.getMaDoUong() == null) {
                                break;
                            }
                            if (dhct.getMaDoUong() == null || dhct.getMaDoUong().isEmpty()) {
                                if (dhct.getMaDoAn().equals(data.getMaDoAn())) {
                                    check = false;
                                }
                            }
                        }
                    }
                    for (ItemOrder item : listOrder) {
                        if (item.getDataOrder().getMaMA().contains(data.getMaDoAn())) {
                            check = false;
                        }
                    }
                    if (check) {
                        ModelListOrder order = new ModelListOrder();
                        order.setMaMA(data.getMaDoAn());
                        order.setTenMA(data.getTenDoAn());
                        order.setGiaTien(data.getGiaDoAn());
                        order.setSoBan(Integer.parseInt(cboSoBan.getSelectedItem().toString().substring(9).trim()));
                        order.setLoaiMA(data.getMaLoaiThucDon());
                        order.setMaHoaDon(dh.getMaDonHang());
                        order.setSoLuong(1);
                        // Sau đó tạo ra item, nơi chứa những cái order đó
                        ItemOrder item = new ItemOrder();
                        item.setDataOrder(order);
                        // CUối cùng là thêm item đó vào nơi nó cần chứa
                        pnlContainOrder.add(item);
                        listOrder.add(item);
                        pnlContainItemMenu.repaint();
                        pnlContainOrder.revalidate();
                        setMoneyPayment();
                    } else {
                        System.out.println("Món ăn đã có trong order rồi ạ");
                    }
                }
            }
        });

        pnlContainItemMenu.add(itemF);
        pnlContainItemMenu.repaint();
        pnlContainItemMenu.revalidate();
    }

    public void addDrinkToMenu(DoUong data) {
        ItemFAD itemF = new ItemFAD();
        itemF.setDataDrink(data);
        itemF.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Bắt sự kiện nếu click chuột trái vào
                if (SwingUtilities.isLeftMouseButton(e)) {
                    List<DonHangChiTiet> list;
                    DonHang dh;
                    if (rdoAnTaiBan.isSelected()) {
                        String soBan = cboSoBan.getSelectedItem().toString().substring(9).trim();
                        dh = daoDH.selectBySoBan(soBan);
                        list = daoDHCT.selectByMaDonHang(dh.getMaDonHang());
                    } else {
                        String maDonHang = cboSoBan.getSelectedItem().toString().substring(9).trim();
                        dh = daoDH.selectByID(maDonHang);
                        list = daoDHCT.selectByMaDonHang(maDonHang);
                    }

                    boolean check = true;
                    if (list != null) {
                        for (DonHangChiTiet dhct : list) {
                            if (dhct.getMaDoAn() == null && dhct.getMaDoUong() == null) {
                                break;
                            }
                            if (dhct.getMaDoAn() == null || dhct.getMaDoAn().isEmpty()) {
                                if (dhct.getMaDoUong().equals(data.getMaDoUong())) {
                                    check = false;
                                }
                            }
                        }
                    }

                    for (ItemOrder item : listOrder) {
                        if (item.getDataOrder().getMaMA().contains(data.getMaDoUong())) {
                            check = false;
                        }
                    }
                    if (check) {
                        // Tạo model và set các chức năng cần thiết
                        ModelListOrder order = new ModelListOrder();
                        order.setMaMA(data.getMaDoUong());
                        order.setTenMA(data.getTenDoUong());
                        order.setGiaTien(data.getGiaDoUong());
                        order.setSoBan(Integer.parseInt(cboSoBan.getSelectedItem().toString().substring(9).trim()));
                        order.setLoaiMA(data.getMaLoaiThucDon());
                        order.setSoLuong(1);
                        order.setMaHoaDon(dh.getMaDonHang());
                        // Sau đó tạo ra item, nơi chứa những cái order đó
                        ItemOrder item = new ItemOrder();
                        item.setDataOrder(order);
                        // CUối cùng là thêm item đó vào nơi nó cần chứa
                        pnlContainOrder.add(item);
                        listOrder.add(item);
                        pnlContainItemMenu.repaint();
                        pnlContainOrder.revalidate();
                        setMoneyPayment();
                    } else {
                        System.out.println("Món ăn đã có trong order rồi ạ");
                    }
                }
            }
        });

        pnlContainItemMenu.add(itemF);
        pnlContainItemMenu.repaint();
        pnlContainItemMenu.revalidate();
    }

    public void addEvent(String nameEvent, ActionListener event) {
        if (nameEvent.equalsIgnoreCase("xóa tất cả")) {
            btnXoaTatCa.addActionListener(event);
        } else if (nameEvent.equalsIgnoreCase("lưu hóa đơn")) {
            btnLuuHoaDon.addActionListener(event);
        }
    }

    public void fillComboBoxSoBan(String name) {
        DefaultComboBoxModel cboModel = (DefaultComboBoxModel) cboSoBan.getModel();
        cboModel.removeAllElements();
        cboSoBan.setEnabled(true);

        List<DonHang> listDH = daoDH.selectAll();
        for (DonHang dh : listDH) {
            if (rdoAnTaiBan.isSelected()) {
                if (dh.getSoBan() != 0) {
                    if (name.equalsIgnoreCase("fillter")) {
                        cboSoBan.setEnabled(true);
                        List<DatBan> listDB = daoDB.selectBySoBan(dh.getSoBan());
                        if (listDB == null) {
                            cboModel.addElement("Bàn số: " + dh.getSoBan());
                        }
                    } else if (name.equalsIgnoreCase("all")) {
                        cboSoBan.setEnabled(false);
                        cboModel.addElement("Bàn số: " + dh.getSoBan());
                    }
                }
            } else {
                if (dh.getSoBan() == 0) {
                    cboModel.addElement("Hóa đơn: " + dh.getMaDonHang());
                }
            }
        }

    }

    public DefaultTableModel getTblModel() {
        DefaultTableModel tblModel = new DefaultTableModel();
        int STT = 1;
        addColumn(tblModel, "STT", "Tên món ăn", "Số lượng", "Giá", "Thành tiền");
        tblModel.setRowCount(0);
        if (listOrder == null) {
            return tblModel;
        } else {
            for (ItemOrder item : listOrder) {
                tblModel.addRow(new Object[]{STT++, item.getDataOrder().getTenMA(), item.getSoLuong(), item.getGiaSP(), item.getThanhTien()});
            }
        }
        return tblModel;
    }

    public void saveBill(Header header) {
        if (cboSoBan.getSelectedItem() != null) {
            DonHang dh;
            if (rdoAnTaiBan.isSelected()) {
                String soBan = cboSoBan.getSelectedItem().toString().substring(9).trim();
                dh = daoDH.selectBySoBan(soBan);
                daoDHCT.deleteByMaDonHang(dh.getMaDonHang());
            } else {
                String maDonHang = cboSoBan.getSelectedItem().toString().substring(9).trim();
                dh = daoDH.selectByID(maDonHang);
                daoDHCT.deleteByMaDonHang(maDonHang);
            }
            // Trường hợp get mã nhân viên tự động
            if (dh.getMaNhanVien() == null || dh.getMaNhanVien().isEmpty()) {
                if (Auth.user.getMaNhanVien() != null || !Auth.user.getMaNhanVien().isEmpty()) {
                    dh.setMaNhanVien(Auth.user.getMaNhanVien());
                }
            }
            // Câu lệnh giúp set giờ vào cho hóa đơn
            if (dh.getGioVao() == null || dh.getGioVao().isEmpty()) {
                dh.setGioVao(header.getLblDate().getText() + " " + header.getLblTime().getText());
            }
//            System.out.println("Sau: " + dh.getGioVao());

            daoDH.update(dh);

            if (listOrder != null) {
                tienSP = 0;
                for (ItemOrder item : listOrder) {
                    DonHangChiTiet dhct = new DonHangChiTiet();
                    if (item.getDataOrder().getLoaiMA().contains("D")) {
                        dhct.setMaDoUong(item.getDataOrder().getMaMA());
                        dhct.setMaDoAn(null);
                    } else {
                        dhct.setMaDoAn(item.getDataOrder().getMaMA());
                        dhct.setMaDoUong(null);
                    }
                    dhct.setMaDonHang(item.getDataOrder().getMaHoaDon());
                    dhct.setSoLuong(item.getSoLuong());
                    dhct.setGiaTien(item.getDataOrder().getGiaTien());
                    dhct.setThanhTien(item.getThanhTien());
                    tienSP += item.getThanhTien();
                    daoDHCT.insert(dhct);
                }
            } else if (listOrder == null) {
                DonHang dh1 = daoDH.selectBySoBan(cboSoBan.getSelectedItem().toString().replace("Bàn số: ", "").trim());
                if (dh1 != null) {
                    daoDHCT.deleteByMaDonHang(dh1.getMaDonHang());
                    dh1.setTongTienThanhToan(0);
                    daoDH.updateTongThanhTien(dh1);
                }
            }
            
            DonHang dh1 = dh;
            dh1.setTongTienThanhToan(tienSP);
            daoDH.updateTongThanhTien(dh1);
            setDefault();

        }
    }

    public void setDefault() {
        if (cboSoBan.getSelectedItem() != null) {
            rdoAnTaiBan.setSelected(true);
            fillComboBoxSoBan("fillter");
            itemChangeComboBox();

        }
    }

    private void itemChangeComboBox() {
        if (cboSoBan.getSelectedItem() != null) {
            List<DonHangChiTiet> list;
            DonHang dh;
            if (rdoAnTaiBan.isSelected()) {
                refeshOrder(pnlContainOrder);
                String soBan = cboSoBan.getSelectedItem().toString().substring(9).trim();
                dh = daoDH.selectBySoBan(soBan);
                list = daoDHCT.selectByMaDonHang(dh.getMaDonHang());
            } else {
                refeshOrder(pnlContainOrder);
                String maDonHang = cboSoBan.getSelectedItem().toString().substring(9).trim();
                dh = daoDH.selectByID(maDonHang);
                list = daoDHCT.selectByMaDonHang(maDonHang);
            }

            if (list != null) {
                for (DonHangChiTiet data : list) {
                    if (data.getGiaTien() != 0) {
                        ItemOrder item = new ItemOrder();
                        ModelListOrder order = new ModelListOrder();
                        if (data.getMaDoUong() == null || data.getMaDoUong().isEmpty()) {
                            DoAn da = doAnDAO.selectByID(data.getMaDoAn());
                            order.setMaMA(data.getMaDoAn());
                            order.setTenMA(da.getTenDoAn());
                            order.setGiaTien(da.getGiaDoAn());
                            order.setLoaiMA(da.getMaLoaiThucDon());
                            order.setSoBan(dh.getSoBan());
                        } else {
                            DoUong du = daoDU.selectByID(data.getMaDoUong());
                            order.setMaMA(data.getMaDoUong());
                            order.setTenMA(du.getTenDoUong());
                            order.setGiaTien(du.getGiaDoUong());
                            order.setLoaiMA(du.getMaLoaiThucDon());
                            order.setSoBan(0);
                        }
                        order.setSoLuong(data.getSoLuong());
                        order.setMaHoaDon(dh.getMaDonHang());
                        // Sau đó tạo ra item, nơi chứa những cái order đó

                        item.setDataOrder(order);
                        // CUối cùng là thêm item đó vào nơi nó cần chứa
                        listOrder.add(item);
                    }

                }
            }
            tienSP = 0;
            for (ItemOrder item : listOrder) {
                pnlContainOrder.add(item);
                tienSP = tienSP + item.getThanhTien();
            }
            pnlContainItemMenu.repaint();
            pnlContainOrder.revalidate();
            setMoneyPayment();
            addEventDeleteOrder();
        }

    }

    public void setComboBox(int soBan) {
        if (soBan == 0) {
            rdoMangDi.setSelected(true);
        } else {
            rdoAnTaiBan.setSelected(true);
            if (daoDB.selectBySoBan(soBan) == null) {
                fillComboBoxSoBan("fillter");
            } else {
                fillComboBoxSoBan("all");
            }
            cboSoBan.setSelectedItem("Bàn số: " + soBan);
            itemChangeComboBox();
        }
    }

    private void addEventDeleteOrder() {
        if (listOrder != null) {
            for (ItemOrder item : listOrder) {
                item.addEventDeleteOrder(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        listOrder.remove(item);
                        item.setVisible(false);

                        pnlContainOrder.repaint();
                        pnlContainOrder.revalidate();
                    }
                });
            }
        }
    }

    private void refeshOrder(JPanel pnl) {
        for (Component comp : pnl.getComponents()) {
            comp.setVisible(false);
        }
        pnl.repaint();
        pnl.revalidate();
        listOrder.clear();
    }

    private void addColumn(DefaultTableModel model, String... nameColumn) {
        model.setColumnCount(0);
        for (int i = 0; i < nameColumn.length; i++) {
            model.addColumn(nameColumn[i]);
        }
    }

    public void deleteAllOrder() {
        refeshOrder(pnlContainOrder);
    }

    public void setMoneyPayment() {
        tienGiam = Double.parseDouble(txtGiamGia.getText().replace("%", "").trim());
        tienSP = 0;
        if (listOrder.isEmpty()) {
            txtGiamGia.setText("0%");
            lblTienSP.setText(Format_Money.formatMoney(0));
            lblTienTra.setText(Format_Money.formatMoney(0));
        } else {
            for (ItemOrder item : listOrder) {
                tienSP = tienSP + item.getThanhTien();
            }

            lblTienSP.setText(Format_Money.formatMoney(tienSP));
            tienTra = tienSP - tienGiam / 100;
            lblTienTra.setText(Format_Money.formatMoney(tienTra));
        }
    }

    public void setForm(String name, DonHang dh, MainForm main) {
        main.showForm(this);
        if (name.contains("bàn")) {
            rdoAnTaiBan.setSelected(true);
            fillComboBoxSoBan("fillter");
            cboSoBan.setSelectedItem("Bàn số: " + dh.getSoBan());
        } else {
            rdoMangDi.setSelected(true);
            fillComboBoxSoBan("fillter");
            if (dh.getMaDonHang() == 0 && dh.getSoBan() == 0) {
                cboSoBan.setSelectedIndex(cboSoBan.getItemCount() - 1);
            } else {
                cboSoBan.setSelectedItem("Hóa đơn: " + dh.getMaDonHang());
            }
        }
    }

    private void printBillKitchen() {
        boolean checkPrint = true; // dùng dể xem coi in hóa đơn thành công hay không
        DonHang dh;
        if (rdoAnTaiBan.isSelected()) {
            dh = daoDH.selectBySoBan(cboSoBan.getSelectedItem().toString().replace("Bàn số: ", "").trim());
        } else {
            dh = daoDH.selectByID(cboSoBan.getSelectedItem().toString().replace("Hóa đơn: ", "").trim());
        }

        if (dh != null) {
            String gioGoiMon = this.header.getLblDate().getText() + " " + this.header.getLblTime().getText();
            try {
                checkPrint = PrintBill.printBillForKitchen(dh, gioGoiMon);
                if (checkPrint) {
                    ms.showNotify(this.header.getLblThongBao(), "Đã in hóa đơn cho bếp", MessageNotify.MessageType.SUCCESS);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void clearForm() {
        for (Component comp : pnlContainItemMenu.getComponents()) {
            comp.setVisible(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlBenTrai = new com.system.customSwing.Designed.MyPanel();
        pnlFooter = new com.system.customSwing.Designed.MyPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblTienSP = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtGiamGia = new com.system.customSwing.TextField_01.TextFieldSuggestion();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        lblTienTra = new javax.swing.JLabel();
        btnHuy = new com.system.customSwing.Designed.MyButton_02();
        btnThanhToan = new com.system.customSwing.Designed.MyButton_02();
        scroll = new javax.swing.JScrollPane();
        pnlContainItemMenu = new com.system.component.PanelContainItemMenu();
        scrollHeader = new javax.swing.JScrollPane();
        pnlChuaLoaiMonAn = new com.system.customSwing.Designed.MyPanel();
        pnlBenPhai = new com.system.customSwing.Designed.MyPanel();
        myPanel1 = new com.system.customSwing.Designed.MyPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rdoAnTaiBan = new com.system.customSwing.Designed.MyRadioButton();
        rdoMangDi = new com.system.customSwing.Designed.MyRadioButton();
        cboSoBan = new com.system.customSwing.Designed.MyComboBox();
        myPanel2 = new com.system.customSwing.Designed.MyPanel();
        btnInBillChoBep = new com.system.customSwing.Designed.MyButton_01();
        btnXuatHoaDOn = new com.system.customSwing.Designed.MyButton_01();
        btnXoaTatCa = new com.system.customSwing.Designed.MyButton_02();
        btnLuuHoaDon = new com.system.customSwing.Designed.MyButton_02();
        jSeparator2 = new javax.swing.JSeparator();
        myPanel3 = new com.system.customSwing.Designed.MyPanel();
        scroll2 = new javax.swing.JScrollPane();
        pnlContainOrder = new com.system.component.PanelContainItemMenu();

        pnlBenTrai.setBackground(new java.awt.Color(204, 0, 255));
        pnlBenTrai.setColorBackgound(new java.awt.Color(255, 255, 255));

        pnlFooter.setColorBackgound(new java.awt.Color(255, 255, 245));
        pnlFooter.setRoundBottomLeft(10);
        pnlFooter.setRoundBottomRight(10);
        pnlFooter.setRoundTopLeft(10);
        pnlFooter.setRoundTopRight(10);

        jPanel1.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Tổng tiền sản phẩm:");

        lblTienSP.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        lblTienSP.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTienSP.setText("1,000,000,000 VNĐ");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setText("Giảm giá:");

        txtGiamGia.setText("10%");
        txtGiamGia.setFont(new java.awt.Font("Arial", 0, 16)); // NOI18N
        txtGiamGia.setSelectionColor(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(83, 83, 83)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTienSP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtGiamGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTienSP, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jPanel2.setBackground(java.awt.Color.blue);
        jPanel2.setOpaque(false);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Tổng cộng:");

        lblTienTra.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        lblTienTra.setForeground(new java.awt.Color(255, 48, 48));
        lblTienTra.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTienTra.setText("1,000,000,000 VNĐ");

        btnHuy.setBackground(new java.awt.Color(255, 76, 76));
        btnHuy.setForeground(new java.awt.Color(51, 51, 51));
        btnHuy.setText("Hủy");
        btnHuy.setToolTipText("");
        btnHuy.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        btnThanhToan.setBackground(new java.awt.Color(8, 202, 63));
        btnThanhToan.setForeground(java.awt.Color.white);
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.setToolTipText("");
        btnThanhToan.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(1, 1, 1)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lblTienTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTienTra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        javax.swing.GroupLayout pnlFooterLayout = new javax.swing.GroupLayout(pnlFooter);
        pnlFooter.setLayout(pnlFooterLayout);
        pnlFooterLayout.setHorizontalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFooterLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(10, 10, 10)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlFooterLayout.setVerticalGroup(
            pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlFooterLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlFooterLayout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(pnlFooterLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlFooterLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2))
                    .addGroup(pnlFooterLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4))))
        );

        scroll.setBackground(new java.awt.Color(51, 51, 51));
        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setOpaque(false);

        pnlContainItemMenu.setBackground(new java.awt.Color(249, 249, 249));
        scroll.setViewportView(pnlContainItemMenu);

        scrollHeader.setBorder(null);
        scrollHeader.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollHeader.setOpaque(false);

        pnlChuaLoaiMonAn.setColorBackgound(new java.awt.Color(255, 255, 255));
        pnlChuaLoaiMonAn.setRoundBottomLeft(20);
        pnlChuaLoaiMonAn.setRoundBottomRight(20);
        pnlChuaLoaiMonAn.setRoundTopLeft(20);
        pnlChuaLoaiMonAn.setRoundTopRight(20);
        pnlChuaLoaiMonAn.setLayout(new java.awt.GridLayout(1, 0, 10, 5));
        scrollHeader.setViewportView(pnlChuaLoaiMonAn);

        javax.swing.GroupLayout pnlBenTraiLayout = new javax.swing.GroupLayout(pnlBenTrai);
        pnlBenTrai.setLayout(pnlBenTraiLayout);
        pnlBenTraiLayout.setHorizontalGroup(
            pnlBenTraiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBenTraiLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(pnlBenTraiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollHeader)
                    .addComponent(scroll, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlFooter, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlBenTraiLayout.setVerticalGroup(
            pnlBenTraiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBenTraiLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(scrollHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(scroll)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlFooter, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlBenPhai.setColorBackgound(new java.awt.Color(255, 255, 255));
        pnlBenPhai.setOpaque(true);

        myPanel1.setColorBackgound(new java.awt.Color(255, 255, 255));
        myPanel1.setRoundTopLeft(15);
        myPanel1.setRoundTopRight(15);

        jLabel7.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel7.setText("hh:mm  dd/mm/yyyy");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 20)); // NOI18N
        jLabel8.setText("Danh sách đặt món");

        buttonGroup1.add(rdoAnTaiBan);
        rdoAnTaiBan.setText("Ăn tại bàn");
        rdoAnTaiBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoAnTaiBanActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdoMangDi);
        rdoMangDi.setText("Mang đi");
        rdoMangDi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdoMangDiActionPerformed(evt);
            }
        });

        cboSoBan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Bàn số 01", "Bàn số 02", "Bàn số 03", "Bàn số 04", "Bàn số 05", "Bàn số 06", "Bàn số 07", "Bàn số 08", "Bàn số 09", "Bàn số 10" }));
        cboSoBan.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cboSoBan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboSoBanItemStateChanged(evt);
            }
        });
        cboSoBan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboSoBanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout myPanel1Layout = new javax.swing.GroupLayout(myPanel1);
        myPanel1.setLayout(myPanel1Layout);
        myPanel1Layout.setHorizontalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(3, 3, 3)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addComponent(rdoAnTaiBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(1, 1, 1)
                        .addComponent(rdoMangDi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(cboSoBan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(17, 17, 17)))
                .addGap(2, 2, 2))
        );
        myPanel1Layout.setVerticalGroup(
            myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel1Layout.createSequentialGroup()
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdoAnTaiBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rdoMangDi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(myPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(myPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboSoBan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        myPanel2.setColorBackgound(new java.awt.Color(255, 255, 255));
        myPanel2.setRoundBottomLeft(20);
        myPanel2.setRoundBottomRight(20);
        myPanel2.setRoundTopLeft(20);
        myPanel2.setRoundTopRight(20);

        btnInBillChoBep.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/icon/billCooker.png"))); // NOI18N
        btnInBillChoBep.setText("In bill cho bếp");
        btnInBillChoBep.setBorderColor(new java.awt.Color(51, 51, 51));
        btnInBillChoBep.setColorClick(new java.awt.Color(204, 204, 204));
        btnInBillChoBep.setColorOver(new java.awt.Color(231, 231, 231));
        btnInBillChoBep.setFocusable(false);
        btnInBillChoBep.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnInBillChoBep.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInBillChoBep.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInBillChoBep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInBillChoBepActionPerformed(evt);
            }
        });

        btnXuatHoaDOn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/icon/print.png"))); // NOI18N
        btnXuatHoaDOn.setText("Xuất hóa đơn");
        btnXuatHoaDOn.setBorderColor(new java.awt.Color(51, 51, 51));
        btnXuatHoaDOn.setColorClick(new java.awt.Color(204, 204, 204));
        btnXuatHoaDOn.setColorOver(new java.awt.Color(231, 231, 231));
        btnXuatHoaDOn.setFocusable(false);
        btnXuatHoaDOn.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        btnXuatHoaDOn.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnXuatHoaDOn.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        btnXoaTatCa.setBackground(new java.awt.Color(231, 231, 231));
        btnXoaTatCa.setForeground(new java.awt.Color(51, 51, 51));
        btnXoaTatCa.setText(" Xóa tất cả món");
        btnXoaTatCa.setToolTipText("");
        btnXoaTatCa.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnXoaTatCa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTatCaActionPerformed(evt);
            }
        });

        btnLuuHoaDon.setBackground(new java.awt.Color(81, 151, 255));
        btnLuuHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnLuuHoaDon.setText("Lưu hóa đơn");
        btnLuuHoaDon.setToolTipText("");
        btnLuuHoaDon.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnLuuHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuHoaDonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout myPanel2Layout = new javax.swing.GroupLayout(myPanel2);
        myPanel2.setLayout(myPanel2Layout);
        myPanel2Layout.setHorizontalGroup(
            myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnXoaTatCa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(33, 33, 33)
                .addComponent(btnLuuHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(myPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jSeparator2)
                .addGap(30, 30, 30))
            .addGroup(myPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnInBillChoBep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(56, 56, 56)
                .addComponent(btnXuatHoaDOn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18))
        );
        myPanel2Layout.setVerticalGroup(
            myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnInBillChoBep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXuatHoaDOn, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(myPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnXoaTatCa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLuuHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        scroll2.setBorder(null);
        scroll2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll2.setOpaque(false);

        javax.swing.GroupLayout pnlContainOrderLayout = new javax.swing.GroupLayout(pnlContainOrder);
        pnlContainOrder.setLayout(pnlContainOrderLayout);
        pnlContainOrderLayout.setHorizontalGroup(
            pnlContainOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 368, Short.MAX_VALUE)
        );
        pnlContainOrderLayout.setVerticalGroup(
            pnlContainOrderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 324, Short.MAX_VALUE)
        );

        scroll2.setViewportView(pnlContainOrder);

        javax.swing.GroupLayout myPanel3Layout = new javax.swing.GroupLayout(myPanel3);
        myPanel3.setLayout(myPanel3Layout);
        myPanel3Layout.setHorizontalGroup(
            myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll2)
        );
        myPanel3Layout.setVerticalGroup(
            myPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(scroll2)
        );

        javax.swing.GroupLayout pnlBenPhaiLayout = new javax.swing.GroupLayout(pnlBenPhai);
        pnlBenPhai.setLayout(pnlBenPhaiLayout);
        pnlBenPhaiLayout.setHorizontalGroup(
            pnlBenPhaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBenPhaiLayout.createSequentialGroup()
                .addComponent(myPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(2, 2, 2))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBenPhaiLayout.createSequentialGroup()
                .addComponent(myPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlBenPhaiLayout.createSequentialGroup()
                .addComponent(myPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(3, 3, 3))
        );
        pnlBenPhaiLayout.setVerticalGroup(
            pnlBenPhaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlBenPhaiLayout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(myPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(myPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(myPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlBenTrai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlBenPhai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlBenTrai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(pnlBenPhai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void rdoAnTaiBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoAnTaiBanActionPerformed
        fillComboBoxSoBan("fillter");
    }//GEN-LAST:event_rdoAnTaiBanActionPerformed

    private void rdoMangDiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdoMangDiActionPerformed
        fillComboBoxSoBan("fillter");
    }//GEN-LAST:event_rdoMangDiActionPerformed

    private void cboSoBanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboSoBanItemStateChanged

    }//GEN-LAST:event_cboSoBanItemStateChanged

    private void cboSoBanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboSoBanActionPerformed
        itemChangeComboBox();
    }//GEN-LAST:event_cboSoBanActionPerformed

    private void btnXoaTatCaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTatCaActionPerformed

    }//GEN-LAST:event_btnXoaTatCaActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        fillComboBoxSoBan("fillter");
        itemChangeComboBox();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void btnInBillChoBepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInBillChoBepActionPerformed
        printBillKitchen();
    }//GEN-LAST:event_btnInBillChoBepActionPerformed

    private void btnLuuHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnLuuHoaDonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.system.customSwing.Designed.MyButton_02 btnHuy;
    private com.system.customSwing.Designed.MyButton_01 btnInBillChoBep;
    private com.system.customSwing.Designed.MyButton_02 btnLuuHoaDon;
    private com.system.customSwing.Designed.MyButton_02 btnThanhToan;
    private com.system.customSwing.Designed.MyButton_02 btnXoaTatCa;
    private com.system.customSwing.Designed.MyButton_01 btnXuatHoaDOn;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.system.customSwing.Designed.MyComboBox cboSoBan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lblTienSP;
    private javax.swing.JLabel lblTienTra;
    private com.system.customSwing.Designed.MyPanel myPanel1;
    private com.system.customSwing.Designed.MyPanel myPanel2;
    private com.system.customSwing.Designed.MyPanel myPanel3;
    private com.system.customSwing.Designed.MyPanel pnlBenPhai;
    private com.system.customSwing.Designed.MyPanel pnlBenTrai;
    private com.system.customSwing.Designed.MyPanel pnlChuaLoaiMonAn;
    private com.system.component.PanelContainItemMenu pnlContainItemMenu;
    private com.system.component.PanelContainItemMenu pnlContainOrder;
    private com.system.customSwing.Designed.MyPanel pnlFooter;
    private com.system.customSwing.Designed.MyRadioButton rdoAnTaiBan;
    private com.system.customSwing.Designed.MyRadioButton rdoMangDi;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JScrollPane scroll2;
    private javax.swing.JScrollPane scrollHeader;
    private com.system.customSwing.TextField_01.TextFieldSuggestion txtGiamGia;
    // End of variables declaration//GEN-END:variables
}
