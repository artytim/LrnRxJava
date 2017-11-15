package Ch3_BasicOperators.Suppressing;

import io.reactivex.Observable;

public class L1_Suppressing_filter {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .filter(s -> s.length() != 5)
                .subscribe(s -> System.out.println("RECEIVED: " + s));
    }
}