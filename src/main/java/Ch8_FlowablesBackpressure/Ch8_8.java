package Ch8_FlowablesBackpressure;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import static Ch5_MulticastingReplayingCaching.Subjects.L5_21_Subjects_2.sleep;

public class Ch8_8 {
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