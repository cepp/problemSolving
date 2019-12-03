package br.com.cepp;

import java.util.Arrays;
import java.util.stream.IntStream;

public class SimpleArraySum {
    public static void main(String[] args) {
        int[] ar = {1,3,55,4,33,2};

        IntStream.of(ar).sum();
    }
}
