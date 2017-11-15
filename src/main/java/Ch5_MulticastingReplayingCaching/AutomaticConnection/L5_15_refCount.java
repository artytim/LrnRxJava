package Ch5_MulticastingReplayingCaching.AutomaticConnection;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class L5_15_refCount {
    /*
    refCount() on ConnectableObservable is similar to autoConnect(1), which fires after
     getting one subscription. But when it has no Observers anymore, it will dispose of
     itself and start over when a new one comes in
     */
    public static void main(String[] args) {
        Observable<Long> seconds =
                Observable.interval(1, TimeUnit.SECONDS)
                        .publish()
                        .refCount();
//        You can use an alias for publish().refCount() using the share() operator.
//                Observable<Long> seconds =
//                Observable.interval(1, TimeUnit.SECONDS).share();
//Observer 1
        seconds.take(5)
                .subscribe(l -> System.out.println("Observer 1: " +
                        l));
        sleep(3000);
//Observer 2
        seconds.take(2)
                .subscribe(l -> System.out.println("Observer 2: " +
                        l));
        sleep(3000);
//there should be no more Observers at this point
//Observer 3
        seconds.subscribe(l -> System.out.println("Observer 3: " +
                l));
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