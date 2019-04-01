import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lausearvutus {

    /**
     * Meetod kasutaja sisetuse sisse lugemiseks (ilma parameetriteta).
     * Meetod tagastab (String-tüüpi) kasutaja sisendi.
     * Rakendamine: kasutajaSisend().
     *
     * @return tagastab (String-tüüpi) kasutaja sisendi.
     **/

    static String kasutajaSisend() {
        Scanner scan = new Scanner (System.in);
        String vastus = scan.next();
        return vastus;
    }

    /**
     * Meetod failist lugemiseks lugemiseks (ilma parameetriteta).
     * Meetod tagastab listi valem isenditest.
     * Rakendamine: valemidFailist().
     *
     * @return Tagastab listi valem isenditest.
     **/

    static List<Valem> valemidFailist() throws Exception {
        java.io.File fail = new java.io.File("Valemid.txt"); // millisest failist sisse lugeda
        List<Valem> tagasta = new ArrayList<>(); // defineerime uue listi (mis pärast tagastatakse)
        try (java.util.Scanner sc = new java.util.Scanner(fail, "UTF-8")) { // loetakse failist sisse
            while (sc.hasNextLine()) { // seni kuni on olemas järgmine rida
                String[] rida = sc.nextLine().split(";"); // rida poolitatakse kohtadest, kus on ';'
                Valem valem = new Valem(rida[0], rida[1], rida[2]); // teeb uue isendi
                tagasta.add(valem); // lisab isendi listi
            }
        }
        return tagasta;
    }

    /**
     * Meetod valemite listist suvalise valemi genereerimiseks ja küsimiseks.
     * Meetod tagastab true või false vastavalt, kas kasutaja tahab jätkata või ülesannet lõpetada.
     * Rakendamine: genereeriValem(Valem isendite list).
     *
     * @param valemiValik etteantud list Valemi isenditest.
     * @return Tagastab true või false vastavalt, kas kasutaja tahab jätkata või ülesannet lõpetada.
     **/

    static boolean genereeriValem(List<Valem> valemiValik) throws Exception {

        int juhuslik = (int) (Math.random() * valemiValik.size()); // genereerib juhusliku arvu selles vahemikus, mitu valemit listis on

        System.out.println(valemiValik.get(juhuslik).getKirjeldus()); // väljastab (juhusliku) Valemi isendist selle kirjelduse
        System.out.println("Sümbolid kopeerimiseks: ¬ ∧ ∨ ⇒ ");
        System.out.println("                            ^ need asendame pärast nuppudega (siis coolim ja mugavam)");
        System.out.print("Kirjuta samaväärne valem (ilma tühikuteta) " + valemiValik.get(juhuslik).getVasak()); // väljastab (juhusliku) Valemi isendist vasaku poole
        String vastus = kasutajaSisend(); // koht, kuhu kasutaja kirjutama peab
        System.out.println();

        if (vastus.equals(valemiValik.get(juhuslik).getParem())) { // kui kasutaja sisestatud vastab vastusele
            System.out.println("Tubli"); // on ta tubli
        }
        else if (vastus.equals("stop")) { // kui kasutaja sisestab "stop"
            return false; // saab programmi lõpetada
        }
        else {
            System.out.println("Vale vastus :( "); // kui kasutaja sisestas vale vastuse
        }
        System.out.println();
        return true;


    }

    public static void main(String[] args) throws Exception {

        List<Valem> valemiValik = valemidFailist(); // teeb failis olevatest valemitest listi

        while (true) { // seni, kuni true, genereerib uusi valemeid
            boolean next = genereeriValem(valemiValik);
            if (next == false) { // kui kasutaja kirjutab "stop" ja meetod genereeriValem() tagastab false
                break; // lõpetab tsükli
            }
        }


    }
}