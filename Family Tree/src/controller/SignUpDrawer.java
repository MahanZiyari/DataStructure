package controller;

import com.jfoenix.controls.*;
import com.jfoenix.validation.NumberValidator;
import com.jfoenix.validation.RequiredFieldValidator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.util.ResourceBundle;

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

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        genderComboBox.getItems().addAll("Male", "Female");

        nameTextField.getValidators().addAll(requiredFieldValidator);
        lastNameTextField.getValidators().addAll(requiredFieldValidator);
        idTextField.getValidators().addAll(requiredFieldValidator, numberValidator);
        partnerTextField.getValidators().addAll(requiredFieldValidator, numberValidator);
    }

    public void loginHyperLinkOnAction(ActionEvent event) {
        drawer.close();
    }
}
