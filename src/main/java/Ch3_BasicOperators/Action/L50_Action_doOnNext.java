package Ch3_BasicOperators.Action;

import io.reactivex.Observable;

public class L50_Action_doOnNext {
    /*
     doOnNext() allows you to peek at each emission coming out of an operator and
     going into the next. This operator does not affect the operation or transform the
     emissions in any way
     */
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .doOnNext(s -> System.out.println("Processing: " + s))
                .map(String::length)
                .subscribe(i -> System.out.println("Received: " + i));
    }
}