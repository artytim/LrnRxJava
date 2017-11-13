package Ch2_ObservablesSubscribers;

import io.reactivex.Observable;

public class L8_Observer_lambdas {
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        source.map(String::length).filter(i -> i >= 5)
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                        Throwable::printStackTrace,
                        () -> System.out.println("Done!"));
    }
}