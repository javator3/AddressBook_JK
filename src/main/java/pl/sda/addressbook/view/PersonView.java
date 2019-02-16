package pl.sda.addressbook.view;

import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sda.addressbook.contoler.NewPersonRootContoller;
import pl.sda.addressbook.contoler.RootControler;
import pl.sda.addressbook.model.Person;

import java.io.IOException;

public class PersonView {

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    private Stage stage;

    public PersonView(){}
    public PersonView(Stage stage) {
        this.stage = stage;
        personList.add(new Person("A", "AAA", "", "", "", ""));
        personList.add(new Person("B", "BBB", "", "", "", ""));
        personList.add(new Person("C", "CCC", "", "", "", ""));
        personList.add(new Person("D", "DDD", "", "", "", ""));
        personList.add(new Person("E", "EEE", "", "", "", ""));
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

        stage2.setTitle("Add New Person");
        stage2.setScene(new Scene(parent, 640, 400));
        stage2.show();

        NewPersonRootContoller newPersonRootContoller = loader.getController();
        newPersonRootContoller.setPersonView(this);

    }

}
