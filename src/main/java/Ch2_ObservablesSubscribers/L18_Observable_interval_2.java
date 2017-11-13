package Ch2_ObservablesSubscribers;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class L18_Observable_interval_2 {
    public static void main(String[] args) {
        Observable<Long> seconds = Observable.interval(1,
                TimeUnit.SECONDS);
//Observer 1
        seconds.subscribe(l -> System.out.println("Observer 1: " + l));
//sleep 5 seconds
        sleep(5000);
//Observer 2
        seconds.subscribe(l -> System.out.println("Observer 2: " + l));
//sleep 5 seconds
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