import java.text.DecimalFormat;

public class IceCreamCone implements IceCream {
    int scoops; // Expected to be 1 or 2
    String flavor; // e.g. "vanilla", "mint chip"

    public IceCreamCone(int scoops, String flavor){
        this.scoops = scoops;
        this.flavor = flavor;
    }

    public void examine(){
        System.out.println("You are ordering a " + scoops + "-scoop " + flavor + " ice cream cone.");
        // More lines appear underneath in the decorators, for example:

        // You have a 2-scoop rocky road ice cream cone.
        // It is decorated with red sprinkles.

        // This will occur by overriding the examine() method such that we run the original examine(), then simply layering on more print statements (or methods with print statements in them) after it.
        // This way, an ice cream cone or cup can be sprinkled upon with equal ease, not needing a separate decorator class for each permutation of ice cream.
        // The world could have a hundred varieties of ice cream (gelato, sundaes, mochi, etc), yet Java is placated by the use of the interface and lets us decorate them all.
    }

    // Cones are pretty simple, based only on number of scoops.
    public float determineCost(){
        // Initialize the value that will be returned
        float total = (float) 0.0;
        
        // Scoops:
        //float scoopFactor = (float) 2.5;
        total += (float) scoops * scoopFactor;

        // Cone addition:
        total += coneCost;

        return total;
    }

    public void printCost(){
        // To make it use exactly 2 decimal places, we use a DecimalFormat.
        DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);
        

        System.out.println("It costs $" + df.format(this.determineCost()) + ".");
    }
}
