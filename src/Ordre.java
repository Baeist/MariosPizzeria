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
    private int pizzaNummer;

    Scanner scanner = new Scanner(System.in);
    PizzaMenu pizzaMenu = new PizzaMenu();

    ArrayList<Pizza> newOrderPizza = new ArrayList<>();
    ArrayList<Pizza> menuListePizza = new ArrayList<>();

    public Ordre(){}

    public void setMenuListePizza(){
        this.menuListePizza = pizzaMenu.pizzaArrayMenu();
    }

    public void getPizza(int pizzaNummer){
        System.out.println(menuListePizza.get(pizzaNummer - 1));
    }

    public void setNewOrderPizza(int pizzaNummer){
        newOrderPizza.add(menuListePizza.get(pizzaNummer - 1));
    }

    public void clearNewOrderPizza(){
        newOrderPizza.clear();
    }

    public Ordre(int hour, int minute){

        this.ordreID = ordreID++;
        this.hour = hour;
        this.minute = minute;
    }
    public void addPizzaToOrder(){
        Scanner scanner = new Scanner(System.in);
        int amountOfPizzas = 0;
        boolean check;

        clearNewOrderPizza();
        setMenuListePizza();
        do {
            System.out.println("Vælg antal pizzaer:");
            if (scanner.hasNextInt()) {
                amountOfPizzas = scanner.nextInt();
                check = true; }
            else{check = false;}
            scanner.nextLine();
        } while(check != true);

        System.out.println("Vælg pizza nummre:");
        for(int i = 0; i < amountOfPizzas; i++){
               do{
                   if (scanner.hasNextInt()){
                pizzaNummer = scanner.nextInt();
                   check = false;}
                   else{check = true;}
                scanner.nextLine();
               } while(check = true);
        setNewOrderPizza(pizzaNummer);
        }



    }




}
