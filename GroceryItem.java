/**GroceryItem is an abstract class that uses Comparable and
 * is a base class for Grocery Items that is used by its subclasses.
 * has Dairy, Produce, and Meat as its subclasses.*/
public abstract  class GroceryItem implements Comparable<GroceryItem>
{

    private String name;

    private int quantity;
    private double price;
    //constructor that initializes instance variables name, quantity, and
    // * price to parameter variables name, quantity, and price.
    public GroceryItem(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // return the prcie
    public double getPrice() {
        return price;
    }
    // set the price 
    public void setPrice(double price) {
        this.price = price;
    }
    // return the quanity
    public int getQuantity() {
        return quantity;
    }
    // set the quanity 
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return String.format("%-24s","Name: "+getName()) +String.format("%-24s"," Quantity: "+getQuantity())+ String.format("%-15s"," Price: "+getPrice());
    }

    @Override
    public int compareTo(GroceryItem that) {

        return this.name.trim().compareTo(that.name.trim());

    }
}
