package Ch3_BasicOperators.Suppressing;

import io.reactivex.Observable;

public class L11_Suppressing_elementAt {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Zeta", "Eta", "Gamma",
                "Delta")
                .elementAt(3)
                .subscribe(i -> System.out.println("RECEIVED: " + i));
    }
}