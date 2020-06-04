public class U2 extends Rocket {
    /**
     * Rocket cost = $120 Million
     * Rocket weight = 18 Tonnes
     * Max weight (with cargo) = 29 Tonnes
     * Chance of launch explosion = 4% * (cargo carried / cargo limit)
     * Chance of landing crash = 8% * (cargo carried / cargo limit)
     */

    U2() {
        cost = 120;
        maxWeight = 29000;
        rocketWeight = 18000;
        cargoLimit = maxWeight - rocketWeight;
        rateExplode = 0.04;
        rateCrash = 0.08;
        currentWeight = rocketWeight;
    }

    public boolean isLaunch() {
        isExploded = rateExplode * (double) (this.cargoWeight / this.cargoLimit);
        return (isExploded < randomNumber);
    };

    public boolean isLand() {
        isCrashed = rateCrash * (double) (this.cargoWeight / this.cargoLimit);
        return (isCrashed < randomNumber);
    };
}
