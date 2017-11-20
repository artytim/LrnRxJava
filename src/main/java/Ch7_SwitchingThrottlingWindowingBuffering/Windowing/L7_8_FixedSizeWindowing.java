package Ch7_SwitchingThrottlingWindowingBuffering.Windowing;

/*
 The window() operators buffer into other Observables rather than collections
 */

import io.reactivex.Observable;

public class L7_8_FixedSizeWindowing {
    public static void main(String[] args) {
        Observable.range(1, 50)
                .window(8)
                .flatMapSingle(obs -> obs.reduce("", (total,
                                                      next) -> total
                        + (total.equals("") ? "" : "|") + next))
                .subscribe(System.out::println);
    }
}