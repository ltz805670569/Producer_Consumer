package cn.itxdl.utilone;

/**
 * 消费者
 */
public class PopThread implements Runnable{
    private WareHouse wh;
    public PopThread(WareHouse wh) {
        this.wh = wh;
    }
    @Override
    public void run() {
      for(int i=0;i<50;i++){
          try {
              Thread.sleep(800);
          } catch (InterruptedException e) {
              e.printStackTrace();
          }
          wh.pop();
      }
    }
}
