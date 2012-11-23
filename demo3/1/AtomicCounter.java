import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    public static AtomicInteger atomicInt = new AtomicInteger();
    
    public static void main(String[] args) throws Exception {
        Runnable r = new Runnable(){
            public void run() {
                for(int i=0;i<10000;i++) {
                    atomicInt.incrementAndGet();
                }
            }
        };
        Thread t1 = new Thread(r);
        t1.start();
        Thread t2 = new Thread(r);
        t2.start();
        t1.join();t2.join();
        System.out.println(atomicInt.intValue());

    }
}