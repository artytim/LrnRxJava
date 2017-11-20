package Ch6_ConcurrencyParallelization.RxJavaConcurrency;

import io.reactivex.Observable;

import java.util.concurrent.ThreadLocalRandom;

public class L6_2_subscribe {
    /*
    The first Observable firing Alpha, Beta, Gamma must finish first and call onComplete()
    before firing the second Observable emitting the numbers 1 through 6
     */
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .map(s -> intenseCalculation((s)))
                .subscribe(System.out::println);
        Observable.range(1, 6)
                .map(s -> intenseCalculation((s)))
                .subscribe(System.out::println);
    }

    public static <T> T intenseCalculation(T value) {
        // Emulate a long-running process
        sleep(ThreadLocalRandom.current().nextInt(3000));
        return value;
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}