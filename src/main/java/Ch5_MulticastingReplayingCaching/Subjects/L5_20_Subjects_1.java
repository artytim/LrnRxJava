package Ch5_MulticastingReplayingCaching.Subjects;
/*
Subject, an abstract type that implements both Observable and Observer.
You can manually call onNext(), onComplete(), and onError() on a Subject, and it will in turn
pass those events downstream toward its Observers.
 */

import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;

public class L5_20_Subjects_1 {
    public static void main(String[] args) {
        Subject<String> subject = PublishSubject.create();
        subject.map(String::length)
                .subscribe(System.out::println);
        subject.onNext("Alpha");
        subject.onNext("Beta");
        subject.onNext("Gamma");
        subject.onComplete();
    }
}