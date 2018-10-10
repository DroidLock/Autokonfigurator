package AutokonfiguratorV1;

import java.util.ArrayList;
import java.util.List;

/**
 * POJO class with addition of 3 specified methods printPlattform(), getPlattform and a override method of toString().
 * explicit explanation above each method.
 *
 * @author  Goran Mladjanovic
 * @version 1.0
 * @since   2018-10-10
 */
public class Plattform {

    private int preis;
    private String modell;
    private List<Plattform> list = new ArrayList<>();

    public Plattform() {

    }

    public Plattform(String modell, int preis) {
        this.modell = modell;
        this.preis = preis;
    }

    public void setPlattform(String modell) {
        this.modell = modell;
    }

    public void setPreis(int preis) {
        this.preis = preis;
    }

    public String getModell() {
        return modell;
    }

    public int getPreis() {
        return preis;
    }

    public void addPlattform(Plattform modell) {
        list.add(modell);
    }

    /**     *
     * @return the size of the arraylist
     */
    public int getListSize() {
        return list.size();
    }

    /**
     * @return a String with name of the and the price of the chosen car model
     */
    @Override
    public String toString() {
        return getModell() + " mit Startpreis von " + getPreis() + " Euro entschieden.";
    }

    /**
     * Method which allows you to print out the ArrayList as strings in the menu. Therefore the menu options are automatically expandable by adding a new car model.
     */
    public void printPlattformList() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i).toString());
        }
    }

    /**
     * @param auswahl defining the index which the user chooses from the arraylist
     * @return the car from the arraylist
     */
    public Plattform getPlattfom(int auswahl) {
        Plattform pick = list.get(auswahl);
        return pick;
    }
}
