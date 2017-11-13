package Ch2_ObservablesSubscribers;

import io.reactivex.Observable;

public class L12_Observable_cold_2 {
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
//first observer
        source.subscribe(s -> System.out.println("Observer 1 Received: " + s));
//second observer
//  Using operators such as map() and filter() against a cold
//  Observable will still maintain the cold nature of the yielded Observables
        source.map(String::length).filter(i -> i >= 5)
                .subscribe(s -> System.out.println("Observer 2 Received: " + s));
    }
}