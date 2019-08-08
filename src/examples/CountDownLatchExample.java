package examples;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchExample {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        Runnable task = () -> {
            try {
                countDownLatch.countDown();
                System.out.println("Countdown: " + countDownLatch.getCount());
                countDownLatch.await();
                System.out.println("Finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        for (int i = 0; i < 3; i++) {
            try{
                Thread.sleep(100);
            }
            catch (Exception e){}
            new Thread(task).start();
        }
    }
}
