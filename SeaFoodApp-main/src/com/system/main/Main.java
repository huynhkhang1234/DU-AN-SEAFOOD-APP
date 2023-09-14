/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.main;

import com.system.DAO.DonHangDAO;
import com.system.component.Header;
import com.system.component.Menu;
import com.system.customSwing.ShowNotify.PanelLoading;
import com.system.form.MainForm;
import com.system.form.QuanLyDatBan;
import com.system.form.QuanLyDatMon;
import com.system.form.QuanLyHoaDon;
import com.system.form.QuanLiNhanSu;
import com.system.form.QuanLyThongKe;
import com.system.form.QuanLyThucDon;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLayeredPane;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import com.system.event.EventMenu;
import com.system.form.QuanLyTaiKhoan;
import com.system.model.code.DonHang;
import com.system.utils.Auth;
import com.system.utils.NotifycationConfirm;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class Main extends javax.swing.JFrame {

    private MigLayout layout;
    private Menu menu;
    private Header header;
    private MainForm main;
    private Animator animator;

    private PanelLoading pnlLoading;
    private QuanLyHoaDon qlhd;
    private QuanLyDatMon qldm;
    private QuanLyDatBan qldb;
    private QuanLiNhanSu qlns;
    private QuanLyTaiKhoan qltk;
    private QuanLyThucDon qltd;
    private QuanLyThongKe thongKe;

    private DonHangDAO daoDH;

    public Header getHeader() {
        return header;
    }

    public Main() {
        initComponents();
        init();

    }

    private void init() {
        this.setLocationRelativeTo(null);
        repaint();
        //setBackground(new Color(0, 0, 0, 0));
        menu = new Menu();
        header = new Header();
        main = new MainForm();
        pnlLoading = new PanelLoading();
        layout = new MigLayout("fill", "0[]0[100%, fill]0", "0[fill, top]0");
        background.setLayout(layout);
        background.setLayer(pnlLoading, JLayeredPane.POPUP_LAYER);

        qlhd = new QuanLyHoaDon();
        qldm = new QuanLyDatMon(this.header);
        qldb = new QuanLyDatBan();
        qlns = new QuanLiNhanSu(this.header);
        qltk = new QuanLyTaiKhoan(this.header);
        qltd = new QuanLyThucDon();
        qltd = new QuanLyThucDon();
        thongKe = new QuanLyThongKe();

        daoDH = new DonHangDAO();

        // Phân bố vị trí cho ba cái panel
        background.add(menu, "w 230!, spany 2"); // Span y = 2 cell
        background.add(header, "h 50!, wrap");
        background.add(main, "w 100%, h 100%");
        background.add(pnlLoading, "pos 0 0 100% 100%");
        header.getLblUser().setText(Auth.tenNhanVien);

        menu.addEventMenu(new EventMenu() {
            @Override
            public void menuIndexChange(int index) {
                if (index == 0) {
                    main.showForm(qlhd);
                } else if (index == 1) {
                    main.showForm(qldm);
                } else if (index == 2) {
                    main.showForm(qldb);
                } else if (index == 3) {
                    main.showForm(qlns);
                } else if (index == 4) {
                    main.showForm(qltk);
                } else if (index == 5) {
                    main.showForm(qltd);
                } else if (index == 6) {
                    main.showForm(thongKe);
                } else if (index == 7) {
                    openLoading();
                } else if (index == 8) {
                    System.exit(0);
                }
            }
        });

        // Đây là chỗ mà làm đóng mở menu nè
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width; // 60 là tương ứng cho việc chừa bao nhiêu px khi đóng vào 
                if (menu.isShowMenu()) {
                    width = 59 + (170 * (1f - fraction));
                    menu.getPnl().setAlignmentX(menu.getPnl().getAlignmentX() - 20);
                } else {
                    width = 60 + (170 * (fraction));
                    menu.getPnl().setAlignmentX(menu.getPnl().getAlignmentX() + 20);
                }
                layout.setComponentConstraints(menu, "w " + width + "!, spany 2");
                menu.revalidate();
            }

            @Override
            public void end() {
                menu.setShowMenu(!menu.isShowMenu());
            }

        };
        animator = new Animator(500, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
        animator.setAcceleration(0.5f);
        header.addMenuEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!animator.isRunning()) {
                    animator.start();
                }
            }
        });

        // để cho hiện form đầu tiên ra
        main.showForm(qldm);
        // sử lí sự kiện thêm sưa xóa from này đến from liên quan
        // addEventForQLNS();
        addEventForQLHD();
        addEventForQLDM();
        addEventForQLDB();
        addEventForQLTD();
        // add sự kiện thêm tài khoản tự động 
        addEventForQLNS();
        DeleteEventForQLNS();
        UpdateEventForQLNS();
    }

    public void addEventForQLDM() {
        qldm.addEvent("xóa tất cả", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NotifycationConfirm.confirmDelete(background, "Xóa thông tin !!!", "Bạn có chắc chắn muốn xóa tất cả không ?", new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        qldm.deleteAllOrder();
                        NotifycationConfirm.close("confirm");
                    }
                });
            }

        });

        qldm.addEvent("lưu hóa đơn", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (qldm.getTblModel().getRowCount() != 0) {
                    DefaultTableModel tblModel = qldm.getTblModel();
                    NotifycationConfirm.confirmAddItemOrder(background, tblModel, "Xác nhận gọi món", "Bạn có chắc chắn muốn lưu hóa đơn không?", new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            qldm.saveBill(header);
                            NotifycationConfirm.close("order");
                            qlhd.addDataToList(background, header, qldm, qldb, thongKe, main, pnlLoading);
                        }
                    });
                } else {
                    qldm.saveBill(header);
                    qlhd.addDataToList(background, header, qldm, qldb, thongKe, main, pnlLoading);
                }
            }

        });
    }

    // các sự kiện khi click chuột vào thêm tài khoản tự động
    public void addEventForQLNS() {
        qlns.addEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    qlns.insert();
                    // qlns.clear();
                    qltk.fillTableTK();
                } catch (ParseException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public void DeleteEventForQLNS() {
        qlns.DeleteEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                qlns.delete();
                qlns.clear();
                qltk.fillTableTK();
            }
        });
    }

    public void UpdateEventForQLNS() {
        qlns.UpdateEvent(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                qlns.update(Main.this);
                // qlns.clear();
                qltk.fillTableTK();
            }
        });
    }

    private void addEventForQLHD() {

        qlhd.addDataToList(background, header, qldm, qldb, thongKe, main, pnlLoading);

        qlhd.addEventTaoHD(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DonHang dh = new DonHang();
                dh.setMaNhanVien(Auth.user.getMaNhanVien());
//                dh.setMaKhachHang();
                dh.setSoBan(0);
                dh.setTongTienThanhToan(0);
                daoDH.insert(dh);
                qldm.setForm("hóa đơn", dh, main);
                qldb.fillTable();
            }
        });

    }

    private void addEventForQLDB() {
        qldb.addEvent("thêm", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    qldb.insert();
                    qlhd.addDataToList(background, header, qldm, qldb, thongKe, main, pnlLoading);
                    qldm.setDefault();
                } catch (ParseException ex) {
                    Logger.getLogger(QuanLyDatBan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        qldb.addEvent("sửa", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    qldb.update();
                    qlhd.addDataToList(background, header, qldm, qldb, thongKe, main, pnlLoading);
                } catch (ParseException ex) {
                    Logger.getLogger(QuanLyDatBan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        qldb.addEvent("xóa", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                qldb.delete();
                qlhd.addDataToList(background, header, qldm, qldb, thongKe, main, pnlLoading);
            }
        });

    }

    private void addEventForQLTD() {
        qltd.addEvent("thêm", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                qltd.addMA();
                qldm.clearForm();
                qldm.fillTable("ăn");
                qldm.fillTable("uống");
            }
        });

        qltd.addEvent("sửa", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                qltd.updateMA();
                qldm.clearForm();
                qldm.fillTable("ăn");
                qldm.fillTable("uống");
            }
        });

        qltd.addEvent("xóa", new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                qltd.deleteMA();
                qldm.clearForm();
                qldm.fillTable("ăn");
                qldm.fillTable("uống");
            }
        });
    }

    private void addColumn(DefaultTableModel model, String... nameColumn) {
        model.setColumnCount(0);
        for (int i = 0; i < nameColumn.length; i++) {
            model.addColumn(nameColumn[i]);
        }
    }

    public void openLoading() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    pnlLoading.setVisible(true);
                    new DangNhap().setVisible(true);
                    // bắt đầu dùng sau 1.5 giây
                    Thread.sleep(1000);
                    pnlLoading.setVisible(false);
                    // hàn để đóng fram chính main.
                    Dispose();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }).start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JLayeredPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 650, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(255, 255, 255));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        g2.dispose();
        super.paint(g);
    }

    private void Dispose() {
        this.dispose();
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLayeredPane background;
    // End of variables declaration//GEN-END:variables
}
