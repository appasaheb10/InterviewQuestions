package thread;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;


public class CallableDemo  implements Callable {

    @Override
    public Integer call() throws Exception {

        // the thread is delayed for some random time
        Thread.sleep(1 * 1000);
        return new Random().nextInt(10);
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Runnable r1 = () ->
                System.out.println("My Runnable");
        System.out.println(Thread.currentThread().getName());
        //r1.run();

        FutureTask futureTask1 = new FutureTask(new CallableDemo());
        FutureTask futureTask2 = new FutureTask(new CallableDemo());
        Thread t1 = new Thread(futureTask1, "t1");
        t1.start();

        Thread t2 = new Thread(futureTask2, "t2");
        t2.start();

        System.out.println(futureTask1.isDone());
        System.out.println(futureTask1.get());
        System.out.println(futureTask1.isDone());
        System.out.println(futureTask2.get());
        System.out.println(futureTask2.isDone());
        // r1.run();
    }
}
