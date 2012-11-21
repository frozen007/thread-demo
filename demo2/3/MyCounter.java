public class MyCounter {
    public static int counter=0;

    public static void main(String[] args) throws Exception {
        
        Runnable r = new Runnable(){
            public void run() {
                for(int i=0;i<10000;i++) {
                    synchronized(MyCounter.class) {
                        counter++;
                    }
                }
            }
        };
        Thread t1 = new Thread(r);
        t1.start();
        Thread t2 = new Thread(r);
        t2.start();
        t1.join();t2.join();
        System.out.println(counter);
        int a=0;
        a++;
    }
}