package Ch3_BasicOperators.ErrorRecovery;

import io.reactivex.Observable;

public class L45_ErrorRecovery_onErrorResumeNext {
    /*
     onErrorResumeNext() accepts another Observable as a parameter to emit potentially
      multiple values, not a single value, in the event of an exception
     */
    public static void main(String[] args) {
        Observable.just(5, 2, 4, 0, 3, 2, 8)
                .map(i -> 10 / i)
                .onErrorResumeNext(Observable.just(-1).repeat(3))
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                        e -> System.out.println("RECEIVED ERROR: " + e)
                );
    }
}