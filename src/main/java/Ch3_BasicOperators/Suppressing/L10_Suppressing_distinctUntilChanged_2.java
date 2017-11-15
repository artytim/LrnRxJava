package Ch3_BasicOperators.Suppressing;

import io.reactivex.Observable;

public class L10_Suppressing_distinctUntilChanged_2 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Zeta", "Eta", "Gamma",
                "Delta")
                .distinctUntilChanged(String::length)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}