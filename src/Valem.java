public class Valem {
    private String kirjeldus;
    private String vasak;
    private String parem;

    public Valem(String kirjeldus, String vasak, String parem) {
        this.kirjeldus = kirjeldus;
        this.vasak = vasak;
        this.parem = parem;
    }

    public String getKirjeldus() {
        return kirjeldus;
    }

    public String getVasak() {
        return vasak;
    }

    public String getParem() {
        return parem;
    }
}
