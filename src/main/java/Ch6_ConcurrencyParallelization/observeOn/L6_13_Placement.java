package Ch6_ConcurrencyParallelization.observeOn;

/*
 The subscribeOn() operator instructs the source Observable which Scheduler to emit
 emissions on.

 The observeOn() operator will intercept emissions at that point in the Observable chain and
 switch them to a different Scheduler going forward.

 The placement of observeOn() matters - it will leave all operations upstream on the default or
 subscribeOn()-defined Scheduler, but will switch to a different Scheduler downstream.
 */

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class L6_13_Placement {
    /*
     Having an Observable emit a series of strings that are /-separated values and break them up
      on an IO Scheduler. But after that, switch to a computation Scheduler to filter only numbers
      and calculate their sum...
     */
    public static void main(String[] args) {

        //Happens on IO Scheduler
        Observable.just("WHISKEY/27653/TANGO", "6555/BRAVO",
                "232352/5675675/FOXTROT")
                .subscribeOn(Schedulers.io())
                .flatMap(s -> Observable.fromArray(s.split("/")))
//                .subscribe(System.out::println);

        //Happens on Computation Scheduler
                .observeOn(Schedulers.computation())
                .filter(s -> s.matches("[0-9]+"))
                .map(Integer::valueOf)
                .reduce((total, next) -> total + next)
                .subscribe(i -> System.out.println("Received " + i
                        + " on thread "
                        + Thread.currentThread().getName()));
        sleep(1000);
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}