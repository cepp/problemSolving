package br.com.cepp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JavaEndOfFile {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String typedValue = scanner.nextLine();

        long line = 1;
        List<String> list = new ArrayList<>();
        list.add(String.format("%d %s", line, typedValue));
        line++;

        while(scanner.hasNext()) {
            typedValue = scanner.nextLine();
            list.add(String.format("%d %s", line, typedValue));
            line++;
        }

        list.parallelStream().forEach(System.out::println);

        scanner.close();

    }
}
