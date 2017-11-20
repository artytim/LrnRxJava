package Ch6_ConcurrencyParallelization.subscribeOn;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ThreadLocalRandom;

public class L6_9_Multiple_Observers_One_Thread {
    /*
     If you want only one thread to serve both Observers, multicast the operation.
     Make sure subscribeOn() is before the multicast operators
     */
    public static void main(String[] args) {
        Observable<Integer> lengths =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon")
                        .subscribeOn(Schedulers.computation())
                        .map(L6_9_Multiple_Observers_One_Thread::intenseCalculation)
                        .map(String::length)
                        .publish()
                        .autoConnect(2);
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