/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.customSwing.TextField_01;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.metal.MetalTextFieldUI;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author HP
 */
public class TextFieldSuggestionUI extends MetalTextFieldUI {

    private JTextField textfield;
    private Border border;
//    private int round = 5;
    private List<String> items = new ArrayList<>();
    private Color colorSelection = new Color(54, 189, 248);
    private Color colorSelectedText = new Color(255, 255, 255);
    public Color colorFocusGained = new Color(128, 189, 255);
    public Color colorFocusLost = new Color(206, 212, 218);

    private int roundTopLeft = 10;
    private int roundTopRight = 10;
    private int roundBottomLeft = 10;
    private int roundBottomRight = 10;

    public int getRoundTopLeft() {
        return roundTopLeft;
    }

    public void setRoundTopLeft(int roundTopLeft) {
        this.roundTopLeft = roundTopLeft;
        border.setRoundTopLeft(roundTopLeft);
        textfield.repaint();
    }

    public int getRoundTopRight() {
        return roundTopRight;
    }

    public void setRoundTopRight(int roundTopRight) {
        this.roundTopRight = roundTopRight;
        border.setRoundTopRight(roundTopRight);
        textfield.repaint();
    }

    public int getRoundBottomLeft() {
        return roundBottomLeft;
    }

    public void setRoundBottomLeft(int roundBottomLeft) {
        this.roundBottomLeft = roundBottomLeft;
        border.setRoundBottomLeft(roundBottomLeft);
        textfield.repaint();
    }

    public int getRoundBottomRight() {
        return roundBottomRight;
    }

    public void setRoundBottomRight(int roundBottomRight) {
        this.roundBottomRight = roundBottomRight;
        border.setRoundBottomRight(roundBottomRight);
        textfield.repaint();
    }

    public List<String> getItems() {
        return items;
    }

    public void setItems(List<String> items) {
        this.items = items;
    }

//    public int getRound() {
//        return round;
//    }
//
//    public void setRound(int round) {
//        this.round = round;
//        border.setRound(round);
//        textfield.repaint();
//    }
    public Color getColorSelection() {
        return colorSelection;
    }

    public void setColorSelection(Color colorSelection) {
        this.colorSelection = colorSelection;
    }

    public Color getColorSelectedText() {
        return colorSelectedText;
    }

    public void setColorSelectedText(Color colorSelectedText) {
        this.colorSelectedText = colorSelectedText;
    }

    public TextFieldSuggestionUI(JTextField textfield) {
        this.textfield = textfield;
        border = new Border(5);
        border.setRoundTopLeft(roundTopLeft);
        border.setRoundTopRight(roundTopRight);
        border.setRoundBottomLeft(roundBottomLeft);
        border.setRoundBottomRight(roundBottomRight);
        textfield.setBorder(border);
        textfield.setOpaque(false);
        textfield.setSelectedTextColor(colorSelectedText);
        textfield.setSelectionColor(colorSelection);
        textfield.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent fe) {
                border.setColor(colorFocusGained);
                textfield.repaint();
            }

            @Override
            public void focusLost(FocusEvent fe) {
                border.setColor(colorFocusLost);
                textfield.repaint();
            }
        });
        AutoCompleteDecorator.decorate(textfield, items, false);
    }

    @Override
    protected void paintBackground(Graphics grphcs) {
        if (textfield.isOpaque()) {
            Graphics2D g2 = (Graphics2D) grphcs.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(textfield.getBackground());
            //g2.fillRoundRect(0, 0, textfield.getWidth(), textfield.getHeight(), round, round);
            Area area = new Area(createRoundTopLeft());
            if (roundTopRight > 0) {
                area.intersect(new Area(createRoundTopRight()));
            }
            if (roundBottomLeft > 0) {
                area.intersect(new Area(createRoundBottomLeft()));
            }
            if (roundBottomRight > 0) {
                area.intersect(new Area(createRoundBottomRight()));
            }
            g2.fill(area);
            g2.dispose();
        }
    }

    private Shape createRoundTopLeft() {
        int width = textfield.getWidth();
        int height = textfield.getHeight();
        int roundX = Math.min(width, roundTopLeft);
        int roundY = Math.min(height, roundTopLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundTopRight() {
        int width = textfield.getWidth();
        int height = textfield.getHeight();
        int roundX = Math.min(width, roundTopRight);
        int roundY = Math.min(height, roundTopRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundBottomLeft() {
        int width = textfield.getWidth();
        int height = textfield.getHeight();
        int roundX = Math.min(width, roundBottomLeft);
        int roundY = Math.min(height, roundBottomLeft);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }

    private Shape createRoundBottomRight() {
        int width = textfield.getWidth();
        int height = textfield.getHeight();
        int roundX = Math.min(width, roundBottomRight);
        int roundY = Math.min(height, roundBottomRight);
        Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
        area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
        area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
        return area;
    }

    private class Border extends EmptyBorder {

        private int roundTopLeft;
        private int roundTopRight;
        private int roundBottomLeft;
        private int roundBottomRight;

        public int getRoundTopLeft() {
            return roundTopLeft;
        }

        public void setRoundTopLeft(int roundTopLeft) {
            this.roundTopLeft = roundTopLeft;
        }

        public int getRoundTopRight() {
            return roundTopRight;
        }

        public void setRoundTopRight(int roundTopRight) {
            this.roundTopRight = roundTopRight;
        }

        public int getRoundBottomLeft() {
            return roundBottomLeft;
        }

        public void setRoundBottomLeft(int roundBottomLeft) {
            this.roundBottomLeft = roundBottomLeft;
        }

        public int getRoundBottomRight() {
            return roundBottomRight;
        }

        public void setRoundBottomRight(int roundBottomRight) {
            this.roundBottomRight = roundBottomRight;
        }

        public Color getFocusColor() {
            return focusColor;
        }

        public void setFocusColor(Color focusColor) {
            this.focusColor = focusColor;
        }

        public Color getColor() {
            return color;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        private Color focusColor = new Color(51, 51, 51);
        private Color color = new Color(206, 212, 218);

        public Border(int border) {
            super(border, border, border, border);
        }

        public Border() {
            this(5);
        }

        @Override
        public void paintBorder(Component cmpnt, Graphics grphcs, int x, int y, int width, int height) {
            Graphics2D g2 = (Graphics2D) grphcs.create();
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            if (cmpnt.isFocusOwner()) {
                g2.setColor(focusColor);
            } else {
                g2.setColor(color);
            }
            Area area = new Area(createRoundTopLeft());
            if (roundTopRight > 0) {
                area.intersect(new Area(createRoundTopRight()));
            }
            if (roundBottomLeft > 0) {
                area.intersect(new Area(createRoundBottomLeft()));
            }
            if (roundBottomRight > 0) {
                area.intersect(new Area(createRoundBottomRight()));
            }
            //g2.fill(area);
            g2.drawRoundRect(x, y, width - 1, height - 1, 5, 5);
            g2.dispose();
        }

        private Shape createRoundTopLeft() {
            int width = textfield.getWidth();
            int height = textfield.getHeight();
            int roundX = Math.min(width, roundTopLeft);
            int roundY = Math.min(height, roundTopLeft);
            Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
            area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
            area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
            return area;
        }

        private Shape createRoundTopRight() {
            int width = textfield.getWidth();
            int height = textfield.getHeight();
            int roundX = Math.min(width, roundTopRight);
            int roundY = Math.min(height, roundTopRight);
            Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
            area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
            area.add(new Area(new Rectangle2D.Double(0, roundY / 2, width, height - roundY / 2)));
            return area;
        }

        private Shape createRoundBottomLeft() {
            int width = textfield.getWidth();
            int height = textfield.getHeight();
            int roundX = Math.min(width, roundBottomLeft);
            int roundY = Math.min(height, roundBottomLeft);
            Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
            area.add(new Area(new Rectangle2D.Double(roundX / 2, 0, width - roundX / 2, height)));
            area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
            return area;
        }

        private Shape createRoundBottomRight() {
            int width = textfield.getWidth();
            int height = textfield.getHeight();
            int roundX = Math.min(width, roundBottomRight);
            int roundY = Math.min(height, roundBottomRight);
            Area area = new Area(new RoundRectangle2D.Double(0, 0, width, height, roundX, roundY));
            area.add(new Area(new Rectangle2D.Double(0, 0, width - roundX / 2, height)));
            area.add(new Area(new Rectangle2D.Double(0, 0, width, height - roundY / 2)));
            return area;
        }
    }

}
