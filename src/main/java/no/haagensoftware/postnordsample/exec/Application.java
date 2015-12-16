package no.haagensoftware.postnordsample.exec;

import javafx.stage.Stage;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;

import java.io.IOException;

/**
 * Created by jhsmbp on 07/10/15.
 */
public class Application  {
    private static final Logger logger = Logger.getLogger(Application.class.getName());

    public static void main(String[] args) {

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
