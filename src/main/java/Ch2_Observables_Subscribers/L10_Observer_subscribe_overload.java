package Ch2_Observables_Subscribers;

import io.reactivex.Observable;

public class L10_Observer_subscribe_overload {
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        source.map(String::length).filter(i -> i >= 5)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}