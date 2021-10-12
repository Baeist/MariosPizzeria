import java.util.Scanner;
import java.util.ArrayList;
public class Ordre {
    private String kommentar;       // tror bedre hvis kommentar er i ordre oprettelsen, men ikke instantieringen
    private int ordreID;
    // private int day;              2  // angive dato giver mere mening når man starter programmet, så bare dato stamp fra main måske
    // private int month;
    private int hour;               // pizza skal være klar kl
    private int minute;
    private String ordreStatus;

    Scanner scanner = new Scanner(System.in);

    ArrayList<Integer> pizza = new ArrayList<>();

    public Ordre(ArrayList pizza, int hour, int minute){
        // noget med pizza numrene fra arraylist
        this.ordreID = ordreID++;
        this.hour = hour;
        this.minute = minute;

    }




}
