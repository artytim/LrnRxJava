package Ch4_CombiningObservables.Concatenating;

import io.reactivex.Observable;

public class L4_9_Concatenating_concat {
    /*
     concat() will fire elements of each provided Observable sequentially and in the order
      specified. It will not move on to the next Observable until the current one calls
      onComplete()
     */
    public static void main(String[] args) {
        Observable<String> source1 =
                Observable.just("Alpha", "Beta", "Gamma", "Delta",
                        "Epsilon");
        Observable<String> source2 =
                Observable.just("Zeta", "Eta", "Theta");
        Observable.concat(source1, source2)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}