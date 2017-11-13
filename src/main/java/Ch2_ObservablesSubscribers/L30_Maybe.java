/*
MaybeObserver is like a standard Observer, but onNext() is called onSuccess() instead
 */
package Ch2_ObservablesSubscribers;

import io.reactivex.Maybe;

public class L30_Maybe {
    public static void main(String[] args) {
// has emission
        Maybe<Integer> presentSource = Maybe.just(100);
        presentSource.subscribe(s -> System.out.println("Process 1 received:" + s),
                Throwable::printStackTrace,
                () -> System.out.println("Process 1 done!"));
//no emission
        Maybe<Integer> emptySource = Maybe.empty();
        emptySource.subscribe(s -> System.out.println("Process 2 received:" + s),
                Throwable::printStackTrace,
                () -> System.out.println("Process 2 done!"));
    }
}