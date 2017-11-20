package Ch6_ConcurrencyParallelization.RxJavaConcurrency;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class L6_1_interval_revisit {
    /*
     By default, Observables execute work on the immediate thread -- the thread that declared
      the Observer and subscribed it. But NOT all Observables will fire on the immediate thread.
     */
    public static void main(String[] args) {
        Observable.interval(1, TimeUnit.SECONDS)
                .map(i -> i + " Mississippi")
                .subscribe(System.out::println);
        sleep(5000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}