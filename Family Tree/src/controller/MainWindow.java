package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainWindow implements Initializable {

    @FXML
    private JFXDrawer userDrawer;

    @FXML
    private JFXButton buildButton;

    @FXML
    private JFXHamburger userBurger;

    @FXML
    private JFXButton findRelationsButton;

    @FXML
    private JFXButton childButton;

    @FXML
    private JFXButton specRelationButton;

    @FXML
    private JFXButton closeRelationButton;
    private HamburgerBackArrowBasicTransition backArrowBasicTransition;

    @FXML
    void buildButtonOnAction(ActionEvent event) {

    }

    @FXML
    void childButtonOnAction(ActionEvent event) {

    }

    @FXML
    void closeRelationButtonOnAction(ActionEvent event) {

    }

    @FXML
    void findRelationsButtonOnAction(ActionEvent event) {

    }

    @FXML
    void specRelationButtonOnAction(ActionEvent event) {

    }

    @FXML
    void userBurgerOnMouseClicked(MouseEvent event) {
        backArrowBasicTransition.setRate(backArrowBasicTransition.getRate() * -1);
        backArrowBasicTransition.play();
        if (userDrawer.isOpened()) {
            userDrawer.close();
        } else {
            userDrawer.open();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        backArrowBasicTransition = new HamburgerBackArrowBasicTransition(userBurger);
        backArrowBasicTransition.setRate(-1);
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/userPanel.fxml"));
        try {
            VBox userPanel = loader.load();
            userDrawer.setSidePane(userPanel);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
