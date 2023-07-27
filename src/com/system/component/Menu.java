/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.component;

import com.system.event.EventMenuCallBack;
import com.system.main.UI.Split;
import com.system.model.UI.ModelMenu;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Path2D;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import net.miginfocom.swing.MigLayout;
import com.system.event.EventMenuSelected;
import com.system.event.EventMenu;
import com.system.main.UI.ListMenu;

/**
 *
 * @author HP
 */
public class Menu extends javax.swing.JPanel {

    public void addEventMenu(EventMenu event) {
        this.event = event;
    }

    private final MigLayout layout;
    private boolean showMenu = true;

    private int selectedIndex = -1;
    private final Timer timer;
    private boolean toUp; // for animation is go up
    private int menuYTarget;
    int menuY;
    private int speed = 2;
    private EventMenuCallBack callBack;
    private EventMenu event;

    public boolean isShowMenu() {
        return showMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }

    public JPanel getPnl() {
        return pnl;
    }

    public Menu() {
        initComponents();
        setOpaque(false);
        listMenu.setOpaque(false);

        layout = new MigLayout("wrap, fillx, insets 0", "[fill]"); //"wrap, fillx, insets 0", "[fill]", "[]0[]"
//        pnl.setLayout(layout);

        // Này là chỉnh các hiệu ứng dành cho viêc Click vào các chức năng 
        listMenu.addEventSelectedMemu(new EventMenuSelected() {
            @Override
            public void menuSelected(int index, EventMenuCallBack callBack) {
                if (index != selectedIndex) {
                    Menu.this.callBack = callBack;
                    toUp = selectedIndex > index;
                    if (selectedIndex == -1) {
                        speed = 20;
                    } else {
                        speed = selectedIndex - index;
                        if (speed < 0) {
                            speed *= -1;
                            // Nếu giá trị của speed mà < 0 thì thay đổi nó thành dương VD: -1 -> 1
                        }
                    }
                    speed++; // tăng thêm speed
                    selectedIndex = index;
                    menuYTarget = selectedIndex * 45 + pnl.getY(); // menuYTarget is locaiton y
                    if (!timer.isRunning()) {
                        timer.start();
                    }
                }
            }
        });

        // Này là các hình di chuyển, hiệu ứng của các Item trong menu
        timer = new Timer(0, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (toUp) {
                    if (menuY <= menuYTarget - 5) {
                        menuY = menuYTarget;
                        repaint();
                        timer.stop();
                        callBack.call(selectedIndex);
                        if (event != null) {
                            event.menuIndexChange(selectedIndex);
                        }
                    } else {
                        menuY -= speed;
                        repaint();
                    }
                } else {
                    if (menuY >= menuYTarget + 5) { // thêm style
                        menuY = menuYTarget;
                        repaint();
                        timer.stop();
                        callBack.call(selectedIndex);
                        if (event != null) {
                            event.menuIndexChange(selectedIndex);
                        }
                    } else {
                        menuY += speed;
                        repaint();
                    }
                }
            }
        });
        initData();
    }

    private void initData() {
        listMenu.addItem(new ModelMenu("bill", "Danh sách Đơn hàng", ModelMenu.MenuType.MENU));
        listMenu.addItem(new ModelMenu("order", "Đặt món ", ModelMenu.MenuType.MENU));
        listMenu.addItem(new ModelMenu("table", "Danh sách Đặt bàn", ModelMenu.MenuType.MENU));
        listMenu.addItem(new ModelMenu("staff", "Quản lý Nhân sự", ModelMenu.MenuType.MENU));
        listMenu.addItem(new ModelMenu("account", "Quản lý Tài khoản", ModelMenu.MenuType.MENU));
        listMenu.addItem(new ModelMenu("menu", "Quản lý Menu", ModelMenu.MenuType.MENU));
        listMenu.addItem(new ModelMenu("chart", "Thống kê doanh thu", ModelMenu.MenuType.MENU));
        listMenu.addItem(new ModelMenu("logOut", "Đăng xuất", ModelMenu.MenuType.MENU));
        listMenu.addItem(new ModelMenu("close", "Thoát chương trình", ModelMenu.MenuType.MENU));
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        profile1 = new com.system.component.Profile();
        pnl = new javax.swing.JPanel();
        listMenu = new com.system.main.UI.ListMenu<>();

        setOpaque(false);

        pnl.setOpaque(false);

        javax.swing.GroupLayout pnlLayout = new javax.swing.GroupLayout(pnl);
        pnl.setLayout(pnlLayout);
        pnlLayout.setHorizontalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(listMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnlLayout.setVerticalGroup(
            pnlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(listMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(profile1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnl, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(profile1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//        GradientPaint gra = new GradientPaint(0, 0, Color.decode("#a8c0ff"), 0, getHeight(), Color.decode("#3f2b96"));
        GradientPaint gra = new GradientPaint(0, 0, new Color(230, 187, 106), getWidth(), 0, new Color(81, 151, 255));
        g2.setPaint(gra);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 40, 40);
        if (selectedIndex >= 0) {
            int menuX = 5;
            int height = 45;
            int width = getWidth();
            g2.setColor(new Color(234, 241, 248));
            g2.fillRoundRect(menuX, menuY, width, height, 35, 35);
            Path2D.Float f = new Path2D.Float();
            f.moveTo(width - 30, menuY);
            f.curveTo(width - 10, menuY, width, menuY, width, menuY - 45);
            f.lineTo(width, menuY + height + 30);
            f.curveTo(width, menuY + height, width - 10, menuY + height, width - 30, menuY + height);

            g2.fill(f);
        }
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
    }
    
    private void split(String name) {
        pnl.add(new Split(name), "h 30");
    }

    private void space() {
        pnl.add(new JLabel(), "push");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.system.main.UI.ListMenu<String> listMenu;
    private javax.swing.JPanel pnl;
    private com.system.component.Profile profile1;
    // End of variables declaration//GEN-END:variables
}
