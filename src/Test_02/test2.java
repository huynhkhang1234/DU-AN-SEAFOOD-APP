/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_02;

import com.system.DAO.DatBanDAO;
import com.system.model.code.DatBan;
import com.system.utils.FormatMoney;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class test2 extends javax.swing.JFrame {

    private DefaultTableModel tblModel;
    private DatBanDAO daoDB;

    public test2() {
        initComponents();
        this.setLocationRelativeTo(null);
        daoDB = new DatBanDAO();
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
        tblModel.setRowCount(0);
        try {
            List<DatBan> list = daoDB.selectAll();// lưu cái cở sở dự liệu về ái list mà ở trong nhân viên
            if (list != null) {
                for (DatBan entity : list) {
                    tblModel.addRow(new Object[]{
                        entity.getMaKhachHang(), entity.getTenKhachHang(), entity.getSoDienThoai(), entity.getSoBan(),
                        entity.getNgayDen(), entity.getThoiGian(), FormatMoney.formatMoney(entity.getTienCoc()), entity.getGhiChu(), entity.isTinhTrang()});
                }
            }

            tbl.setModel(tblModel);
        } catch (Exception e) {
            e.printStackTrace();
        }
        setIDAuto("KH", tbl);
    }

    public void setIDAuto(String name, JTable tbl) {
        List<Integer> listSo = new ArrayList<>();
        for (int i = 0; i < tbl.getRowCount(); i++) {
            if (tbl.getValueAt(i, 0).toString().contains(name)) {
                int so = Integer.parseInt(tbl.getValueAt(i, 0).toString().replace(name, "").trim());
                listSo.add(so);
            }
        }

        for (int i = 1; i <= tbl.getRowCount(); i++) {
            for (Integer so : listSo) {
                if (i != so) {
                    txtma.setText(name + "00" + i);
                    if (i > 9) {
                        txtma.setText(name + "0" + i);
                    }

                }
            }
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbl = new javax.swing.JTable();
        txtma = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl);

        txtma.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(131, 131, 131)
                .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(test2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(test2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(test2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(test2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new test2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl;
    private javax.swing.JLabel txtma;
    // End of variables declaration//GEN-END:variables
}
