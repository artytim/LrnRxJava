package Ch5_MulticastingReplayingCaching.UnderstandingMulticasting;

import io.reactivex.Observable;

import java.util.concurrent.ThreadLocalRandom;

public class L5_3_Bad_MulticastingWithOperators {
    /*
    Observable.range() will yield two separate emission generators, and each will emit a
     separate stream for each Observer. Each stream also has its own separate map()
     instance, hence each Observer gets different random integers.
     */
    public static void main(String[] args) {
        Observable<Integer> threeRandoms = Observable.range(1, 3)
                .map(i -> randomInt());
        threeRandoms.subscribe(i -> System.out.println("Observer 1: " + i));
        threeRandoms.subscribe(i -> System.out.println("Observer 2: " + i));
    }

    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(100000);
    }
}