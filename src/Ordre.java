import java.util.Scanner;
import java.util.ArrayList;

public class Ordre {
    private static int ordreIDIncrementer = 0;
    private int ordreID = ordreIDIncrementer;
    private int hour;               // pizza skal være klar kl
    private int minute;
    private String ordreStatus;     // måske
    private int pizzaNummer;
    private int time;

    Ordre currentOrdre;

    PizzaMenu pizzaMenu = new PizzaMenu();
    OrdreListe currentOrdreListe = new OrdreListe();

    ArrayList<Pizza> newOrderPizza = new ArrayList<>();
    ArrayList<Pizza> menuListePizza = new ArrayList<>();

    public Ordre(){}
    public Ordre(ArrayList newPizzaOrder, int time, int hour, int minute, String comment, int orderID){
        this.time = time;
        this.hour = hour;
        this.minute = minute;
        this.newOrderPizza = newPizzaOrder;

    }
    public Ordre(ArrayList newPizzaOrder, int time, int hour, int minute, int orderID){
        this.time = time;
        this.hour = hour;
        this.minute = minute;
        this.newOrderPizza = newPizzaOrder;
    };

    public void setMenuListePizza(){
        this.menuListePizza = pizzaMenu.pizzaArrayMenu();
    }

    public void getPizza(int pizzaNummer){
        System.out.println(menuListePizza.get(pizzaNummer - 1));
    }

    public void setNewOrderPizza(int pizzaNummer){
        newOrderPizza.add(menuListePizza.get((pizzaNummer - 1)));
    }

    public void clearNewOrderPizza(){
        newOrderPizza.clear();
        ordreIDIncrementer ++;
    }

    public int getOrdreID(int ordreID){
        this.ordreID = ordreID + 1;
        return this.ordreID;
    }
    public void setTime(int hour, int minute){
        this.time = hour * 60 + minute;
    }
    public int getTime(){
        return time;
    }


    public void addPizzaToOrder(){
        Scanner scanner = new Scanner(System.in);
        ordreID = ordreIDIncrementer;
        int amountOfPizzas = 1;
        boolean check = true;
        String comments;
        String accept;

        clearNewOrderPizza();
        setMenuListePizza();

        amountOfPizzas = getUserInt("Vælg antal pizzaer");

        System.out.println("Vælg pizza nummre:");
        for(int i = 0; i < amountOfPizzas; i++)
        {
            this.pizzaNummer = getUserInt();
               setNewOrderPizza(pizzaNummer);
        }

        this.hour = getUserInt("Vælg timetal for levering:");

        this.minute = getUserInt("Vælg minut tid:");

        System.out.println("Evt. kommentarer(j)?");
        accept = scanner.nextLine();
        if(accept.equals("j")){
            System.out.println("Skriv kommentarer:");
            comments = scanner.nextLine();
            setTime(hour, minute);
            this.currentOrdre = new Ordre(newOrderPizza, time, hour, minute, comments , ordreID);
            System.out.println("Ordre nummer: 0" + (ordreID + 1) + "\n" + newOrderPizza + "\n" + comments +"\nKlar til kl " + hour + ":" + minute);
        }
        else{
            setTime(hour, minute);
            this.currentOrdre = new Ordre(newOrderPizza, time, hour, minute, ordreID );
        System.out.println("Ordre nummer: 0" + (ordreID + 1) + "\n" + newOrderPizza + "\nKlar til kl " + hour + ":" + minute);


        }

        System.out.println("Accepter ordren(j)?");
        accept = scanner.nextLine();
        if(accept.equals("j")){

            getOrdreID(ordreID);
            currentOrdreListe.currentOrders.add(currentOrdre);
        }

            currentOrdreListe.sortList();




    }

    // TODO Evt slet.
    public String toString() {
        return "Ordre " + ordreID;
    }

    public int getUserInt(String prompt){
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        int userInput = -1;
        do{
            System.out.println(prompt);
            if (scanner.hasNextInt()) {
                userInput = scanner.nextInt();
                check = true; }
            else{check = false;}
            scanner.nextLine();
        }
        while (!check);
        return userInput;
    }
    public int getUserInt(){
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        int userInput = -1;
        do{
            if (scanner.hasNextInt()) {
                userInput = scanner.nextInt();
                check = true; }
            else{check = false;}
            scanner.nextLine();
        }
        while (!check);
        return userInput;
    }
}
