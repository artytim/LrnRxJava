package Ch4_CombiningObservables.Concatenating;

import io.reactivex.Observable;

public class L4_11_Concatenating_concatMap {
    /*
     concatMap() [~flatMap()] will merge each mapped Observable sequentially and
      fire it one at a time. It will only move to the next Observable when
      the current one       calls onComplete()
     */
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        source.concatMap(s -> Observable.fromArray(s.split("")))
                .subscribe(System.out::println);
    }
}