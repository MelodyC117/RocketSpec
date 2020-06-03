import java.lang.reflect.Array;
import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class Simulation {

    /**
     * this method loads all items from a text file and returns an ArrayList of Items:
     * Each line in the text file consists of the item name followed by = then its weigh in kg.
     */
    public ArrayList<Item> loadItems(ArrayList<Item> cargoList, int phase) throws Exception {
        File file = new File((phase == 1) ? "P1.txt" : "P2.txt");
        Scanner scan = new Scanner(file);

        while (scan.hasNextLine()) {
            Item cargo = new Item();
            String[] cargoItem = scan.nextLine().split("=");
            cargo.name = cargoItem[0];
            cargo.weight = Integer.parseInt(cargoItem[1]);
            cargoList.add(cargo);
        }
        return cargoList;
    }

    /**
     * this method takes the ArrayList of Items returned from loadItems and starts creating U1 rockets.
     * It first tries to fill up 1 rocket with as many items as possible before creating a new rocket object and
     * filling that one until all items are loaded. The method then returns the ArrayList of those U1 rockets that are fully loaded.
     */
    public ArrayList<U1> loadU1(ArrayList<Item> cargoList) {
        ArrayList<Item> U1Item = new ArrayList<Item>();

        int i = 0;
        while (i < cargoList.size()){
            U1 U1Rocket = new U1();
            while (U1Rocket.currentWeight < U1Rocket.maxWeight) {

            }
        }
        return U1Item;
    };

}















