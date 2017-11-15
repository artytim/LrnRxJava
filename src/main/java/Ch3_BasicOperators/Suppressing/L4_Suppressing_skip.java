package Ch3_BasicOperators.Suppressing;

import io.reactivex.Observable;

public class L4_Suppressing_skip {
    public static void main(String[] args) {
        Observable.range(1, 100)
                .skip(90)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}