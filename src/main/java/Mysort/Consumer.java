package Mysort;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    private BlockingQueue<String> blockingDeque;

    public Consumer(BlockingQueue<String> blockingDeque) {
        this.blockingDeque = blockingDeque;
    }

    public void run() {
        String str = null;
        try {
            while (true) {
                str = blockingDeque.take();
                System.out.println(Thread.currentThread().getName() + "    " + str);
                Thread.sleep((int) (Math.random() * 2000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
