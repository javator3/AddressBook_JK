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

public class EditPersonController implements Initializable {

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
    private int index;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void savePerson(ActionEvent actionEvent) {

        Person person = personView.getPersonList().get(index);
        person.setName(nameTextField.getText());
        person.setLastname(lastNameTextField.getText());
        person.setStreet(streetTextField.getText());
        person.setCity(cityTextField.getText());
        person.setZipCode(zipTextField.getText());
        person.setTelephone(phoneTextField.getText());

        Stage stage = (Stage) saveButton.getScene().getWindow();
        stage.close();

    }

    public void closeWindow(ActionEvent actionEvent) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    public void setPersonView(PersonView personView) {
        this.personView = personView;
    }


    public void setPerson(Person person) {
        nameTextField.setText(person.getName());
        lastNameTextField.setText(person.getLastname());
        streetTextField.setText(person.getStreet());
        cityTextField.setText(person.getCity());
        zipTextField.setText(person.getZipCode());
        phoneTextField.setText(person.getTelephone());
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
