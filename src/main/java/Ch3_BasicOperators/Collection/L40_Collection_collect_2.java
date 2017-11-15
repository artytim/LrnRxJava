package Ch3_BasicOperators.Collection;

import com.google.common.collect.ImmutableList;
import io.reactivex.Observable;

public class L40_Collection_collect_2 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .collect(ImmutableList::builder,
                        ImmutableList.Builder::add)
                .map(ImmutableList.Builder::build)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}