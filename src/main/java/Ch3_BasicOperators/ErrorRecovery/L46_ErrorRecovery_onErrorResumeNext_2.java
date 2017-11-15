package Ch3_BasicOperators.ErrorRecovery;

import io.reactivex.Observable;

public class L46_ErrorRecovery_onErrorResumeNext_2 {
    public static void main(String[] args) {
        /*
         Quietly stop emissions in the event that there is an error and gracefully
         call the onComplete() function
         */
        Observable.just(5, 2, 4, 0, 3, 2, 8)
                .map(i -> 10 / i)
                .onErrorResumeNext(Observable.empty())
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                        e -> System.out.println("RECEIVED ERROR: " + e)
                );
    }
}