package no.haagensoftware.postnordsample.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by jhsmbp on 16/12/15.
 */
public class Henteliste {
    private StringProperty firma;
    private StringProperty addresse;

    public Henteliste() {
        firma = new SimpleStringProperty();
        addresse = new SimpleStringProperty();
    }

    public Henteliste(String firma, String addresse) {
        this();
        this.firma.set(firma);
        this.addresse.set(addresse);
    }

    public String getFirma() {
        return firma.get();
    }

    public StringProperty firmaProperty() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma.set(firma);
    }

    public String getAddresse() {
        return addresse.get();
    }

    public StringProperty addresseProperty() {
        return addresse;
    }

    public void setAddresse(String addresse) {
        this.addresse.set(addresse);
    }
}
