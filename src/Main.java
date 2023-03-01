public class Main {
    public static void main(String[] args) throws Exception {
        // DECORATOR PATTERN
        // First, make an interface. Say, ice cream.
        // Then, make concrete classes implementing it. Say, ice cream cone, ice cream sandwich, sundae.
            // Ice-creams are served in single or double scoops either in a cup (small, medium, large) or in a cone.
        // Then, make an abstract IceCreamDecorator class, also implementing the interface.
        // Then, make a concrete IceCreamSprinkleSprayer class extending that.

        // REMEMBER: Must calculate cost!

        // Debug
        ///*
        IceCreamCup cuppy = new IceCreamCup(2, "vanilla", "large");
        IceCreamCone coney = new IceCreamCone(1, "chocolate");
        cuppy.examine();
        cuppy.printCost();
        coney.examine();
        coney.printCost();
        //*/

        // TODO: Make actual decorators now that the basic ice cream functionality is there
    }
}
