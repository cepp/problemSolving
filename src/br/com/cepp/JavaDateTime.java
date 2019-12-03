package br.com.cepp;

import java.util.Calendar;
import java.util.Locale;

public class JavaDateTime {
    public static void main(String[] args) {
        int month = 8;
        int day = 5;
        int year = 2015;
        Calendar cal = Calendar.getInstance(Locale.ENGLISH);
        cal.clear();
        cal.set(year, month-1, day);
        System.out.println(cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG_STANDALONE, Locale.ENGLISH).toUpperCase(Locale.ENGLISH));
    }
}
