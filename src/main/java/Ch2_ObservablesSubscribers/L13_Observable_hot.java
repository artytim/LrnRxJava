/* A hot Observable is more like a radio station. It broadcasts the same emissions to all
    Observers at the same time.

A JavaFX or Android UI event can be represented as a hot Observable. In
JavaFX, you can create an Observable<Boolean> off a selectedProperty() operator of
a ToggleButton using Observable.create(). You can then transform the Boolean
emissions into strings indicating whether the ToggleButton is UP or DOWN and then use
an Observer to display them in Label
 */
package Ch2_ObservablesSubscribers;

import io.reactivex.Observable;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class L13_Observable_hot extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        ToggleButton toggleButton = new ToggleButton("TOGGLE ME");
        Label label = new Label();
        Observable<Boolean> selectedStates =
                valuesOf(toggleButton.selectedProperty());
        selectedStates.map(selected -> selected ? "DOWN" : "UP")
                .subscribe(label::setText);
        VBox vBox = new VBox(toggleButton, label);
        stage.setScene(new Scene(vBox));
        stage.show();
    }

    private static <T> Observable<T> valuesOf(final
                                              ObservableValue<T> fxObservable) {
        return Observable.create(observableEmitter -> {
//emit initial state
            observableEmitter.onNext(fxObservable.getValue());
//emit value changes uses a listener
            final ChangeListener<T> listener = (observableValue, prev,
                                                current) -> observableEmitter.onNext(current);
            fxObservable.addListener(listener);
        });
    }
}