package Ch7_SwitchingThrottlingWindowingBuffering.Buffering;

import io.reactivex.Observable;

public class L7_3_FixedSizeBuffering_skip_rolling {
    /*
     Making skip less than count produces some interesting rolling buffers...
     */
    public static void main(String[] args) {
        Observable.range(1, 10)
                .buffer(3, 1)
                .subscribe(System.out::println);
    }
}