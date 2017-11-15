package Ch5_MulticastingReplayingCaching.UnderstandingMulticasting;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.ThreadLocalRandom;

public class L5_5_MulticastingWithOperators {
    /*
    To prevent the map() operator from yielding two separate streams for each Observer,
     call publish() after map()
     */
    public static void main(String[] args) {
        ConnectableObservable<Integer> threeRandoms =
                Observable.range(1, 3)
                        .map(i -> randomInt()).publish();
        threeRandoms.subscribe(i -> System.out.println("Observer 1: " + i));
        threeRandoms.subscribe(i -> System.out.println("Observer 2: " + i));
        threeRandoms.connect();
    }

    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(100000);
    }
}