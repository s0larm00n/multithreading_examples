package examples;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import java.util.stream.Stream;

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


        List<String> array = Arrays.asList("one", "two");
        Stream<String> stringStream = array.stream().map(value -> {
            System.out.println("Executed");
            return value.toUpperCase();
        });

        System.out.println(array);


        Supplier newsSupplier = () -> {
            try {
                Thread.sleep(2000);
            }
            catch (Exception e){}
            return "the item";
        };

        CompletableFuture<String> reader = CompletableFuture.supplyAsync(newsSupplier);
        CompletableFuture.completedFuture("!!")
                .thenCombine(reader, (a, b) -> b + a)
                .thenAccept(result -> System.out.println(result))
                .get();
    }
}
