package no.haagensoftware.postnordsample.router;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
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
    private Stage currentModal = null;
    private Map<String, String> routeMap;


    private Router() {
        routeMap = new HashMap<>();
        routeMap.put("main", "MainContent.fxml");
        routeMap.put("henteliste", "Henteliste.fxml");
        routeMap.put("nyttHentepunkt", "NyttHentepunkt.fxml");
        routeMap.put("progressDialog", "ProgressDialog.fxml");
        routeMap.put("webView", "WebView.fxml");
    }

    public static Router getInstance() {
        if (instance == null) {
            instance = new Router();
        }

        return instance;
    }

    public void modal(String route, String windowTitle, PostNordControllerBase controllerCallback) {
        if (stage != null) {
            String fxml = routeMap.get(route);

            if (fxml != null) {
                AnchorPane pane = loadFxml(fxml, controllerCallback);

                currentModal = new Stage();
                currentModal.setTitle(windowTitle);
                currentModal.initModality(Modality.APPLICATION_MODAL);
                currentModal.initOwner(stage);

                Scene scene = new Scene(pane, 400, 300);
                currentModal.setScene(scene);

                currentModal.show();
            }
        }
    }

    public void closeCurrentModal() {
        if (currentModal != null) {
            currentModal.close();
            currentModal = null;
        }
    }

    public void navigateTo(String routeName) {
        if (stage != null) {
            logger.info("Navigerer til rute: " + routeName);

            String fxml = routeMap.get(routeName);
            if (fxml != null) {
                AnchorPane pane = loadFxml(fxml, null);

                ((BorderPane)stage.getScene().getRoot()).setCenter(pane);
            }
        }
    }

    private AnchorPane loadFxml(String fxml, PostNordControllerBase controllerCallback) {
        AnchorPane pane = null;
        URL resource = FileUtil.getUrlForResource(fxml);

        try {
            FXMLLoader loader = new FXMLLoader(resource);
            pane = (AnchorPane)loader.load();

            PostNordControllerBase controller = loader.getController();
            controller.setupUi();

            controller.setControllerCallback(controllerCallback);
        } catch(Exception e) {
            e.printStackTrace();
        }

        return pane;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }
}
