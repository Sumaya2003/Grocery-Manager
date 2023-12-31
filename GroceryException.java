
 //GroceryException inherits the throwable/exception  class to be used as an
 //          exception class for the GroceryManager
public class GroceryException extends Throwable {
    public GroceryException(String out_of_xxx) {
        super(out_of_xxx);
    }
    //This is a no arg class constructor that calls the parent constructor in its
     //* body that contains a message
     public GroceryException() {
        super("This grocery data is Wrong!");
    }

}
