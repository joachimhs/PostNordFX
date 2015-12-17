package no.haagensoftware.postnordsample.dao;

import javafx.event.ActionEvent;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCombination;
import no.haagensoftware.postnordsample.router.Router;

/**
 * Created by jhsmbp on 16/12/15.
 */
public class MenuDao {
    private static MenuDao instance = null;
    private Menu menu;

    private MenuDao() {
        menu = new Menu("Oppgaver");
        MenuItem henteliste = new MenuItem("_Henteliste");
        henteliste.setOnAction(this::navigateToHenteliste);
        henteliste.setAccelerator(KeyCombination.keyCombination("Shortcut+H"));
        henteliste.setMnemonicParsing(true);
        menu.getItems().add(henteliste);
    }

    private void navigateToHenteliste(ActionEvent actionEvent) {
        Router.getInstance().modal("progressDialog", "Laster inn filer..", null);
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
