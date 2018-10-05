import java.util.ArrayList;
import java.util.List;

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

    @Override
    public String toString() {
        return getAusstattung() + "-Paket mit Zusatzkosten von " + getPreis() + " Euro.";
    }

    public void addAusfuehrung(Ausfuehrung packet) {
        a.add(packet);
    }

    public void printAusfuehrung() {
        for (int i = 0; i < a.size(); i++) {
            System.out.println((i + 1) + ". " + a.get(i).toString());
        }

    }
}
