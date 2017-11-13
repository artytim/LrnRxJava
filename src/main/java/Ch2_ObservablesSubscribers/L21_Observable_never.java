/*
 Observable.never() forever leaving observers waiting for emissions but
  never actually giving any
 */
package Ch2_ObservablesSubscribers;

import io.reactivex.Observable;

public class L21_Observable_never {
    public static void main(String[] args) {
        Observable<String> empty = Observable.never();
        empty.subscribe(System.out::println,
                Throwable::printStackTrace,
                () -> System.out.println("Done!"));
        sleep(5000);
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}