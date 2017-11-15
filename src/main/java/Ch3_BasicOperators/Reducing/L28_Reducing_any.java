package Ch3_BasicOperators.Reducing;

import io.reactivex.Observable;

import java.time.LocalDate;

public class L28_Reducing_any {
    /*
     The any() method will check whether At Least ONE emission meets a specific criterion
      and return a Single<Boolean>
     */
    public static void main(String[] args) {
        Observable.just("2016-01-01", "2016-05-02", "2016-09-12",
                "2016-04-03")
                .map(LocalDate::parse)
                .any(dt -> dt.getMonthValue() >= 6)
                .subscribe(s -> System.out.println("Received: " + s));
    }
}