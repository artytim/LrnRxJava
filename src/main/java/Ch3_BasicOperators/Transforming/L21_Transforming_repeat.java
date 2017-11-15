package Ch3_BasicOperators.Transforming;

import io.reactivex.Observable;

public class L21_Transforming_repeat {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .repeat(2)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}