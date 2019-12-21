package cn.itxdl.utilfour;

import java.util.Random;

public class PushNewThread implements Runnable{
    private QueueStorage storage = new QueueStorage();

    public PushNewThread(QueueStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for(int i = 0;i<30;i++){
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Random ran = new Random();
            Integer product = ran.nextInt(100);
            storage.push(product);
        }
    }
}
