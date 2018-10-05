import java.util.ArrayList;
import java.util.List;

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

    public int getListSize() {
        int listSize = list.size();
        return listSize;
    }

    @Override
    public String toString() {
        return getModell() + " mit Startpreis von " + getPreis() + " Euro entschieden.";
    }

    public void printPlattformList() {
        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i).toString());
        }
    }

    public Plattform getPlattfom(int auswahl) {
        Plattform pick = list.get(auswahl);
        return pick;
    }
}
