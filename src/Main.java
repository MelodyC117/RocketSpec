import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class Main {

    public static void main(String [] args) throws Exception {

        double totalCost = 0;
        Simulation sim = new Simulation();
        ArrayList<Item> cargoListP1 = new ArrayList<>();
        ArrayList<Item> cargoListP2 = new ArrayList<>();
        ArrayList<Rocket> U1P1 = new ArrayList<>();
        ArrayList<Rocket> U1P2 = new ArrayList<>();
        ArrayList<Rocket> U2P1 = new ArrayList<>();
        ArrayList<Rocket> U2P2 = new ArrayList<>();

        // U1 - load all from P1
        cargoListP1 = sim.loadItems(cargoListP1, 1);
        U1P1 = sim.loadU1(cargoListP1);
        totalCost = sim.runSimulation(U1P1);
        System.out.println("Total budget for Phase 1 with U1 is " + totalCost);

        // U1 - load all from P2
        cargoListP2 = sim.loadItems(cargoListP2, 2);
        U1P2 = sim.loadU1(cargoListP2);
        totalCost = sim.runSimulation(U1P2);
        System.out.println("Total budget for Phase 1 with U1 is " + totalCost);

        // U2 - load all from P1
        U2P1 = sim.loadU2(cargoListP1);
        totalCost = sim.runSimulation(U2P1);
        System.out.println("Total budget for Phase 1 with U1 is " + totalCost);

        // U2 - load all from P1
        U2P2 = sim.loadU2(cargoListP2);
        totalCost = sim.runSimulation(U2P2);
        System.out.println("Total budget for Phase 1 with U1 is " + totalCost);
    }
}
