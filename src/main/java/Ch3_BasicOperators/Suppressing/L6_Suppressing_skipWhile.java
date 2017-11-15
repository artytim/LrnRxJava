package Ch3_BasicOperators.Suppressing;

import io.reactivex.Observable;

public class L6_Suppressing_skipWhile {
    public static void main(String[] args) {
        Observable.range(1, 100)
                .skipWhile(i -> i <= 95)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}