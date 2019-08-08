package examples;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class FunctionalInterfacesJava8 {
    public static void main(String[] args) {
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return "String";
            }
        };
        Consumer<String> consumer = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        Function<String, Integer> converter = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return Integer.valueOf(s);
            }
        };

        Supplier<String> supplier2 = () -> "String";
        Consumer<String> consumer2 = s -> System.out.println(s);
        Function<String, Integer> converter2 = s -> Integer.valueOf(s);
    }
}
