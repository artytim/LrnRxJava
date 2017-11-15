package Ch3_BasicOperators.Collection;

import io.reactivex.Observable;

public class L35_Collection_toMap_2 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .toMap(s -> s.charAt(0), String::length)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}