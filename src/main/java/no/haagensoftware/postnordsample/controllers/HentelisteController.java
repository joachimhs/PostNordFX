package no.haagensoftware.postnordsample.controllers;

import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import no.haagensoftware.postnordsample.dao.HentelisteDao;
import no.haagensoftware.postnordsample.data.Henteliste;
import no.haagensoftware.postnordsample.router.Router;
import no.haagensoftware.postnordsample.tablecells.PulsCell;
import org.apache.log4j.Logger;
import postnord.controller.SjaforAnchor;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


/**
 * Created by jhsmbp on 16/12/15.
 */
public class HentelisteController extends PostNordControllerBase {
    private static final Logger logger = Logger.getLogger(HentelisteController.class.getName());
    @FXML private DatePicker datePicker;
    @FXML private TableView hentelisteTabell;
    @FXML private TableColumn valgtKolonne;
    @FXML private TableColumn firmaKolonne;
    @FXML private TableColumn addresseKolonne;
    @FXML private TableColumn pulsKolonne;
    @FXML private SjaforAnchor sjaforComponent;


    private LongProperty currTimestamp = new SimpleLongProperty(System.currentTimeMillis());

    private ObservableList<Henteliste> hentelisteObservableList = FXCollections.observableArrayList();



    @Override
    public void setupUi() {
        sjaforComponent.setOnAction();

        datePicker.setValue(LocalDateTime.ofInstant(
                Instant.ofEpochMilli(currTimestamp.get()),
                ZoneId.systemDefault()).toLocalDate());

        hentelisteObservableList.addAll(HentelisteDao.getInstance().getHentelister(datePicker.getValue()));

        hentelisteTabell.setItems(hentelisteObservableList);
        hentelisteTabell.setEditable(true);

        firmaKolonne.setCellValueFactory(new PropertyValueFactory<Henteliste, String>("firma"));
        addresseKolonne.setCellValueFactory(new PropertyValueFactory<Henteliste, String>("addresse"));

        valgtKolonne.setCellValueFactory(new PropertyValueFactory<Henteliste, Boolean>("valgt"));
        valgtKolonne.setCellFactory(CheckBoxTableCell.forTableColumn(valgtKolonne));
        valgtKolonne.setEditable(true);


        pulsKolonne.setCellValueFactory(new PropertyValueFactory<Henteliste, String>("pulsIndikator"));
        pulsKolonne.setCellFactory(tableColumn -> new PulsCell());
    }

    public void update() {
        hentelisteObservableList.clear();
        hentelisteObservableList.addAll(HentelisteDao.getInstance().getHentelister(datePicker.getValue()));
    }

    @FXML
    public void dateChanged() {
        logger.info("Date changed to: " + datePicker.getValue().format(DateTimeFormatter.ISO_LOCAL_DATE));
        update();
    }

    @FXML
    public void nyKlikket() {
        Router.getInstance().modal("nyttHentepunkt", "Nytt Hentepunkt", this);
    }


}
