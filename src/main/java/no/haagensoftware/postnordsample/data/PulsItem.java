package no.haagensoftware.postnordsample.data;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 * Created by jhsmbp on 17/12/15.
 */
public class PulsItem {
    private IntegerProperty gronn;
    private IntegerProperty gul;
    private IntegerProperty rod;

    public PulsItem() {
        this.gronn = new SimpleIntegerProperty(0);
        this.gul = new SimpleIntegerProperty(0);
        this.rod = new SimpleIntegerProperty(0);
    }

    public PulsItem(Integer gronn, Integer gul, Integer rod) {
        this();
        this.gronn.set(gronn);
        this.gul.set(gul);
        this.rod.set(rod);
    }

    public int getGronn() {
        return gronn.get();
    }

    public IntegerProperty gronnProperty() {
        return gronn;
    }

    public void setGronn(int gronn) {
        this.gronn.set(gronn);
    }

    public int getGul() {
        return gul.get();
    }

    public IntegerProperty gulProperty() {
        return gul;
    }

    public void setGul(int gul) {
        this.gul.set(gul);
    }

    public int getRod() {
        return rod.get();
    }

    public IntegerProperty rodProperty() {
        return rod;
    }

    public void setRod(int rod) {
        this.rod.set(rod);
    }
}
