package br.com.cepp;

public class LeftRotation {
    public static void main(String[] args) {
        int n = 5;
        int d = 4,ojknim5;

        int[] a = new int[n];
        int[] aItems = {1, 2, 3, 4, 5};//, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5};

        for (int i = 0; i < n; i++) {
            int newIndex = d - i;
            a[newIndex] = aItems[i];
        }

        for(int i = 0; i < n; i++) {
            System.out.print(String.format("%s ",a[i]));
        }
    }
}
