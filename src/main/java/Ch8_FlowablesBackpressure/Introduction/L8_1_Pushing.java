package Ch8_FlowablesBackpressure.Introduction;

import io.reactivex.Observable;

public class L8_1_Pushing {
    /*
     Observables push items synchronously and one at a time from the source all the way to
     the Observer (by default without concurrency).
     */
    public static void main(String[] args) {
        Observable.range(1, 999_999_999)
                .map(MyItem::new)
                .subscribe(myItem -> {
                    sleep(50);
                    System.out.println("Received MyItem " +
                            myItem.id);
                });
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