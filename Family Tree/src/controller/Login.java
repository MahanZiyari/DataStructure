package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.collections.ObservableList;
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
import model.entity.Node;
import model.service.PersonService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

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
    private ObservableList<Node> familyMembers;

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
        //primaryStage.close();
        //stage.show();
        if (checkInput()){
            try {
                familyMembers = PersonService.getInstance().report(familyTextField.getText());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }
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
        familyTextField.getValidators().addAll(requiredValidator);

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

    private boolean checkInput(){
        if (!nameTextField.validate() || !familyTextField.validate())
            return false;
        else if (!Pattern.matches("\\D*", nameTextField.getText()) || !Pattern.matches("\\D*", familyTextField.getText())){
            return false;
        }
        else if (!Pattern.matches("\\w*", nameTextField.getText()) || !Pattern.matches("\\w*", familyTextField.getText())){
            return false;
        }
        return true;
    }
}
