package cn.itxdl.utilone;

import java.util.Random;

/**
 * 生产者
 */
public class PushThread implements Runnable{
    private WareHouse wh;

    public PushThread(WareHouse wh) {
        this.wh = wh;
    }

    @Override
    public void run() {
        for(int i=0;i<50;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Random ran = new Random();
            String product = "产品"+ ran.nextInt(100);
            wh.push(product);
        }
    }
}
