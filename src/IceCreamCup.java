import java.text.DecimalFormat;

public class IceCreamCup implements IceCream {
    int scoops; // Expected to be 1 or 2
    String flavor; // e.g. "vanilla", "mint chip"
    String size; // e.g. "small", "medium", "large"

    public IceCreamCup(int scoops, String flavor, String size){
        this.scoops = scoops;
        this.flavor = flavor;
        this.size = size;
    }

    public void examine(){
        System.out.println("You have ordered a " + scoops + "-scoop " + size + " " + flavor + " ice cream cup.");
    }

    // Cups' costs are determined by number of scoops as well as size.
    public float determineCost(){
        // Initialize the value that will be returned
        float total = (float) 0.0;

        // Scoops:
        //float scoopFactor = (float) 2.5;
        total += (float) scoops * scoopFactor;

        // Cup addition:
        total += cupCost;

        // Size multiplier:
        float smallFactor = (float) 0.67;
        float largeFactor = (float) 1.33;
        if(size.equalsIgnoreCase("small")){
            total *= smallFactor;
        }
        else if(size.equalsIgnoreCase("large")){
            total *= largeFactor;
        }
        // All other size strings are assumed to be medium and have a factor of 1.0.

        return total;
    }

    public void printCost(){
        // To make it use exactly 2 decimal places, we use a DecimalFormatter.
        DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);
        

        System.out.println("It costs $" + df.format(this.determineCost()) + ".");
    }
}
