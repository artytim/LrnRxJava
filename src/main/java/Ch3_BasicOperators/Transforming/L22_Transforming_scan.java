package Ch3_BasicOperators.Transforming;

import io.reactivex.Observable;

public class L22_Transforming_scan {
    /*
     emit the rolling sum for each emission by passing a lambda to the scan() method
      that adds each next emission to the accumulator
     */
    public static void main(String[] args) {
        Observable.just(5, 3, 7, 10, 2, 14)
                .scan((accumulator, next) -> accumulator + next)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}