package Ch3_BasicOperators.Transforming;

import io.reactivex.Observable;

/*
  defaultIfEmpty() - For a given Observable<T>, specify a default T emission
  if no emissions occur when onComplete() is called
 */
public class L15_Transforming_defaultIfEmpty {
    public static void main(String[] args) {
        Observable<String> items =
                Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon");
        items.filter(s -> s.startsWith("Z"))
                .defaultIfEmpty("None")
                .subscribe(System.out::println);
    }
}