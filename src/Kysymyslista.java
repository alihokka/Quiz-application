import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Kysymyslista {


    private ArrayList<String[]> kysymyspatteristo = new ArrayList<>();
    private Scanner lukija;
    private String pelaajannimi;

    public Kysymyslista(Scanner lukija) {
        this.lukija = lukija;
    }

    public void lisaaKysymys(String kysymysPilkkuVastaus) {
        String[] kysymysJaVastaus = kysymysPilkkuVastaus.split(",");
        kysymyspatteristo.add(kysymysJaVastaus);
        Collections.shuffle(kysymyspatteristo);
    }

    public void sekoita(){
        Collections.shuffle(kysymyspatteristo);
    }

    public void setPelaajannimi(String nimi){
        this.pelaajannimi = nimi;
    }

    public void kysy10Kysymysta() {
        int indeksi = 0;
        int oikeatVastaukset = 0;
        while (indeksi < 10) {
            System.out.println(kysymyspatteristo.get(indeksi)[0]);
            String vastaus = lukija.nextLine().toLowerCase();
            if (vastaus.equals(kysymyspatteristo.get(indeksi)[1])) {
                System.out.println("Vastasit oikein!");
                oikeatVastaukset++;

            } else {
                System.out.println("Vastasit väärin!");
            }

            indeksi++;
        }
        if(oikeatVastaukset < 5) {
            System.out.println("Ei mennyt kovin vahvasti, " + this.pelaajannimi + ", oikeita vastauksia: " + oikeatVastaukset + "/10");
        }else if(oikeatVastaukset < 8){
            System.out.println("Hyvää työtä, " + this.pelaajannimi +", oikeita vastauksia" + oikeatVastaukset + "/10");
        }else if(oikeatVastaukset <= 10){
            System.out.println("Erinomaista, " + this.pelaajannimi + ", oikeita vastauksia: " + oikeatVastaukset + "/10");
        }

    }
}
