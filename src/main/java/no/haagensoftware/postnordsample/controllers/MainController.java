package no.haagensoftware.postnordsample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

/**
 * Created by jhsmbp on 16/12/15.
 */
public class MainController extends PostNordControllerBase {

    @FXML
    private Label mainLabel;


    public void setupUi() {
        mainLabel.setText("Yippie!!");
    }

    @Override
    public void update() {

    }
}
