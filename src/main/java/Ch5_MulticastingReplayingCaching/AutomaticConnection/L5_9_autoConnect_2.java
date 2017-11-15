package Ch5_MulticastingReplayingCaching.AutomaticConnection;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class L5_9_autoConnect_2 {
    public static void main(String[] args) {
        Observable<Long> seconds =
                Observable.interval(1, TimeUnit.SECONDS)
                        .publish()
                        .autoConnect(); // numberOfSubscribers is default to 1
//Observer 1
        seconds.subscribe(i -> System.out.println("Observer 1: " + i));
        sleep(3000);
//Observer 2
        seconds.subscribe(i -> System.out.println("Observer 2: " + i));
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