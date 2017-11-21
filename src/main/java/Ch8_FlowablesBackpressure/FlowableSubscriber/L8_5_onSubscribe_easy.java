package Ch8_FlowablesBackpressure.FlowableSubscriber;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.concurrent.ThreadLocalRandom;

public class L8_5_onSubscribe_easy {
    public static void main(String[] args) {
        Flowable.range(1, 1000)
                .doOnNext(s -> System.out.println("Source pushed " + s))
                .observeOn(Schedulers.io())
                .map(i -> intenseCalculation(i))
                .subscribe(new Subscriber<Integer>() {
                    @Override
                    public void onSubscribe(Subscription
                                                    subscription) {
                        //tells the upstream "give me everything now"
                        //The operators preceding Subscriber will request emissions at their own
                        //backpressured pace, no backpressure will exist between
                        //the last operator and the Subscriber
                        subscription.request(Long.MAX_VALUE);
                    }

                    @Override
                    public void onNext(Integer s) {
                        sleep(50);
                        System.out.println("Subscriber received " +
                                s);
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