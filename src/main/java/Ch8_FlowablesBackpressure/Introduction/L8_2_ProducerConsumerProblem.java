package Ch8_FlowablesBackpressure.Introduction;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

public class L8_2_ProducerConsumerProblem {
    /*
     The emissions are being pushed much faster than the Observer can process them, and because
      backlogged emissions get queued by observeOn() in an unbounded manner, this could lead to
      many problems, including OutOfMemoryError exceptions
     */
    public static void main(String[] args) {
        Observable.range(1, 999_999_999)
                .map(MyItem::new)
                .observeOn(Schedulers.io()) // The source is no longer in charge of pushing...
                .subscribe(myItem -> {
                    sleep(50);
                    System.out.println("Received MyItem " + myItem.id);
                });
        sleep(Long.MAX_VALUE);
    }

    static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static final class MyItem {
        final int id;

        MyItem(int id) {
            this.id = id;
            System.out.println("Constructing MyItem " + id);
        }
    }
}