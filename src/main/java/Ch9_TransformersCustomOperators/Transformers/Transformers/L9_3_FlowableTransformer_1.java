package Ch9_TransformersCustomOperators.Transformers.Transformers;

import com.google.common.collect.ImmutableList;
import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;

public class L9_3_FlowableTransformer_1 {
    public static void main(String[] args) {
        Flowable.just("Alpha", "Beta", "Gamma", "Delta",
                "Epsilon")
                .compose(toImmutableList())
                .subscribe(System.out::println);
        Flowable.range(1, 10)
                .compose(toImmutableList())
                .subscribe(System.out::println);
    }

    public static <T> FlowableTransformer<T, ImmutableList<T>>
    toImmutableList() {
        return upstream ->
                upstream.collect(ImmutableList::<T>builder,
                        ImmutableList.Builder::add)
                        .map(ImmutableList.Builder::build)
                        .toFlowable(); // must turn Single into Flowable
    }
}