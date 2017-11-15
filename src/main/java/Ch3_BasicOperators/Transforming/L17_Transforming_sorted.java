package Ch3_BasicOperators.Transforming;

import io.reactivex.Observable;

public class L17_Transforming_sorted {
    public static void main(String[] args) {
        Observable.just(6, 2, 5, 7, 1, 4, 9, 8, 3)
                .sorted()
                .subscribe(System.out::println);
    }
}