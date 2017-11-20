package Ch7_SwitchingThrottlingWindowingBuffering.Buffering;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class L7_6_TimeBasedBuffering_count {
    public static void main(String[] args) {
        Observable.interval(300, TimeUnit.MILLISECONDS)
                .map(i -> (i + 1) * 300) // map to elapsed time
                //buffer emissions every 1 second, but limit the buffer size to 2
                .buffer(1, TimeUnit.SECONDS, 2)
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