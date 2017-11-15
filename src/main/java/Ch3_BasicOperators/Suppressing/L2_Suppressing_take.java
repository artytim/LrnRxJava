package Ch3_BasicOperators.Suppressing;

import io.reactivex.Observable;

public class L2_Suppressing_take {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                .take(3)
                .subscribe(s -> System.out.println("RECEIVED: " + s));
    }
}