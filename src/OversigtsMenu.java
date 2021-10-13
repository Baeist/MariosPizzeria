import java.util.Scanner;
class OversigtsMenu {
    private boolean running = true;
    PizzaMenu pizzaMenu = new PizzaMenu();
    Ordre pizzaOrdre = new Ordre();

    public void run(){
        String [] menu = {"1: Ny ordre.", "2: Se Menu.", "3: Se ordre liste.", "4: Afslut ordre og put i arkiv.", "5: Se arkiv.", "6: Rediger ordreliste", "7: Hjælp", "8: Luk program"};
        int choice;

        printOversigt(menu);

        while(this.running) {
            choice = readChoice(menu);

                switch (choice) {
                    case 1:
                        pizzaOrdre.addPizzaToOrder();
                        break;
                    case 2:
                        pizzaMenu.printMenu();
                        break;
                    case 3:
                        pizzaOrdre.currentOrdreListe.showCurrent();
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        printOversigt(menu);
                        break;
                    case 8:
                        this.running = false;
                        break;
                }
        }


    }
    public void printOversigt(String[] menu){
        int menuSize = menu.length;
        for(int i = 0; i < menuSize; i++){
            System.out.println(menu[i]);
    }}

        public int readChoice(String[] menu){
            Scanner scanner = new Scanner(System.in);
            int choice = 0;
            int menuSize = menu.length;

            do {
                System.out.println("Vælg:");
                if (scanner.hasNextInt())
                   choice = scanner.nextInt();
                scanner.nextLine();
            }
            while(choice > menuSize || choice < 1);

            return choice;
        }
}
