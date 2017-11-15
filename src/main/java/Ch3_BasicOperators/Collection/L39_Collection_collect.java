package Ch3_BasicOperators.Collection;

import io.reactivex.Observable;

import java.util.HashSet;

public class L39_Collection_collect {
    /*
     When none of the collection operators have what you need, you can always use the
     collect() operator to specify a different type to collect items into
     */
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .collect(HashSet::new, HashSet::add)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}