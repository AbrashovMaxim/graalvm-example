package ru.axalit.graalvm.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AxDemoApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();

        Label label = new Label();
        label.setText("AXALIT DEMO LAUNCH");

        borderPane.setCenter(label);

        primaryStage.setScene(new Scene(borderPane, 1000, 1000));
        primaryStage.show();
    }

}
