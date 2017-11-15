package Ch3_BasicOperators.Reducing;

import io.reactivex.Observable;

public class L26_Reducing_reduce_2 {
    /*
     Turn the emissions into a single comma-separated value string, use reduce() like
      this...
     */
    public static void main(String[] args) {
        Observable.just(5, 3, 7, 10, 2, 14)
                .reduce("", (total, next) -> total + (total.equals("") ?
                        "" :
                        ",") + next)
                .subscribe(s -> System.out.println("Received: " +
                        s));
    }
}