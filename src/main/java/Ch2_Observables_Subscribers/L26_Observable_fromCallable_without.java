/*
The error was emitted to the Observer rather than being thrown where it occurred.
 */

package Ch2_Observables_Subscribers;

import io.reactivex.Observable;

public class L26_Observable_fromCallable_without {
    public static void main(String[] args) {
        Observable.just(1 / 0)
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                        e -> System.out.println("Error Captured: " + e));
    }
}