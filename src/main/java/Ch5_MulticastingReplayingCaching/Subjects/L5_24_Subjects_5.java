package Ch5_MulticastingReplayingCaching.Subjects;

import io.reactivex.subjects.ReplaySubject;
import io.reactivex.subjects.Subject;

public class L5_24_Subjects_5 {
    public static void main(String[] args) {
        Subject<String> subject =
                ReplaySubject.create();
        subject.subscribe(s -> System.out.println("Observer 1: " +
                s));
        subject.onNext("Alpha");
        subject.onNext("Beta");
        subject.onNext("Gamma");
        subject.onComplete();
        subject.subscribe(s -> System.out.println("Observer 2: " +
                s));
    }
}