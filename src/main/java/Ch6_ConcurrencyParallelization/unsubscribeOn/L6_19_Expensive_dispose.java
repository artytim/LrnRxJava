package Ch6_ConcurrencyParallelization.unsubscribeOn;

/*
 When you dispose an Observable, sometimes, that can be an expensive operation depending on the
  nature of the source (E.g., emitting the results of a database query using RxJava-JDBC), it can be
  expensive to stop and dispose that Observable because it needs to shut down the resources it is
  using.

 You  should not need to use unsubscribeOn() for lightweight operations as it adds unnecessary
  overhead. But if you have Observable operations that are heavy with resources which are slow to
  dispose of, unsubscribeOn() can be a crucial tool...
 */

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;

import java.util.concurrent.TimeUnit;

public class L6_19_Expensive_dispose {
    public static void main(String[] args) {
        Disposable d = Observable.interval(1, TimeUnit.SECONDS)
                .doOnDispose(() -> System.out.println("Disposing on thread"
                                + Thread.currentThread().getName()))
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