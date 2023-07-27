/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test_02;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicArrowButton;

/**
 *
 * @author HP
 */
public class Main extends JPanel {
  public Main() {
    setLayout(new BorderLayout());


    JPanel east = new JPanel(new BorderLayout());
    add(east, BorderLayout.EAST);

    BasicArrowButton north = new BasicArrowButton(BasicArrowButton.NORTH);

    east.add(north, BorderLayout.NORTH);

    BasicArrowButton south = new BasicArrowButton(BasicArrowButton.SOUTH);
    east.add(south, BorderLayout.SOUTH);
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Main");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    frame.add(new Main());
    frame.setSize(200, 300);
    frame.setLocationByPlatform(true);
    frame.setVisible(true);
  }
    
}
