package br.com.cepp;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
//        String s = "DUDDDUUDUU";
//        int n = 10;
//        int nValleys = 0;
//        int seaLevel = 0;
//        for(int i = 0; i < n; i++) {
//            String step = s.substring(i, i+1);
//
//            seaLevel = "U".equals(step) ? seaLevel + 1 : seaLevel - 1;
//
//            nValleys = seaLevel == -1 && "D".equals(step) ? nValleys + 1 : nValleys;
//        }
//
//        System.out.println(nValleys);
        int[][] v = new int[][]{
                {5, 3, 4},
                {1, 5, 8},
                {6, 4, 2}
        };

        Map<String, Integer> sumMap = new HashMap<>();
        sumRows(v, sumMap);
        sumColumns(v, sumMap);
        final int magicConstant = getMagicConstant(sumMap);
        sumMap.entrySet().removeIf(item -> item.getValue() == magicConstant);
        Map<String, Integer> interceptionIndexes = inteterception(sumMap);


        System.out.println(magicConstant);
    }

    static Map<String, Integer> inteterception(Map<String, Integer> map) {
        Map<String, Integer> interception = new HashMap<>();
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            countInterceptionDiagonal(interception, item.getKey());
            if(item.getKey().startsWith("r")) {
                countInterceptionRow(interception, item.getKey());
            }
            if(item.getKey().startsWith("c")) {
                countInterceptionColumn(interception, item.getKey());
            }
        }

        return interception;
    }

    static void countInterceptionRow(Map<String, Integer> interception, String key) {
        int row = Integer.parseInt(key.substring(1));
        for(int j = 0; j < 3; j++) {
            String newKey = row+""+j;
            int value = 1;
            if(interception.containsKey(newKey)) {
                value += interception.get(newKey)+1;
            }
            interception.put(newKey, value);
        }
    }

    static void countInterceptionColumn(Map<String, Integer> interception, String key) {
        int column = Integer.parseInt(key.substring(1));
        for(int i = 0; i < 3; i++) {
            String newKey = i+""+column;
            int value = 1;
            if(interception.containsKey(newKey)) {
                value += interception.get(newKey)+1;
            }
            interception.put(newKey, value);
        }
    }

    static void countInterceptionDiagonal(Map<String, Integer> interception, String key) {
        if("d1".equals(key)) {
            countInterceptionD1(interception);
        } else if("d2".equals(key)) {
            countInterceptionD2(interception);
        }
    }

    static void countInterceptionD1(Map<String, Integer> interception) {
        for(int i = 0; i < 3; i++) {
            String key = i+""+i;
            int value = 1;
            if(interception.containsKey(key)) {
                value += interception.get(key)+1;
            }
            interception.put(key, value);
        }
    }

    static void countInterceptionD2(Map<String, Integer> interception) {
        int x = 0;
        for(int i = 2; i >= 0; i--) {
            String key = x+""+i;
            int value = 1;
            if(interception.containsKey(key)) {
                value += interception.get(key)+1;
            }
            interception.put(key, value);
            x++;
        }
    }

    static int getMagicConstant(Map<String, Integer> map) {
        Map<Integer, Integer> n = new HashMap<>();
        int magicConstant = 0;
        int count = 0;
        for (Map.Entry<String, Integer> item : map.entrySet()) {
            int value = 1;
            if(n.containsKey(item.getValue())) {
                value = n.get(item.getValue()) + 1;
            }
            n.put(item.getValue(), value);
            if(value > count && item.getValue() != magicConstant) {
                count = value;
                magicConstant = item.getValue();
            }
        }

        return magicConstant;
    }

    static void sumRows(final int[][] a,final Map<String, Integer> sumMap) {
        int sumDiagonal = 0;
        for(int i = 0; i < 3; i++) {
            int sum = 0;
            for(int j = 0; j < 3; j++) {
                sum += a[i][j];
                sumDiagonal += i==j ? a[i][j] : 0;
            }
            sumMap.put("r"+i, sum);
        }

        sumMap.put("d1", sumDiagonal);
        sumMap.put("d2", a[0][2]+a[2][0]+a[1][1]);
    }

    static void sumColumns(final int[][] a,final Map<String, Integer> sumMap) {
        for(int i = 2; i >= 0; i--) {
            int sum = 0;
            for(int j = 2; j >= 0; j--) {
                sum += a[i][j];
            }
            sumMap.put("c"+i, sum);
        }
    }

    static void test() {
        int N = 4;
        if(N%2 > 0) {
            System.out.println("Weird");
        } else if(N >= 2 && N <= 5) {
            System.out.println("Not Weird");
        } else if(N >= 6 && N <= 20) {
            System.out.println("Weird");
        } else {
            System.out.println("Not Weird");
        }
    }
}
