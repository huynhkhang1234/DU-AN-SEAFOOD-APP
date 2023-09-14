/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.system.method;

import java.text.DecimalFormat;

/**
 *
 * @author HP
 */
public class Format_Money {
    private static final DecimalFormat formatMoney = new DecimalFormat("###, ###, ###, ### VNĐ");
    
    public static String formatMoney(double number) {
        return formatMoney.format(number);
    }
}
