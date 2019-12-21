package cn.itxdl.utiltwo;

public class ProductionTest {
    public static void main(String[] args) {

        MyStorage myStorage = new MyStorage();

        /**
         * 生产线程
         */
        ProducerThread push = new ProducerThread(myStorage);
//        Thread p1 = new Thread(push);
        Thread p2 = new Thread(push);
        Thread p3 = new Thread(push);
//        p1.setName("zhangsan");
        p2.setName("lisi");
        p3.setName("wangwu");
//        p1.start();
        p2.start();
        p3.start();

        /**
         * 消费者线程
         */
        ConsumerThread pop = new ConsumerThread(myStorage);
        Thread c1 = new Thread(pop);
        Thread c2 = new Thread(pop);
        Thread c3 = new Thread(pop);
        c1.setName("顾客一");
        c2.setName("顾客二");
        c3.setName("顾客三");
        c1.start();
        c2.start();
        c3.start();

    }
}
