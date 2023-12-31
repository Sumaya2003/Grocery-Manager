public class Meat extends GroceryItem{
    private   boolean isGround;
// Meat class constructor it will instalize all the instance variables 
    public Meat(String name, int quantity, double price, boolean isGround) {
        super(name, quantity, price);
        this.isGround = isGround;
    }

    /** takes in file input line, splits the inputLine based
     * on the blank spaces and stores each item delimited by the separator is stored
     * in order in the meatInput array.*/
    public Meat(String inputLine)
    {

        super(inputLine.split(" ")[1],Integer.parseInt(inputLine.split(" ")[2]), Double.parseDouble(inputLine.split(" ")[3]));
        this.isGround=Boolean.parseBoolean(inputLine.split(" ")[4]);



    }

    /**This class's version of toString calls the base class's toString method. Then it
     * combines it with a formatted string that prints isGround using the argument
     * given by the method getIsGround of the Accessor.*/
    @Override
    public String toString() {
        return super.toString()+String.format("%-5s"," isGround: "+isGround);
    }
    //@return ground
    public boolean isGround() {
        return isGround;
    }

    public void setGround(boolean ground) {
        isGround = ground;
    }
}
