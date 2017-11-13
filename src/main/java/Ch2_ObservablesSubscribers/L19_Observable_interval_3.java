/*
 Use ConnectableObservable to force the emissions to become hot
 */
package Ch2_ObservablesSubscribers;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.TimeUnit;

public class L19_Observable_interval_3 {
    public static void main(String[] args) {
        ConnectableObservable<Long> seconds =
                Observable.interval(1, TimeUnit.SECONDS).publish();
//observer 1
        seconds.subscribe(l -> System.out.println("Observer 1: " + l));
        seconds.connect();
//sleep 5 seconds
        sleep(5000);
//observer 2
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