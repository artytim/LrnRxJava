package Ch3_BasicOperators.Transforming;

import io.reactivex.Observable;

public class L23_Transforming_scan_2 {
    /*
    Emit the rolling count of emissions - provide an initial value of 0 and  add 1 to it
     for every emission. The initial value will be emitted first, so use skip(1) after
     scan() if you do not want that initial emission.
     */
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .scan(0, (total, next) -> total + 1)
                .skip(1)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}