import java.text.DecimalFormat;

public class IceCreamSprinkler extends IceCreamDecorator {
    int sprinkleQuantity;

    // Constructor (quite standard for a decorator)
    public IceCreamSprinkler(IceCream decoratedIceCream) {
        super(decoratedIceCream);
        this.sprinkleQuantity = 0;
    }

    public void sprinkle(){
        // Add another unit of sprinkledness
        sprinkleQuantity++;
        System.out.println("Sprinkles added! There are now " + sprinkleQuantity + " helpings of sprinkles on the ice cream.");
    }

    @Override
    public void examine(){
        // First use the already-implemented printout...
        decoratedIceCream.examine();
        // Then place more lines under it.
        System.out.println("It has been decorated with " + sprinkleQuantity + " helpings of sprinkles!");
    }

    @Override
    public float determineCost() {
        // First, get the cost it would have if it were undecorated.
        float total = decoratedIceCream.determineCost();

        // Then add decoration costs.
        total += sprinkleFactor * sprinkleQuantity; // Experiment: can a float and int be multiplied together safely? If not, use the line below instead:
        //total += sprinkleFactor * (float) sprinkleQuantity;

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
