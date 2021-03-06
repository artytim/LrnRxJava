package Ch3_BasicOperators.ErrorRecovery;

import io.reactivex.Observable;

public class L41_ErrorRecovery_onError {
    public static void main(String[] args) {
        Observable.just(5, 2, 4, 0, 3, 2, 8)
                .map(i -> 10 / i)
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                        e -> System.out.println("RECEIVED ERROR: " + e)
                );
    }
}