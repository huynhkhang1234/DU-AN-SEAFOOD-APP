/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.method;

import java.awt.Color;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author HP
 */
public class MessageNotify {
    private final Icon iconNormal = new ImageIcon(getClass().getResource("/com/system/icon/dotNormal.png"));
    private final Icon iconSuccess = new ImageIcon(getClass().getResource("/com/system/icon/dotSuccess.png"));
    private final Icon iconError = new ImageIcon(getClass().getResource("/com/system/icon/dotError.png"));
    
    public void showNotify(JLabel lbl, String content, MessageType mt) { // này dùng để bắt thông báo là gì thành công, thất bại hay là bình thường nà
        lbl.setText(content);
        if (mt == mt.SUCCESS) {
            // Nếu cái message nó có chứa chữ "thành công" hoặc "success" hoặc nó là chữ "1"
            // Thì nó sẽ set màu chữ nè, rồi set Icon khác, cụ thể là IconSucess
            lbl.setForeground(new Color(102,255,102));
            lbl.setIcon(iconSuccess);
        } else if (mt == mt.ERROR) {
            // Nếu cái message nó có chứa chữ "lỗi" hoặc "error" hoặc nó là chữ "2"
            // Thì nó sẽ set màu chữ nè, rồi set Icon khác, cụ thể là IconError
            lbl.setForeground(new Color(201,35,7));
            lbl.setIcon(iconError);
        } else {
            lbl.setForeground(new Color(153, 153, 153));
            lbl.setIcon(iconNormal);
        }
    } 
    
    public void showNotifyDefault(JLabel lbl) {
        lbl.setText("Trạng thái");
        lbl.setForeground(new Color(153, 153, 153));
        lbl.setIcon(iconNormal);
    }
    
    public static enum MessageType {
        SUCCESS, ERROR, DEFAULT;
    }
}
