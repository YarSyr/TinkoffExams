package org.example;
import java.util.Scanner;
public class E3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] colSumm = new int[n];
        int[] rowSumm = new int[n];
        int[][] matrix = new int[n][n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rowSumm[i] += matrix[i][j];
                colSumm[j] += matrix[i][j];
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(rowSumm[i] - colSumm[j]) <= matrix[i][j]) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}