package Ch8_FlowablesBackpressure.CreatingFlowable;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class L8_10_ObservableToFlowable {
    public static void main(String[] args) {
        Observable<Integer> source = Observable.range(1, 1000);
        source.toFlowable(BackpressureStrategy.BUFFER)
                .observeOn(Schedulers.io())
                .subscribe(System.out::println);
        sleep(10000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}