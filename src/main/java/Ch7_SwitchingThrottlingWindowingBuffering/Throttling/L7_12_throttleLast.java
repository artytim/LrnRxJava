package Ch7_SwitchingThrottlingWindowingBuffering.Throttling;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class L7_12_throttleLast {
    /*
     The throttleLast() operator (aliased as sample()) will only emit the last item
     at a fixed time interval.
     */
    public static void main(String[] args) {
        Observable<String> source1 = Observable.interval(100,
                TimeUnit.MILLISECONDS)
                .map(i -> (i + 1) * 100) // map to elapsed time
                .map(i -> "SOURCE 1: " + i)
                .take(10);
        Observable<String> source2 = Observable.interval(300,
                TimeUnit.MILLISECONDS)
                .map(i -> (i + 1) * 300) // map to elapsed time
                .map(i -> "SOURCE 2: " + i)
                .take(3);
        Observable<String> source3 = Observable.interval(2000,
                TimeUnit.MILLISECONDS)
                .map(i -> (i + 1) * 2000) // map to elapsed time
                .map(i -> "SOURCE 3: " + i)
                .take(2);
        Observable.concat(source1, source2, source3)
                // Sample emissions by dipping into the stream on a timer
                // and pulling out the latest one
                //.throttleLast(1, TimeUnit.SECONDS)  //aliased as sample()
                //.throttleLast(2, TimeUnit.SECONDS) //reduce the sample frequency
                .throttleLast(500, TimeUnit.MILLISECONDS) // increase the sample frequency
                .subscribe(System.out::println);
        sleep(6000);
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}