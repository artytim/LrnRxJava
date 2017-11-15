package Ch3_BasicOperators.ErrorRecovery;

import io.reactivex.Observable;

public class L48_ErrorRecovery_retry {
    /*
     retry() will re-subscribe to the preceding Observable
     */
    public static void main(String[] args) {
        Observable.just(5, 2, 4, 0, 3, 2, 8)
                .map(i -> 10 / i)
                .retry()
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                        e -> System.out.println("RECEIVED ERROR: " + e)
                );
    }
}