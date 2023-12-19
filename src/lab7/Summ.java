package lab7;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Summ {
    static int[] mas = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 10, 11, 12, 13, 14};

    final static int COUNT_TREADS = 3;

    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(COUNT_TREADS);

        int[][] m = splitika(mas,COUNT_TREADS );
        List<Future<Integer>> futures = new ArrayList<>();
        for (int[] mm:m){
            futures.add(es.submit(() -> sum(mm)));
        }

        int res = 0;
        for (Future<Integer> val:futures){
            try {
                res+= val.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(res);
        es.shutdown();
        System.out.println(sum(mas));
    }
    public static int sum(int[] m) {
        int s = 0;
        for (int v : m) {
            s += v;
        }
        return s;
    }

    public static int[][] splitika(int[] m, int c) {
        int[][] fin = new int[c][m.length / c];
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < fin.length && j < fin[0].length && k<m.length){
            fin[i][j]=m[k];
            k++;
            j++;
            if(j==fin[0].length){
                j=0;
                i++;
            }
        }
        return fin;
    }

}
