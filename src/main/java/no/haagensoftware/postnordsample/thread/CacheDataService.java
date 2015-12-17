package no.haagensoftware.postnordsample.thread;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import no.haagensoftware.postnordsample.dao.HentelisteDao;
import no.haagensoftware.postnordsample.dao.MenuDao;

/**
 * Created by jhsmbp on 17/12/15.
 */
public class CacheDataService extends Service<CacheDataTask> {
    private HentelisteDao hentelisteDao;
    private MenuDao menuDao;

    public CacheDataService(HentelisteDao hentelisteDao, MenuDao menuDao) {
        this.hentelisteDao = hentelisteDao;
        this.menuDao = menuDao;
    }

    @Override
    protected Task<CacheDataTask> createTask() {
        return new CacheDataTask(hentelisteDao, menuDao);
    }
}
