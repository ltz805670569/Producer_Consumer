package cn.itxdl.utiltwo;

import java.util.Random;

public class ProducerThread implements Runnable{
    MyStorage myStorage = new MyStorage();

    public ProducerThread(MyStorage myStorage) {
        this.myStorage = myStorage;
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
            myStorage.product(product);
        }
    }
}
