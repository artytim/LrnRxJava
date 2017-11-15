package Ch3_BasicOperators.Suppressing;

import io.reactivex.Observable;

public class L8_Suppressing_distinct_2 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .distinct(String::length)  // key off each string's length and use it for uniqueness logic
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}