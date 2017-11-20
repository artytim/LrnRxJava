package Ch6_ConcurrencyParallelization.RxJavaConcurrency;

import io.reactivex.Observable;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class L6_5_KeepAlive {
    /*
    If you are using Android, JavaFX, or other frameworks that manage their own non-daemon
    threads, this is not a concern as the application will be kept alive for you
    */
    public static void main(String[] args) {
        Observable.interval(1, TimeUnit.SECONDS)
                .map(l -> intenseCalculation((l)))
                .subscribe(System.out::println);
        sleep(Long.MAX_VALUE); // keep the application alive indefinitely
    }

    public static <T> T intenseCalculation(T value) {
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