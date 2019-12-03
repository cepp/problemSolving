package br.com.cepp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicArray {
    public static void main(String[] args) {
        final int n = 2;
        List<List<Integer>> queries = new ArrayList<>();
        queries.add(Arrays.asList(new Integer[]{1, 0 ,5}));
        queries.add(Arrays.asList(new Integer[]{1, 1, 7}));
        queries.add(Arrays.asList(new Integer[]{1, 0, 3}));
        queries.add(Arrays.asList(new Integer[]{2, 1, 0}));
        queries.add(Arrays.asList(new Integer[]{2, 1, 1}));

        List<List<Integer>> temp = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            temp.add(i, new ArrayList<>());
        }
        List<Integer> result = new ArrayList<>();

        int lastAnswer = 0;
        for(int i = 0; i < queries.size(); i++) {
            List<Integer> line = queries.get(i);
            int index = (line.get(1) ^ lastAnswer) % n;
            if(line.get(0) == 1) {
                temp.get(index).add(line.get(2));
            } else {
                lastAnswer = temp.get(index).get(line.get(2));
                result.add(lastAnswer);
            }
        }

        System.out.println(result);
    }
}
