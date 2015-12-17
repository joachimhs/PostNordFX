package no.haagensoftware.postnordsample.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import no.haagensoftware.postnordsample.dao.HentelisteDao;
import no.haagensoftware.postnordsample.dao.MenuDao;
import no.haagensoftware.postnordsample.router.Router;
import no.haagensoftware.postnordsample.thread.CacheDataService;

/**
 * Created by jhsmbp on 17/12/15.
 */
public class ProgressDialogController extends PostNordControllerBase {
    @FXML private Label statusLabel;
    @FXML private ProgressBar progressBar;

    @Override
    public void setupUi() {
        CacheDataService service = new CacheDataService(
                HentelisteDao.getInstance(),
                MenuDao.getInstance()
        );

        service.progressProperty().addListener((observableValue, previousProgress, newProgress) -> {
            progressBar.progressProperty().set(newProgress.doubleValue());
        });

        service.messageProperty().addListener((observableValue, oldMessage, newMessage) -> {
            statusLabel.setText(newMessage);
        });

        service.stateProperty().addListener((observableValue, oldState, newState) -> {
            if (newState.compareTo(Worker.State.SUCCEEDED) == 0) {
                Router.getInstance().closeCurrentModal();
                Router.getInstance().navigateTo("henteliste");
            }
        });



        service.start();
    }

    @Override
    public void update() {

    }
}
