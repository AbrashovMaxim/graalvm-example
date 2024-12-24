package ru.axalit.graalvm.javafx.sharedlib.display;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import ru.axalit.graalvm.javafx.sharedlib.proxy.AxDemoProxy;

public class AxDemoApplication extends Application {

    private long isolateThread;

    private AxDemoProxy demoProxy;


    @Override
    public void start(Stage primaryStage) {
        initializeTest();

        BorderPane borderPane = new BorderPane();

        VBox primaryVBox = new VBox();
        primaryVBox.setSpacing(15);
        primaryVBox.setAlignment(Pos.CENTER);
        Label nameCameraLabel = new Label("Камера не подключена...");

        VBox changeNameVBox = new VBox();
        changeNameVBox.setSpacing(5);
        changeNameVBox.setAlignment(Pos.CENTER);
        changeNameVBox.setDisable(true);
        Label changeNamelabel = new Label("Изменить название камеры");
        TextField changeNameTextField = new TextField();
        Button changeNameButton = new Button("Сохранить");
        changeNameButton.setOnAction(event -> {
            if (!changeNameTextField.getText().isBlank()) {
                System.out.println("Старое название камеры: " + demoProxy.getNameCamera());
                AxDemoJNIController.changeObjectString(isolateThread, demoProxy, changeNameTextField.getText());
                System.out.println("Новое название камеры: " + demoProxy.getNameCamera());
                nameCameraLabel.setText("Название камеры: " + demoProxy.getNameCamera());
            }
        });
        changeNameVBox.getChildren().addAll(changeNamelabel, changeNameTextField, changeNameButton);

        primaryVBox.getChildren().addAll(nameCameraLabel, changeNameVBox);

        borderPane.setCenter(primaryVBox);


        if (demoProxy != null) {
            changeNameVBox.setDisable(false);
            nameCameraLabel.setText("Название камеры: " + demoProxy.getNameCamera());
        }


        primaryStage.setScene(new Scene(borderPane, 1000, 1000));
        primaryStage.show();
    }


    private void initializeTest() {
        if (AxDemoJNIController.isConnectedLib) {
            isolateThread = AxDemoJNIController.createIsolate();

            System.out.println("Проверка выражений: 150 + 150 = " + AxDemoJNIController.add(isolateThread, 150, 150));
            AxDemoJNIController.callFromDll(isolateThread);

            Object object = AxDemoJNIController.createObject(isolateThread);
            if (object instanceof AxDemoProxy newDemoProxy) {
                demoProxy = newDemoProxy;
            }
        }
    }

}
