import java.text.DecimalFormat;

public class IceCreamSprinkler extends IceCreamDecorator {
    int sprinkleQuantity;
    int whippedCreamQuantity;
    int fruitQuantity;
    String fruitType;
    int waferQuantity;

    // Constructor (quite standard for a decorator)
    public IceCreamSprinkler(IceCream decoratedIceCream) {
        super(decoratedIceCream);
        // Initialize the new values
        this.sprinkleQuantity = 0;
        this.whippedCreamQuantity = 0;
        this.fruitQuantity = 0;
        this.fruitType = "fruit"; // Meant to be replaced, but this is a nice general fail-safe
        this.waferQuantity = 0;
    }

    public void sprinkle(){
        // Add another unit of sprinkledness
        sprinkleQuantity++;
        System.out.println("Sprinkles added! There are now " + sprinkleQuantity + " teaspoons of sprinkles on the ice cream.");
    }

    public void whip(){
        // Add another unit of whipped cream
        whippedCreamQuantity++;
        System.out.println("Whipped cream added! There are now " + whippedCreamQuantity + " blasts of whipped cream on the ice cream.");
    }

    public void fruitify(){
        // Add another unit of fruit
        fruitQuantity++;
        System.out.println(fruitType + " added! There are now " + fruitQuantity + " " + fruitType + " on the ice cream.");
    }

    public void fruitify(String fruit){
        // Add another unit of fruit and assign the kind of fruit
        fruitQuantity++;
        fruitType = fruit; 
        System.out.println(fruitType + " added! There are now " + fruitQuantity + " " + fruitType + " on the ice cream.");
    }

    public void waferize(){
        // Add another unit of wafers
        waferQuantity++;
        System.out.println("Wafer added! There are now " + waferQuantity + " wafers in the ice cream.");
    }

    @Override
    public void examine(){
        // First use the already-implemented printout...
        decoratedIceCream.examine();
        // Then place more lines under it.
        System.out.println("It has been decorated with:");
        
        
        // SPRINKLES
        if(sprinkleQuantity > 0){
            System.out.println(sprinkleQuantity + " teaspoons of sprinkles");
        }

        // WHIPPED CREAM
        if(whippedCreamQuantity > 0){
            System.out.println(whippedCreamQuantity + " blasts of whipped cream");
        }

        // FRUIT
        if(fruitQuantity > 0){
            System.out.println(fruitQuantity + " " + fruitType);
        }

        // WAFERS
        if(waferQuantity > 0){
            System.out.println(waferQuantity + " wafers");
        }

        // NONE
        if(sprinkleQuantity == 0 && whippedCreamQuantity == 0 && fruitQuantity == 0 && waferQuantity == 0){
            System.out.println("Nothing yet!");
        }
        
    }

    @Override
    public float determineCost() {
        // First, get the cost it would have if it were undecorated.
        float total = decoratedIceCream.determineCost();

        // Then add decoration costs.
        // SPRINKLES
        total += sprinkleFactor * sprinkleQuantity;

        // WHIPPED CREAM
        total += whippedCreamFactor * whippedCreamQuantity;

        // FRUIT
        total += fruitFactor * fruitQuantity;

        // WAFERS
        total += waferFactor * waferQuantity;

        return total;
    }

    @Override
    public void printCost(){
        // To make it use exactly 2 decimal places, we use a DecimalFormat.
        DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);
        

        System.out.println("It costs $" + df.format(this.determineCost()) + ".");
    }

    
}
