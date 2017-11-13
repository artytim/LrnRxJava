package Ch3_BasicOperators;

import io.reactivex.Observable;

public class Ch3_24 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .count()
                .subscribe(s -> System.out.println("Received: " + s));
    }
}