package pl.sda.addressbook.contoler;

import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
