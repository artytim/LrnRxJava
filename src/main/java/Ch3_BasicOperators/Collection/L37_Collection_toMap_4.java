package Ch3_BasicOperators.Collection;

import io.reactivex.Observable;

public class L37_Collection_toMap_4 {
    /*
     Having a key that maps to multiple emissions, the last emission for that key will
      replace subsequent ones
     */
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .toMap(String::length)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}