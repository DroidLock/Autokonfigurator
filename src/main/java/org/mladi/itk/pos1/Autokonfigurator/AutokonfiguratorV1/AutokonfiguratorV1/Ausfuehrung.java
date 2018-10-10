package AutokonfiguratorV1;

import java.util.ArrayList;
import java.util.List;

/**
 * POJO class with addition of 4 specified methods getpacket(), addAusführung(), printAusfuehrung() and a override method of toString().
 * explicit explanation above each method.
 *
 * @author  Goran Mladjanovic
 * @version 1.0
 * @since   2018-10-10
 */

public class Ausfuehrung {

    private String ausstattung;
    private int preis;
    private List<Ausfuehrung> a = new ArrayList<>();


    public Ausfuehrung() {

    }

    public String getAusstattung() {
        return ausstattung;
    }

    public Ausfuehrung(String ausstattung, int preis) {
        setAusstattung(ausstattung);
        setPreis(preis);
    }


    public void setAusstattung(String ausstattung) {
        this.ausstattung = ausstattung;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public void setAusf(List<Ausfuehrung> a) {
        this.a = a;
    }

    /**
     * @param auswahl index which is presented to the user as menuoption so the right euqipment can be chosen
     * @return the picked euqipment
     */
    public Ausfuehrung getPacket(int auswahl) {
        Ausfuehrung pick = a.get(auswahl);
        return pick;
    }

    public int getPreis() {
        return preis;
    }

    public List<Ausfuehrung> getA() {
        return a;
    }

    /**
     * Method to get a String back for equipment and the price of the chosen equipment in a sentence
     * @return  a String with name of the chosen equipment and the price of the equipment
     */
    @Override
    public String toString() {
        return getAusstattung() + "-Paket mit Zusatzkosten von " + getPreis() + " Euro.";
    }

    /**
     * Method to add a new vehicle equipment to the database(arraylist).
     * @param packet name which packet should be added to the database
     */
    public void addAusfuehrung(Ausfuehrung packet) {
        a.add(packet);
    }

    /**
     * Method which allows you to print out the ArrayList as strings in the menu which. Therefore the menuoptions are automaticlly expandable by adding a new vehicle equipment.
     */
    public void printAusfuehrung() {
        for (int i = 0; i < a.size(); i++) {
            System.out.println((i + 1) + ". " + a.get(i).toString());
        }

    }
}
