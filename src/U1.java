public class U1 extends Rocket {
    /**
     * Rocket cost = $100 Million
     * Rocket weight = 10 Tonnes
     * Max weight (with cargo) = 18 Tonnes
     * Chance of launch explosion = 5% * (cargo carried / cargo limit)
     * Chance of landing crash = 1% * (cargo carried / cargo limit)
     */

    U1() {
        cost = 100;
        maxWeight = 18000;
        rocketWeight = 10000;
        cargoLimit = maxWeight - rocketWeight;
        rateExplode = 0.05;
        rateCrash = 0.01;
        currentWeight = rocketWeight;
    }

    public boolean isLaunch() {
        isExploded = rateExplode * (double) (this.cargoWeight / this.cargoLimit);
        return (isExploded >= randomNumber);
    };

    public boolean isLand() {
        isCrashed = rateCrash * (double) (this.cargoWeight / this.cargoLimit);
        return (isCrashed >= randomNumber);
    };
}
