public class Rocket implements Spaceship{
    /**
     * launch and land methods in the Rocket class should always return true. When U1 and U2 classes extend the Rocket class
     * they will override these methods to return true or false based on the actual probability of each type.
     * carry and canCarry should be implemented here and will not need to be overridden in the U1 and U2 classes
     */

    int currentWeight;
    int cost;
    int maxWeight;
    int rocketWeight;
    int cargoLimit;
    int cargoWeight;
    double rateExplode;
    double rateCrash;
    double isExploded;
    double isCrashed;
    double randomNumber;

    Rocket() {
        currentWeight = 0;
        cost = 0;
        rocketWeight = 0;
        maxWeight = 0;
        cargoLimit = 0;
        cargoWeight = 0;
        rateExplode = 0.0;
        rateCrash = 0.0;
        isExploded = 0.0;
        isCrashed = 0.0;
        randomNumber = Math.random();
    }

    public boolean isLaunch() {
        return true;
    };

    public boolean isLand() {
        return true;
    };

    public boolean canCarry(Item cargo) {
        return (cargo.weight + this.currentWeight <= this.maxWeight);
    };

    public void carry(Item cargo) {
        this.currentWeight += cargo.weight;
        this.cargoWeight += cargo.weight;
    };



}
