package no.haagensoftware.postnordsample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import no.haagensoftware.postnordsample.dao.HentelisteDao;
import no.haagensoftware.postnordsample.data.Henteliste;
import no.haagensoftware.postnordsample.router.Router;

/**
 * Created by jhsmbp on 16/12/15.
 */
public class HentepunktController extends PostNordControllerBase {

    @FXML private TextField firmaField;
    @FXML private TextField addresseField;

    @Override
    public void setupUi() {

    }

    @Override
    public void update() {

    }

    @FXML public void okKlikket() {
        if (firmaField.getText().length() > 0 && addresseField.getText().length() > 0) {
            Henteliste nyHenteliste = new Henteliste(firmaField.getText(), addresseField.getText());
            HentelisteDao.getInstance().addHentepunkt(nyHenteliste);

            if (getControllerCallback() != null) {
                getControllerCallback().update();
            }

            Router.getInstance().closeCurrentModal();
        }
    }
}
