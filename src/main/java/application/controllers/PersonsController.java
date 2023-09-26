package application.controllers;


import application.AppUtils;
import application.SceneFactory;
import database.dto.PersonCountDomainsDto;
import database.models.Domain;
import database.queries.DomainQueries;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class PersonsController {

    @FXML
    private TableView<PersonCountDomainsDto> personsTable;

    @FXML
    public TableColumn<PersonCountDomainsDto, Integer> id;

    @FXML
    public TableColumn<PersonCountDomainsDto, String> jobTitle;

    @FXML
    public TableColumn<PersonCountDomainsDto, String> firstNameLastName;

    @FXML
    public TableColumn<PersonCountDomainsDto, String> phone;

    @FXML
    public TableColumn<PersonCountDomainsDto, String> email;

    @FXML
    public TableColumn<PersonCountDomainsDto, String> numDomains;

    public TableView<PersonCountDomainsDto> getPersonsTable() {
        return personsTable;
    }

    @FXML
    public void handleTableClick(MouseEvent mouseEvent) throws IOException {

        int countClicks = mouseEvent.getClickCount();

        if (countClicks == 2 && mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
            PersonCountDomainsDto person = personsTable.getSelectionModel().getSelectedItem();
            if (person != null) {
                ((Stage)personsTable.getScene().getWindow()).setScene(SceneFactory.getDomainsView());
                DomainsController domainsController = SceneFactory.getDomainsController();
                ObservableList<Domain> observableDomains = AppUtils.createObservableList(DomainQueries.getDomains(person.getId()));
                domainsController.getDomainsTable().setItems(observableDomains);
            }
        }
    }
}
