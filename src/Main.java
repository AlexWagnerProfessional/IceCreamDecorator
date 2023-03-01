public class Main {
    public static void main(String[] args) throws Exception {
        // DECORATOR PATTERN
        // First, make an interface. Say, ice cream.
        // Then, make concrete classes implementing it. Say, ice cream cone, ice cream sandwich, sundae.
            // Ice-creams are served in single or double scoops either in a cup (small, medium, large) or in a cone.
        // Then, make an abstract IceCreamDecorator class, also implementing the interface.
        // Then, make a concrete IceCreamSprinkleSprayer class extending that.

        // REMEMBER: Must calculate cost!

        // Debug: Successful!
        /*
        IceCreamCup cuppy = new IceCreamCup(2, "vanilla", "large");
        IceCreamCone coney = new IceCreamCone(1, "chocolate");
        cuppy.examine();
        cuppy.printCost();
        coney.examine();
        coney.printCost();
        //*/

        // DECORATOR TEST: SPRINKLES
        IceCreamSprinkler sprinky = new IceCreamSprinkler(new IceCreamCone(2, "chocolate"));
        sprinky.sprinkle();
        sprinky.sprinkle();
        sprinky.examine();
        sprinky.printCost();

        IceCreamSprinkler spunky = new IceCreamSprinkler(new IceCreamCup(1, "snickerdoodle", "large"));
        spunky.sprinkle();
        spunky.sprinkle();
        spunky.sprinkle();
        spunky.examine();
        spunky.printCost();
    }
}
