package application.controllers;

import application.Utils;
import application.SceneFactory;
import database.dto.PersonCountDomainsDto;
import database.models.Domain;
import database.queries.PersonQueries;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;

public class DomainsController {

    @FXML
    private Button comeBackButton;

    @FXML
    private TableView<Domain> domainsTable;

    @FXML
    private TableColumn<Domain, Integer> id;

    @FXML
    private TableColumn<Domain, String> webName;

    @FXML
    private TableColumn<Domain, String> domainName;

    @FXML
    private TableColumn<Domain, String> ip;

    @FXML
    private TableColumn<Domain, LocalDateTime> dateReg;

    @FXML
    private TableColumn<Domain, String> countryReg;

    @FXML
    private TableColumn<Domain, Integer> personId;

    public TableView<Domain> getDomainsTable() {
        return domainsTable;
    }

    @FXML
    public void comeBackButtonClick(ActionEvent mouseEvent) throws IOException {

        ((Stage)comeBackButton.getScene().getWindow()).setScene(SceneFactory.getPersonsView());
        PersonsController personsController = SceneFactory.getPersonsController();
        ObservableList<PersonCountDomainsDto> observablePersons = Utils.createObservableList(PersonQueries.getPersons());
        personsController.getPersonsTable().setItems(observablePersons);

    };
}
