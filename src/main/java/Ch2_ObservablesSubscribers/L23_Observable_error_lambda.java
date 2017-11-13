package Ch2_ObservablesSubscribers;

import io.reactivex.Observable;

public class L23_Observable_error_lambda {
    public static void main(String[] args) {
        Observable.error(() -> new Exception("Crash and burn!"))
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                        Throwable::printStackTrace,
                        () -> System.out.println("Done!"));
    }
}