package Ch3_BasicOperators.Collection;

import io.reactivex.Observable;

import java.util.concurrent.ConcurrentHashMap;

public class L36_Collection_toMap_3 {
    /*
     By default, toMap() will use HashMap. Provide a 3rd lambda argument to provide
      a different map implementation
     */
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .toMap(s -> s.charAt(0), String::length,
                        ConcurrentHashMap::new)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}