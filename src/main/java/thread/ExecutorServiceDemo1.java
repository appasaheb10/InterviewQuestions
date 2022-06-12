package thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceDemo1 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService e = Executors.newSingleThreadExecutor();
        Thread thread = new Thread(new Task());
        e.submit(thread);
        e.submit(new Task());
        e.shutdown();
        e.awaitTermination(5, TimeUnit.SECONDS);
    }
}


class Task implements Runnable {

    @Override
    public void run() {
        System.out.println("Called in Task");
       /* try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }
}