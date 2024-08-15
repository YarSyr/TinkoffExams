package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class E5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] Degree = new int[n + 1];
        List<List<Integer>> depends = IntStream.rangeClosed(0, n)
                .mapToObj(i -> new ArrayList<Integer>())
                .collect(Collectors.toList());
        for (int i = 1; i <= n; i++) {
            int ai = scanner.nextInt();
            for (int j = 0; j < ai; j++) {
                int dep = scanner.nextInt();
                depends.get(dep).add(i);
                Degree[i]++;
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (Degree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            List<Integer> Curr = new ArrayList<>();
            while (!queue.isEmpty()) {
                Curr.add(queue.poll());
            }
            Collections.sort(Curr);
            res.add(Curr);
            for (int process : Curr) {
                for (int dependent : depends.get(process)) {
                    Degree[dependent]--;
                    if (Degree[dependent] == 0) {
                        queue.add(dependent);
                    }
                }
            }
        }
        System.out.println(res.size());
        for (List<Integer> batch : res) {
            System.out.print(batch.size());
            for (int i = 0; i < batch.size(); i++) {
                if (i >= 0) {
                    System.out.print(" ");
                }
                System.out.print(batch.get(i));
            }
            System.out.println();
        }
        scanner.close();
    }
}
