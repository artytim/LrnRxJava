package Ch3_BasicOperators.Reducing;

import io.reactivex.Observable;

public class L24_Reducing_count {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .count()
                .subscribe(s -> System.out.println("Received: " + s));
    }
}