package Ch7_SwitchingThrottlingWindowingBuffering.Buffering;

import io.reactivex.Observable;

public class L7_2_FixedSizeBuffering_skip {
    public static void main(String[] args) {
        Observable.range(1, 10)
                .buffer(2, 3)
                .subscribe(System.out::println);
    }
}