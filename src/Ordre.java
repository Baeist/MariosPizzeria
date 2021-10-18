import java.util.Scanner;
import java.util.ArrayList;

public class Ordre {
    private static int ordreIDIncrementer = 0;
    private int ordreID = ordreIDIncrementer;
    private int hour;               // Hvilke time pizzaen skal være klar
    private int minute;             //hvilke minutter pizzaen skal være klar
    private int pizzaNummer;        //nummeret på pizzaen
    private int time;               //udregnet tid som int pizzaen skal være klar
    private int price;              //prisen på pizzaen
    private String comments;        //kommentar på pizzaen
    ArrayList<Pizza> orderedPizzas; //hvilke pizzaer der er bestilt


    Ordre currentOrdre;

    PizzaMenu pizzaMenu = new PizzaMenu();
    OrdreListe currentOrdreListe = new OrdreListe();
    ArrayList<Pizza> menuListePizza = new ArrayList<>();

    public Ordre() {
    }

    //ordre med kommentar
    public Ordre(ArrayList<Pizza> orderedPizzas, int price, int time, int hour, int minute, String comments, int orderID) {
        this.price = price;
        this.time = time;
        this.hour = hour;
        this.minute = minute;
        this.orderedPizzas = orderedPizzas;
        this.comments = comments;

    }

    //ordre uden kommentar
    public Ordre(ArrayList<Pizza> orderedPizzas, int price, int time, int hour, int minute, int orderID) {
        this.price = price;
        this.time = time;
        this.hour = hour;
        this.minute = minute;
        this.orderedPizzas = orderedPizzas;
    }

    public void setMenuListePizza() {
        this.menuListePizza = pizzaMenu.pizzaArrayMenu();
    }

    public void getPizza(int pizzaNummer) {
        System.out.println(menuListePizza.get(pizzaNummer - 1));
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }


    public ArrayList<Pizza> getOrderedPizzas(){
        return orderedPizzas;
    }

    public void incrementOrderID() {
        ordreIDIncrementer++;
    }

    public int getOrdreID(int ordreID) {
        this.ordreID = ordreID + 1;
        return this.ordreID;
    }
    public int getOrdreID(){
        return ordreID;
    }

    public void setTime(int hour, int minute) {
        this.time = hour * 60 + minute;
    }

    public int getTime() {
        return time;
    }

    public void setPrice(int amount, ArrayList<Pizza> current) {
        int totalPris = 0;
        for (int i = 0; i < amount; i++) {
            totalPris = current.get(i).getPris() + totalPris;
        }
        this.price = totalPris;
    }

    public int getPrice() {
        return price;
    }

    public String getComments() {
        return comments;
    }

    public String toString() {
        return "Ordre " + ordreID;
    }

    public int getUserInt() {
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        int userInput = -1;
        do {
            if (scanner.hasNextInt()) {
                userInput = scanner.nextInt();
                check = true;
            } else {
                check = false;
            }
            scanner.nextLine();
        }
        while (!check);
        return userInput;
    }

    public int getUserInt(String prompt) {
        Scanner scanner = new Scanner(System.in);
        boolean check = true;
        int userInput = -1;
        do {
            System.out.println(prompt);
            if (scanner.hasNextInt()) {
                userInput = scanner.nextInt();
                check = true;
            } else {
                check = false;
            }
            scanner.nextLine();
        }
        while (!check);
        return userInput;
    }

    //user input to get int
    public int getUserInt(ArrayList menu) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        int menuSize = menu.size();
        do {
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
            }

            if (choice > menuSize || choice < 1) {
                System.out.println("Forkert input.");
            }
            scanner.nextLine();
        }
        while (choice > menuSize || choice < 1);
        return choice;
    }

    //tilføjelse af pizzaer til ordre
    public void addPizzaToOrder() {
        Scanner scanner = new Scanner(System.in);
        ordreID = ordreIDIncrementer;
        int amountOfPizzas = 0;
        boolean check = true;
        String kommentar;
        String accept;

        incrementOrderID();
        setMenuListePizza();

        amountOfPizzas = getUserInt("Vælg antal pizzaer:");

        System.out.println("Vælg pizza nummre:");
        ArrayList newOrderPizza = new ArrayList();

        for (int i = 0; i < amountOfPizzas; i++) {
            this.pizzaNummer = getUserInt(pizzaMenu.pizzaArrayMenu());
            newOrderPizza.add(menuListePizza.get((pizzaNummer - 1)));
        }

        //valg af levering tidspunkt
        this.hour = getUserInt("Vælg tidspunkt for levering(timetal):");

        this.minute = getUserInt("Vælg tidspunkt for levering(minutter):");

        //Valg af om der skal være kommentar
        System.out.println("Evt. kommentarer(j)?");

        //hvis der er kommentar
        accept = scanner.nextLine();
        if (accept.equals("j")) {
            System.out.println("Skriv kommentarer:");
            kommentar = scanner.nextLine();
            setTime(hour, minute);
            setPrice(amountOfPizzas, newOrderPizza);
            this.currentOrdre = new Ordre(newOrderPizza, price, time, hour, minute, kommentar, ordreID);
            //System.out.println("Ordre nummer: " + (ordreID + 1) + "\n" + newOrderPizza + "\n" + this.comments + "\nKlar til kl " + hour + ":" + minute + "\n Total pris: " + price + " KR.");

            System.out.println("Ordre nummer: " + (ordreID + 1));

            for (int i = 0; i < newOrderPizza.size(); i++) {
                System.out.println(newOrderPizza.get(i));
            }

            System.out.println("Kommentar: " + kommentar);
            System.out.println("Klar til kl " + hour + ":" + minute);
            System.out.println("Total pris: " + price + " kr.");


        } else { //hvis der ikke er en kommentar
            setTime(hour, minute);
            setPrice(amountOfPizzas, newOrderPizza);
            this.currentOrdre = new Ordre(newOrderPizza, price, time, hour, minute, ordreID);

            System.out.println("Ordre nummer: " + (ordreID + 1));

            for (int i = 0; i < newOrderPizza.size(); i++) {
                System.out.println(newOrderPizza.get(i));
            }

            System.out.println("Klar til kl " + hour + ":" + minute);
            System.out.println("Total pris: " + price + " kr.");
        }

        System.out.println("Accepter ordren(j)?");
        accept = scanner.nextLine();

        if (accept.equals("j")) {
            getOrdreID(ordreID);
            currentOrdreListe.currentOrders.add(currentOrdre);
        }


    }
}
