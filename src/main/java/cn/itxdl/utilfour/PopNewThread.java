package cn.itxdl.utilfour;

public class PopNewThread implements Runnable{
    private QueueStorage storage = new QueueStorage();

    public PopNewThread(QueueStorage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        for(int i=0;i<30;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            storage.pop();
        }
    }
}
