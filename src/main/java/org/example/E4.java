package org.example;
import java.util.Scanner;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class E4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] endTime = new int[n + 1];
        int[] Degree = new int[n + 1];
        List<List<Integer>> depends = IntStream.rangeClosed(0, n)
                .mapToObj(i -> new ArrayList<Integer>())
                .collect(Collectors.toList());
        for (int i = 1; i <= n; i++) {
            int a = scanner.nextInt();
            Degree[i] = a;
            for (int j = 0; j < a; j++) {
                int dependency = scanner.nextInt();
                depends.get(dependency).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (Degree[i] == 0) {
                queue.offer(i);
                endTime[i] = 1;
            }
        }
        while (!queue.isEmpty()) {
            int currentProcess = queue.poll();
            for (int d : depends.get(currentProcess)) {
                Degree[d]--;
                endTime[d] = Math.max(endTime[d], endTime[currentProcess] + 1);
                if (Degree[d] == 0) {
                    queue.offer(d);
                }
            }
        }
        System.out.println(endTime[1]);
    }
}
