package controller;

import com.jfoenix.controls.*;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.entity.Node;
import model.service.PersonService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class SignUpDrawer implements Initializable {

    @FXML
    private JFXTextField nameTextField;

    @FXML
    private JFXTextField lastNameTextField;

    @FXML
    private JFXTextField idTextField;

    @FXML
    private JFXDatePicker birthDatePicker;

    @FXML
    private JFXCheckBox marriageCheckBox;

    @FXML
    private JFXTextField partnerTextField;

    @FXML
    private JFXTextField familyTextField;

    @FXML
    private JFXComboBox<String> genderComboBox;

    @FXML
    private JFXCheckBox privacyCheckBox;

    @FXML
    private JFXButton signUpButton;

    @FXML
    private NumberValidator numberValidator;

    @FXML
    private RequiredFieldValidator requiredFieldValidator;
    private JFXDrawer drawer;

    public void setPrimaryStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    private Stage primaryStage;

    public void setDrawer(JFXDrawer drawer) {
        this.drawer = drawer;
    }

    @FXML
    void idTextFieldOnKeytyped(KeyEvent event) {
        idTextField.validate();
    }

    @FXML
    void lastNameTextFieldOnKeytyped(KeyEvent event) {
        lastNameTextField.validate();
    }

    @FXML
    void marriageCheckBoxOnAction(ActionEvent event) {
        if (marriageCheckBox.isSelected())
            partnerTextField.setDisable(false);
        else
            partnerTextField.setDisable(true);
    }

    @FXML
    void nameTextFieldOnKeytyped(KeyEvent event) {
        nameTextField.validate();
    }

    @FXML
    void partnerTextFieldOnKeytyped(KeyEvent event) {
        partnerTextField.validate();
    }

    @FXML
    void privacyCheckBoxOnAction(ActionEvent event) {
        if (privacyCheckBox.isSelected())
            signUpButton.setDisable(false);
        else
            signUpButton.setDisable(true);
    }

    @FXML
    void signUpButtonOnAction(ActionEvent event) {
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
                PersonService.getInstance().create(familyTextField.getText());
            } catch (Exception e) {
                error = true;
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setContentText(e.getMessage());
                //alert.setHeaderText("Table Not Found");
                alert.show();
                e.printStackTrace();
            }
        }

        if (!error){
            int state = 0;
            mainWindowController.setCurrentFamily(familyTextField.getText());
            primaryStage.close();
            stage.show();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        genderComboBox.getItems().addAll("Male", "Female");

        nameTextField.getValidators().addAll(requiredFieldValidator);
        lastNameTextField.getValidators().addAll(requiredFieldValidator);
        idTextField.getValidators().addAll(requiredFieldValidator, numberValidator);
        partnerTextField.getValidators().addAll(numberValidator);
        familyTextField.getValidators().add(requiredFieldValidator);
        birthDatePicker.getValidators().add(requiredFieldValidator);
    }

    public void loginHyperLinkOnAction(ActionEvent event) {
        drawer.close();
    }

    private boolean checkInput(){
        Alert alert = new Alert(Alert.AlertType.WARNING);
        if (!nameTextField.validate() | !lastNameTextField.validate() | !idTextField.validate() | !familyTextField.validate() | !birthDatePicker.validate()){
            return false;
        }
        else if (!Pattern.matches("\\D*", nameTextField.getText()) || !Pattern.matches("\\D*", lastNameTextField.getText()) || !Pattern.matches("\\D*", familyTextField.getText())){
            System.out.println("number detected");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Only numbers and alphabet is allowed");
            alert.show();
            return false;
        }
        else if (!Pattern.matches("\\w*", nameTextField.getText()) || !Pattern.matches("\\w*", lastNameTextField.getText()) || !Pattern.matches("\\w*", familyTextField.getText())){
            System.out.println("Special CH detected");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("Only numbers and alphabet is allowed");
            alert.show();
            return false;
        }
        else if (idTextField.getText().length() != 10){
            System.out.println("invalid length");
            alert.setHeaderText("Invalid Input");
            alert.setContentText("The length of ID must be 10 digit");
            alert.show();
            return false;
        }

        return true;
    }

    public void familyTextFieldOnKeyTyped(KeyEvent keyEvent) {
        familyTextField.validate();
    }
}
