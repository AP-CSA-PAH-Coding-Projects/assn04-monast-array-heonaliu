package apcsa.githubtrack;

// Implement your ShoppingCart class here
public class ShoppingCart
{
    private ShoppingList list;
    private String name;
    private boolean missionComp;
    private static int numShopCarts; // variable part of the class, not a specific instance

    //CONSTRUCTORS ===========
    //constructor if provide a name and list
    public ShoppingCart(String initName, ShoppingList initList)
    {
        name = initName;
        list = initList;
        missionComp = false;
    }

    //only provides a list
    public ShoppingCart(ShoppingList initList)
    {
        list = initList;
        missionComp = false;
    }

    // only provides name
    public ShoppingCart(String initName)
    {
        name = initName;
        list = new ShoppingList();
        missionComp = false;
    }

    //if no list initiated,  use this constructor
    public ShoppingCart()
    {
        list = new ShoppingList();
        missionComp = false;
    }

    //METHODS ========
    
    public boolean isCompleted()
    {
        //counts how many items in Shopping list that are sold
        int count = 0;
        for (int i = 0; i<list.getSize(); i++)
        {
            //gets the item at index i and checks if the item is sold
            if (list.getAt(i).isSold() == true)
            {
                count++;
            }
        }
        //if size of the list and number of items sold match, must be all completed
        if (list.getSize() == count)
        {
            missionComp = true;
            return true;
        } else {
            return false;
        }
    }

    public void returnCart()
    {
        //checks if everything is bought
        if (isCompleted()) //removed a redundant part
        {
            //completes mission AND adds to total returned carts
            numShopCarts++;
        }
    }

    // Getters ============
    public String getName()
    {
        return name;
    }
    public boolean getCompleted()
    {
        return missionComp;
    }
    public static int getTotalCartsReturned()
    {
        return numShopCarts;
    }
}