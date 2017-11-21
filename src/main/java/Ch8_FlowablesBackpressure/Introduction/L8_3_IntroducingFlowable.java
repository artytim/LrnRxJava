package Ch8_FlowablesBackpressure.Introduction;

import io.reactivex.Flowable;
import io.reactivex.schedulers.Schedulers;

public class L8_3_IntroducingFlowable {
    /*
     The Flowable is a backpressured variant of the Observable that tells the source to emit at
      a pace specified by the downstream operations, effectively introduces a pull dynamic to the
      push-based operation to limit how frequently the source emits.

     The benefits offered from the Flowable are leaner usage of memory (preventing OutOfMemoryError
      exceptions) aand prevention of MissingBackpressureException.

     The disadvantage of Flowable is that it adds overhead and may not perform as quickly as an
      Observable.

     Use a Flowable If...

       -You are dealing with over 10,000 elements and there is opportunity for the source
        to generate emissions in a regulated manner. This is especially true when the
        source is asynchronous and pushes large amounts of data.

       -You want to emit from IO operations that support blocking while returning
        results, which is how many IO sources work. Data sources that iterate records,
        such as lines from files or a ResultSet in JDBC, are especially easy to control
        because iteration can pause and resume as needed. Network and Streaming APIs
        that can request a certain amount of returned results can also easily be backpressured.
     */
    public static void main(String[] args) {
        Flowable.range(1, 999_999_999)
                .map(MyItem::new)
                .observeOn(Schedulers.io())
                .subscribe(myItem -> {
                    sleep(50);
                    System.out.println("Received MyItem " +
                            myItem.id);
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