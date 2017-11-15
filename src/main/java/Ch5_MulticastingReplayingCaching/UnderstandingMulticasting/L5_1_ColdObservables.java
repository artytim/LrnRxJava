package Ch5_MulticastingReplayingCaching.UnderstandingMulticasting;

import io.reactivex.Observable;

public class L5_1_ColdObservables {
    /*
    Two separate streams of data generated for two separate subscriptions
    */
    public static void main(String[] args) {
        Observable<Integer> threeIntegers = Observable.range(1, 3);
        threeIntegers.subscribe(i -> System.out.println("Observer One: " + i));
        threeIntegers.subscribe(i -> System.out.println("Observer Two: " + i));
    }
}