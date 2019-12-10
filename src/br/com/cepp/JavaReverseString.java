package br.com.cepp;

import static java.lang.System.*;

public class JavaReverseString {
    public static void main(String[] args) {
        String stringToReverse = "java";
        char[] chars = new char[stringToReverse.length()];
        int j = 0;
        for(int i = stringToReverse.length()-1; i >= 0; i--) {
            chars[i] = stringToReverse.charAt(j);
            j++;
        }
        boolean equals = stringToReverse.equals(String.valueOf(chars));
        out.println(equals ? "Yes" : "No");
    }
}
