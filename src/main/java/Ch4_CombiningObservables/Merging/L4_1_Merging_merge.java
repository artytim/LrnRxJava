package Ch4_CombiningObservables.Merging;

import io.reactivex.Observable;

public class L4_1_Merging_merge {
    public static void main(String[] args) {
        Observable<String> source1 =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        Observable<String> source2 =
                Observable.just("Zeta", "Eta", "Theta");
        Observable.merge(source1, source2)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
        // Or use mergeWith(),
//        source1.mergeWith(source2)
//                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}