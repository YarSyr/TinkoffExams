package org.example;
import java.util.Scanner;
public class E1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long sumN = n * (n + 1) / 2;
        long sumBef= 99 * 100 / 2;
        long result = sumN - sumBef;
        System.out.println(result);
    }
}
