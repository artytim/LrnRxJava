package Ch3_BasicOperators.Reducing;

import io.reactivex.Observable;

public class L25_Reducing_reduce {
    /*
    The reduce() operator is syntactically identical to scan(), but it ONLY emits the
     final accumulation when the source calls onComplete(). Depending on which overload
     you use, it can yield Single or Maybe
     */
    public static void main(String[] args) {
        Observable.just(5, 3, 7, 10, 2, 14)
                .reduce((total, next) -> total + next)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}