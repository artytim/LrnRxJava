package Ch8_FlowablesBackpressure.CreatingFlowable;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import static Ch5_MulticastingReplayingCaching.Subjects.L5_21_Subjects_2.sleep;

public class L8_8_Observable_create {
    /*
    create your own Observable from scratch, which describes how to emit items when
    it is subscribed to...
     */
    public static void main(String[] args) {
        Observable<Integer> source = Observable.create(emitter -> {
            for (int i = 0; i <= 1000; i++) {
                if (emitter.isDisposed())
                    return;
                emitter.onNext(i);
            }
            emitter.onComplete();
        });
        source.observeOn(Schedulers.io())
                .subscribe(System.out::println);
        sleep(1000);
    }
}