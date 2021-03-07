package Mysort;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable{
    private BlockingQueue<String> blockingDeque;
    private static AtomicInteger taskCount = new AtomicInteger();//自动更新的值

    public Producer(BlockingQueue<String> queue) {
        this.blockingDeque = queue;
    }

    public void run() {
        String str = null;
        try {
            while (true) {
                Thread.sleep((int)(Math.random()*2000));
                str = "-----" + taskCount.incrementAndGet();
                blockingDeque.put(str);
                System.out.println(Thread.currentThread().getName() + "    " + str);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
