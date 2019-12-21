package cn.itxdl.utiltwo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用可重入锁
 */
public class MyStorage {
    private Queue<Object> queue = new LinkedList<>();
    private static final int MAX = 20;
    private Lock lock;
    private Condition producerCon;
    private Condition consumerCon;
    {
        lock = new ReentrantLock();
        producerCon = lock.newCondition();
        consumerCon = lock.newCondition();
    }


    public void product(String product){
        lock.lock();
        try{
            while(queue.size() >= MAX){
                try {
                    System.out.println("仓库已满");
                    producerCon.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            queue.offer(product);
            System.out.println(Thread.currentThread().getName()+"++++++++存储了："+product);
            consumerCon.signal();
        }finally {
            lock.unlock();
        }
    }

    public void consume(){
        lock.lock();
        try{
            while(queue.size() <=0){
                try {
                    System.out.println("仓库已空");
                    consumerCon.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Object product = queue.poll();
            System.out.println(Thread.currentThread().getName()+"----消费了"+product);
            producerCon.signal();
        }finally {
            lock.unlock();
        }
    }
}
