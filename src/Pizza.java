public class Pizza {


    private String navn;
    private int nummer;
    private String ingredienser;
    private int pris;
    private boolean pizzaStatus;

    // Constructore
    public Pizza (int nummer, String navn, String ingredienser, int pris) {
        this.nummer = nummer;
        this.navn = navn;
        this.ingredienser = ingredienser;
        this.pris = pris;

        // pizzaStatus.
        boolean pizzaStatus;
    }

    public String toString(){
        return  (nummer + ". " + navn + ": " + pris + " Kr." +"\n" + ingredienser);
    }
}
