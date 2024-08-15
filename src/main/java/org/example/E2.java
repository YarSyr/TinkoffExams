package org.example;
import java.util.Scanner;
public class E2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long Count = (long) Math.pow(4, n - 1);
        System.out.println(Count);
        }
    }