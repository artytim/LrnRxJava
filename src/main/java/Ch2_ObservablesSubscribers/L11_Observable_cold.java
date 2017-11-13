//Cold Observables are much like a music CD that can be replayed to each listener, so each
//person can hear all the tracks at any time

package Ch2_ObservablesSubscribers;

import io.reactivex.Observable;

public class L11_Observable_cold {
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
//first observer
        source.subscribe(s -> System.out.println("Observer 1 Received: " + s));
//second observer
        source.subscribe(s -> System.out.println("Observer 2 Received: " + s));
    }
}