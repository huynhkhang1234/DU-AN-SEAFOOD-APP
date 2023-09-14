/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.utils;

import java.text.DecimalFormat;

/**
 *
 * @author ADMIN
 */
public class FormatMoney {
    private static final DecimalFormat formatMoney = new DecimalFormat("###, ###, ### VNĐ");
    public static String formatMoney(double number) {
        return formatMoney.format(number);
    }
    
    public static String formatReplace(String replace){
        return replace.replace(",","").trim();
    }
    public static String formatVND(String VNĐ){
        return VNĐ.replace("VNĐ","").trim();
    }
}
