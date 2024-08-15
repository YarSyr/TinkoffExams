package org.example;

import java.util.Scanner;

public class P6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        long[] array = new long[size];
        for (int i = 0; i<size; i++){
            array[i] = scanner.nextLong();
        }
        int miss_a = 0;int miss_b = 0;
        int miss_a_loc = 0;int miss_b_loc = 0;
        for (int i = 0; i<size; i++){
            if((i+1)%2==0){ // чётн/a
                if(array[i]%2!=0){miss_a++;miss_a_loc = i+1;}
            } else { //нечётн/b
                if(array[i]%2==0){miss_b++;miss_b_loc = i+1;}
            }
        }
        String res = "-1 -1";
        if(miss_a == 1 && miss_b == 1){
            if(miss_a_loc<miss_b_loc){
                res = String.valueOf(miss_a_loc)+ " " + String.valueOf(miss_b_loc);
            } else {
                res = String.valueOf(miss_b_loc)+ " " + String.valueOf(miss_a_loc);
            }
        } else if (miss_a == 0 && miss_b == 0 && size > 2) {
            res = "1 3";
        }
        System.out.println(res);
    }
}
// && (miss_a_loc-miss_b_loc == -1 || miss_a_loc-miss_b_loc == 1)