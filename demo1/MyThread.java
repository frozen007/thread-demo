public class MyThread {
    public static void main(String[] args) throws Exception {
        //����3���߳�,ÿ���߳�ÿ��1�����һ��hello,��3��
        Thread[] tArray = new Thread[3];
        for(int i=0; i<tArray.length; i++) {
            tArray[i] = new Thread(new Runnable(){
                    public void run() {
                        for(int j=0;j<3;j++) {
                            System.out.println("hello"+j);
                            try{Thread.sleep(1000); /*����1��*/} catch(Exception e) {}
                        }
                    }
                });
            //�����߳�
            tArray[i].start();
        }
        /*�ȴ����߳̽���*/
        for(Thread t : tArray) {
            t.join();
        }
        System.out.println("done!");
    }
}