package no.haagensoftware.postnordsample.web;

import com.google.gson.Gson;
import no.haagensoftware.postnordsample.dao.HentelisteDao;
import no.haagensoftware.postnordsample.data.Henteliste;
import org.apache.log4j.Logger;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

/**
 * Created by jhsmbp on 17/12/15.
 */
public class HentelisteBridge {
    private static final Logger logger = Logger.getLogger(HentelisteBridge.class.getName());
    public String loadHenteliste(String dato) {
        logger.info(dato);

        LocalDate localDate = LocalDate.parse(dato);

        List<Henteliste> hentelisteList = HentelisteDao.getInstance().getHentelister(localDate);

        return new Gson().toJsonTree(hentelisteList).toString();
    }
}
