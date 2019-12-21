package cn.itxdl.utilone;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 仓库
 */
public class WareHouse {
    //队列遵守先进先出
   private Queue<Object> queue = new LinkedList<>();
   private static final int MAX = 20;
//   private int count = 0;

    /**
     * 入库
     * @param product
     */
   public synchronized void push(String product){
       while(queue.size() > MAX){
           try {
               System.out.println("仓库已满");
               this.wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
//       count++;
       queue.offer(product);
       System.out.println(Thread.currentThread().getName()+"++++++++存储了："+product);
//       System.out.println(count);
       this.notifyAll();
   }

    /**
     * 出库
     */
   public synchronized void pop(){
       while(queue.size() <= 0){
           try {
               System.out.println("仓库已空");
               this.wait();
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
       }
       Object product = queue.poll();
       System.out.println(Thread.currentThread().getName()+"----消费了："+product);
       this.notifyAll();
   }
}
