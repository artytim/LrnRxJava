package Ch3_BasicOperators.Action;

import io.reactivex.Observable;

public class L51_Action_doOnComplete {
    /*
     onComplete() allows you to fire off an action when onComplete() is called
     at the point in the Observable chain
     */
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .doOnComplete(() -> System.out.println("Source is done emitting!"))
                .map(String::length)
                .subscribe(i -> System.out.println("Received: " + i));
    }
}