package Ch4_CombiningObservables.Merging;

import io.reactivex.Observable;

public class L4_5_Merging_flatMap {
    /*
     flatMap() is an operator that performs a dynamic Observable.merge() by taking each
      emission and mapping it to an Observable. Then, it merges the emissions from the
      resulting Observables into a single stream
     */
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        source.flatMap(s -> Observable.fromArray(s.split("")))
                .subscribe(System.out::println);
    }
}