package Ch3_BasicOperators.Transforming;

import io.reactivex.Observable;

public class L19_Transforming_sorted_3 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .sorted((x, y) -> Integer.compare(x.length(), y.length()))
                .subscribe(System.out::println);
    }
}