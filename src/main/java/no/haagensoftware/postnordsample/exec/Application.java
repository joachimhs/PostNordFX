package no.haagensoftware.postnordsample.exec;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import no.haagensoftware.postnordsample.controllers.PostNordControllerBase;
import no.haagensoftware.postnordsample.dao.MenuDao;
import no.haagensoftware.postnordsample.router.Router;
import no.haagensoftware.postnordsample.util.FileUtil;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import java.io.IOException;
import java.net.URL;

/**
 * Created by jhsmbp on 07/10/15.
 */
public class Application extends javafx.application.Application {
    private static final Logger logger = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws Exception {
        super.init();
        System.out.println("init called on: " + Thread.currentThread().getName());
    }

    @Override
    public void start(Stage stage) throws Exception {
        configureLog4J();

        System.out.println("Start called on: " + Thread.currentThread().getName());

        setupGui(stage);
    }

    private void setupGui(Stage stage) {
        Router.getInstance().setStage(stage);

        Pane pane = new Pane();
        Scene scene = new Scene(pane);//, stage.getWidth(), stage.getHeight());
        BorderPane borderPane = new BorderPane();
        borderPane.setCenter(pane);
        borderPane.setStyle("-fx-background-color: #0ff");

        scene.setRoot(borderPane);
        stage.setScene(scene);
        stage.setTitle("Post Nord");

        borderPane.setTop(createMenu());

        Router.getInstance().navigateTo("main");

        stage.show();
    }

    private MenuBar createMenu() {
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(MenuDao.getInstance().getMenu());

        String os = System.getProperty("os.name");
        if (os != null && os.startsWith("Mac")) {
            menuBar.useSystemMenuBarProperty().set(true);
        }

        return menuBar;
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        System.out.println("Stop called on: " + Thread.currentThread().getName());
    }

    private void configureLog4J() throws IOException {
        Logger root = Logger.getRootLogger();
        if (!root.getAllAppenders().hasMoreElements()) {
            //Log4J is not configured. Set it up correctly!
            root.setLevel(Level.INFO);
            root.addAppender(new ConsoleAppender(new PatternLayout("%-5p [%t]: %m%n")));
            //root.addAppender(new FileAppender(new PatternLayout("%-5p [%t]: %m%n"), workspace.getWorkspaceDir() + File.separatorChar + "maps.log", true));
        }
    }
}
