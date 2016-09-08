package effective;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by fred on 8/25/16.
 */
public class ThreadPoolPlay {

    public static void main(String[] args) {
        /**
         *

//        ExecutorService tpe = Executors.newCachedThreadPool();
        ExecutorService pool = Executors.newFixedThreadPool(3);
//        ExecutorService tpe = Executors.newSingleThreadExecutor();
//        ExecutorService tpe = Executors.newScheduledThreadPool(3);

        ThreadPoolPlay tp = new ThreadPoolPlay();

//        Worker[] ws = new Worker[5];
//        for(int i = 0; i < 5; i++) {
//            ws[i] = tp.new Worker(i);
//            tpe.execute(ws[i]);
//        }

        List<Future<Integer>> resultList = new ArrayList<>();
        FactorialCalculator[] ws = new FactorialCalculator[5];
        for(int i = 0; i < 5; i++) {
            ws[i] = tp.new FactorialCalculator(i);
            resultList.add(pool.submit(ws[i]));
        }


        for(int i = 0; i < resultList.size(); i++) {
            Future<Integer> result = resultList.get(i);
            Integer number = null;
            try {
                number = result.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }

            System.out.printf("Task%d calculate result: %d\n", i, number);
        }

        pool.shutdown();
         */

        String path = "skdjfskjdfkshffs./";
        if(path.endsWith("/")) {
            path = path.substring(0,path.length()-1);
        }
        System.out.println(path);


    }

    class Worker extends Thread {
        private int id;

        public Worker(int id) {
            this.id = id;
        }

        public void run() {
            for(int i = 0; i < 100; i++) {
                System.out.println("Worker"+id+"has been done "+i+"%");
            }
        }
    }

    class FactorialCalculator implements Callable<Integer> {
        private Integer number;

        public FactorialCalculator (Integer num) {
            this.number = num;
        }

        public Integer call() throws Exception {
            int result = 1;

            if(number == 0 || number == 1) {
                result = 1;
            }else {
                for(int i = 2; i <= number; i++) {
                    result *= i;
//                    TimeUnit.MILLISECONDS.sleep(200);
                }
            }

            System.out.printf("%s: %d\n", Thread.currentThread().getName(), result);
            return result;

        }

    }
}
