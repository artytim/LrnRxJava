package Ch3_BasicOperators.Transforming;

import io.reactivex.Observable;

import java.util.Comparator;

public class L18_Transforming_sorted_2 {
    public static void main(String[] args) {
        Observable.just(6, 2, 5, 7, 1, 4, 9, 8, 3)
                .sorted(Comparator.reverseOrder())
                .subscribe(System.out::println);
    }
}