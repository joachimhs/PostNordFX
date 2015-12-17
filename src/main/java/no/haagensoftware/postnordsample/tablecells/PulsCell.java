package no.haagensoftware.postnordsample.tablecells;

import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;
import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TableCell;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import no.haagensoftware.postnordsample.data.Henteliste;
import no.haagensoftware.postnordsample.data.PulsItem;

/**
 * Created by jhsmbp on 17/12/15.
 */
public class PulsCell extends TableCell<Henteliste, String> {
    private Canvas canvas;

    public PulsCell() {
        this.canvas = new Canvas(100, 40);
    }

    @Override
    protected void updateItem(String string, boolean b) {
        super.updateItem(string, b);

        ObservableValue ov = getTableColumn().getCellObservableValue(getIndex());

        Object rowItem = getTableRow().getItem();

        if (!isEmpty() && rowItem != null && rowItem instanceof Henteliste) {
            Henteliste henteliste = (Henteliste)rowItem;
            generateGraphicsContent(string, henteliste.getPulsItem());
        }

        this.setGraphic(canvas);
    }

    private void generateGraphicsContent(String text, PulsItem pulsItem) {
        double andel = (pulsItem.getGronn() + pulsItem.getGul() + pulsItem.getRod())/100d;

        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.GREEN);
        gc.fillRect(0, 0, pulsItem.getGronn() / andel, 40);
        gc.setFill(Color.YELLOW);
        gc.fillRect(pulsItem.getGronn() / andel, 0, pulsItem.getGul() / andel, 40);
        gc.setFill(Color.RED);
        gc.fillRect((pulsItem.getGronn() + pulsItem.getGul()) / andel, 0, pulsItem.getRod() / andel, 40);

        gc.setTextAlign(TextAlignment.CENTER);
        gc.setTextBaseline(VPos.CENTER);
        gc.setFill(Color.BLACK);
        gc.fillText(text, 50, 20);
    }
}
