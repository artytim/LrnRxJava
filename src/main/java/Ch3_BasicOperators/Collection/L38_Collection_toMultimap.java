package Ch3_BasicOperators.Collection;

import io.reactivex.Observable;

public class L38_Collection_toMultimap {
    /*
     Use toMultiMap() to make a given key to map to multiple emissions
     */
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .toMultimap(String::length)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}