package pl.sda.addressbook.contoler;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.sda.addressbook.model.Person;
import pl.sda.addressbook.view.PersonView;


import java.net.URL;
import java.util.ResourceBundle;

public class NewPersonRootContoller implements Initializable {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField streetTextField;

    @FXML
    private TextField cityTextField;

    @FXML
    private TextField zipTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    private Button saveButton;

    @FXML
    private Button cancelButton;

    private PersonView personView;

    public void savePerson(ActionEvent actionEvent) {

        personView.getPersonList().add(new Person(nameTextField.getText(), lastNameTextField.getText(), streetTextField.getText(), cityTextField.getText(), zipTextField.getText(), phoneTextField.getText()));

    }

    public void closeWindow(ActionEvent actionEvent){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void setPersonView(PersonView personView) {
        this.personView = personView;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

}
