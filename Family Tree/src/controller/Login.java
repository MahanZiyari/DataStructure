package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Login implements Initializable {

    @FXML
    private AnchorPane parent;

    @FXML
    private JFXTextField nameTextField;

    @FXML
    private JFXTextField familyTextField;

    @FXML
    private Hyperlink signupHyperLink;

    @FXML
    private JFXButton loginButton;

    @FXML
    private JFXDrawer signUpDrawer;

    @FXML
    private NumberValidator numValidator;

    @FXML
    private RequiredFieldValidator requiredValidator;
    private SignUpDrawer drawerController;
    private Stage primaryStage;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    @FXML
    void familyTextFieldOnKeyTyped(KeyEvent event) {
        familyTextField.validate();
    }

    @FXML
    void loginButtonOnAction(ActionEvent event) {
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/MainWindow.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("My Family Tree");
        stage.setScene(new Scene(root, 705, 468));
        primaryStage.close();
        stage.show();
    }

    @FXML
    void nameTextFieldOnKeyTyped(KeyEvent event) {
        nameTextField.validate();
    }

    @FXML
    void signupHyperLinkOnAction(ActionEvent event) {
        signUpDrawer.open();
        drawerController.setDrawer(signUpDrawer);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameTextField.getValidators().addAll(requiredValidator);
        familyTextField.getValidators().addAll(numValidator, requiredValidator);

        AnchorPane anchorPane = null;
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/signUpDrawer.fxml"));
            anchorPane = loader.load();
            drawerController = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
        signUpDrawer.setSidePane(anchorPane);
    }
}
