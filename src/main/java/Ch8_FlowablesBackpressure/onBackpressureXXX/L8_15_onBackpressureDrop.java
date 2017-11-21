package Ch8_FlowablesBackpressure.onBackpressureXXX;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.TimeUnit;

public class L8_15_onBackpressureDrop {
    /*
     The onBackpressureDrop()will simply discard emissions if the downstream is too busy
     to process them...
     */
    public static void main(String[] args) {
        Flowable.interval(1, TimeUnit.MILLISECONDS)
                .onBackpressureDrop(i ->
                        System.out.println("Dropping " + i))
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