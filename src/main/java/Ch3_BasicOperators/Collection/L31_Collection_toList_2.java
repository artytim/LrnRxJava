package Ch3_BasicOperators.Collection;

import io.reactivex.Observable;

public class L31_Collection_toList_2 {
    /*
     By default, toList() will use a standard ArrayList implementation. You can specify
      an integer argument to serve as the capacityHint to optimize the initialization of
      ArrayList to expect roughly that number of items
     */
    public static void main(String[] args) {
        Observable.range(1, 1000)
                .toList(1000)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}