package examples;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class FutureExample {
    public static void main(String []args) throws Exception {
        Callable task = () -> {
            Thread.sleep(2000);
            System.out.println("Done!");
            return "Hello, World!";
        };
        @SuppressWarnings("unchecked")
        FutureTask<String> future = new FutureTask<>(task);
        new Thread(future).start();
        Thread.sleep(5000);
        System.out.println(future.get());
    }
}
