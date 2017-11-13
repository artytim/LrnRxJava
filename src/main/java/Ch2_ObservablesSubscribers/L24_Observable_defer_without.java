/*
When your Observable source is not capturing changes to the things driving
it, try putting it in Observable.defer().

If your Observable source was implemented naively and behaves brokenly with
more than one Observer, Observable.defer() provides a quick workaround for this
 */
package Ch2_ObservablesSubscribers;

import io.reactivex.Observable;

public class L24_Observable_defer_without {
    private static int start = 1;
    private static int count = 5;

    public static void main(String[] args) {
        Observable<Integer> source = Observable.range(start, count);
        source.subscribe(i -> System.out.println("Observer 1: " + i));
//modify count
        count = 10;
        source.subscribe(i -> System.out.println("Observer 2: " + i));
    }
}