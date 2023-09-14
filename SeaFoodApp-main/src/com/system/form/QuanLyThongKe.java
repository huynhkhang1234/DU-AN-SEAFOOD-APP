/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.form;

import com.system.DAO.ThongKeDAO;
import com.system.component.CardItemStatistic;
import com.system.customSwing.Chart.ModelChart;
import com.system.customSwing.Chart.ModelChartPie;
import com.system.model.UI.ModelItemCardStatistic;
import java.awt.Color;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class QuanLyThongKe extends javax.swing.JPanel {

    private List<Integer> listMonth = new ArrayList<>();
    private List<String> list = new ArrayList<>();
//    private List<Object> listTK = new ArrayList<>();

    private ThongKeDAO daoTK = new ThongKeDAO();
    private DefaultTableModel tblModel = new DefaultTableModel();

    public QuanLyThongKe() {
        initComponents();
        setOpaque(false);
        for (int i = 1; i <= 12; i++) {
            listMonth.add(i);
        }

        LineChart.addLegend("Doanh thu", new Color(12, 84, 175), new Color(0, 108, 247));
        LineChart.addLegend("HĐ mang đi", new Color(54, 4, 143), new Color(104, 49, 200));
        LineChart.addLegend("HĐ ăn tại bàn", new Color(5, 125, 0), new Color(95, 209, 69));
        LineChart.addLegend("Chi phí khác", new Color(186, 37, 37), new Color(241, 100, 120));
        init();
    }

    public void init() {
        setDataChartPie();
        itemChangeBox();
    }

    // Hàm này dùng để set dữ liệu cho các card thống kê ở trên
    public void setDataCardStatistic(int thang, int nam) {
        List<Object[]> tienMangDi = daoTK.getTongTienMangDi(thang, nam);
        List<Object[]> tienAnTaiBan = daoTK.getTongTienTaiBan(thang, nam);

        Object[] a = tienAnTaiBan.get(0);
        Object[] b = tienMangDi.get(0);

        int soLuongMD = Integer.parseInt(b[0].toString());
        double tongTienMD = Double.parseDouble(b[1].toString());

        int soLuongTB = Integer.parseInt(a[0].toString());
        double tongTienTB = Double.parseDouble(a[1].toString());

        this.clearCard();

        themThongKe(new ModelItemCardStatistic("Doanh thu", tongTienMD + tongTienTB - 2000000, 156, "Tháng trước", null, new Color(40, 199, 213), new Color(76, 132, 254)));
        themThongKe(new ModelItemCardStatistic("Hóa đơn tại bàn", tongTienTB, soLuongTB, "Tháng trước", null, new Color(247, 131, 236), new Color(117, 124, 254)));
        themThongKe(new ModelItemCardStatistic("Hóa đơn mang đi", tongTienMD, soLuongMD, "Tháng trước", null, new Color(66, 237, 171), new Color(10, 177, 231)));
        themThongKe(new ModelItemCardStatistic("Chi phí khác", 2000000, 15, "Tháng trước", null, new Color(255, 151, 140), new Color(255, 109, 184)));
    }

    // Hàm này set dữ liệu cho các cột của biểu đồ 
    public void setDataChartLine(int thang, int nam) {
        LineChart.clear();
        list.clear();
        if (thang < 4) {
            nam -= 1;
            for (int i = thang; i > 0; i--) {
                list.add(i + "/" + (nam + 1));
            }

            for (int i = 12; i > 0; i--) {
                if (i == 12 - list.size()) {
                    break;
                }
                list.add(i + "/" + nam);
            }
        } else {
            for (int i = thang; i > 0; i--) {
                if (i == thang - 4) {
                    break;
                }
                list.add(i + "/" + nam);
            }
        }

        for (int i = 3; i >= 0; i--) {
            int year = Integer.parseInt(list.get(i).substring(list.get(i).indexOf("/")).replace("/", ""));
            int month = Integer.parseInt(list.get(i).substring(0, list.get(i).indexOf("/")));

            List<Object[]> tienMangDi = daoTK.getTongTienMangDi(month, year);
            List<Object[]> tienAnTaiBan = daoTK.getTongTienTaiBan(month, year);

            Object[] a = tienAnTaiBan.get(0);
            Object[] b = tienMangDi.get(0);
            int soLuongMD = Integer.parseInt(b[0].toString());
            double tongTienMD = Double.parseDouble(b[1].toString());

            int soLuongTB = Integer.parseInt(a[0].toString());
            double tongTienTB = Double.parseDouble(a[1].toString());

            LineChart.addData(new ModelChart(list.get(i), new double[]{tongTienTB + tongTienMD - 150000, tongTienMD, tongTienTB, 150000}));
        }
        LineChart.start();
    }

    public void setDataChartPie() {
        List<ModelChartPie> list1 = new ArrayList<>();
        list1.add(new ModelChartPie("Monday", 10, new Color(4, 174, 243)));
        list1.add(new ModelChartPie("Tuesday", 150, new Color(215, 39, 250)));
        list1.add(new ModelChartPie("Wednesday", 80, new Color(44, 88, 236)));
        list1.add(new ModelChartPie("Thursday", 100, new Color(21, 202, 87)));
        list1.add(new ModelChartPie("Friday", 125, new Color(127, 63, 255)));
        list1.add(new ModelChartPie("Saturday", 80, new Color(238, 167, 35)));
        list1.add(new ModelChartPie("Sunday", 200, new Color(245, 79, 99)));
        chartPie.setModel(list1);
    }

    // Hàm để thêm các số lượng thống kê vào mainForm
    public void themThongKe(ModelItemCardStatistic data) {
        CardItemStatistic itemF = new CardItemStatistic();
        itemF.setData(data);

        pnlContainCard.add(itemF);
        pnlContainCard.repaint();
        pnlContainCard.revalidate();
    }

    private void itemChangeBox() {
        if (cboYear.getSelectedItem() != null && cboMonth.getSelectedItem() != null) {
            int thang = Integer.parseInt(cboMonth.getSelectedItem().toString().replace("Tháng", "").trim());
            int nam = Integer.parseInt(cboYear.getSelectedItem().toString().replace("Năm:", "").trim());

            setData(thang, nam);
        }
    }

    private void setData(int thang, int nam) {
        setDataChartLine(thang, nam);
        setDataCardStatistic(thang, nam);
        fillTable(thang, nam);
    }

    private void fillTable(int thang, int nam) {
        tblModel.setColumnCount(0);
        addColumn(tblModel, "STT", "Mã hóa đơn", "Mã nhân viên", "Mã khách hàng", "Ngày bán", "Số bàn", 
                  "Tên món ăn", "Số lượng", "Thành tiền", "Ghi chú");

        if (cboYear.getSelectedItem() != null && cboMonth.getSelectedItem() != null) {

            tblModel.setRowCount(0);
            List<Object[]> listTK = daoTK.getHoaDonChiTiet(thang, nam);
            for (Object[] row : listTK) {
                if(row[5].toString().equals("0"))
                    row[5] = "Mang đi";
                tblModel.addRow(row);
            }
            tblThongKe.getTbl().setModel(tblModel);
        }
    }

    private void addColumn(DefaultTableModel model, String... nameColumn) {
        model.setColumnCount(0);
        for (int i = 0; i < nameColumn.length; i++) {
            model.addColumn(nameColumn[i]);
        }
    }

    private void clearCard() {
        for (Component comp : pnlContainCard.getComponents()) {
            comp.setVisible(false);
        }
        pnlContainCard.removeAll();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        modelItemCardStatistic1 = new com.system.model.UI.ModelItemCardStatistic();
        pnlContainCard = new javax.swing.JPanel();
        myPanelShadow1 = new com.system.customSwing.Designed.MyPanelShadow();
        LineChart = new com.system.customSwing.Chart.LineChart();
        cboYear = new com.system.customSwing.Designed.MyComboBox();
        cboMonth = new com.system.customSwing.Designed.MyComboBox();
        myPanelShadow2 = new com.system.customSwing.Designed.MyPanelShadow();
        tblThongKe = new com.system.customSwing.Designed.MyTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        myPanelShadow3 = new com.system.customSwing.Designed.MyPanelShadow();
        chartPie = new com.system.customSwing.Chart.ChartPie();

        setBackground(new java.awt.Color(234, 241, 248));
        setOpaque(false);

        pnlContainCard.setOpaque(false);
        pnlContainCard.setLayout(new java.awt.GridLayout(1, 0, 20, 0));

        myPanelShadow1.setBackground(new java.awt.Color(255, 255, 255));

        cboYear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Năm: 2023", "Năm: 2022", "Năm: 2021", "Năm: 2020", "Năm: 2019", "Năm: 2018", " " }));
        cboYear.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        cboYear.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboYearItemStateChanged(evt);
            }
        });
        cboYear.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboYearMouseClicked(evt);
            }
        });

        cboMonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tháng 01", "Tháng 02", "Tháng 03", "Tháng 04", "Tháng 05", "Tháng 06", "Tháng 07", "Tháng 08", "Tháng 09", "Tháng 10", "Tháng 11", "Tháng 12", " " }));
        cboMonth.setFont(new java.awt.Font("SansSerif", 1, 13)); // NOI18N
        cboMonth.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboMonthItemStateChanged(evt);
            }
        });
        cboMonth.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cboMonthMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout myPanelShadow1Layout = new javax.swing.GroupLayout(myPanelShadow1);
        myPanelShadow1.setLayout(myPanelShadow1Layout);
        myPanelShadow1Layout.setHorizontalGroup(
            myPanelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(myPanelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(myPanelShadow1Layout.createSequentialGroup()
                        .addComponent(LineChart, javax.swing.GroupLayout.DEFAULT_SIZE, 717, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanelShadow1Layout.createSequentialGroup()
                        .addComponent(cboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cboYear, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))))
        );
        myPanelShadow1Layout.setVerticalGroup(
            myPanelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanelShadow1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(myPanelShadow1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LineChart, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        myPanelShadow2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(78, 134, 253));
        jLabel1.setText("Bảng thống kê");

        javax.swing.GroupLayout myPanelShadow2Layout = new javax.swing.GroupLayout(myPanelShadow2);
        myPanelShadow2.setLayout(myPanelShadow2Layout);
        myPanelShadow2Layout.setHorizontalGroup(
            myPanelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelShadow2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(myPanelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tblThongKe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanelShadow2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1012, Short.MAX_VALUE)))
                .addContainerGap())
        );
        myPanelShadow2Layout.setVerticalGroup(
            myPanelShadow2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, myPanelShadow2Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tblThongKe, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE)
                .addContainerGap())
        );

        myPanelShadow3.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout myPanelShadow3Layout = new javax.swing.GroupLayout(myPanelShadow3);
        myPanelShadow3.setLayout(myPanelShadow3Layout);
        myPanelShadow3Layout.setHorizontalGroup(
            myPanelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelShadow3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chartPie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        myPanelShadow3Layout.setVerticalGroup(
            myPanelShadow3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(myPanelShadow3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(chartPie, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(pnlContainCard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(15, 15, 15))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(myPanelShadow2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(myPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(2, 2, 2)
                        .addComponent(myPanelShadow3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlContainCard, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(myPanelShadow1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(myPanelShadow3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(myPanelShadow2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cboMonthMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboMonthMouseClicked

    }//GEN-LAST:event_cboMonthMouseClicked

    private void cboYearMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cboYearMouseClicked

    }//GEN-LAST:event_cboYearMouseClicked

    private void cboMonthItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboMonthItemStateChanged
        itemChangeBox();
    }//GEN-LAST:event_cboMonthItemStateChanged

    private void cboYearItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboYearItemStateChanged
        itemChangeBox();
    }//GEN-LAST:event_cboYearItemStateChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.system.customSwing.Chart.LineChart LineChart;
    private com.system.customSwing.Designed.MyComboBox cboMonth;
    private com.system.customSwing.Designed.MyComboBox cboYear;
    private com.system.customSwing.Chart.ChartPie chartPie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private com.system.model.UI.ModelItemCardStatistic modelItemCardStatistic1;
    private com.system.customSwing.Designed.MyPanelShadow myPanelShadow1;
    private com.system.customSwing.Designed.MyPanelShadow myPanelShadow2;
    private com.system.customSwing.Designed.MyPanelShadow myPanelShadow3;
    private javax.swing.JPanel pnlContainCard;
    private com.system.customSwing.Designed.MyTable tblThongKe;
    // End of variables declaration//GEN-END:variables

}
