package Ch6_ConcurrencyParallelization.Schedulers;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class L6_7_X_Starting_ShuttingDown {
    /*
    Each default Scheduler is lazily instantiated when you first invoke its usage. You can
     dispose the computation(), io(), newThread(), single(), and trampoline() Schedulers
     at any time by calling their shutdown() method or all of them by calling Schedulers.shutdown().

     This will stop all their threads and forbid new tasks from coming in and will throw an error
      if you try otherwise. You can also call their start() method, or Schedulersers.start(),
      to reinitialize the Schedulers so they can accept tasks again.

    Only manage the life cycle of your Schedulers if you absolutely have to. It is better to let the
     Schedulers dynamically manage their usage of resources and keep them initialized and
     available so tasks can quickly be executed at a moment's notice.
     */

    public static void main(String[] args) {
        /*
        Build a Scheduler off a standard Java ExecutorService to have more custom and
         fine-tuned control over your thread management policies:

         Create a create a new fixed ExecutorService specified with 20 threads,
         Then, wrap it inside a Scheduler implementation by calling Schedulers.from()...

        ExecutorService will likely keep your program alive indefinitely, so you have to manage
         its disposal if its life is supposed to be finite. If you want to support the life cycle
         of one Observable subscription, call its shutdown() method after the operation terminates
         or disposes via the doFinally() operator.
         
        */

        int numberOfThreads = 20;
        ExecutorService executor =
                Executors.newFixedThreadPool(numberOfThreads);
        Scheduler scheduler = Schedulers.from(executor);
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .subscribeOn(scheduler)
                .doFinally(executor::shutdown)
                .subscribe(System.out::println);
    }
}