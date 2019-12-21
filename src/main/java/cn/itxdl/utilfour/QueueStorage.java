package cn.itxdl.utilfour;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 阻塞队列
 */
public class QueueStorage {
    private BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(10);

    public void push(Integer product)  {

        try {
            queue.put(product);
            System.out.println(Thread.currentThread().getName()+"++++++++存储产品："+product);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void pop(){
        try {
            Integer product = queue.take();
            System.out.println(Thread.currentThread().getName()+"----消费产品："+product);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
