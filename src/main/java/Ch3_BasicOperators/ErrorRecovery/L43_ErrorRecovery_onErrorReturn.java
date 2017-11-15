package Ch3_BasicOperators.ErrorRecovery;

import io.reactivex.Observable;

public class L43_ErrorRecovery_onErrorReturn {
    /*
     You can supply Function<Throwable,T> to dynamically produce the value using a
      lambda. This gives you access to Throwable , which you can use to determine
      the returned value
     */
    public static void main(String[] args) {
        Observable.just(5, 2, 4, 0, 3, 2, 8)
                .map(i -> 10 / i)
                .onErrorReturn(e -> -1)
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                        e -> System.out.println("RECEIVED ERROR: " + e)
                );
    }
}