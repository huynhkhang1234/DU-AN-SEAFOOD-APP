/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.component;

import com.system.customSwing.Designed.WrapLayout;
import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author HP
 */
public class PanelContainItemMenu extends JPanel {
    
    public PanelContainItemMenu() {
        setBackground(new Color(240, 240, 240));
        setLayout(new WrapLayout(WrapLayout.LEFT, 10, 10));
    }
}
