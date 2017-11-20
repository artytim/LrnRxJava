package Ch6_ConcurrencyParallelization.subscribeOn;

/*
 The subscribeOn() operator will suggest to the source Observable upstream which Scheduler
  to use and how to execute operations on one of its threads. If that source is not already tied
  to a particular Scheduler, it will use the Scheduler you specify. It will then push emissions
  all the way to the final Observer using that thread (unless you add observeOn() calls).

 You can put subscribeOn() anywhere in the Observable chain, and it will suggest to the upstream
 all the way to the origin Observable which thread to execute emissions with.
 */

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ThreadLocalRandom;

public class L6_8_Multiple_Observers {
    /*
     Having multiple Observers to the same Observable with subscribeOn() will result in each one
      getting its own thread (or have them waiting for an available thread if none are available)

     In the Observer, you can print the executing thread's name by calling
      Thread.currentThread().getName()
     */
    public static void main(String[] args) {
        Observable<Integer> lengths =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon")
                        .subscribeOn(Schedulers.computation())
                        .map(L6_8_Multiple_Observers::intenseCalculation)
                        .map(String::length);
        lengths.subscribe(i ->
                System.out.println("Received " + i + " on thread " +
                        Thread.currentThread().getName()));
        lengths.subscribe(i ->
                System.out.println("Received " + i + " on thread " +
                        Thread.currentThread().getName()));
        sleep(10000);
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