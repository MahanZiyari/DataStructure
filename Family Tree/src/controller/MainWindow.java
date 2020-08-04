package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXHamburger;
import com.jfoenix.transitions.hamburger.HamburgerBackArrowBasicTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.entity.Node;

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
    private Node currentPerson;
    private String currentFamily;

    public Node getCurrentPerson() {
        return currentPerson;
    }

    public void setCurrentPerson(Node currentPerson) {
        this.currentPerson = currentPerson;
    }

    public String getCurrentFamily() {
        return currentFamily;
    }

    public void setCurrentFamily(String currentFamily) {
        this.currentFamily = currentFamily;
    }

    @FXML
    void buildButtonOnAction(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/BuildWindow.fxml"));
        Stage stage = new Stage();
        Parent parent = null;
        try {
             parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("Build your family tree");
        stage.setScene(new Scene(parent, 705, 468));
        stage.show();

    }

    @FXML
    void childButtonOnAction(ActionEvent event) {
        JFXDialog dialog = new JFXDialog();
        dialog.setContent(new Label("the most belonged child is "));
    }

    @FXML
    void closeRelationButtonOnAction(ActionEvent event) {

    }

    @FXML
    void findRelationsButtonOnAction(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/FindRelationWindow.fxml"));
        Stage stage = new Stage();
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //stage.setTitle("Build your family tree");
        stage.setScene(new Scene(parent, 705, 468));
        stage.show();
    }

    @FXML
    void specRelationButtonOnAction(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/searchRelationWindow.fxml"));
        Stage stage = new Stage();
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //stage.setTitle("Build your family tree");
        stage.setScene(new Scene(parent, 705, 468));
        stage.show();
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
