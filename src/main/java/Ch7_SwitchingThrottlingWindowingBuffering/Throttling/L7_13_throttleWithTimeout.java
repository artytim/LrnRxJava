package Ch7_SwitchingThrottlingWindowingBuffering.Throttling;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class L7_13_throttleWithTimeout {
    /*
     throttleWithTimout() (aka debounce()) accepts time interval arguments that specify
      how long a period of inactivity (which means no emissions are coming from the source)
      must be before the last emission can be pushed forward.

      The throttleWithTimeout() is an effective way to handle excessive inputs (such as a
       user clicking on a button rapidly) and other noisy, redundant events that sporadically
       speed up, slow down, or cease.
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
                //only emit after 1 second of silence
                .throttleWithTimeout(1, TimeUnit.SECONDS)
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