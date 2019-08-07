package examples;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureExample {
    public static void main(String []args) throws Exception {
        Callable task = () -> {
            Thread.currentThread().sleep(2000);
            System.out.println("Done!");
            return "Hello, World!";
        };
        FutureTask<String> future = new FutureTask<>(task);
        new Thread(future).start();
        Thread.currentThread().sleep(5000);
        System.out.println(future.get());
    }
}
