package pl.sda.addressbook.contoler;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import pl.sda.addressbook.model.Person;
import pl.sda.addressbook.view.PersonView;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class RootControler implements Initializable{

    @FXML
    private Label nameResult;

    @FXML
    private Label lastNameResult;

    @FXML
    private Label streetResult;

    @FXML
    private Label cityResult;

    @FXML
    private Label postalCodeResult;

    @FXML
    private Label telephoneResult;

    @FXML
    private Button newPerson;

    @FXML
    private Button editPerson;

    @FXML
    private Button deletePerson;

    @FXML
    private Button save;

    @FXML
    private TableView<Person> personTableView;

    @FXML
    private TableColumn<Person, String> nameCol;

    @FXML
    private TableColumn<Person, String> lastNameCol;

    private PersonView personView;

    public void setPersonView(PersonView personView){
        this.personView = personView;
        personTableView.setItems(personView.getPersonList());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        nameCol.setCellValueFactory(c -> c.getValue().nameProperty());
        lastNameCol.setCellValueFactory(c -> c.getValue().lastnameProperty());

    }

    public void addNewPerson(ActionEvent actionEvent) throws Exception {
      personView.loadNewPersonView();

    }

    public void saveListToJSON(ActionEvent actionEvent){

        ObjectMapper mapper = new ObjectMapper();
        File file = new File("currentAddressList.json");

        try {
            mapper.writeValue(file, personView.getPersonList());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void deleteMarkedPerson(){

    }

}
