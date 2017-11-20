package Ch6_ConcurrencyParallelization.RxJavaConcurrency;

import io.reactivex.schedulers.Schedulers;
import io.reactivex.Observable;

import java.util.concurrent.ThreadLocalRandom;

public class L6_6_KeepAliveBlocking {
    /*
    Use blocking operators to stop the declaring thread and wait for emissions

    blockingSubscribe() can be used to stop and wait for onComplete() to be called before
    the main thread is allowed to proceed and exit the application
     */
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .subscribeOn(Schedulers.computation())
                .map(L6_6_KeepAliveBlocking::intenseCalculation)
                .blockingSubscribe(System.out::println,
                        Throwable::printStackTrace,
                        () -> System.out.println("Done!"));
    }

    public static <T> T intenseCalculation(T value) {
        sleep(ThreadLocalRandom.current().nextInt(3000));
        return value;
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}