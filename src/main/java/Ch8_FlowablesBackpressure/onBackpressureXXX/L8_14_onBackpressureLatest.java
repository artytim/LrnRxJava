package Ch8_FlowablesBackpressure.onBackpressureXXX;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class L8_14_onBackpressureLatest {
    /*
     onBackPressureLatest() will retain the latest value from the source while the downstream is busy,
     and once the downstream is free to process more, it will provide the latest value.
     */
    public static void main(String[] args) {
        Flowable.interval(1, TimeUnit.MILLISECONDS)
                .onBackpressureLatest()
                .observeOn(Schedulers.io())
                .subscribe(i -> {
                    sleep(5);
                    System.out.println(i);
                });
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