package br.com.cepp;

import java.util.Arrays;
import java.util.Comparator;

public class ArraysDS {
    public static void main(String[] args) {
        int[] a = {1,2,4,3,3,4};

        int[] newArray = new int[a.length];
        int index = 0;
        for(int i = a.length-1; i >= 0; i--) {
            newArray[index] = a[i];
            index++;
        }

    }
}
