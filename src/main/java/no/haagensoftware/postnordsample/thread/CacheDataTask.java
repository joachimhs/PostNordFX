package no.haagensoftware.postnordsample.thread;

import javafx.concurrent.Task;
import no.haagensoftware.postnordsample.dao.HentelisteDao;
import no.haagensoftware.postnordsample.dao.MenuDao;
import no.haagensoftware.postnordsample.data.Henteliste;

/**
 * Created by jhsmbp on 17/12/15.
 */
public class CacheDataTask extends Task {
    private HentelisteDao hentelisteDao;
    private MenuDao menuDao;

    public CacheDataTask(HentelisteDao hentelisteDao, MenuDao menuDao) {
        this.hentelisteDao = hentelisteDao;
        this.menuDao = menuDao;
    }

    @Override
    protected Object call() throws Exception {
        updateProgress(0, 100);
        updateMessage("Starter henting av data");
        Thread.sleep(500);

        updateProgress(20, 100);
        updateMessage("Lager Hentelister...");
        Thread.sleep(1000);

        updateProgress(65, 100);
        updateMessage("Optimaliserer....");
        Thread.sleep(500);

        updateProgress(100, 100);
        updateMessage("Ferdig!");


        return null;
    }
}
