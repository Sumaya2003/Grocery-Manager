import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class GroceryManager {

    private ArrayList<GroceryItem> inventory;
    private HashSet<String> restockingList=new HashSet<>();

    public void loadInventory(String filename) {
        try {
            //use file reader to read data from provided file name
            FileReader reader = new FileReader(filename);
            BufferedReader bufferedReader = new BufferedReader(reader);
            //read the first line of file
            String line = bufferedReader.readLine();
            //the lin contains three numbers store them into num[] array
            String[] num = line.split(" ");
            //get each number from num array
            //first number represents total number of dairy in file
            int numberOfDairy = Integer.parseInt(num[0]);
            //second number represents total number of Produce in file
            int numberOfProduce = Integer.parseInt(num[1]);
            //Third number represents total number of Meat in file
            int numberOfMeat = Integer.parseInt(num[2]);
            int t = 0;

            //populate inventory list
            inventory = new ArrayList<>();
            //use loop to read dairy
            for (int i = 0; i < numberOfDairy; i++) {
                String l = bufferedReader.readLine();
                Dairy dairy = new Dairy(l);
                inventory.add(dairy);
            }

            //use loop to read produce
            for (int i = 0; i < numberOfProduce; i++) {
                String l = bufferedReader.readLine();
                Produce produce = new Produce(l);
                inventory.add(produce);
            }

            //use loop to read meat
            for (int i = 0; i < numberOfMeat; i++) {
                String l = bufferedReader.readLine();
                Meat meat = new Meat(l);
                inventory.add(meat);
            }

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    /*
    Subtracts the items and quantities in the order from the inventory.
     */

    public void processOrder(GroceryOrder<GroceryItem> order) throws GroceryException {


        //get each item from order
        for (GroceryItem itemInOrder:order)
        {

            boolean found=false;
            //get each item from inventory
            for (GroceryItem itemInInventory:inventory)
            {
                //compare both items (0 if they match)
                if(itemInOrder.compareTo(itemInInventory)==0)
                {
                    found=true;
                    //get remaining quantity
                    int quantity=itemInInventory.getQuantity()-itemInOrder.getQuantity();

                    //if quantity if 0 or below
                    if(quantity<=0) {



                        itemInOrder.setQuantity(itemInInventory.getQuantity());
                        itemInInventory.setQuantity(0);
                        restockingList.add(itemInInventory.getName());
                        //inventory.remove(itemInInventory);

                        try {

                            System.out.println("Out of " + itemInOrder.getName());
                            throw new GroceryException("Out of " + itemInOrder.getName());

                        }
                        finally {
                            continue;
                        }


                    }
                    else
                        itemInInventory.setQuantity(quantity);
                }

                /* if (!found)
                throw new GroceryException("Out of "+itemInOrder.getName());*/

            }

        }

    }

    public GroceryItem findItemByName(String name) {
        GroceryItem item1 = null;

        for (int i = 0; i < inventory.size(); i++) {

            GroceryItem item = inventory.get(i);
            if (item.getName().equals(name)) {
                return item;
            }

        }

        return null;

    }

    public void sortInventoryByName() {

        GroceryItem temp;
        int n=inventory.size();
        for(int i=0 ; i<n; i++)
        {

            for(int j=1; j<(n-i); j++)
            {

                if(inventory.get(j-1).compareTo(inventory.get(j))>0)
                {
                    temp=inventory.get(j-1);
                    inventory.set(j-1,inventory.get(j));
                    inventory.set(j,temp);

                }
            }
        }
    }

    public void  sortInventoryByPrice() {

        int n = inventory.size();
        for (int j = 1; j < n; j++) {
            GroceryItem key = inventory.get(j);
            int i = j - 1;
            while ((i > -1) && (inventory.get(i).getPrice() > key.getPrice())) {
                inventory.remove(i+1);
                inventory.add(i+1,inventory.get(i));

                i--;
            }
            inventory.remove(i+1);
            inventory.add(i+1,key);

        }
    }

    public void  displayRestockingList()
    {

        Iterator<String> iterator= restockingList.iterator();

        while (iterator.hasNext())
        {
            System.out.println(iterator.next());
        }

    }

    public void displayInventory()
    {

        for(int i=0; i< inventory.size(); i++)
        {
            System.out.println(inventory.get(i));
        }



    }

}
