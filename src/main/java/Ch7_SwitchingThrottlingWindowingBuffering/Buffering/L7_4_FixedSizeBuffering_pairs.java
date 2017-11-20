package Ch7_SwitchingThrottlingWindowingBuffering.Buffering;

import io.reactivex.Observable;

public class L7_4_FixedSizeBuffering_pairs {
    /*
     Emit the "previous" emission and the next emission together...
     */
    public static void main(String[] args) {
        Observable.range(1, 10)
                .buffer(2, 1)
                .filter(c -> c.size() == 2)
                .subscribe(System.out::println);
    }
}