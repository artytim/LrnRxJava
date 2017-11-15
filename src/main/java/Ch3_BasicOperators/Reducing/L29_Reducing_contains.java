package Ch3_BasicOperators.Reducing;

import io.reactivex.Observable;

public class L29_Reducing_contains {
    /*
     The contains() operator will check whether a specific element (based on the
      hashCode()/equals() implementation) ever emits from an Observable
     */
    public static void main(String[] args) {
        Observable.range(1, 10000)
                .contains(9563)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}