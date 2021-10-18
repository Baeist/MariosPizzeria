import java.util.ArrayList;
import java.util.Scanner;

public class OrdreListe {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Ordre> currentOrders = new ArrayList<>();
    ArrayList<Ordre> archiveOrders = new ArrayList<>();

    public OrdreListe() {
    }

    public OrdreListe(ArrayList<Ordre> list) {
        this.currentOrders = list;
    }

    public void addOrdre(Ordre newOrder) {
        currentOrders.add(newOrder);

    }

    public void showTotalArchiveAmount() {
        int total = 0;
        for (int i = 0; i < archiveOrders.size(); i++) {
            total = total + archiveOrders.get(i).getPrice();
        }
        System.out.println("Total omsætning for i dag: " + total + " kr.");
    }

    public void showArchive() {
        System.out.println(archiveOrders);
    }
    public void showCurrent() {
        System.out.println(currentOrders);
    }

    public ArrayList<Ordre> getCurrentOrders() {
        return currentOrders;
    }

    public void sortList() {
        boolean listIsSortet;
        do {
            // checker om en list er sorteret
            // count tæller hvor mange gange et et tal fra højre er mindre;
            // hvis count er 0 så er listen soteret
            int count = 0;

            for (int i = 0; i < currentOrders.size() - 1; i++) {

                if (currentOrders.get(i).getTime() < currentOrders.get(i + 1).getTime()) {
                    count++;
                }
            }

            listIsSortet = count == 0;

            if (!listIsSortet) {
                for (int i = 0; i < currentOrders.size() - 1; i++) {
                    Ordre ObjectInHand = currentOrders.get(i);

                    if (ObjectInHand.getTime() < currentOrders.get(i + 1).getTime()) {
                        currentOrders.remove(i);
                        currentOrders.add(i + 1, ObjectInHand);
                    }
                }
            }
        } while (!listIsSortet);
    }
    public void sortListByID() {
        boolean listIsSortet;
        do {
            // checker om en list er sorteret
            // count tæller hvor mange gange et et tal fra højre er mindre;
            // hvis count er 0 så er listen soteret
            int count = 0;

            for (int i = 0; i < currentOrders.size() - 1; i++) {

                if (currentOrders.get(i).getOrdreID() > currentOrders.get(i + 1).getOrdreID()) {
                    count++;
                }
            }

            listIsSortet = count == 0;

            if (!listIsSortet) {
                for (int i = 0; i < currentOrders.size() - 1; i++) {
                    Ordre ObjectInHand = currentOrders.get(i);

                    if (ObjectInHand.getOrdreID() > currentOrders.get(i + 1).getOrdreID()) {
                        currentOrders.remove(i);
                        currentOrders.add(i + 1, ObjectInHand);
                    }
                }
            }
        } while (!listIsSortet);
    }

    public void removeOrder() {
        int input;

        System.out.println("Hvilken ordre vil du fjerne?");
        showCurrent();

        if (scanner.hasNextInt()) {
            input = scanner.nextInt();
            if (input < currentOrders.size() + 1 && input > 0) {
                currentOrders.remove(input - 1);

                System.out.println(currentOrders);

            } else {
                System.out.println("Fokert input");
            }
        }
    }

    public void archiveOrder() {
        int input;

        System.out.println("Hvilken ordre vil du arkivere?");
        showCurrent();

        if (scanner.hasNextInt()) {
            input = scanner.nextInt();
            if (input < currentOrders.size() + 1 && input > 0) {
                archiveOrders.add(currentOrders.get(input - 1));
                currentOrders.remove(input - 1);
            } else {
                System.out.println("Fokert input");
            }
        }
    }

    public void print() {

        for (int i = 0; i < currentOrders.size(); i++) {
            System.out.println(currentOrders.get(i).toString() + ". Afhentning kl: " + currentOrders.get(i).getHour()
                    + ":" + currentOrders.get(i).getMinute() + ".");

            for (int n = 0; n < currentOrders.get(i).orderedPizzas.size(); n++) {
                System.out.println("  " + currentOrders.get(i).orderedPizzas.get(n).toString());
            }

            if (currentOrders.get(i).getComments() == null) {
                System.out.println();
                System.out.println("  Total pris: " + currentOrders.get(i).getPrice() + " kr.");
                System.out.println();
            } else {
                System.out.println("  Kommentar: " + currentOrders.get(i).getComments());
                System.out.println("  Total pris: " + currentOrders.get(i).getPrice() + " kr.");
                System.out.println();
            }
        }


    }
    public void printArchive() {

        for (int i = 0; i < archiveOrders.size(); i++) {

            for (int n = 0; n < archiveOrders.get(i).orderedPizzas.size(); n++) {
                System.out.println("  " + archiveOrders.get(i).orderedPizzas.get(n).toString());
            }
                System.out.println("  Total pris: " + archiveOrders.get(i).getPrice() + " kr.\n");
        }
    }
}
