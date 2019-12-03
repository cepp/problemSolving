package br.com.cepp;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class TwoDArrayDS {
    public static void main(String[] args) {
//        int[][] arr = {
//                {1, 1, 1, 0, 0, 0},
//                {0, 1, 0, 0, 0, 0},
//                {1, 1, 1, 0, 0, 0},
//                {0, 0, 2, 4, 4, 0},
//                {0, 0, 0, 2, 0, 0},
//                {0, 0, 1, 2, 4, 0}
//        };

//        int[][] arr = {
//                {-9, -9, -9, 1, 1, 1},
//                {0, -9, 0, 4, 3, 2},
//                {-9, -9, -9, 1, 2, 3},
//                {0, 0, 8, 6, 6, 0},
//                {0, 0, 0, -2, 0, 0},
//                {0, 0, 1, 2, 4, 0}
//        };

//        int[][] arr = {
//                {-1, -1, 0, -9, -2, -2},
//                {-2, -1, -6, -8, -2, -5},
//                {-1, -1, -1, -2, -3, -4},
//                {-1, -9, -2, -4, -4, -5},
//                {-7, -3, -3, -2, -9, -9},
//                {-1, -3, -1, -2, -4, -5}
//        };

        int[][] arr = {
                {-1, 1, -1, 0, 0, 0},
                {0, -1, 0, 0, 0, 0},
                {-1, -1, -1, 0, 0, 0},
                {0, -9, 2, -4, -4, 0},
                {-7, 0, 0, -2, 0, 0},
                {0, 0, -1, -2, -4, 0}
        };

        Integer maxValue = null;

        for(int i = 0; i < 4; i++) {
            for(int j = 0; j < 4; j++) {
                int sum = 0;
                for (int x = i; x < i + 3; x++) {
                    for (int y = j; y < j + 3; y++) {
                        boolean isValidValue = y == (j + 1) || x != (i + 1);
                        int value = isValidValue ? arr[x][y] : 0;
                        sum += value;
                    }
                }

                maxValue = maxValue == null ? sum : Math.max(sum, maxValue);
            }
        }

        System.out.println(maxValue);
    }
}
