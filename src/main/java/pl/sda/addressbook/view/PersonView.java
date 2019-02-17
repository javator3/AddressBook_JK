package pl.sda.addressbook.view;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sda.addressbook.contoler.EditPersonController;
import pl.sda.addressbook.contoler.NewPersonRootContoller;
import pl.sda.addressbook.contoler.RootControler;
import pl.sda.addressbook.model.Person;
import pl.sda.addressbook.model.PersonString;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PersonView {

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    private Stage stage;

    public PersonView(){}
    public PersonView(Stage stage) {
        this.stage = stage;
        /*personList.add(new Person("Anita", "Kowalska", "Pierwsza", "Duże", "80-900", "123456789"));
        personList.add(new Person("Banita", "Biały", "Druga", "Sredne", "60-100", "987654321"));
        personList.add(new Person("Czesiu", "Niemen", "Trzecia", "Małe", "70-200", ""));
        personList.add(new Person("Zuzia", "Nieduża", "Czwarta", "Duże", "48-900", "654789321"));
        personList.add(new Person("Alica", "Sajko", "Piąta", "Małe", "70-200", "456321789"));*/

        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("currentAddressList.json");

        PersonString[] person = null;

        try {
            person = objectMapper.readValue(file, PersonString[].class);
            for (PersonString e: person) {
                personList.add(new Person(e.getName(), e.getLastname(), e.getStreet(), e.getCity(), e.getZipCode(), e.getTelephone()));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public void loadView(){

        FXMLLoader loader =  new FXMLLoader();
        loader.setLocation(getClass().getResource("/root.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent parent = loader.getRoot();

        stage.setTitle("Address Book");
        stage.setScene(new Scene(parent, 640, 400));

        RootControler rootControler = loader.getController();
        rootControler.setPersonView(this);
        stage.show();

    }

    public void loadNewPersonView() {
        FXMLLoader loader =  new FXMLLoader();
        loader.setLocation(getClass().getResource("/addingNewPersonRoot.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent parent = loader.getRoot();

        Stage stage2 = new Stage();

        stage2.setTitle("Add/Edit New Person");
        stage2.setScene(new Scene(parent, 640, 400));
        stage2.show();

        NewPersonRootContoller newPersonRootContoller = loader.getController();
        newPersonRootContoller.setPersonView(this);

    }

    public void loadPersonEdit(Person person, int index){

        FXMLLoader loader =  new FXMLLoader();
        loader.setLocation(getClass().getResource("/editingPersonRoot.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent parent = loader.getRoot();

        Stage stage2 = new Stage();

        stage2.setTitle("Edit New Person");
        stage2.setScene(new Scene(parent, 640, 400));
        stage2.show();


        EditPersonController editPersonController = loader.getController();
        editPersonController.setPerson(person);
//        editPersonController.deletePerson(index);
        editPersonController.setPersonView(this);

    }
}
