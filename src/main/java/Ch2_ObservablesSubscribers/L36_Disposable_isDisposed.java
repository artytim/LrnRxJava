package Ch2_ObservablesSubscribers;

import io.reactivex.Observable;

public class L36_Disposable_isDisposed {
    public static void main(String[] args) {
        Observable<Integer> source =
                Observable.create(observableEmitter -> {
                    try {
                        for (int i = 0; i < 1000; i++) {
                            while (!observableEmitter.isDisposed()) {
                                observableEmitter.onNext(i);
                            }
                            if (observableEmitter.isDisposed())
                                return;
                        }
                        observableEmitter.onComplete();
                    } catch (Throwable e) {
                        observableEmitter.onError(e);
                    }
                });
    }
}