import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lausearvutus {

    static String kasutajaSisend() {
        Scanner scan = new Scanner (System.in);
        String vastus = scan.next();
        return vastus;
    }

    static List<String[]> valemidFailist() throws Exception {
        java.io.File fail = new java.io.File("Valemid.txt");
        List<String[]> tagasta = new ArrayList<>();
        try (java.util.Scanner sc = new java.util.Scanner(fail, "UTF-8")) {
            String[] valem;
            while (sc.hasNextLine()) {
                String rida = sc.nextLine();
                valem = rida.split(", ");
                tagasta.add(valem);
            }
        }
        return tagasta;
    }

    static void genereeriValem() throws Exception {

        List<String[]> valemiValik = valemidFailist();

        int juhuslik = (int) (Math.random() * valemiValik.size());

        System.out.println(valemiValik.get(juhuslik)[0]);
        System.out.println("Sümbolid kopeerimiseks: ¬ ∧ ∨ ⇒ ");
        System.out.println("                            ^ need asendame pärast nuppudega (siis coolim ja mugavam)");
        System.out.print("Kirjuta samaväärne valem (ilma tühikuteta) " + valemiValik.get(juhuslik)[1]);
        String vastus = kasutajaSisend();
        System.out.println();

        if (vastus.equals(valemiValik.get(juhuslik)[2])) {
            System.out.println("Tubli");
        }
        else {
            System.out.println("C'mon wtf, sul pole ikka veel põhisamaväärsused selged v?!");
        }


    }

    public static void main(String[] args) throws Exception {

        genereeriValem();

    }
}

/*
static void genereeriValem() {
        String[] vasakPool = {"(F∧G)∧H ≡ ", "(F∨G)∨H ≡ ", "F∧(G∨H) ≡ ", "F∨(G∧H) ≡ "};
        String[] paremPool = {"F∧(G∧H)", "F∨(G∨H)", "F∧G∨F∧H", "(F∨G)∧(F∨H)"};

        int juhuslik = (int) (Math.random() * 3);

        System.out.println("Sümbolid kopeerimiseks: ¬ ∧ ∨ ⇒ ");
        System.out.println("^ need asendame pärast nuppudega");
        System.out.print("Kirjuta samaväärne valem (ilma tühikuteta) " + vasakPool[juhuslik]);
        String vastus = kasutajaSisend();
        System.out.println();

        if (vastus.equals(paremPool[juhuslik])) {
            System.out.println("Tubli");
        }
        else {
            System.out.println("Wtf, sul pole ikka veel põhisamaväärsused selged v?!");
        }
 */
