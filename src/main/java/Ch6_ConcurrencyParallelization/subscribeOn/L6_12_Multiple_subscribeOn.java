package Ch6_ConcurrencyParallelization.subscribeOn;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class L6_12_Multiple_subscribeOn {
    /*
     if you have multiple subscribeOn() calls on a given Observable chain, the top-most one,
      or the one closest to the source, will win and cause any subsequent ones to have NO
      practical effect.
     */
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .subscribeOn(Schedulers.computation())
                .filter(s -> s.length() == 5)
                .subscribeOn(Schedulers.io())
                .subscribe(i -> System.out.println("Received " + i
                        +
                        " on thread " +
                        Thread.currentThread().getName()));
        sleep(5000);
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}