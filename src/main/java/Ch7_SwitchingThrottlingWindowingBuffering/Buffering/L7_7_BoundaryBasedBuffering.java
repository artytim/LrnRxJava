package Ch7_SwitchingThrottlingWindowingBuffering.Buffering;

/*
 The idea of an Observable serving as a cut-off for another Observable is a powerful pattern.
 */

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class L7_7_BoundaryBasedBuffering {
    public static void main(String[] args) {
        Observable<Long> cutOffs =
                Observable.interval(1, TimeUnit.SECONDS);
        Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(i -> (i + 1) * 300) // map to elapsed time
                .buffer(cutOffs) //Use the timing of the emission as the buffer cut-off
                .subscribe(System.out::println);
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