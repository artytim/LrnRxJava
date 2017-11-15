package Ch4_CombiningObservables.Grouping;

import io.reactivex.Observable;
import io.reactivex.observables.GroupedObservable;

public class L4_18_Grouping_groupBy_2 {
    /*
     Use the groupBy() operator to group emissions for an Observable<String>
     by each String's length

     Call toList() to emit the emissions as lists grouped by their lengths
     */
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        Observable<GroupedObservable<Integer, String>> byLengths =
                source.groupBy(s -> s.length());
        byLengths.flatMapSingle(grp -> grp.toList())
                .subscribe(System.out::println);
    }
}