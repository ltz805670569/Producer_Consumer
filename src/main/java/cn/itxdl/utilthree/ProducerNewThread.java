package cn.itxdl.utilthree;

import java.util.Random;

public class ProducerNewThread implements Runnable{
    MyNewStorage myNewStorage = new MyNewStorage();

    public ProducerNewThread(MyNewStorage myNewStorage) {
        this.myNewStorage = myNewStorage;
    }

    @Override
    public void run() {
        int count = 0;
        for(int i = 0;i<30;i++){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            count++;
            System.out.println(Thread.currentThread().getName()+":"+count);
            Random ran = new Random();
            String product = "产品编号为："+ran.nextInt(100);
            myNewStorage.product(product);
        }
    }
}
