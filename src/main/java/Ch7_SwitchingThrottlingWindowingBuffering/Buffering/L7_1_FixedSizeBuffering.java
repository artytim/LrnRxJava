package Ch7_SwitchingThrottlingWindowingBuffering.Buffering;

import io.reactivex.Observable;

import java.util.HashSet;

public class L7_1_FixedSizeBuffering {
    public static void main(String[] args) {
        Observable.range(1, 50)
//                .buffer(8) // batch up emissions into lists of eight elements
                .buffer(8, HashSet::new) // put items in another collection
                .subscribe(System.out::println);
    }
}