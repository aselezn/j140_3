package application;

import application.controllers.DomainsController;
import application.controllers.PersonsController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;


public class SceneFactory {

    private static Scene loginView;
    private static Scene personsView;
    private static PersonsController personsController;
    private static Scene domainsView;
    private static DomainsController domainsController;


    public static Scene getLoginView() throws IOException {

        if(loginView==null) {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/login-view.fxml"));
            Parent root = fxmlLoader.load();
            loginView = new Scene(root, 400, 300);
        }

        return loginView;
    }

    public static Scene getPersonsView() throws IOException {

        if(personsView==null) {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/persons-view.fxml"));
            Parent root = fxmlLoader.load();
            personsView = new Scene(root, 780, 600);
            personsController = (PersonsController)fxmlLoader.getController();

        }

        return personsView;
    }

    public static PersonsController getPersonsController(){
        return personsController;
    }

    public static Scene getDomainsView() throws IOException {

        if(domainsView==null) {
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("/domains-view.fxml"));
            Parent root = fxmlLoader.load();
            domainsView = new Scene(root, 780, 600);
            domainsController = (DomainsController)fxmlLoader.getController();

        }

        return domainsView;
    }

    public static DomainsController getDomainsController(){
        return domainsController;
    }


}
