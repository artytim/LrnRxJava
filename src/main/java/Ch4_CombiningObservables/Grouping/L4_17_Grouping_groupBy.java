package Ch4_CombiningObservables.Grouping;

import io.reactivex.Observable;
import io.reactivex.observables.GroupedObservable;

public class L4_17_Grouping_groupBy {
    /*
     groupBy() accepts a lambda mapping each emission to a key and returns an
      Observable<GroupedObservable<K,T>>, which emits a GroupedObservable, having
      the key K value accessible as a property, emitting the T emissions that
      are mapped for that given key
     */
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        //Use groupBy() to group emissions for an Observable<String> by each String's length
        Observable<GroupedObservable<Integer, String>> byLengths =
                source.groupBy(s -> s.length());
    }
}