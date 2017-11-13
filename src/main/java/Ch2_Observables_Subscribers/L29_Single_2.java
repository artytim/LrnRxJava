package Ch2_Observables_Subscribers;

import io.reactivex.Observable;

public class L29_Single_2 {
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("Alpha", "Beta", "Gamma");
        source.first("Nil") //returns a Single
                .subscribe(System.out::println);
    }
}