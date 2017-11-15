package Ch3_BasicOperators.ErrorRecovery;

import io.reactivex.Observable;

public class L42_ErrorRecovery_onErrorReturnItem {
    /*
     Use onErrorReturnItem()to set a default value when an exception occurs
     */
    public static void main(String[] args) {
        Observable.just(5, 2, 4, 0, 3, 2, 8)
                .map(i -> 10 / i)
                .onErrorReturnItem(-1)
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                        e -> System.out.println("RECEIVED ERROR: " + e)
                );
    }
}