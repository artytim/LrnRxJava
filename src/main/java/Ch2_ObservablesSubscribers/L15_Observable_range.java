/*
Observable.range() will emit each number from a start value and increment each emission until
 the specified count is reached
 */
package Ch2_ObservablesSubscribers;

import io.reactivex.Observable;

public class L15_Observable_range {
    public static void main(String[] args) {
        Observable.range(1, 10)
                .subscribe(s -> System.out.println("RECEIVED: " + s));
    }
}