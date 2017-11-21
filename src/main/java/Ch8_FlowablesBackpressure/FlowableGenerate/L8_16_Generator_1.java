package Ch8_FlowablesBackpressure.FlowableGenerate;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.ThreadLocalRandom;

public class L8_16_Generator_1 {
    /*
     Flowable.generate() creates backpressure, respecting sources at a nicely abstracted level.
     It will accept a Consumer<Emitter<T>> much like Flowable.create(), but it will use a lambda
     to specify what onNext(), onComplete(), and onError() events to pass each time an item is
     requested from the upstream.
     */
    public static void main(String[] args) {
        randomGenerator(1, 10000)
                .subscribeOn(Schedulers.computation())
                .doOnNext(i -> System.out.println("Emitting " +
                        i))
                .observeOn(Schedulers.io())
                .subscribe(i -> {
                    sleep(50);
                    System.out.println("Received " + i);
                });
        sleep(10000);
    }

    static Flowable<Integer> randomGenerator(int min, int max) {
        return Flowable.generate(emitter ->
                emitter.onNext(ThreadLocalRandom.current().nextInt(min, max))
        );
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}