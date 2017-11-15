package Ch3_BasicOperators.Suppressing;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class L2_Suppressing_take_2 {
    public static void main(String[] args) {
        Observable.interval(300, TimeUnit.MILLISECONDS)
                .take(2, TimeUnit.SECONDS) // emit every 300 ms, but for only 2 seconds
                .subscribe(i -> System.out.println("RECEIVED: " + i));
        sleep(5000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}