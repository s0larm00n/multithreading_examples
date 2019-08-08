package examples;

import java.util.concurrent.*;

public class ThreadPoolExecutorExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int threadBound = 2;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, threadBound,
                0L, TimeUnit.SECONDS, new SynchronousQueue<>());
        Callable<String> task = () -> {
            Thread.sleep(1000);
            return Thread.currentThread().getName();
        };
        for (int i = 0; i < threadBound + 1; i++) {
            threadPoolExecutor.submit(task);
        }
        threadPoolExecutor.shutdown();
    }

}

        /*Данный код упадёт с ошибкой вида:
        Task java.util.concurrent.FutureTask@7cca494b rejected from
        java.util.concurrent.ThreadPoolExecutor@7ba4f24f[Running, pool size = 2, active threads = 2, queued tasks = 0, completed tasks = 0]
        То есть task нельзя засабмитить, т.к. SynchronousQueue устроена так,
        что фактически состоит из одного элемента и не позволяет положить
        туда больше. Как мы видим, queued tasks здесь 0, и в этом нет ничего
        странного, т.к. это специфика SynchronousQueue — фактически это очередь
        в 1 элемент, которая всегда пустая. (!) Когда один поток кладёт в очередь
        элемент, он будет ждать, пока другой поток не заберёт элемент из очереди.*/
