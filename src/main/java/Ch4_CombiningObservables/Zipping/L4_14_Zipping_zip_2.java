package Ch4_CombiningObservables.Zipping;

import io.reactivex.Observable;

import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class L4_14_Zipping_zip_2 {
    /*
    Zipping can also be helpful in slowing down emissions using Observable.interval()

    Zip each string with a 1-second interval. This will slow each string emission by
    one second
     */
    public static void main(String[] args) {
        Observable<String> strings =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        Observable<Long> seconds =
                Observable.interval(1, TimeUnit.SECONDS);
        Observable.zip(strings, seconds, (s, l) -> s)
                .subscribe(s ->
                        System.out.println("Received " + s +
                                " at " + LocalTime.now())
                );
        sleep(6000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}