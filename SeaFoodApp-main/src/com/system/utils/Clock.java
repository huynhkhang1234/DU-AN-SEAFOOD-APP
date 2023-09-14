/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author ADMIN
 */
public class Clock extends Thread {

    private JLabel lblWatch;

    public Clock(JLabel lblWatch) {
        this.lblWatch = lblWatch;
    }
    

    @Override
    public void run() {
        while (true) {
            SimpleDateFormat date = new SimpleDateFormat("hh:mm:ss aa");
            Date time = new Date();
            String GetText = date.format(time);
            lblWatch.setText(GetText);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println(e);
            }
        }
    }
}
