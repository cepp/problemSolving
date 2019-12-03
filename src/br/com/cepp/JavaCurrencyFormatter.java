package br.com.cepp;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class JavaCurrencyFormatter {
    public static void main(String[] args) {
        NumberFormat usNumberFormat = DecimalFormat.getCurrencyInstance(new Locale("en", "in"));
        System.out.println(usNumberFormat.format(1000.23));
    }
}
