public interface IceCream {
    // Implemented by: Cone, Cup
    // Each of those keeps track of a number of scoops and a flavor.
    // More things, like sprinkles, should come in via decorators.

    // Some useful numbers for calculating costs among various types of ice cream:
    float scoopFactor = (float) 2.5;
    float coneCost = (float) 1.5;
    float cupCost = (float) 1.0;

    // Should print a message to the console showing off the ice cream cone/cup
    public void examine();
    public float determineCost();
    public void printCost();
}
