package Ch4_CombiningObservables.Merging;

import io.reactivex.Observable;

public class L4_8_Merging_flatMap_4 {
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        source.flatMap(s -> Observable.fromArray(s.split("")),
                (s, r) ->
                        s + "-" + r)
                .subscribe(System.out::println);
    }
}