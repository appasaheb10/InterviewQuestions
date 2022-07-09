package thread;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * Java Program to demonstrate how to use CountDownLatch, *
 * Its used when a thread * needs to wait for other threads before starting its work. * * @author Javin Paul
 */
public class CountDownLatchDemo {
    List<String> stringList = Arrays.asList("A", "B");
    public static void main(String args[]) throws InterruptedException {

        CountDownLatch latch = new CountDownLatch(4);
        ThreadGroup threadGroup = new ThreadGroup("FileSearch");
        Worker first = new Worker(1000, latch, "WORKER-1",  threadGroup);
        Worker second = new Worker(2000, latch, "WORKER-2",  threadGroup);
        Worker third = new Worker(3000, latch, "WORKER-3",  threadGroup);
        Worker fourth = new Worker(4000, latch, "WORKER-4",  threadGroup);
        first.start();
        second.start();
        third.start();
        fourth.start();
        // Main thread will wait until all thread finished
         latch.await();
        //threadGroup.interrupt();
        System.out.println(Thread.currentThread().getThreadGroup());


        System.out.println(Thread.currentThread().getName() + " has finished");
    }
}

class Worker extends Thread {
    private int delay;
    private CountDownLatch latch;
    List<String> stringList = Arrays.asList("A", "B");
    public Worker(int delay, CountDownLatch latch, String name, ThreadGroup group) {
        super(group,name);
        this.delay = delay;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " has started");
            Thread.sleep(delay);
            if(stringList.contains("B")){
                latch.countDown();
            }
           /* if(latch.getCount() == 0) {
                Thread.currentThread().getThreadGroup().destroy();
            }*/
            System.out.println(Thread.currentThread().getName() + " has finished");

        } catch (InterruptedException e) {
            System.out.println("Thred intrupt");
        }
    }
}
