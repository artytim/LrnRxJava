package Ch6_ConcurrencyParallelization.subscribeOn;

/*
 Most Observable factories, such as Observable.fromIterable() and Observable.just(), will emit
  items on the Scheduler specified by subscribeOn().

 For factories such as Observable.fromCallable() and Observable.defer(), the initialization
  of these sources will also run on the specified Scheduler when using subscribeOn().
 */

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.net.URL;
import java.util.Scanner;

public class L6_10_Observable_fromCallable {
    /*
     Using Observable.fromCallable() to wait on a URL response, you can do that work on the
      IO Scheduler so the main thread is not blocking and waiting for it...
     */
    public static void main(String[] args) {
        Observable.fromCallable(() ->
                getResponse("https://api.github.com/users/thomasnield/starred")
        ).subscribeOn(Schedulers.io())
                .subscribe(System.out::println);
        sleep(10000);
    }

    private static String getResponse(String path) {
        try {
            return new Scanner(new URL(path).openStream(),
                    "UTF-8").useDelimiter("\\A").next();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static void sleep(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}