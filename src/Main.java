import java.util.Scanner;

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
        // Successful!
        /*
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
        //*/

        // GET USER INPUT
        try(Scanner scanny = new Scanner(System.in)){
            String flavor;
            String typeChoice;
            int scoops;
            String cupSize; // Only used for cups, not cones
            IceCreamSprinkler cream;

            // GENERATE STANDARD ICE CREAM

            System.out.println("Welcome to Java Creamery! What flavor of ice cream would you like?");
            flavor = scanny.nextLine();

            System.out.println("Excellent choice. How many scoops?");
            try{
                scoops = Integer.parseInt(scanny.nextLine());
            }
            catch(Exception e){
                System.out.println("Something went wrong when trying to interpret that as an integer. Defaulting to 1 scoop.");
                scoops = 1;
            }

            if(scoops < 1){
                System.out.println("You can't have 0 or negative scoops! Defaulting to 1 scoop.");
                scoops = 1;
            }

            System.out.println("Would you like your ice cream in a cone or a cup?");
            typeChoice = scanny.nextLine();

            // User picks cone: Simply make it using the provided scoops and flavor
            if(typeChoice.toLowerCase().contains("cone")){
                System.out.println("Cone selected.");
                cream = new IceCreamSprinkler(new IceCreamCone(scoops, flavor));
            }

            // User picks cup: Ask for size as well, then plug in "small", "medium", or "large" for the size depending on their response
            else if(typeChoice.toLowerCase().contains("cup")){
                System.out.println("Cup selected.");
                System.out.println("Would you like a small, medium, or large cup?");
                cupSize = scanny.nextLine();
                if(cupSize.toLowerCase().contains("small")){
                    cream = new IceCreamSprinkler(new IceCreamCup(scoops, flavor, "small"));
                    System.out.println("Small cup selected.");
                }
                else if(cupSize.toLowerCase().contains("large")){
                    cream = new IceCreamSprinkler(new IceCreamCup(scoops, flavor, "large"));
                    System.out.println("Large cup selected.");
                }
                else{
                    cream = new IceCreamSprinkler(new IceCreamCup(scoops, flavor, "medium"));
                    System.out.println("Medium cup selected.");
                }

            }

            // User messes up: Default to cone
            else{
                System.out.println("Sorry, I couldn't interpret that as a cone or cup. Defaulting to a cone.");
                cream = new IceCreamSprinkler(new IceCreamCone(scoops, flavor));
            }

            

            // DECORATE ICE CREAM
            String decorationChoice = "";
            System.out.println("Time to decorate your ice cream with toppings!");

            while(!decorationChoice.toUpperCase().contains("STOP")){
                cream.examine(); // Helpful printout
                System.out.println("Would you like sprinkles, whipped cream, fruit, or wafers? You can select the same thing again to add another unit of it. Or, type STOP to end decoration and place your order.");
                decorationChoice = scanny.nextLine();

                // SPRINKLES
                if(decorationChoice.toLowerCase().contains("sprinkle")){
                    cream.sprinkle();
                }

                // WHIPPED CREAM
                else if(decorationChoice.toLowerCase().contains("whip")){
                    cream.whip();
                }

                // FRUIT
                // the user can also use the fruit's exact name
                else if(decorationChoice.toLowerCase().contains("fruit") || decorationChoice.contains(cream.fruitType)){
                    // If this is the first fruit, ask what kind
                    if(cream.fruitQuantity < 1){
                        System.out.println("What kind of fruit would you like? e.g. banana slices");
                        String fruitChoice = scanny.nextLine();
                        cream.fruitify(fruitChoice);
                    }

                    // Otherwise, this is not the first fruit, and we add more of the same
                    else{
                        cream.fruitify();
                    }
                }

                // WAFERS
                else if(decorationChoice.toLowerCase().contains("wafer")){
                    cream.waferize();
                }

                // STOP
                else if(decorationChoice.toUpperCase().contains("STOP")){
                    break;
                }

                // NONE
                else{
                    System.out.println("Sorry, I don't recognize that option. Please try again.");
                }
            }

            // After decoration is done, the order is complete!
            // Print an appropriate message to the console using the Sprinkler methods:
            cream.examine();
            cream.printCost();

            System.out.println("Order complete. Here is your ice cream!");
            System.out.println("Thank you for shopping with Java Creamery!");
        }
        
    }
}
