package no.haagensoftware.postnordsample.data;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/**
 * Created by jhsmbp on 16/12/15.
 */
public class Henteliste {
    private StringProperty firma;
    private StringProperty addresse;
    private StringProperty pulsIndikator;
    private BooleanProperty valgt;
    private PulsItem pulsItem;

    public Henteliste() {
        firma = new SimpleStringProperty();
        addresse = new SimpleStringProperty();
        pulsIndikator = new SimpleStringProperty();
        valgt = new SimpleBooleanProperty(false);
        pulsItem = new PulsItem();

        valgt.addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observableValue, Boolean aBoolean, Boolean t1) {
                System.out.println("Endrer: " + firma.get() + " fra: " + aBoolean.booleanValue() + " til: " + t1.booleanValue());
            }
        });
    }

    public Henteliste(String firma, String addresse, String pulsIndikator) {
        this();
        this.firma.set(firma);
        this.addresse.set(addresse);
        this.pulsIndikator.set(pulsIndikator);
    }

    public PulsItem getPulsItem() {
        return pulsItem;
    }

    public void setPulsItem(PulsItem pulsItem) {
        this.pulsItem = pulsItem;
    }

    public String getPulsIndikator() {
        return pulsIndikator.get();
    }

    public StringProperty pulsIndikatorProperty() {
        return pulsIndikator;
    }

    public void setPulsIndikator(String pulsIndikator) {
        this.pulsIndikator.set(pulsIndikator);
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

    public boolean getValgt() {
        return valgt.get();
    }

    public BooleanProperty valgtProperty() {
        return valgt;
    }

    public void setValgt(boolean valgt) {
        this.valgt.set(valgt);
    }
}
