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
    private LocalDate currentDate = null;

    private HentelisteDao() {
        hentelister = new ArrayList<>();
        hentelister.add(new Henteliste("Haagen Software AS", "Munkerudtunet 10", "75%"));
        hentelister.add(new Henteliste("Kodegenet AS", "Gamle Bygdevei 180C", "25%"));
        hentelister.add(new Henteliste("PostNord", "Åndalsnesveien 99", "33%"));
        hentelister.add(new Henteliste("Utdanningsdirektoratet", "Fyrstikkalleen 55", "77%"));

        hentelister.get(0).getPulsItem().setGronn(15);
        hentelister.get(0).getPulsItem().setGul(45);
        hentelister.get(0).getPulsItem().setRod(22);

        hentelister.get(1).getPulsItem().setGronn(65);
        hentelister.get(1).getPulsItem().setGul(12);
        hentelister.get(1).getPulsItem().setRod(7);

        hentelister.get(2).getPulsItem().setGronn(66);
        hentelister.get(2).getPulsItem().setGul(12);
        hentelister.get(2).getPulsItem().setRod(5);

        hentelister.get(3).getPulsItem().setGronn(5);
        hentelister.get(3).getPulsItem().setGul(22);
        hentelister.get(3).getPulsItem().setRod(99);
    }

    public static HentelisteDao getInstance() {
        if (instance == null) {
            instance = new HentelisteDao();
        }

        return instance;
    }

    public List<Henteliste> getHentelister(LocalDate localDate) {
        List<Henteliste> hentelisteReturn = new ArrayList<>();


            if (localDate.isAfter(LocalDate.of(2015, 12, 16))) {
                hentelisteReturn.add(hentelister.get(0));
                hentelisteReturn.add(hentelister.get(1));
            } else {
                hentelisteReturn.add(hentelister.get(2));
                hentelisteReturn.add(hentelister.get(3));
            }

            if (hentelister.size() > 4) {
                hentelisteReturn.addAll(hentelister.subList(4, hentelister.size()));
            }

        return hentelisteReturn;
    }

    public void addHentepunkt(Henteliste henteliste) {
        hentelister.add(henteliste);
    }
}
