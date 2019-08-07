package examples;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String []args) throws Exception {
        // CompletableFuture уже содержащий результат
        CompletableFuture<String> completed;
        completed = CompletableFuture.completedFuture("Просто значение");
        // CompletableFuture, запускающий (run) новый поток с Runnable, поэтому он Void
        CompletableFuture<Void> voidCompletableFuture;
        voidCompletableFuture = CompletableFuture.runAsync(() -> {
            System.out.println("run " + Thread.currentThread().getName());
        });
        // CompletableFuture, запускающий новый поток, результат которого возьмём у Supplier
        CompletableFuture<String> supplier;
        supplier = CompletableFuture.supplyAsync(() -> {
            System.out.println("supply " + Thread.currentThread().getName());
            return "Значение";
        });



        //Обработка ошибок
        CompletableFuture.completedFuture(2L)
                .thenApply((a) -> {
                    throw new IllegalStateException("error");
                }).thenApply((a) -> 3L)
                //.exceptionally(ex -> 0L)
                .thenAccept(val -> System.out.println(val));
    }
}
