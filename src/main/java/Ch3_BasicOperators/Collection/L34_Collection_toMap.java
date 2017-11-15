package Ch3_BasicOperators.Collection;

import io.reactivex.Observable;

public class L34_Collection_toMap {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .toMap(s -> s.charAt(0))
                .subscribe(s -> System.out.println("Received: " + s));
    }
}