package Ch3_BasicOperators.Collection;

import io.reactivex.Observable;

public class L30_Collection_toList {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .toList()
                .subscribe(s -> System.out.println("Received: " + s));
    }
}