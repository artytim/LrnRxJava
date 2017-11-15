package Ch3_BasicOperators.ErrorRecovery;

import io.reactivex.Observable;

public class L47_ErrorRecovery_onErrorResumeNext_3 {
    public static void main(String[] args) {
        Observable.just(5, 2, 4, 0, 3, 2, 8)
                .map(i -> 10 / i)
                .onErrorResumeNext((Throwable e) ->
                        Observable.just(-1).repeat(3))
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                        e -> System.out.println("RECEIVED ERROR: " + e)
                );
    }
}