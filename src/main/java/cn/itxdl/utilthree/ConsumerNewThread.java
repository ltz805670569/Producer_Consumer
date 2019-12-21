package cn.itxdl.utilthree;

public class ConsumerNewThread implements Runnable{
    MyNewStorage myNewStorage = new MyNewStorage();

    public ConsumerNewThread(MyNewStorage myNewStorage) {
        this.myNewStorage = myNewStorage;
    }

    @Override
    public void run() {
        for(int i=0;i<30;i++){
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myNewStorage.consume();
        }
    }
}
