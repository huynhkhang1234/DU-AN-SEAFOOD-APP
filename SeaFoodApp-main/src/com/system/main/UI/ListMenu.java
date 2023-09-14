/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.main.UI;

import com.system.component.MenuItem;
import com.system.event.EventMenuCallBack;
import com.system.model.UI.ModelMenu;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.SwingUtilities;
import com.system.event.EventMenuSelected;

/**
 *
 * @author HP
 */
public class ListMenu<E extends Object> extends JList<E> {

    public void addEventSelectedMemu(EventMenuSelected event) {
        events.add(event);
    }
    private final DefaultListModel model;
    private final List<EventMenuSelected> events;
    private int selectedIndex = -1;

    public ListMenu() {
        model = new DefaultListModel();
        events = new ArrayList<>();
        super.setModel(model);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    int index = locationToIndex(e.getPoint());
                    Object o = model.getElementAt(index);
                    if (o instanceof ModelMenu) {
                        ModelMenu data = (ModelMenu) o;
                        if (data.getType() == ModelMenu.MenuType.MENU) {
                            if (index != selectedIndex) {
                                selectedIndex = -1;
                                runEvent(index);
                            }
                        }
                    } else {
                        if (index != selectedIndex) {
                            selectedIndex = -1;
                            runEvent(index);
                        }
                    }
                }
            }

        });
    }

    public void runEvent(int indexChange) {
        for (EventMenuSelected event : events) {
            event.menuSelected(indexChange, new EventMenuCallBack() {
                @Override
                public void call(int index) {
                    // this call back event run when animation done
                    selectedIndex = index;
                    repaint();
                }
            });
        }
    }

    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                ModelMenu data;
                if (value instanceof ModelMenu) {
                    data = (ModelMenu) value;
                } else {
                    data = new ModelMenu("1", value + "", ModelMenu.MenuType.MENU);
                }
                MenuItem item = new MenuItem(data);
                item.setSelected(index == selectedIndex);
                return item;
            }

        };
    }

    @Override
    public void setModel(ListModel<E> list) {
        for (int i = 0; i < list.getSize(); i++) {
            model.addElement(list.getElementAt(i));
        }
    }

    public void addItem(ModelMenu data) {
        model.addElement(data);
    }


}
