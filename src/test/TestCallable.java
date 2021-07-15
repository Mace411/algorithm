package test;

import com.sun.corba.se.impl.orbutil.closure.Future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class TestCallable {

    class Call implements Callable<Integer> {

        @Override
        public Integer call() throws Exception {
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                sum += i;
            }
            return sum;
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        List<Integer> list = new ArrayList<>();
        FutureTask<List<Integer>> task = new FutureTask<>(() -> {
            int sum = 0;
            for (int i = 1; i <= 100; i++) {
                sum += i;
            }
            list.add(sum);
        }, list);
//        FutureTask<Integer> task = new FutureTask<>(() -> {
//            int sum = 0;
//            for (int i = 1; i <= 100; i++) {
//                sum += i;
//            }
//            return sum;
//        });
        Thread t = new Thread(task);
        t.start();
//        /*List<Integer> result = */task.get();
        System.err.println(list.get(0));

    }

}
