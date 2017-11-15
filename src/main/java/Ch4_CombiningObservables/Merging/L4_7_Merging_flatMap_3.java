package Ch4_CombiningObservables.Merging;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class L4_7_Merging_flatMap_3 {
    /*
     Emit the values 2, 3, 10, and 7, which will yield interval Observables that
     emit at 2 seconds, 3 seconds, 10 seconds, and 7 seconds, respectively.
     These four Observables will be merged into a single stream
     */
    public static void main(String[] args) {
        Observable<Integer> intervalArguments =
                Observable.just(2, 3, 10, 7);
        intervalArguments.flatMap(i ->
                Observable.interval(i, TimeUnit.SECONDS)
                        .map(i2 -> i + "s interval: " + ((i + 1) * i) + " seconds elapsed")
        ).subscribe(System.out::println);
        sleep(12000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}