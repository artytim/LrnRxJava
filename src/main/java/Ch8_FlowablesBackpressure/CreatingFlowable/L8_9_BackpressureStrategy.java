package Ch8_FlowablesBackpressure.CreatingFlowable;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class L8_9_BackpressureStrategy {
    /*
     There are currently 5 BackpressureStrategy options to choose from...

    BackpressureStrategy

   -MISSING Essentially results in no backpressure implementation at all. The
    downstream must deal with backpressure overflow, which can be
    helpful when used with onBackpressureXXX() operators.

   -ERROR Signals a MissingBackpressureException the moment the
    downstream cannot keep up with the source.

   -BUFFER Queues up emissions in an unbounded queue until the downstream is
    able to consume them, but can cause an OutOfMemoryError if the
    queue gets too large.

   -DROP If the downstream cannot keep up, this will ignore upstream emissions
    and not queue anything while the downstream is busy.

   -LATEST This will keep only the latest emission until the downstream is ready
    to receive it.

    */
    public static void main(String[] args) {
        Flowable<Integer> source = Flowable.create(emitter -> {
            for (int i = 0; i <= 1000; i++) {
                if (emitter.isCancelled())
                    return;
                emitter.onNext(i);
            }
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER); //buffer the emissions before they are backpressured
        /*
         Note: it is possible that when Flowable.create() pushes too many emissions, you will get an
         OutOfMemoryError. But at least it prevents MissingBackpressureException...
         */
        source.observeOn(Schedulers.io())
                .subscribe(System.out::println);
        sleep(1000);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}