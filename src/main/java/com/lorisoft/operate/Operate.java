package com.lorisoft.operate;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class Operate extends Application {
    @FXML
    private Button btn2;
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Dashboard.fxml"));
//Parent root = FXMLLoader.load(getClass().getResource("../../../../../../resources/main/EquipmentRegister.fxml"));
        Scene mainScene = new Scene(root);
        Label label = new Label("My Label");
        stage.setScene(mainScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
