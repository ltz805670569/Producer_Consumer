package cn.itxdl.utilthree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MyNewStorage {
    private int count = 0;
    private Queue<Object> queue = new LinkedList<>();
    private ReentrantReadWriteLock reentrantReadWriteLock;
    private static final int MAX = 20;
    private Lock readLock;
    private Lock writeLock;
    {
        reentrantReadWriteLock = new ReentrantReadWriteLock(true);
        readLock = reentrantReadWriteLock.readLock();
        writeLock = reentrantReadWriteLock.writeLock();
    }


    public void product(String product){
        writeLock.lock();
//        try {
//            while(queue.size() >= MAX){
//                try {
//                    this.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
            count++;
            queue.offer(product);
            System.out.println(Thread.currentThread().getName()+"生产者，++++++++存储了："+product);
            System.out.println(count);
//            this.notifyAll();
//        }finally {
            writeLock.unlock();
//        }
    }

    public void consume(){
        readLock.lock();
//        try{
//            while(queue.size() <= 0){
//                try {
//                    this.wait();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
            Object product = queue.poll();
            System.out.println(Thread.currentThread().getName()+"消费者，----消费了"+product);
//            this.notifyAll();
//        }finally {
            readLock.unlock();
//        }
    }
}
