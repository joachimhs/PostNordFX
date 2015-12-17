package no.haagensoftware.postnordsample.controllers;

import javafx.fxml.FXML;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import netscape.javascript.JSObject;
import no.haagensoftware.postnordsample.util.FileUtil;
import no.haagensoftware.postnordsample.web.HentelisteBridge;

import javax.xml.ws.WebEndpoint;
import java.net.URL;

/**
 * Created by jhsmbp on 17/12/15.
 */
public class WebViewController extends PostNordControllerBase {
    @FXML private WebView webView;

    @Override
    public void setupUi() {
        WebEngine webEngine = webView.getEngine();

        URL index = FileUtil.getUrlForResource("henteliste/index.html");

        webEngine.load(index.toExternalForm());

        JSObject window = (JSObject)webEngine.executeScript("window");
        window.setMember("hentelisteBridge", new HentelisteBridge());
    }

    @Override
    public void update() {

    }
}
