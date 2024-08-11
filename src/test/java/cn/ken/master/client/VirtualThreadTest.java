package cn.ken.master.client;

public class VirtualThreadTest {


    public static void main(String[] args) {
        Runnable r = () -> {};
        Thread.ofVirtual().start(r);

    }
}
