package Ch6_ConcurrencyParallelization.Schedulers;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ThreadLocalRandom;

public class L6_7_Schedulers_computation {
    /*
    The subscribeOn() operator suggests to the source to fire emissions on a specified Scheduler
    (e.g., Schedulers.computation()), which pools a fixed number of threads. It will provide
    a thread to push emissions for each Observer. When onComplete() is called, the thread will
    be given back to Scheduler so it can be reused elsewhere.

    Operators and factories that use the computation Scheduler unless you specify a different one:
     interval(), delay(), timer(), timeout(), buffer(), take(), skip(), takeWhile(), skipWhile(),
     window(),...

    */
    public static void main(String[] args) {
        /*
        Both operations are firing simultaneously allowing the program to finish much
        more quickly
         */
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .subscribeOn(Schedulers.computation())  // specify a scheduler
                .map(s -> intenseCalculation((s)))
                .subscribe(System.out::println);
        Observable.range(1, 6)
                .subscribeOn(Schedulers.computation())
                .map(s -> intenseCalculation((s)))
                .subscribe(System.out::println);
        sleep(20000);
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