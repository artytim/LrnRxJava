package Ch6_ConcurrencyParallelization.Schedulers;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class L6_7_X_TypeOfSchedulers {
    /*
    Schedulers.computation() - maintain a fixed number of threads based on the processor count
     available to your Java session, making it appropriate for computational tasks.

    Schedulers.io() is appropriate for IO tasks such as reading and writing databases, web requests,
     and disk storage, tasks that are less expensive on the CPU and often have idle time waiting for
     the data to be sent or come back. It will maintain as many threads as there are tasks and
     will dynamically grow, cache, and reduce the number of threads as needed.

        Database db = Database.from(conn);
        Observable<String> customerNames =
                db.select("SELECT NAME FROM CUSTOMER")
                        .getAs(String.class)
                        .subscribeOn(Schedulers.io());

    Schedulers.newThread() will return a Scheduler that does NOT pool threads at all. It will create
     a new thread for each Observer and then destroy the thread when it is done.

         Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .subscribeOn(Schedulers.newThread());

    Schedulers.single() is backed by a single-threaded implementation appropriate for event looping
     (running tasks sequentially on a single thread). It can also be helpful to isolate fragile,
     non-threadsafe operations to a single thread:

        Observable.just("Alpha", "Beta", "Gamma", "Delta", "Epsilon")
            .subscribeOn(Schedulers.single());

    Schedulers.trampoline() is used primarily in RxJava's internal implementation. It is just like
     default scheduling on the immediate thread, but it prevents cases of recursive scheduling where
     a task schedules a task while on the same thread, allowing the current task to finish and then
     execute that new scheduled task afterward.

    You can build a Scheduler off a standard Java ExecutorService. You may choose to do this
     in order to have more custom and fine-tuned control over your thread management policies.

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