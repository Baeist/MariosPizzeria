import java.util.ArrayList;
import java.util.Scanner;

public class OrdreListe {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Ordre> currentOrders = new ArrayList<>();
    ArrayList<Ordre> archiveOrders = new ArrayList<>();

    public OrdreListe() {}
    public OrdreListe(ArrayList<Ordre> list) {
        this.currentOrders = list;
    }

    public void addOrdre(Ordre newOrder) {
        currentOrders.add(newOrder);

    }
    public void showArchive(){
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

                if (currentOrders.get(i).getTime() < currentOrders.get(i+1).getTime()) {
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

    public void removeOrder() {
        int input;

        System.out.println("Hvilken order vil du fjerne?");
        showCurrent();

        if (scanner.hasNextInt()) {
            input = scanner.nextInt();
            if (input < currentOrders.size() + 1 && input > 0) {
                currentOrders.remove(input-1);

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
                archiveOrders.add(currentOrders.get(input-1));
                currentOrders.remove(input-1);



            } else {
                System.out.println("Fokert input");
            }
        }
    }
}
