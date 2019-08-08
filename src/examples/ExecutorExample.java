package examples;

import java.util.concurrent.Executor;

public class ExecutorExample {
    public static void main(String[] args) throws Exception {
        Runnable task = () -> System.out.println("Task executed");
        Executor executor = (runnable) -> {
            new Thread(runnable).start();
        };
        executor.execute(task);
    }

}
