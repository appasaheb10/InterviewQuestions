package thread.coding;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Predicate;
//https://www.java67.com/2015/06/java-countdownlatch-example.html
public class ProducerConsumer {
    private Queue<String> queue = new LinkedList<String>();
    private int max;
    private ReentrantLock lock = new ReentrantLock(true);
    private Condition notFull = lock.newCondition();
    private Condition notEmpty = lock.newCondition();
   /* Object notFull = new Object();
    Object notEmpty = new Object();*/

    public ProducerConsumer(int size) {
        this.max = size;
    }

    public void put() throws InterruptedException {
        lock.lock();
        int i = 0;
        try {
            while(true) {
                while (queue.size() == max) {
                    notFull.await();
                }
                queue.add(++i + "");
                notEmpty.signalAll();
                Thread.sleep(1000);
            }
        }finally {
            lock.unlock();
        }
    }

    public void take() throws InterruptedException {

        while (true) {
            lock.lock();
            try {
                while (queue.size() == 0) {
                    notEmpty.wait();
                }
                System.out.println(queue.remove());
                notFull.signalAll();
            } finally {
                lock.unlock();
            }
        }

    }



    /*public synchronized void put(String msg) throws InterruptedException {
        //try {
            if (queue.size() == max) {
                notFull.wait();
            }
            queue.add(msg);
        notFull.notifyAll();
        *//*}finally {
        }*//*
    }

    public synchronized String take() throws InterruptedException {
        //try {
            if (queue.size() == 0) {

                notFull.wait();
            }
            String msg = queue.remove();
        notFull.notifyAll();
            return msg;
        *//*} finally {

        }*//*
    }*/

    static volatile Boolean stop = false;
    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer(2);
        int i=0;
         new Thread(() -> {
                 try {
                     producerConsumer.put();
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
        }).start();


        new Thread(() -> {
                try {
                    producerConsumer.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
        }).start();

    }

}


