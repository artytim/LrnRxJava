package Ch6_ConcurrencyParallelization.Parallelization;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

public class L6_17_Parallelization {
    /*
     Create a Observable off each emission, used subscribeOn() to emit it on the
      computation Scheduler, and then performed the intenseCalculation(),
      which will occur on one of the computation threads. Each instance will request its own
      thread from the computation Scheduler, and flatMap() will merge all of them safely back
      into a serialized stream.
     */
    public static void main(String[] args) {
        Observable.range(1, 10)
                .flatMap(i -> Observable.just(i)
                        .subscribeOn(Schedulers.computation())
                        .map(i2 -> intenseCalculation(i2))
                )
                .subscribe(i -> System.out.println("Received " + i +
                        " "
                        + LocalTime.now() + " on thread "
                        + Thread.currentThread().getName()));
        sleep(20000);
    }

    public static <T> T intenseCalculation(T value) {
        sleep(ThreadLocalRandom.current().nextInt(3000));
        return value;
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}