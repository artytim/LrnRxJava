/*
 Observable.empty() create an Observable that emits nothing and calls onComplete()
 */
package Ch2_Observables_Subscribers;

import io.reactivex.Observable;

public class L20_Observable_empty {
    public static void main(String[] args) {
        Observable<String> empty = Observable.empty();
        empty.subscribe(System.out::println,
                Throwable::printStackTrace,
                () -> System.out.println("Done!"));
    }
}