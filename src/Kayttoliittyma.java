import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Kayttoliittyma {
    private Scanner lukija;
    private Kysymyslista kyssarilista;


    public Kayttoliittyma() {
        this.lukija = new Scanner(System.in);
        this.kyssarilista = new Kysymyslista(lukija);

    }

    public void aloita() {

        try (Scanner tiedostonLukija = new Scanner(new File("kyssarit.txt"))) {

            while (tiedostonLukija.hasNextLine()) {
                String kysymysJaVastaus = tiedostonLukija.nextLine();
                if (kysymysJaVastaus.isEmpty()) {
                    break;
                }

                kyssarilista.lisaaKysymys(kysymysJaVastaus);
            }

        } catch (FileNotFoundException ex) {
            System.out.println("tiedostoa ei löydy");
        }


        System.out.println("Tervetuloa tietovisan pariin!");
        System.out.print("Kerropa nimesi: ");
        String nimi = lukija.nextLine();
        System.out.println("Sinulta kysytään 10 erittäin laadukasta kysymystä, joihin vastaat\n" +
                "joko kyllä tai ei, tai vaihtoehtoisesti a, b tai c");
        System.out.println("Onnea matkaan " + nimi + "!");
        kyssarilista.setPelaajannimi(nimi);

        kyssarilista.kysy10Kysymysta();

        while (true) {
            System.out.println("Haluatko pelata uudestaan? kyllä / ei");
            String vastaus = lukija.nextLine().toLowerCase();
            if (vastaus.equals("kyllä")) {
                kyssarilista.sekoita();
                kyssarilista.kysy10Kysymysta();
            }
            if (vastaus.equals("ei")) {
                System.out.println("Kiitos hei " + nimi + "!");
                break;
            }

        }
    }
}
