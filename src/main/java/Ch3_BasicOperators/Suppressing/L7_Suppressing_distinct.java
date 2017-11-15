package Ch3_BasicOperators.Suppressing;

import io.reactivex.Observable;

public class L7_Suppressing_distinct {
    /*
      The distinct() operator will emit each unique emission, but it will suppress any
      duplicates that follow.
     */
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .map(String::length)
                .distinct()
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}