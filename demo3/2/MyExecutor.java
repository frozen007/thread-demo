import java.util.concurrent.*;

public class MyExecutor {
    public static void main(String[] args) {
        Executor exe = Executors.newFixedThreadPool(3);
        exe.execute(new Runnable(){
                public void run() {
                    System.out.println("task1");
                }
            });

        exe.execute(new Runnable(){
                public void run() {
                    System.out.println("task2");
                }
            });

        exe.execute(new Runnable(){
                public void run() {
                    System.out.println("task3");
                }
            });

    }
}
    