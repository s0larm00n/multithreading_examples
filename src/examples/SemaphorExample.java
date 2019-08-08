package examples;

import java.util.concurrent.Semaphore;

public class SemaphorExample {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(1);
        Runnable task = () -> {
            try {
                semaphore.acquire();
                System.out.println("Finished");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(task).start();
        Thread.sleep(5000);
        semaphore.release(1);
    }
}
