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
import javafx.scene.control.Alert;
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
    private JFXTextField idTextField;

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
        boolean error = false;
        Stage stage = new Stage();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/MainWindow.fxml"));
        MainWindow mainWindowController = null;
        Parent root = null;
        try {
            root = loader.load();
            mainWindowController = loader.getController();
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("My Family Tree");
        stage.setScene(new Scene(root, 705, 468));
        if (checkInput()){
            try {
                familyMembers = PersonService.getInstance().report(familyTextField.getText());
            } catch (Exception e) {
                error = true;
                Alert notFoundAlert = new Alert(Alert.AlertType.WARNING);
                notFoundAlert.setContentText(e.getMessage());
                notFoundAlert.setHeaderText("Table Not Found");
                notFoundAlert.show();
            }
            if (!error && personFinder(familyMembers) != null){
                mainWindowController.setCurrentPerson(personFinder(familyMembers));
                mainWindowController.setCurrentFamily(familyTextField.getText());
                primaryStage.close();
                stage.show();
            }


        }
    }

    private Node personFinder(ObservableList<Node> familyMembers){
        for (int i = 0; i < familyMembers.size(); i++){
            if (familyMembers.get(i).getId().equalsIgnoreCase(idTextField.getText())){
                return familyMembers.get(i);
            }
        }
        Alert notFoundAlert = new Alert(Alert.AlertType.WARNING);
        notFoundAlert.setContentText("ID or FamilyName is Wrong");
        notFoundAlert.setHeaderText("User NOt Found");
        notFoundAlert.show();
        return null;
    }

    @FXML
    void idTextFieldOnKeyTyped(KeyEvent event) {
        idTextField.validate();
    }

    @FXML
    void signupHyperLinkOnAction(ActionEvent event) {
        drawerController.setPrimaryStage(primaryStage);
        signUpDrawer.open();
        drawerController.setDrawer(signUpDrawer);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        idTextField.getValidators().addAll(requiredValidator, numValidator);
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
        Alert alert = new Alert(Alert.AlertType.WARNING);
        if (!idTextField.validate() | !familyTextField.validate())
            return false;
        else if (!Pattern.matches("\\D*", familyTextField.getText())){
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Only numbers and alphabet is allowed");
            alert.show();
            return false;
        }
        else if (!Pattern.matches("\\w*", familyTextField.getText())){
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Only numbers and alphabet is allowed");
            alert.show();
            return false;
        }
        else if (idTextField.getText().length() != 10){
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Invalid Id Length (must be 10 digit)");
            alert.show();
            return false;
        }
        return true;
    }
}
