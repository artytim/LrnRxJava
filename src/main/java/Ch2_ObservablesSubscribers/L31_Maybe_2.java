package Ch2_ObservablesSubscribers;

import io.reactivex.Observable;

public class L31_Maybe_2 {
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        source.firstElement().subscribe(  // yield a Maybe
                s -> System.out.println("RECEIVED " + s),
                Throwable::printStackTrace,
                () -> System.out.println("Done!"));
    }
}