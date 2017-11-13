/*
If initializing your emission has a likelihood of throwing an error, you should use
Observable.fromCallable() instead of Observable.just().
 */

package Ch2_Observables_Subscribers;

import io.reactivex.Observable;

public class L27_Observable_fromCallable {
    public static void main(String[] args) {
        Observable.fromCallable(() -> 1 / 0)
                .subscribe(i -> System.out.println("Received: " + i),
                        e -> System.out.println("Error Captured: " + e));
    }
}