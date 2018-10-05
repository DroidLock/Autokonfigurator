import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menue {

    private Plattform autos = new Plattform();
    private Ausfuehrung packet = new Ausfuehrung();
    private int preisauto;
    private int preispaket;
    private Plattform pickedPlattform;
    private Ausfuehrung pickedAusfuehrung;


    public void fillPlattList() {
        autos.addPlattform(new Plattform("Golf", 34900));
        autos.addPlattform(new Plattform("Passat", 48900));
        autos.addPlattform(new Plattform("Sharan", 64900));
        autos.addPlattform(new Plattform("Touareg", 70000));
    }

    public void fillAusList() {
        packet.addAusfuehrung(new Ausfuehrung("Standard", 0));
        packet.addAusfuehrung(new Ausfuehrung("Sport", 12900));
        packet.addAusfuehrung(new Ausfuehrung("Luxus", 14900));
    }

    public String getAuswahl() {
        Scanner l = new Scanner(System.in);
        String temp = "";
        try {
            temp = l.nextLine();
        } catch (InputMismatchException ex) {
            System.out.println("Bitte bestätigen sie mit 'Y' oder 'N'!");
            getAuswahl();
        }
        return temp;
    }

    public int getZahl() {
        Scanner test = new Scanner(System.in);
        int zahl = 0;
        if (test.hasNextInt()) {
            zahl = Integer.parseInt(test.nextLine());
        } else {
            System.out.println("Sie haben eine ungültige Auswahl getroffen.");
            zahl = getZahl();
        }
        return zahl;
    }

    public void reAsk() throws InterruptedException {
        switch (getZahl()) {
            case 1:
                initMenue();
                break;
            case 2:
                System.exit(0);
                break;
            default:
                System.out.println("Sie haben eine falsche Auswahl getroffen");
                reAsk();
        }
    }

    public void initMenue() throws InterruptedException {

        System.out.println();
        System.out.println("++++++++++++++++++++++++++++++");
        System.out.println("Willkommen im Autokonfigurator von VW");
        System.out.println();
        System.out.println("1. Aktuelle Autoliste mit Preisen ausgeben");
        System.out.println("2. Aktuelle Modellausfuehrung mit Preisen ausgeben");
        System.out.println("3. Bestellung kontrollieren und bestätigen");
        System.out.println("4. Programm beenden");

        int x = getZahl();


        switch (x) {
            case 1: {
                menuePlattform();
            }
            break;
            case 2: {
                menueAusstattung();
            }
            break;
            case 3: {
                bestellMenue();
            }
            break;
            case 4: {
                System.out.println("Danke fürs Benützen unseres Konfigurators");
                TimeUnit.SECONDS.sleep(1);
                System.exit(0);
            }
            break;
            default: {
                System.out.println("Sie haben eine ungültige Auswahl getroffen.");
                TimeUnit.SECONDS.sleep(1);
                initMenue();
            }
        }
    }

    public void menuePlattform() throws InterruptedException {


        System.out.println("*****************************");
        System.out.println("Diese Autos stehen Ihnen zur Auswahl");
        System.out.println();
        autos.printPlattformList();
        System.out.println("99. Zurück");
        int auswahl = getZahl();

        int index = auswahl - 1;

        //Es wird überprüft ob der index nicht outOfBounce ist, ... falls nicht wird der Autopreis aus der Liste geholt und abgespeichert
        if (index < autos.getListSize()) {
            preisauto = autos.getPlattfom(index).getPreis();
        }
        if (auswahl == 99) {
            initMenue();
        }
        if (index > autos.getListSize()) {
            System.out.println("Sie haben eine falsche Auswahl getroffen");
            menuePlattform();
        }

        if (auswahl <= autos.getListSize()) {
            pickedPlattform = autos.getPlattfom(auswahl - 1);
            System.out.println("Sie haben sich fuer den " + pickedPlattform + " Sie können weiters aus drei Zusatzpacketen wählen");
            TimeUnit.SECONDS.sleep(1);
            initMenue();
        }
    }

    public void menueAusstattung() throws InterruptedException {

        //Falls Ausstattung schon vor der Plattform ausgewählt wurde
       /* if (pickedAusfuehrung != null) {
            initMenue();
        }*/

        System.out.println("*****************************");
        System.out.println("Diese Pakete stehen Ihnen zur Auswahl");
        packet.printAusfuehrung();
        System.out.println("99. Zurück");

        int auswahl = getZahl();

        int index = auswahl - 1;
        if (index < autos.getListSize()) {
            preispaket = packet.getPacket(index).getPreis();
        }

        switch (auswahl) {
            case 1: {
                pickedAusfuehrung = packet.getPacket(index);
                System.out.println("Sie haben Sich für das Standard-Paket entschieden.");
                TimeUnit.SECONDS.sleep(1);
                initMenue();
            }
            break;
            case 2: {
                pickedAusfuehrung = packet.getPacket(index);
                System.out.println("Sie haben Sich für das Sport-Paket entschieden.");
                TimeUnit.SECONDS.sleep(1);
                initMenue();
            }
            break;
            case 3: {
                pickedAusfuehrung = packet.getPacket(index);
                System.out.println("Sie haben Sich für das Luxus-Paket entschieden.");
                TimeUnit.SECONDS.sleep(1);
                initMenue();
            }
            break;
            case 4: {
                initMenue();
            }
            break;
            default: {
                System.out.println("Sie haben eine falsche Auswahl getroffen.");
                packet.printAusfuehrung();
            }
        }
    }

    public void bestellMenue() throws InterruptedException {

        LocalDate today = LocalDate.now();


        if (pickedPlattform == null || pickedAusfuehrung == null) {
            System.out.println("Sie haben die nicht alle Optionen ausgewaehlt.");
            System.out.println();
            initMenue();
        }

        System.out.println("Sie haben sich für den " + pickedPlattform);
        System.out.println("Zusaetzlich wurde das " + pickedAusfuehrung);
        System.out.println("Die Gesamtkosten betragen: " + (preisauto + preispaket));
        System.out.println("Möchten Sie dieses Autokombination bestellen? y/n");

        switch (getAuswahl()) {
            case "y": {
                System.out.println("Danke für Ihre Bestellung am " + today + ".");
                System.out.println("Ihr Fahrzeug wird am " + today.plus(2, ChronoUnit.WEEKS) + " geliefert.");
                TimeUnit.SECONDS.sleep(1);
                System.exit(0);
            }
            break;
            case "n": {
                System.out.println("1. Möchten Sie Ihr Traumauto nochmals konfigurieren?");
                System.out.println("2. Möchten Sie das Programm beenden?");
                reAsk();
            }
            break;
            default: {
                System.out.println("Sie haben eine falsche Auswahl getroffen.");
                bestellMenue();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Menue start = new Menue();
        start.fillPlattList();
        start.fillAusList();
        start.initMenue();
    }
}



