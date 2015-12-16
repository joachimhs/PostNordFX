package no.haagensoftware.postnordsample.router;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import no.haagensoftware.postnordsample.controllers.PostNordControllerBase;
import no.haagensoftware.postnordsample.util.FileUtil;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by jhsmbp on 16/12/15.
 */
public class Router {
    private static final Logger logger = Logger.getLogger(Router.class.getName());
    private static Router instance = null;
    private Stage stage;
    private Map<String, String> routeMap;

    private Router() {
        routeMap = new HashMap<>();
        routeMap.put("main", "MainContent.fxml");
        routeMap.put("henteliste", "Henteliste.fxml");
    }

    public static Router getInstance() {
        if (instance == null) {
            instance = new Router();
        }

        return instance;
    }

    public void navigateTo(String routeName) {
        if (stage != null) {
            logger.info("Navigerer til rute: " + routeName);

            String fxml = routeMap.get(routeName);
            if (fxml != null) {
                AnchorPane pane = loadFxml(fxml);

                ((BorderPane)stage.getScene().getRoot()).setCenter(pane);
            }
        }
    }

    private AnchorPane loadFxml(String fxml) {
        AnchorPane pane = null;
        URL resource = FileUtil.getUrlForResource(fxml);

        try {
            FXMLLoader loader = new FXMLLoader(resource);
            pane = (AnchorPane)loader.load();

            PostNordControllerBase controllerBase = loader.getController();
            controllerBase.setupUi();
        } catch(Exception e) {
            e.printStackTrace();
        }

        return pane;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
