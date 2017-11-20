package Ch7_SwitchingThrottlingWindowingBuffering.Windowing;

import io.reactivex.Observable;

public class L7_9_FixedSizeWindowing_skip {
    public static void main(String[] args) {
        Observable.range(1, 50)
                .window(2, 3)
                .flatMapSingle(obs -> obs.reduce("", (total,
                                                      next) -> total
                        + (total.equals("") ? "" : "|") + next))
                .subscribe(System.out::println);
    }
}