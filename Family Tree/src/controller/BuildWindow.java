package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class BuildWindow implements Initializable {

    @FXML
    private AnchorPane Parent;

    @FXML
    private JFXTreeTableView<?> familyTable;

    @FXML
    private TreeTableColumn<?, ?> idColumn;

    @FXML
    private TreeTableColumn<?, ?> nameColumn;

    @FXML
    private TreeTableColumn<?, ?> lastNameColumn;

    @FXML
    private TreeTableColumn<?, ?> birthColumn;

    @FXML
    private TreeTableColumn<?, ?> deathColumn;

    @FXML
    private TreeTableColumn<?, ?> genderColumn;

    @FXML
    private TreeTableColumn<?, ?> partnerColumn;

    @FXML
    private TreeTableColumn<?, ?> fatherColumn;

    @FXML
    private JFXButton mainMenuButton;

    @FXML
    private JFXButton graphButton;

    @FXML
    private JFXButton refreshButton;

    @FXML
    private JFXRadioButton hierarchyRadioButton;

    @FXML
    private JFXButton addButton;

    @FXML
    private JFXButton removeButton;

    @FXML
    void addButtonOnAction(ActionEvent event) {

    }

    @FXML
    void birthColumnOnEditCommit(ActionEvent event) {

    }

    @FXML
    void deathColumnOnEditCommit(ActionEvent event) {

    }

    @FXML
    void fatherColumnOnEditCommit(ActionEvent event) {

    }

    @FXML
    void graphButtonOnAction(ActionEvent event) {

    }

    @FXML
    void hierarchyRadioButtonOnAction(ActionEvent event) {

    }

    @FXML
    void idCoulumnOnEditommit(ActionEvent event) {

    }

    @FXML
    void lastNameColumnOnEditCommit(ActionEvent event) {

    }

    @FXML
    void mainMenuButtonOnAction(ActionEvent event) {

    }

    @FXML
    void nameColumnOnEditCommit(ActionEvent event) {

    }

    @FXML
    void partnerColumnOnEditCommit(ActionEvent event) {

    }

    @FXML
    void refreshButtonOnAction(ActionEvent event) {

    }

    @FXML
    void removeButtonOnAction(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
