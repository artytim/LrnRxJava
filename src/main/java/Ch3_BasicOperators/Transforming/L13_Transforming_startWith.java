package Ch3_BasicOperators.Transforming;

import io.reactivex.Observable;

/*
 startWith() insert a T emission that precedes all the other emissions
 */
public class L13_Transforming_startWith {
    public static void main(String[] args) {
        Observable<String> menu =
                Observable.just("Coffee", "Tea", "Espresso", "Latte");
    //print menu
        menu.startWith("COFFEE SHOP MENU")
                .subscribe(System.out::println);
    }
}