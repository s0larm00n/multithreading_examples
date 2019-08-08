package examples;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierExample {
    public static void main(String[] args) throws InterruptedException {
        Runnable action = () -> System.out.println("На старт!");
        CyclicBarrier berrier = new CyclicBarrier(3, action);
        Runnable task = () -> {
            try {
                berrier.await();
                System.out.println("Finished");
            } catch (BrokenBarrierException | InterruptedException e) {
                e.printStackTrace();
            }
        };
        System.out.println("Limit: " + berrier.getParties());
        for (int i = 0; i < 3; i++) {
            new Thread(task).start();
        }
    }
}

//berrier.isBroken()
//berrier.reset()