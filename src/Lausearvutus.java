import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lausearvutus {

    static String kasutajaSisend() {
        Scanner scan = new Scanner (System.in);
        String vastus = scan.next();
        return vastus;
    }

    static List<Valem> valemidFailist() throws Exception {
        java.io.File fail = new java.io.File("Valemid.txt");
        List<Valem> tagasta = new ArrayList<>();
        try (java.util.Scanner sc = new java.util.Scanner(fail, "UTF-8")) {
            while (sc.hasNextLine()) {
                String[] rida = sc.nextLine().split(", ");
                Valem valem = new Valem(rida[0], rida[1], rida[2]);
                tagasta.add(valem);
            }
        }
        return tagasta;
    }

    static boolean genereeriValem(List<Valem> valemiValik) throws Exception {

        int juhuslik = (int) (Math.random() * valemiValik.size());

        System.out.println(valemiValik.get(juhuslik).getKirjeldus());
        System.out.println("Sümbolid kopeerimiseks: ¬ ∧ ∨ ⇒ ");
        System.out.println("                            ^ need asendame pärast nuppudega (siis coolim ja mugavam)");
        System.out.print("Kirjuta samaväärne valem (ilma tühikuteta) " + valemiValik.get(juhuslik).getVasak());
        String vastus = kasutajaSisend();
        System.out.println();

        if (vastus.equals(valemiValik.get(juhuslik).getParem())) {
            System.out.println("Tubli");
        }
        else if (vastus.equals("stop")) {
            return false;
        }
        else {
            System.out.println("C'mon wtf, sul pole ikka veel põhisamaväärsused selged v?!");
        }
        return true;


    }

    public static void main(String[] args) throws Exception {

        List<Valem> valemiValik = valemidFailist();

        while (true) {
            System.out.println("\r\n".repeat(50));
            boolean next = genereeriValem(valemiValik);
            if (next == false) {
                break;
            }
        }


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