package com.lorisoft.operate;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.control.MenuItem;

public class Controller implements Initializable {

    @FXML
    private Label lbl1,lbl2;

    @FXML
    private Button btn1,btn2;

    @FXML
    private MenuItem mMainModules, mAboutHelp;

    @FXML
    private void handleMenuItemAction(ActionEvent event) throws Exception {
        System.out.println("MenuItem");
        Stage stage = null;
        Parent root = null;

        if (event.getSource() == mMainModules) {
            if (btn1 != null) {
            System.out.println("menuItemModules");
            stage = (Stage) btn1.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/Modules.fxml"));
        }
        }
        else {
            if (btn2 != null)  {
            System.out.println("menuItemtheOtherThing");
            System.out.println(btn2);
            System.out.println(btn2.getScene());
            stage = (Stage) btn2.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/EquipmentRegister.fxml"));
        }
        }
        if (stage != null) {
           Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    private void handleButtonAction (ActionEvent event) throws Exception {
        System.out.println("Button");
        Stage stage;
        Parent root;

        if(event.getSource()==btn1){
            stage = (Stage) btn1.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/Modules.fxml"));
        }
        else{
            stage = (Stage) btn2.getScene().getWindow();
            root = FXMLLoader.load(getClass().getResource("/EquipmentRegister.fxml"));
        }
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
}