package Ch3_BasicOperators.Suppressing;

import io.reactivex.Observable;

public class L5_Suppressing_takeWhile {
    public static void main(String[] args) {
        Observable.range(1, 100)
                .takeWhile(i -> i < 5)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}