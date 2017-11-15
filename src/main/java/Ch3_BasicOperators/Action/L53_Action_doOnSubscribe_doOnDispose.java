package Ch3_BasicOperators.Action;

import io.reactivex.Observable;

public class L53_Action_doOnSubscribe_doOnDispose {
    /*
     The doOnSubscribe() fires a specific Consumer<Disposable> the moment subscription
     occurs at that point in the Observable chain

     The doOnDispose() operator will perform a specific action when disposal
     is executed at that point in the Observable chain

     Issue: NO "Disposing!" displayed?
     */
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .doOnSubscribe(d -> System.out.println("Subscribing!"))
                .doOnDispose(() -> System.out.println("Disposing!"))
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}