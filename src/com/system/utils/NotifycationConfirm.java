
package com.system.utils;

import com.system.component.PanelAddItem;
import com.system.component.PanelCofirm;
import java.awt.event.ActionListener;
import javax.swing.JLayeredPane;
import javax.swing.table.DefaultTableModel;

public class NotifycationConfirm {
    
    private static PanelCofirm pnlConfirm;
    private static PanelAddItem pnlConfirmOder;
    
    public static void confirmDelete(JLayeredPane containPanel, String title, String content, ActionListener event) {
        pnlConfirm = new PanelCofirm(title, content);
        containPanel.setLayer(pnlConfirm, JLayeredPane.POPUP_LAYER);
        containPanel.add(pnlConfirm, "pos 0 0 100% 100%");
        pnlConfirm.setVisible(true);
        pnlConfirm.addEventButtonOK(event);
    }
    
    public static void confirmAddItemOrder(JLayeredPane containPanel, DefaultTableModel model, String nameNotify, String content, ActionListener event) {
        pnlConfirmOder = new PanelAddItem(model, nameNotify, content);
        containPanel.setLayer(pnlConfirmOder, JLayeredPane.POPUP_LAYER);
        containPanel.add(pnlConfirmOder, "pos 0 0 100% 100%");
        pnlConfirmOder.setVisible(true);
        pnlConfirmOder.addEventButtonOK(event);
    }
    
    public static void close(String namePnl) {
        if (namePnl.contains("order")) {
            pnlConfirmOder.setVisible(false);
        } else {
            pnlConfirm.setVisible(false);
        }
    }
}
