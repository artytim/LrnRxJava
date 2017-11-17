package Ch5_MulticastingReplayingCaching.Replaying_Caching;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class L5_16_Replaying_Caching_replay {
    /*
    The replay() operator is a powerful way to hold onto previous emissions within a certain
    scope and re-emit them when a new Observer comes in.
     */
    public static void main(String[] args) {
        Observable<Long> seconds =
                Observable.interval(1, TimeUnit.SECONDS)
                        .replay()  // multicast and replay previous integer emissions
                        .autoConnect();
//Observer 1
        seconds.subscribe(l -> System.out.println("Observer 1: " +
                l));
        sleep(3000);
//Observer 2
        seconds.subscribe(l -> System.out.println("Observer 2: " +
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