package Ch6_ConcurrencyParallelization.unsubscribeOn;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class L6_20_unsubscribeOn {
    /*
     Use unsubscribeOn() and specify to unsubscribe on Schedulers.io()

     */
    public static void main(String[] args) {
        Disposable d = Observable.interval(1, TimeUnit.SECONDS)
                .doOnDispose(() -> System.out.println("Disposing on thread"
                                + Thread.currentThread().getName()))
                //disposal is being done by the IO Scheduler...
                .unsubscribeOn(Schedulers.io())
                .subscribe(i -> System.out.println("Received " +
                        i));
        sleep(3000);
        d.dispose();
        sleep(3000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}