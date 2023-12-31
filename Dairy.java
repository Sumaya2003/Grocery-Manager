public class Dairy extends GroceryItem {
    int refrigerationTemperature;
    /**
     *This Dairy class's constructor calls the base class's arg constructor, which takes an argument.
     * in the Dairy constructor's name, quantity, and price arguments
     * parameter. It then initializes instance variable refrigerationTemperature to
     * refrigerationTemperature is an int parameter.
     * .*/
    public Dairy(String name, int quantity, double price, int refrigerationTemperature) {
        super(name, quantity, price);
        this.refrigerationTemperature = refrigerationTemperature;
    }

    public Dairy(String inputLine)
    {

        super(inputLine.split(" ")[1],Integer.parseInt(inputLine.split(" ")[2]), Double.parseDouble(inputLine.split(" ")[3]));
        this.refrigerationTemperature=Integer.parseInt(inputLine.split(" ")[4]);

    }
    //concatenates it with formatted String that prints Temperature using argument
    // * given by Accessor method getRefrigerationTemperature.
    @Override
    public String toString() {
        return super.toString()+String.format("%-5s"," Temperature: "+getRefrigerationTemperature());
    }
    // return the temp of friderater 
    public int getRefrigerationTemperature() {
        return refrigerationTemperature;
    }
    //sets instance variable refrigerationTemperature to the
    //* parameter int temp value.
    public void setRefrigerationTemperature(int refrigerationTemperature) {
        this.refrigerationTemperature = refrigerationTemperature;
    }
}
