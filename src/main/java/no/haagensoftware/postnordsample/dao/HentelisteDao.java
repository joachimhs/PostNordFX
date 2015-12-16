package no.haagensoftware.postnordsample.dao;

import no.haagensoftware.postnordsample.data.Henteliste;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by jhsmbp on 16/12/15.
 */
public class HentelisteDao {
    private static HentelisteDao instance;
    private List<Henteliste> hentelister;

    private HentelisteDao() {
        hentelister = new ArrayList<>();

    }

    public static HentelisteDao getInstance() {
        if (instance == null) {
            instance = new HentelisteDao();
        }

        return instance;
    }

    public List<Henteliste> getHentelister(LocalDate dato) {
        hentelister.clear();
        
        if (dato.isAfter(LocalDate.of(2015, 12, 16))) {
            hentelister.add(new Henteliste("PostNord", "Åndalsnesveien 22"));
            hentelister.add(new Henteliste("Haagen Software", "Munkerudtunet 10"));
        } else {
            hentelister.add(new Henteliste("PostGlobe", "Globeveien 12"));
            hentelister.add(new Henteliste("Papirkompaniet", "Papirveien 77"));
        }
        return hentelister;
    }
}
