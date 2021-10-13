import java.util.ArrayList;

public class OrdreListe {

    ArrayList<Ordre> currentOrders = new ArrayList<>();

    public OrdreListe(){};


    public void addOrdre(Ordre newOrder){
        currentOrders.add(newOrder);
        }

       public void showCurrent(){

          System.out.println();

       }


    public ArrayList<Ordre> getCurrentOrders() {
        return currentOrders;
    }
}
