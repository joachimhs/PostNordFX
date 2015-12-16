package no.haagensoftware.postnordsample.dao;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;

/**
 * Created by jhsmbp on 16/12/15.
 */
public class MenuDao {
    private static MenuDao instance = null;
    private Menu menu;

    private MenuDao() {
        menu = new Menu("Oppgaver");
        MenuItem henteliste = new MenuItem("Henteliste");
        henteliste.setAccelerator(KeyCombination.keyCombination("Shortcut+H"));
        menu.getItems().add(henteliste);
    }

    public static MenuDao getInstance() {
        if (instance == null) {
            instance = new MenuDao();
        }

        return instance;
    }

    public Menu getMenu() {
        //Gå til DB
        return menu;
    }

}
