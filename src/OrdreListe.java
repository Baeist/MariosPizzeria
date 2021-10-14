import java.util.ArrayList;
import java.util.Scanner;

public class OrdreListe {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Ordre> currentOrders = new ArrayList<>();

    public OrdreListe() {}
    public OrdreListe(ArrayList<Ordre> list) {
        this.currentOrders = list;
    }

    public void addOrdre(Ordre newOrder) {
        currentOrders.add(newOrder);

    }


    public void showCurrent() {
        System.out.println(currentOrders);
    }


    public ArrayList<Ordre> getCurrentOrders() {
        return currentOrders;
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
}
