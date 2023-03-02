public abstract class IceCreamDecorator implements IceCream {
    // Attributes
    protected IceCream decoratedIceCream;

    // Attributes will include some useful costs:
    float sprinkleFactor = (float) 0.3;
    float whippedCreamFactor = (float) 0.35;
    float fruitFactor = (float) 0.4;
    float waferFactor = (float) 0.45;

    // Constructor
    public IceCreamDecorator(IceCream decoratedIceCream){
        this.decoratedIceCream = decoratedIceCream;
    }

    // Methods
    // By default, examine() runs the IceCream's own, original examine().
    // This can, and most likely will, be overridden by a concrete subclass of this decorator.
    public void examine(){
        decoratedIceCream.examine();
    }

    public float determineCost(){
        return decoratedIceCream.determineCost();
    }

    public void printCost(){
        decoratedIceCream.printCost();
    }

    
}
