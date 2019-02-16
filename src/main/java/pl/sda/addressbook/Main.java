package pl.sda.addressbook;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.sda.addressbook.view.PersonView;

public class Main extends Application {

    public static void main(String[] args) {

            launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        PersonView personView = new PersonView(primaryStage);

        personView.loadView();

    }
}
