public class Main {
    public static void main(String[] args){
        OversigtsMenu startMenu = new OversigtsMenu();
        PizzaMenu pizzaMenu = new PizzaMenu();

        pizzaMenu.printMenu();

        startMenu.run();


    }
}
