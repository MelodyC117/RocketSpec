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
        File file = new File((phase == 1) ? "src/P1.txt" : "src/P2.txt");
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
    public ArrayList<Rocket> loadU1(ArrayList<Item> cargoList) {
        ArrayList<Rocket> U1Item = new ArrayList<>();
        U1 U1Rocket = new U1();
        int counter = 1;

        for (Item cargo : cargoList) {
            if (U1Rocket.canCarry(cargo)) {
                U1Rocket.carry(cargo);
                System.out.println("Loading ... " + cargo.weight + " kg");
                System.out.println("Current Weight: " + U1Rocket.currentWeight + " kg");
            }
            else {
                U1Item.add(U1Rocket);
                U1Rocket = new U1();
                counter++;
                U1Rocket.carry(cargo);
                System.out.println("Creating New Rocket ... ");
                System.out.println("Loading ... " + cargo.weight + " kg");
                System.out.println("Current Weight: " + U1Rocket.currentWeight + " kg");
            }
        }
        U1Item.add(U1Rocket);
        System.out.println("Total Rockets for U1 created: " + counter);
        return U1Item;
    };

    public ArrayList<Rocket> loadU2(ArrayList<Item> cargoList) {
        ArrayList<Rocket> U2Item = new ArrayList<>();
        U2 U2Rocket = new U2();
        int counter = 1;

        for (Item cargo : cargoList) {
            if (U2Rocket.canCarry(cargo)) {
                U2Rocket.carry(cargo);
                System.out.println("Loading ... " + cargo.weight + " kg");
                System.out.println("Current Weight: " + U2Rocket.currentWeight + " kg");
            }
            else {
                U2Item.add(U2Rocket);
                U2Rocket = new U2();
                U2Rocket.carry(cargo);
                counter++;
                U2Rocket.carry(cargo);
                System.out.println("Creating New Rocket ... ");
                System.out.println("Loading ... " + cargo.weight + " kg");
                System.out.println("Current Weight: " + U2Rocket.currentWeight + " kg");
            }
        }
        U2Item.add(U2Rocket);
        System.out.println("Total Rockets for U2 created: " + counter);
        return U2Item;
    };

    /**
     * this method takes an ArrayList of Rockets and calls launch and land methods for each of the rockets in the ArrayList.
     * Every time a rocket explodes or crashes (i.e if launch or land return false) it will have to send that rocket again.
     * All while keeping track of the total budget required to send each rocket safely to Mars. runSimulation then returns
     * the total budget required to send all rockets (including the crashed ones).
     */
    public int runSimulation(ArrayList<Rocket> rockets) {

        boolean launchSuccess;
        boolean landSuccess;
        int totalBudget = 0;
        for (Rocket rocket : rockets) {
            launchSuccess = rocket.isLaunch();
            landSuccess = rocket.isLand();
            System.out.println("Launch Success: " + launchSuccess);
            System.out.println("Land Success: " + landSuccess);
            while (!launchSuccess || !landSuccess) {
                totalBudget += rocket.cost;
                launchSuccess = rocket.isLaunch();
                landSuccess = rocket.isLand();
                System.out.println("Launch Success: " + launchSuccess);
                System.out.println("Land Success: " + landSuccess);
                System.out.println("Total Cost: " + totalBudget);
            }
        }
        return totalBudget;
    };

}















