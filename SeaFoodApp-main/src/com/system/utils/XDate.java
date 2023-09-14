/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author ADMIN
 */
public class XDate extends Thread {

    private JLabel lblNgayGio;

    public XDate(JLabel lblNgayGio) {
        this.lblNgayGio = lblNgayGio;
    }

    @Override
    public void run() {
        Date date = new Date();
        SimpleDateFormat time = new SimpleDateFormat("dd/MM/yyyy");
        lblNgayGio.setText(time.format(date));
    }

    static final SimpleDateFormat DATE_FORMATER = new SimpleDateFormat("dd/MM/yyyy");

    public static Date toDate(String date, String... pattern) {
        try {
            if (pattern.length > 0) {
                DATE_FORMATER.applyPattern(pattern[0]);
            }
            if (date == null) {
                return XDate.now();
            }
//            System.out.println(date);
            return DATE_FORMATER.parse(date);
        } catch (ParseException ex) {
            throw new RuntimeException(ex);
        }
    }

    public static String toString(Date date, String... pattern) {
        if (pattern.length > 0) {
            DATE_FORMATER.applyPattern(pattern[0]);
        }
        if (date == null) {
            date = XDate.now();
        }
        return DATE_FORMATER.format(date);
    }

    public static Date now() {
        return new Date();
    }

    public static Date addDays(Date date, int days) {
        date.setTime(date.getTime() + days * 24 * 60 * 60 * 1000);
        return date;
    }

    public static Date add(int days) {
        Date now = XDate.now();
        now.setTime(now.getTime() + days * 24 * 60 * 60 * 1000);
        return now;
    }

    public static LocalDate dateNow() {
        return  java.time.LocalDate.now();
    }
  
    private static final SimpleDateFormat formatDate = new SimpleDateFormat("dd-MM-yyyy");

    public static String SimpleDateFormat(Date date) {
        return formatDate.format(date);
    }
}
