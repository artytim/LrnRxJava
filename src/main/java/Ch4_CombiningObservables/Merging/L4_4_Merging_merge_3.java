package Ch4_CombiningObservables.Merging;

import io.reactivex.Observable;

import java.util.concurrent.TimeUnit;

public class L4_4_Merging_merge_3 {
    /*
     You can merge multiple infinite sources into a single stream
     */
    public static void main(String[] args) {
//emit every second
        Observable<String> source1 =
                Observable.interval(1,
                        TimeUnit.SECONDS)
                        .map(l -> l + 1) // emit elapsed seconds
                        .map(l -> "Source1: " + l + " seconds");
//emit every 300 milliseconds
        Observable<String> source2 =
                Observable.interval(300, TimeUnit.MILLISECONDS)
                        .map(l -> (l + 1) * 300) // emit elapsed milliseconds
                        .map(l -> "Source2: " + l + " milliseconds");
//merge and subscribe
        Observable.merge(source1, source2)
                .subscribe(System.out::println);
//keep alive for 3 seconds
        sleep(3000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}