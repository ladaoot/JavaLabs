package lab7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

public class Max {
    static int[][] matrix = new int[][]{
            {1, 2, 3, 4, 5},
            {2, 9, 3, 4, 1},
            {7, 9, 10, 15, 9}
    };

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(matrix.length);
        List<Future<Integer>> futures = new ArrayList<>();
        for (int[] m : matrix) {
            futures.add(es.submit(() -> {
                Arrays.sort(m);
                return m[m.length - 1];
            }));
        }
        List<Integer> list = new ArrayList<>();
        for (Future<Integer> val : futures) {
            try {
                list.add(val.get());
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(Collections.max(list));
        es.shutdown();
    }
}
