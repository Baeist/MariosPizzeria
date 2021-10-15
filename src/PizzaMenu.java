import java.util.ArrayList;

public class PizzaMenu {

    Pizza p1 = new Pizza(1, "Vesuvio", "tomatsauce, ost, skinke og oregano", 57);
    Pizza p2 = new Pizza(2, "Amerikaner", "tomatsauce, ost, oksefars og oregano", 53);
    Pizza p3 = new Pizza(3, "Cacciatore", "tomatsauce, ost, pepperoni og oregano", 57);
    Pizza p4 = new Pizza(4, "Carbona", "tomatsauce, ost, kødsauce, spaghetti, cocktailpølser, oregano", 63);
    Pizza p5 = new Pizza(5, "Dennis", "tomatsauce, ost, skinke, pepperoni, cocktailpølser og oregano", 65);
    Pizza p6 = new Pizza(6, "Bertil", "tomatsauce, ost, bacon og oregano", 57);
    Pizza p7 = new Pizza(7, "Silvia", "tomatsauce, ost, pepperoni, rød peber, løg, oliven og oregano", 61);
    Pizza p8 = new Pizza(8, "Victoria", "tomatsauce, ost, skinke, bacon, kebab, chili og oregano", 61);
    Pizza p9 = new Pizza(9, "Toronfo", "tomatsauce, ost, skinke, bacon, kebab, chili og oregano", 61);
    Pizza p10 = new Pizza(10, "Capricciosa", "tomatsauce, ost, skinke, champignon og oregano", 61);
    Pizza p11 = new Pizza (11, "Hawai", "tomatsauce, ost, skinke, ananas og oregano", 61);
    Pizza p12 = new Pizza (12, "Le Blissola", "tomatsauce, ost, skinke, ananas og oregano", 61);
    Pizza p13 = new Pizza (13, "Venezia", "tomatsauce, ost, pepperoni, bacon, løg og oregano", 61);
    Pizza p14 = new Pizza (14, "Mafia", "tomatsauce, ost, pepperoni, bacon, løg og oregano", 61);

    PizzaMenu() {  }

    public ArrayList pizzaArrayMenu(){
        ArrayList<Pizza> pizzaArrayList = new ArrayList<Pizza>();
        pizzaArrayList.add(p1);
        pizzaArrayList.add(p2);
        pizzaArrayList.add(p3);
        pizzaArrayList.add(p4);
        pizzaArrayList.add(p5);
        pizzaArrayList.add(p6);
        pizzaArrayList.add(p7);
        pizzaArrayList.add(p8);
        pizzaArrayList.add(p9);
        pizzaArrayList.add(p10);
        pizzaArrayList.add(p11);
        pizzaArrayList.add(p12);
        pizzaArrayList.add(p13);
        pizzaArrayList.add(p14);

        return pizzaArrayList;
    }

    public void printMenu(){
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);
        System.out.println(p6);
        System.out.println(p7);
        System.out.println(p8);
        System.out.println(p9);
        System.out.println(p10);
        System.out.println(p11);
        System.out.println(p12);
        System.out.println(p13);
        System.out.println(p14);
    }
}
