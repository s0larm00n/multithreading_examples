package examples;

import java.util.concurrent.Exchanger;

public class ExchangerExample {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        Runnable task = () -> {
            try {
                Thread thread = Thread.currentThread();
                String withThreadName = exchanger.exchange(thread.getName());
                System.out.println(thread.getName() + " обменялся с " + withThreadName);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        new Thread(task).start();
        new Thread(task).start();
    }
}
