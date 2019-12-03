package br.com.cepp;

import java.util.Arrays;

public class NewYearChaos {
    public static void main(String[] args) {
        int[] q1 = {5, 1, 2, 3, 7, 8, 6, 4};
        moves(q1);

        int[] q2 = {1, 2, 5, 3, 7, 8, 6, 4};
        moves(q2);
    }

    static void moves(int[] q) {
        int moves = 0;
        for(int i = 0; i < q.length; i++) {
            final int valueArray = q[i];
            int brides = 0;
            if(Arrays.stream(q, i, q.length).anyMatch(value -> value < valueArray)) {
                brides = Math.abs((q[i]-1) - i);
                System.out.println(String.format("brides: %d", brides));

                moves += brides;
            }

            if(brides > 2) {
                System.out.println("Too chaotic");
                return;
            }
        }
        System.out.println(moves);
    }
}
