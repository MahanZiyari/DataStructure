package controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class Login {

    @FXML
    private AnchorPane parent;

    @FXML
    private Pane loginPane;

    @FXML
    void loginPaneOnMouseEntered(MouseEvent event) {
        loginPane.setStyle("-fx-background-color: #FDEE00");
        parent.setStyle("-fx-background-color: #a107a7");
    }

    @FXML
    void loginPaneOnMouseExited(MouseEvent event) {
        loginPane.setStyle("-fx-background-color: #a107a7");
        parent.setStyle("-fx-background-color: #FDEE00");
    }

    @FXML
    void parentOnMouseEntered(MouseEvent event) {

    }

    @FXML
    void parentOnMouseExited(MouseEvent event) {

    }

}
