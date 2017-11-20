package Ch5_MulticastingReplayingCaching.Replaying_Caching;

import io.reactivex.Observable;

public class L5_19_Replaying_Caching_cache {
    /*
    The cache() operator will subscribe to the source on the first downstream Observer that
     subscribes and hold all values indefinitely
     */
    public static void main(String[] args) {
        Observable<Integer> cachedRollingTotals =
                Observable.just(6, 2, 5, 7, 1, 4, 9, 8, 3)
                        .scan(0, (total, next) -> total + next)
                        .cache();
        cachedRollingTotals.subscribe(System.out::println);
    }
}