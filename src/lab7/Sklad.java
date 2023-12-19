package lab7;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class Sklad {
    private static final int MAX_WEIGHT_PER_GROUPLER = 150;

    public static void main(String[] args) {
        List<Integer> items = new ArrayList<>();
        // Добавление товаров на склад
        items.add(80);
        items.add(30);
        items.add(40);
        items.add(120);
        items.add(50);
        items.add(70);
        items.add(150);
        items.add(70);
        items.add(70);

        ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

        MoveItemsTask task = new MoveItemsTask(items);
        forkJoinPool.invoke(task);

        System.out.println("Перенос товаров завершен");
    }

    static class MoveItemsTask extends RecursiveAction {

        private final List<Integer> items;

        MoveItemsTask(List<Integer> items) {
            this.items = items;
        }

        @Override
        protected void compute() {
            if (isCanMovesItems(items)) {
                moveItems(items);
            } else {
                if(items.size()<=1) return;
                int mid = items.size() / 2;
                MoveItemsTask leftTask = new MoveItemsTask(items.subList(0, mid));
                MoveItemsTask rightTask = new MoveItemsTask(items.subList(mid, items.size()));

                invokeAll(leftTask, rightTask);
            }
        }

        private boolean isCanMovesItems(List<Integer> items){
            long sum = 0;
            for(Integer item:items){
                sum+=item;
                if(sum>MAX_WEIGHT_PER_GROUPLER){
                    return false;
                }
            }
            return true;
        }

        private void moveItems(List<Integer> items) {

            System.out.println(Thread.currentThread().getName() + " переносит товары: " + items);

            // Имитация времени переноса
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
