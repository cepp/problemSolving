package br.com.cepp;

import java.util.Arrays;

public class ArrayManipulation {

    static long maxValue = 0L;

    public static void main(String[] args) {
        int n = 10;
//        int[][] queries = {{5,3}, {1, 2, 100}, {2, 5 ,100}, {3, 4, 100}};
//        int[][] queries = {{10,4}, {2, 6, 8}, {3, 5 ,7}, {1, 8, 1}, {5, 9, 15}};
        int[][] queries = {{10,3}, {1, 5, 3}, {4, 8 ,7}, {6, 9, 1}};
        long[] array = new long[n];
        int indexA = 0;
        int indexB = 0;

        for (int[] query : queries) {
            indexA = query[0] - 1;
            indexB = n < query[1] ? n : query[1];
//            if(indexA > indexB) {
//                continue;
//            }
            System.out.println("Before: "+Arrays.toString(array));
            System.out.println(String.format("arr[%d][%d]", indexA, indexB));
            for (int x = indexA; x < indexB; x++) {
                array[x] += query[2];
                maxValue = Math.max(array[x], maxValue);
            }
            System.out.println("After: "+Arrays.toString(array));


//            Arrays.parallelPrefix(array, indexA, indexB, (x, y) -> compute(y, query[2]));

        }
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        System.out.println(Arrays.toString(array));
        System.out.println(array[array.length-1]);
    }

    static long compute(long y, long value) {
        System.out.println(String.format("[%d]: %d", y, value));
        long sum = y + value;
        maxValue = Math.max(sum, maxValue);
        return sum;
    }
}
