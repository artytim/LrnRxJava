package Ch5_MulticastingReplayingCaching.Replaying_Caching;

import io.reactivex.Observable;

public class L5_17_Replaying_Caching_replay_2 {
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma",
                        "Delta", "Epsilon")
                        .replay(1)
                        .autoConnect(); // the second Observer will ONLY receive the last value
//Observer 1
        source.subscribe(l -> System.out.println("Observer 1: " +
                l));
//Observer 2
        source.subscribe(l -> System.out.println("Observer 2: " +
                l));
    }
}