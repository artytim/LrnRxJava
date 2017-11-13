/*
Completable is concerned with an action being executed, but it does not receive
any emissions. Logically, it does not have onNext() or onSuccess() to receive emissions,
but it does have onError() and onComplete():
 */
package Ch2_ObservablesSubscribers;

import io.reactivex.Completable;

public class L32_Completable {
    public static void main(String[] args) {
        //fromRunnable() will execute the specified action before calling onComplete()
        Completable.fromRunnable(() -> runProcess())
                .subscribe(() -> System.out.println("Done!"));
    }

    public static void runProcess() {
//run process here
    }
}