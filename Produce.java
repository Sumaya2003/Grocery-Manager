public class Produce extends GroceryItem {
    private boolean isOrganic;
    /**It then initializes instance variable organic to the parameter
     * boolean isOrganic.
     * 
     * @param name
     * @param quantity
     * @param price
     * @param isOrganic
     */
    public Produce(String name, int quantity, double price, boolean isOrganic) {
        super(name, quantity, price);
        this.isOrganic = isOrganic;
    }

    /**
     *  * This class's constructor takes a line from a file and splits it into two lines.
     * on the empty spaces and stores each item that is separated by the separator.
     * in the produceInput array, in order.
     */
    public Produce(String inputLine) {

        super( inputLine.split(" ")[1], Integer.parseInt(inputLine.split(" ")[2]), Double.parseDouble(inputLine.split(" ")[3]));
        this.isOrganic = Boolean.parseBoolean(inputLine.split("")[4]);

    }
    //This method assigns the parameter boolean organic to the instance variable organic.
    public boolean isOrganic() {
        return isOrganic;
    }
    // set muatater organic 
    public void setOrganic(boolean organic) {
        isOrganic = organic;
    }

    /**Then it
     * combines it with a formatted string that prints isOrganic using the argument
     * given by the getIsOrganic method of the Accessor.
     */
    @Override
    public String toString() {
        return super.toString() +String.format("%-5s", " Organic: " + isOrganic);
    }
}
