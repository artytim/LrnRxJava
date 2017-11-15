package Ch4_CombiningObservables.Merging;

import io.reactivex.Observable;

public class L4_6_Merging_flatMap_2 {
    /*
     Take a sequence of String values (each a concatenated series of values
     separated by "/"), use flatMap() on them, and filter for only numeric values
     before converting them into Integer emissions
     */
    public static void main(String[] args) {
        Observable<String> source =
                Observable.just("521934/2342/FOXTROT",
                        "21962/12112/78886/TANGO",
                        "283242/4542/WHISKEY/2348562");
        source.flatMap(s -> Observable.fromArray(s.split("/")))
                .filter(s -> s.matches("[0-9]+")) //use regex to filter integers
                .map(Integer::valueOf)
                .subscribe(System.out::println);
    }
}