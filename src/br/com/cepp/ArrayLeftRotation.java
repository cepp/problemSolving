package br.com.cepp;

import java.util.Arrays;

public class ArrayLeftRotation {
    public static void main(String[] args) {
//        int[] a = {1, 2, 3, 4, 5};
//        int d = 4;
        int[] a = {41, 73, 89, 7, 10, 1, 59, 58, 84, 77, 77, 97, 58, 1, 86, 58, 26, 10, 86, 51};
        int d = 10;

        int[] ret = Arrays.copyOf(a, a.length);
        for(int i = 0; i < a.length; i++) {
            int sumIndexes = i - d;
            int index = sumIndexes < 0 ?  a.length + sumIndexes : sumIndexes;

            System.out.println(String.format("[%d][%d][%d][%d] = %d", i, d, sumIndexes, index, a[i]));

            ret[index] = a[i];

        }
        System.out.println(Arrays.toString(ret));
    }
}
