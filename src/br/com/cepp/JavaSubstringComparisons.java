package br.com.cepp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.lang.System.*;

public class JavaSubstringComparisons {
    public static void main(String[] args) {
        String s = "welcometojava";
        int k = 3;

        List<String> strings = new ArrayList<>();
        for(int i = 0; i < s.length(); i++) {
            if(i + k > s.length()) {
                break;
            }
            strings.add(s.substring(i, i+k));
        }
        Collections.sort(strings);

        out.println(strings);
    }
}
