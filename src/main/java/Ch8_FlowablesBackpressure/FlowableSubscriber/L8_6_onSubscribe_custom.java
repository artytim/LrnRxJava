package Ch8_FlowablesBackpressure.FlowableSubscriber;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.ThreadLocalRandom;

import java.util.concurrent.atomic.AtomicInteger;

public class L8_6_onSubscribe_custom {
    /*
     Manage custom backpressure with your own Subscriber implementation.

     Note: The request() calls do not go all the way upstream. They only go to the preceding operator,
     which decides how to relay that request upstream.
     */
    public static void main(String[] args) {
        Flowable.range(1, 1000)
                .doOnNext(s -> System.out.println("Source pushed "
                        + s))
                .observeOn(Schedulers.io())
                .map(i -> intenseCalculation(i))
                .subscribe(new Subscriber<Integer>() {
                    //request 40 emissions initially and then 20 emissions at a time after that
                    Subscription subscription;
                    AtomicInteger count = new AtomicInteger(0);

                    @Override
                    public void onSubscribe(Subscription
                                                    subscription) {
                        this.subscription = subscription;
                        System.out.println("Requesting 40 items!");
                        subscription.request(40);
                    }

                    @Override
                    public void onNext(Integer s) {
                        sleep(50);
                        System.out.println("Subscriber received " +
                                s);
                        if (count.incrementAndGet() % 20 == 0 &&
                                count.get() >= 40)
                            System.out.println("Requesting 20 more !");
                        subscription.request(20);
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {
                        System.out.println("Done!");
                    }
                });
        sleep(20000);
    }

    public static <T> T intenseCalculation(T value) {
//sleep up to 200 milliseconds
        sleep(ThreadLocalRandom.current().nextInt(200));
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