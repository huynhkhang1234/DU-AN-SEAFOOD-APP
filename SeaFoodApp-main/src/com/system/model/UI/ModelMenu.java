/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.model.UI;

import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author HP
 */
public class ModelMenu {
    private String icon;
    private String menuName;
    MenuType type;

    public ModelMenu() {
    }

    public ModelMenu(String icon, String menuName, MenuType type) {
        this.icon = icon;
        this.menuName = menuName;
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }
   
    public Icon toIcon() {
        return new ImageIcon(getClass().getResource("/com/system/icon/Menu/icon_" + icon + ".png"));
    }
    
    public Icon toIconSelected() {
        return new ImageIcon(getClass().getResource("/com/system/icon/Menu/icon_" + icon + "_selected.png"));
    }
    
    public static enum MenuType {
        MENU, EMPTY;
    }
}
