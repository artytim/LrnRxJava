package Ch4_CombiningObservables.Ambiguous;

import io.reactivex.Observable;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

public class L4_12_Ambiguous_amb {
    /*
     The Observable.amb() factory will accept an Iterable<Observable<T>> and emit
      the emissions of the first Observable that emits, while the others are
      disposed of

      This is helpful when you have multiple sources for the same data or events and
       you want the fastest one to win
     */
    public static void main(String[] args) {
//emit every second
        Observable<String> source1 =
                Observable.interval(1, TimeUnit.SECONDS)
                        .take(2)
                        .map(l -> l + 1) // emit elapsed seconds
                        .map(l -> "Source1: " + l + " seconds");
//emit every 300 milliseconds
        Observable<String> source2 =
                Observable.interval(300, TimeUnit.MILLISECONDS)
                        .map(l -> (l + 1) * 300) // emit elapsed milliseconds
                        .map(l -> "Source2: " + l + " milliseconds");
//emit Observable that emits first
        Observable.amb(Arrays.asList(source1, source2))
                .subscribe(i -> System.out.println("RECEIVED: " +
                        i));
//keep application alive for 5 seconds
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