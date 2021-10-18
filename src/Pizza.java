public class Pizza { //objekt pizza

    private String navn;
    private int nummer;
    private String ingredienser;
    private int pris;

    // Constructor
    public Pizza (int nummer, String navn, String ingredienser, int pris) {
        this.nummer = nummer;
        this.navn = navn;
        this.ingredienser = ingredienser;
        this.pris = pris;
    }

    public int getPris(){
        return pris;
    }

    public String toString(){
        return  (nummer + ". " + navn + ": " + pris + " kr, " + ingredienser);
    }
}
