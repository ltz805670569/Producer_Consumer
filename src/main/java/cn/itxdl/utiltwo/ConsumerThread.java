package cn.itxdl.utiltwo;

public class ConsumerThread implements Runnable{
    private MyStorage myStorage = new MyStorage();

    public ConsumerThread(MyStorage myStorage) {
        this.myStorage = myStorage;
    }

    @Override
    public void run() {
        for(int i=0;i<30;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myStorage.consume();
        }
    }
}
