package br.com.cepp;

import java.util.Arrays;

import static java.lang.System.*;

public class LeftRotation {
    public static void main(String[] args) {
        int d = 4;

        int[] a = {1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5};

        for(int i = 0; i < d; i++) {
            int tmp = a[0];
            System.arraycopy(a, 1, a, 0, a.length - 1);
            a[a.length-1] = tmp;
        }


        Arrays.stream(a).forEach(i -> out.print(i + " "));
        out.println("\n5 1 2 3 4 5 1 2 3 4 5 1 2 3 4");
    }
}
