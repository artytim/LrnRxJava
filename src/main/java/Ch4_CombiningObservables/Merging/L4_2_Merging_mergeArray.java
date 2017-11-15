package Ch4_CombiningObservables.Merging;

import io.reactivex.Observable;

public class L4_2_Merging_mergeArray {
    /*
     If you have more than FOUR Observable<T> sources, you can use the
     Observable.mergeArray() to pass a varargs of Observable[] instances that you want
     to merge
     */
    public static void main(String[] args) {
        Observable<String> source1 =
                Observable.just("Alpha", "Beta");
        Observable<String> source2 =
                Observable.just("Gamma", "Delta");
        Observable<String> source3 =
                Observable.just("Epsilon", "Zeta");
        Observable<String> source4 =
                Observable.just("Eta", "Theta");
        Observable<String> source5 =
                Observable.just("Iota", "Kappa");
        Observable.mergeArray(source1, source2, source3, source4,
                source5)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}