import java.util.ArrayList;

public class MyProConsume {
	public static ArrayList<String> dataList = new ArrayList<String>();
	
	public static void main(String[] args) {
		Producer p = new Producer();
		p.start();
		Consumer c = new Consumer();
		c.start();
	}

	static class Producer extends Thread {
		public void run() {
			for(int i=0;i<10000;i++) {
				synchronized(dataList) {
					dataList.add("data"+i);
					dataList.notify();
				}
			}
		}
	}
	
	static class Consumer extends Thread {
		public void run() {
			while(true) {
				 synchronized(dataList) {
					if(dataList.isEmpty()) {
						try{
							dataList.wait();
						}catch(Exception e) {
						}
						continue;
					}
					String data = dataList.remove(0);
					System.out.println(data);
				 }
			}
		}
	}
}