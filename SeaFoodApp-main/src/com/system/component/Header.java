
package com.system.component;

import com.system.customSwing.Designed.MyImageAvatar;
import com.system.utils.Clock;
import com.system.utils.XDate;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Header extends JPanel {

    public MyImageAvatar getLblAvatarMain() {
        return lblAvatarMain;
    }

    public void setLblAvatarMain(MyImageAvatar lblAvatarMain) {
        this.lblAvatarMain = lblAvatarMain;
    }

    public JLabel getLblThongBao() {
        return lblThongBao;
    }

    public Header() {
        initComponents();
        
//         khởi động đồng hồ chạy
          Clock time = new Clock(lblTime);
          time.start();
//         ngày hiện thị
          XDate date = new XDate(lblDate);
          date.start();
    }
    
    public void addMenuEvent(ActionListener event) {
        btnCOMenu.addActionListener(event);
    }

    public JLabel getLblDate() {
        return lblDate;
    }

    public JLabel getLblRole() {
        return lblRole;
    }

    public JLabel getLblTime() {
        return lblTime;
    }

    public JLabel getLblUser() {
        return lblUser;
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCOMenu = new com.system.customSwing.Designed.Button();
        lblAvatarMain = new com.system.customSwing.Designed.MyImageAvatar();
        lblUser = new javax.swing.JLabel();
        lblRole = new javax.swing.JLabel();
        lblThongBao = new javax.swing.JLabel();
        lblDate = new javax.swing.JLabel();
        lblTime = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        btnCOMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/icon/menu.png"))); // NOI18N

        lblAvatarMain.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/icon/avatar.jpg"))); // NOI18N

        lblUser.setForeground(new java.awt.Color(51, 51, 51));
        lblUser.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblUser.setText("Pi Nguyễn");

        lblRole.setForeground(new java.awt.Color(127, 127, 127));
        lblRole.setText("Admin");

        lblThongBao.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblThongBao.setForeground(new java.awt.Color(153, 153, 153));
        lblThongBao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/system/icon/dotSuccess.png"))); // NOI18N
        lblThongBao.setText("Trạng thái");

        lblDate.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblDate.setForeground(new java.awt.Color(51, 51, 51));
        lblDate.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblDate.setText("dd-mm-yyyy");

        lblTime.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        lblTime.setForeground(new java.awt.Color(51, 51, 51));
        lblTime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblTime.setText("hh:mm:ss");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCOMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lblThongBao, javax.swing.GroupLayout.DEFAULT_SIZE, 129, Short.MAX_VALUE)
                .addGap(169, 169, 169)
                .addComponent(lblTime, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblUser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRole))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblAvatarMain, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCOMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblUser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblRole))
                    .addComponent(lblAvatarMain, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblThongBao, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblTime, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(5, 5, 5))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.system.customSwing.Designed.Button btnCOMenu;
    private com.system.customSwing.Designed.MyImageAvatar lblAvatarMain;
    private javax.swing.JLabel lblDate;
    private javax.swing.JLabel lblRole;
    private javax.swing.JLabel lblThongBao;
    private javax.swing.JLabel lblTime;
    private javax.swing.JLabel lblUser;
    // End of variables declaration//GEN-END:variables
}
