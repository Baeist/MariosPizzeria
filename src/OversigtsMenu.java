import java.util.Scanner;

class OversigtsMenu {
    private boolean running = true;
    PizzaMenu pizzaMenu = new PizzaMenu();
    Ordre pizzaOrdre = new Ordre();

    //oversigtmenu valgmuligheder
    public void run() {
        String[] menu = {"1: Ny ordre.", "2: Se Menu.", "3: Se ordre liste.", "4: Afslut ordre og put i arkiv.", "5: Se arkiv.", "6: Afslut ordre og slet.", "7: Hjælp", "8: Luk program"};
        int choice;

        printOversigt(menu);

        while (running) {
            choice = readChoice(menu);

            switch (choice) {
                case 1: //ny ordre
                    pizzaOrdre.addPizzaToOrder();
                    break;
                case 2: //se menu
                    pizzaMenu.printMenu();
                    break;
                case 3: //se ordre liste
                    pizzaOrdre.currentOrdreListe.sortList();
                    pizzaOrdre.currentOrdreListe.print();
                    break;
                case 4: //afslut ordre og put i arkiv
                    pizzaOrdre.currentOrdreListe.sortListByID();
                    pizzaOrdre.currentOrdreListe.archiveOrder();
                    break;
                case 5: //se arkiv
                    pizzaOrdre.currentOrdreListe.printArchive();
                    pizzaOrdre.currentOrdreListe.showTotalArchiveAmount();
                    break;
                case 6: //afslut ordre og slet
                    pizzaOrdre.currentOrdreListe.removeOrder();
                    break;
                case 7: //hjælp
                    printOversigt(menu);
                    break;
                case 8: //afslut program
                    running = false;
                    break;
            }
        }
    }

    public void printOversigt(String[] menu) {
        int menuSize = menu.length;
        for (int i = 0; i < menuSize; i++) {
            System.out.println(menu[i]);
        }
    }

    public int readChoice(String[] menu) {
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        int menuSize = menu.length;

        do {
            System.out.println();
            System.out.println("Vælg nyt menupunkt:");
            if (scanner.hasNextInt())
                choice = scanner.nextInt();
            scanner.nextLine();
        }
        while (choice > menuSize || choice < 1);

        return choice;
    }


}
