package br.com.cepp;

import java.util.Arrays;

public class SparseArrays {
    public static void main(String[] args) {
        String[] strings = {"aba","baba","aba","xzxb"};
        String[] queries = {"aba", "xzxb", "ab"};

        int[] a = new int[queries.length];

        int i = 0;
        for(String s : queries) {
            a[i] = (int) Arrays.stream(strings).filter(s::equals).count();
            i++;
        }

        System.out.println(Arrays.toString(a));
    }
}
