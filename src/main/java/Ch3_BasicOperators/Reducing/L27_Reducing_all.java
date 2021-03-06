package Ch3_BasicOperators.Reducing;

import io.reactivex.Observable;

public class L27_Reducing_all {
    /*
     The all() operator verifies that each emission qualifies with a specified condition
      and return a Single<Boolean>. If they all pass, it will emit True. If it encounters
      one that fails, it will immediately emit False
     */
    public static void main(String[] args) {
        Observable.just(5, 3, 7, 11, 2, 14)
                .all(i -> i < 10)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}