package examples;

public class RaceConditionExample {
    public static int value = 0;

    public static void main(String[] args) {
        Runnable task = () -> {
            for (int i = 0; i < 10000; i++) {
                int oldValue = value;
                int newValue = ++value;
                if (oldValue + 1 != newValue) {
                    throw new IllegalStateException(oldValue + " + 1 = " + newValue);
                }
            }
        };
        new Thread(task).start();
        new Thread(task).start();
        new Thread(task).start();
    }
}
