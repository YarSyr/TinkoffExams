package org.example;
import java.util.*;

public class P5 {
    static long res;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long l = scanner.nextLong();long r = scanner.nextLong();
        //long l = Long.parseLong("0");long r = Long.parseLong("1000000000000000000");
        if(l<10&&r<=10){
            res = r-l+1;
            if(r ==10) {res--;}
            System.out.println(res);
            return;
        }
        if(l<10&&r>10){res = 10-l;}
        for(long i = 1; i<10; i++){
            long priv = i;
            for(long j = i*10+i; j<=r; j++) {
                if(j<=r&&j>=l&&priv==((j-i)/10)){
                    //System.out.println(j);
                    res++;
                }
                long buff = j;
                priv = j;
                j = j*10+i;
                if (j<buff){break;};
                j--;
            }
        }
       System.out.println(res);
    }
}