package Ch5_MulticastingReplayingCaching.UnderstandingMulticasting;

import io.reactivex.Observable;
import io.reactivex.observables.ConnectableObservable;

public class L5_2_ConnectableObservable {
    /*
    Using ConnectableObservable will force emissions from the source to become hot,
     pushing a single stream of emissions to all Observers at the same time rather than
     giving a separate stream to each Observer

    Set up the Observers in advance and then call connect() to start
     firing the emissions so both Observers receive the same emissions simultaneously
    */
    public static void main(String[] args) {
        //Calling publish() on Observable returns a ConnectableObservable
        ConnectableObservable<Integer> threeIntegers =
                Observable.range(1, 3).publish();
        threeIntegers.subscribe(i -> System.out.println("Observer One:" + i));
        threeIntegers.subscribe(i -> System.out.println("Observer Two:" + i));
        threeIntegers.connect();  //start firing the emissions
    }
}