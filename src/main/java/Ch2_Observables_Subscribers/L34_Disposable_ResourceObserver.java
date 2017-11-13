/*
If you do not want to explicitly handle the Disposable and want RxJava to handle it for you,
you can extend ResourceObserver as your Observer, which uses a default Disposable handling.
Pass this to subscribeWith() instead of subscribe(), and you will get the default Disposable returned
 */
package Ch2_Observables_Subscribers;

import io.reactivex.Observable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.ResourceObserver;

import java.util.concurrent.TimeUnit;

public class L34_Disposable_ResourceObserver {
    public static void main(String[] args) {
        Observable<Long> source =
                Observable.interval(1, TimeUnit.SECONDS);
        ResourceObserver<Long> myObserver = new
                ResourceObserver<Long>() {
                    @Override
                    public void onNext(Long value) {
                        System.out.println(value);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Done!");
                    }
                };
//capture Disposable
        Disposable disposable = source.subscribeWith(myObserver);
    }
}