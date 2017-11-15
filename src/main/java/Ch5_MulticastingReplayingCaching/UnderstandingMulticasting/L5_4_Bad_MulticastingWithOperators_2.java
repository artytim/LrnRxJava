package Ch5_MulticastingReplayingCaching.UnderstandingMulticasting;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.ThreadLocalRandom;

public class L5_4_Bad_MulticastingWithOperators_2 {
    /*
    Multicast after Observable.range(), but the multicasting happens before the map() operator
     */
    public static void main(String[] args) {
        ConnectableObservable<Integer> threeInts =
                Observable.range(1, 3).publish();
        Observable<Integer> threeRandoms = threeInts.map(i ->
                randomInt());
        threeRandoms.subscribe(i -> System.out.println("Observer 1: " + i));
        threeRandoms.subscribe(i -> System.out.println("Observer 2: " + i));
        threeInts.connect();
    }

    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(100000);
    }
}
