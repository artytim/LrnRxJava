package Ch4_CombiningObservables.Zipping;

import io.reactivex.Observable;

public class L4_13_Zipping_zip {
    /*
     Zipping allows you to take an emission from each Observable source and combine
      it into a single emission. Each Observable can emit a different type, but you
      can combine these different emitted types into a single emission
     */
    public static void main(String[] args) {
        Observable<String> source1 =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        Observable<Integer> source2 = Observable.range(1, 6);
        Observable.zip(source1, source2, (s, i) -> s + "-" + i)
                .subscribe(System.out::println);
        // Or
        //source1.zipWith(source2, (s,i) -> s + "-" + i)
    }
}