package com.system.customSwing.TextField_01;

import javax.swing.JTextField;

public class TextFieldSuggestion extends JTextField {

    private TextFieldSuggestionUI textUI;

    public TextFieldSuggestion() {
        textUI = new TextFieldSuggestionUI(this);
        setUI(textUI);
    }

    public void addItemSuggestion(String text) {
        textUI.getItems().add(text);
    }

    public void removeItemSuggestion(String text) {
        textUI.getItems().remove(text);
    }

    public void clearItemSuggestion() {
        textUI.getItems().clear();
    }

//    public void setRound(int round) {
//        textUI.setRound(round);
//    }
//
//    public int getRound() {
//        return textUI.getRound();
//    }
    public int getRoundTopLeft() {
        return textUI.getRoundTopLeft();
    }

    public void setRoundTopLeft(int roundTopLeft) {
        textUI.setRoundTopLeft(roundTopLeft);
    }
    
    public int getRoundTopRight() {
        return textUI.getRoundTopRight();
    }

    public void setRoundTopRight(int roundTopRight) {
        textUI.setRoundTopRight(roundTopRight);
    }
    
    public int getRoundBottomLeft() {
        return textUI.getRoundBottomLeft();
    }

    public void setRoundBottomLeft(int roundBottomLeft) {
        textUI.setRoundBottomLeft(roundBottomLeft);
    }
    
    public int getRoundBottomRight() {
        return textUI.getRoundBottomRight();
    }

    public void setRoundBottomRight(int roundBottomRight) {
        textUI.setRoundBottomRight(roundBottomRight);
    }

}
