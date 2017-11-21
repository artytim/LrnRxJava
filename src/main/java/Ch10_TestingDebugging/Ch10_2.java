package Ch10_TestingDebugging;

import io.reactivex.Observable;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.Assert.assertTrue;

public class Ch10_2 {
    @Test
    public void testBlockingSubscribe() {
        AtomicInteger hitCount = new AtomicInteger();
        Observable<Long> source = Observable.interval(1,
                TimeUnit.SECONDS)
                .take(5);
        source.subscribe(i -> hitCount.incrementAndGet());
        assertTrue(hitCount.get() == 5);
    }
}
