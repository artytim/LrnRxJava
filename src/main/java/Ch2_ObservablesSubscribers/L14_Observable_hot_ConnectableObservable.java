/*
 ConnectableObservable will take any Observable, even if it is cold, and make it hot so that
   all emissions are played to all Observers at once.

   Using ConnectableObservable to force each emission to go to all Observers simultaneously
    is known as multicasting
 */
package Ch2_ObservablesSubscribers;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class L14_Observable_hot_ConnectableObservable {
    public static void main(String[] args) {
        ConnectableObservable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
                        .publish();
//Set up observer 1
        source.subscribe(s -> System.out.println("Observer 1: " + s));
//Set up observer 2
        source.map(String::length)
                .subscribe(i -> System.out.println("Observer 2: " + i));
//Fire!
        source.connect();
    }
}