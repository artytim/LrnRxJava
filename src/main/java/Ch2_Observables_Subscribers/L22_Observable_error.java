package Ch2_Observables_Subscribers;

import io.reactivex.Observable;

public class L22_Observable_error {
    public static void main(String[] args) {
        Observable.error(new Exception("Crash and burn!"))
                .subscribe(i -> System.out.println("RECEIVED: " + i),
                        Throwable::printStackTrace,
                        () -> System.out.println("Done!"));
    }
}