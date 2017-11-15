package Ch3_BasicOperators.Transforming;

import io.reactivex.Observable;

public class L14_Transforming_startWith_2 {
    public static void main(String[] args) {
        Observable<String> menu =
                Observable.just("Coffee", "Tea", "Espresso", "Latte");
//print menu
        menu.startWithArray("COFFEE SHOP MENU", "----------------")
                .subscribe(System.out::println);
    }
}