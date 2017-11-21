package Ch9_TransformersCustomOperators.Transformers.Transformers;

import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;

public class L9_2_ObservableTransformer_2 {
    public static void main(String[] args) {
        Observable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .compose(joinToString("/"))
                .subscribe(System.out::println);
    }

    public static ObservableTransformer<String, String>
    joinToString(String separator) {
        return upstream -> upstream
                .collect(StringBuilder::new, (b, s) -> {
                    if (b.length() == 0)
                        b.append(s);
                    else
                        b.append(separator).append(s);
                })
                .map(StringBuilder::toString)
                .toObservable();
    }
}