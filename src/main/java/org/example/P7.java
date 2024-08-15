package org.example;

import java.util.Scanner;

public class P7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int ys_count = 0;
        int[] array = new int[size];
        int[] by = new int[size];
        int[] to = new int[size];
        for (int i = 0; i<size; i++) {
            array[i] = scanner.nextInt();
            by[i] += 1;
            to[array[i]] += 1;
            if (to[array[i]] > 2 || by[i] > 2) {
                System.out.println("-1 -1");
                return;
            }
            if(by[i]==2){

            }
            if (array[i] == i) {
                ys_count++;
                if (ys_count > 2) {
                    System.out.println("-1 -1");
                    return;
                }
            }
        }
        for (int i = 0; i<size; i++){
            array[i] = scanner.nextInt();
            by[i]+=1;
            to[array[i]]+=1;
        }

        System.out.println("s");
    }
}