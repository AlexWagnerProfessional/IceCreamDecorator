public abstract class IceCreamDecorator implements IceCream {
    // Attributes
    protected IceCream decoratedIceCream;

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
}
