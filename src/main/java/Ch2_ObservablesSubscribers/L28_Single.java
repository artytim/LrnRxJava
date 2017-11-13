/*
Single<T> is an Observable<T> that will only emit one item;
 it is limited only to operators that make sense for a single emission
 */
package Ch2_ObservablesSubscribers;

import io.reactivex.Single;

public class L28_Single {
    public static void main(String[] args) {
        Single.just("Hello")
                .map(String::length)
                .subscribe(System.out::println,
                        Throwable::printStackTrace);
    }
}