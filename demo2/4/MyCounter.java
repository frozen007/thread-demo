public class MyCounter {
    public static int counter=0;

    public static void main(String[] args) throws Exception {
        //定义线程
        Runnable r = new Runnable(){
            public void run() {
                for(int i=0;i<10000;i++) {
                    synchronized(MyCounter.class) {
                        //用MyCounter.class锁来阻止并发访问
                        counter++;
                    }
                }
            }
        };
        //创建并启动线程
        Thread t1 = new Thread(r);
        t1.start();
        Thread t2 = new Thread(r);
        t2.start();
        //等待线程结束
        t1.join();t2.join();
        System.out.println(counter);
    }
}