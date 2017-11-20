package Ch6_ConcurrencyParallelization.subscribeOn;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class L6_11_Ignore_subscribeOn {
    /*
    Observable.interval() will use Schedulers.computation() and will ignore any subscribeOn()
    you specify otherwise. But you can provide a third argument to specify a different Scheduler
    to use
    */
    public static void main(String[] args) {
        Observable.interval(1, TimeUnit.SECONDS,
                Schedulers.newThread())
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