package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXToggleButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FindRelationWindow {

    @FXML
    private JFXComboBox<?> sourceComboBox;

    @FXML
    private JFXComboBox<?> targetButton;

    @FXML
    private JFXButton swapButton;

    @FXML
    private JFXToggleButton sourceLock;

    @FXML
    private JFXToggleButton targetLock;

    @FXML
    private JFXButton findButton;

    @FXML
    private Label resultLabel;

    @FXML
    void findButtonOnAction(ActionEvent event) {

    }

    @FXML
    void sourceLockOnAction(ActionEvent event) {

    }

    @FXML
    void swapButtonOnAction(ActionEvent event) {

    }

    @FXML
    void targetLockOnAction(ActionEvent event) {

    }

}
