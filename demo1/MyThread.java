public class MyThread {
    public static void main(String[] args) throws Exception {
        //创建3个线程,每个线程每隔1秒输出一次hello,共3次
        Thread[] tArray = new Thread[3];
        for(int i=0; i<tArray.length; i++) {
            tArray[i] = new Thread(new Runnable(){
                    public void run() {
                        for(int j=0;j<3;j++) {
                            System.out.println("hello"+j);
                            try{Thread.sleep(1000); /*休眠1秒*/} catch(Exception e) {}
                        }
                    }
                });
            //启动线程
            tArray[i].start();
        }
        /*等待子线程结束*/
        for(Thread t : tArray) {
            t.join();
        }
        System.out.println("done!");
    }
}