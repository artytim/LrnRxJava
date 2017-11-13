/*
 Observable.range() arguments
  The first argument is the starting value
  The second argument is the total count of emissions
 */
package Ch2_ObservablesSubscribers;

import io.reactivex.Observable;

public class L16_Observable_range_2 {
    public static void main(String[] args) {
        Observable.range(5, 10)
                .subscribe(s -> System.out.println("RECEIVED: " + s));
    }
}