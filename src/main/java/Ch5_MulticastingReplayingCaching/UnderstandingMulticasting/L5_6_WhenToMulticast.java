package Ch5_MulticastingReplayingCaching.UnderstandingMulticasting;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

import java.util.concurrent.ThreadLocalRandom;

public class L5_6_WhenToMulticast {
    /*
    If there are multiple Observers, you need to find the proxy point where you can multicast
     and consolidate the upstream operations. This point is typically the boundary where
     Observers have common operations upstream and diverge into different operations downstream
     */
    public static void main(String[] args) {
        ConnectableObservable<Integer> threeRandoms =
                Observable.range(1, 3)
                        .map(i -> randomInt()).publish();

        //Observer 1 - print each random integer
        threeRandoms.subscribe(i -> System.out.println("Observer 1: " + i));

        //Observer 2 - sum the random integers, then print
        threeRandoms.reduce(0, (total, next) -> total + next)
                .subscribe(i -> System.out.println("Observer 2: " + i));

        threeRandoms.connect();
    }

    public static int randomInt() {
        return ThreadLocalRandom.current().nextInt(100000);
    }
}