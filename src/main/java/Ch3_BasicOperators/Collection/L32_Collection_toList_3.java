package Ch3_BasicOperators.Collection;

import io.reactivex.Observable;

import java.util.concurrent.CopyOnWriteArrayList;

public class L32_Collection_toList_3 {
    /*
      Specify a different list implementation besides ArrayList to provide a
       Callable lambda as an argument to construct one
     */
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .toList(CopyOnWriteArrayList::new)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}