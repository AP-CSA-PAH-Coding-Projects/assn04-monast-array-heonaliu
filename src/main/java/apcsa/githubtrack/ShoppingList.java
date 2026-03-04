package apcsa.githubtrack;

// Implement the ShoppingList class here

public class ShoppingList implements MyList {
    //instance variables
    private int capacity;
    private int size;
    private ShoppingItem[] storage;

    public ShoppingList()
    {
        capacity = 8;
        size = 0;
        storage = new ShoppingItem[capacity];
    }

    // public ShoppingList(int initCapacity, int initSize)
    // {
    //     capacity = 8;
    //     size = 0;
    //     storage = new ShoppingItem[capacity];
    // }

    public void addToEnd(Object s) //err msg requires this be an Object
    {
        ShoppingItem item = (ShoppingItem)s; //casting to Shopping Item
        //checks if full
        if (size == capacity)
        {
            //then double capacity space using makeCapacity() method
            makeCapacity(capacity*2);
        }
        //appends storage to size (index of item in the list)
        storage[size] = item;
        size++; //adding a new item
    }

    public void insertAt(int index, Object item)
    {
        ShoppingItem newI = (ShoppingItem)item; //casting to Shopping Item
        //checks for invalid indexes
        if (index<0 || index > size)
        {
            System.out.println("Invalid index!");
        } else {
            if (size == capacity)
            {
                makeCapacity(capacity*2);
            }
            //starting from the last item all the way to index, shifts 1 space to the right
            for (int i = size; i>index; i--)
            {
                storage[i] = storage[i-1];
            }
            storage[index] = newI; // inserts new item at specified index
            size++; // increment size since a new item is added
        }
    }

    public void removeAt(int index)
    {
        //checks for invalid indexes
        if (index<0 || index > size)
        {
            System.out.println("Invalid index!");
        } else {
            //reverse the insertAt method (start at index) each value is the value to it's right
            for (int i = index; i < size-1; i++)
            {
                storage[i] = storage[i+1];
            }
            size--; //removing one item    
        }
    }

    public ShoppingItem getAt(int index)
    {
       //checks for invalid indexes or also if index has no item
        if (index<0 || index > size || storage[index] == null)
        {
            System.out.println("Invalid index!");
            //must return ShoppingItem so if invalid, return an invalid item
            ShoppingItem inv = new ShoppingItem("Invalid", 0);
            return inv;
        } else {
            //if exists, returns item at index
            return storage[index];
        }
    }

    //returns size attribute
    public int getSize()
    {
        return size;
    }

    // Capacity Management

    public void makeCapacity(int minCapacity)
    {
        // if (!(mincapacity <= size || minCapacity==capacity)) 
        if (minCapacity > size && minCapacity != capacity)
        {
            // if mincap is less than 8, set it to 8, else set it to the min capacity
            if (minCapacity < 8)
            {
                capacity = 8;
            } else {
                capacity = minCapacity;
            }

            //creates a new array with the new capacity
            ShoppingItem[] newStorage = new ShoppingItem[minCapacity];

            //copies every item from old array to new array
            for (int i = 0; i<size; i++)
            {
                newStorage[i] = storage[i];
            }
            //adjust item's attributes to the new values for new storage list and new capacity
            storage = newStorage;
            capacity = minCapacity;
        }
    }

    // removes any null items in storage
    public void trimExcess()
    {
        //if array length not already = size, then call makeCapacity to create a new array with the capacity of 'size' attribute
        if (storage.length != size)
        {
            makeCapacity(size);
        }
    }

    public void goShopping()
    {
        for (ShoppingItem s: storage)
        {
            if (s!=null)
            {
                //sets every item to become "bought"
                s.buy();
            }
        }
    }

    public void goShopping(ShoppingList toBuy)
    {
        //for each item of toBuy
        for (int i = 0; i<toBuy.getSize(); i++)
        {
            //checks a specific item at each index of i of toBuy
            ShoppingItem otherItem = toBuy.getAt(i);
            for (int j = 0; j<storage.length;j++)
            {
                //checks each index of storage if it's equal to the item from toBuy
                // if yes, set it as bought
                if (storage[j]!= null && storage[j].equals(otherItem))
                {
                    storage[j].buy();
                    break;
                }
            }
        }
    }

    //gets total price
    public double getTotalPrice()
    {
        double price = 0.0;
        //for each loop that checks !null and adds to the price and returns the sum
        for (ShoppingItem s: storage)
        {

            if (s != null)
            {
                price += s.getPrice();
            }

        }
        return price;
    }

    public boolean isIdentical(ShoppingList other)
    {
        boolean found = false;
        //checks size, if not equal, automatically return false without checking anything else
        if (other.getSize() != size)
        {
            return false;
        }
        
        for (int i = 0; i < other.getSize(); i++)
        {
            //reset found variable for each item
            found = false;
            ShoppingItem currItem = other.getAt(i);
            for (int j = 0; j<size; j++)
            {
                //for each item in storage, check if currItem exists (if there is at least one instance, found will be set to true)
                if (storage[j].equals(currItem))
                {
                    found = true;
                }
            }
            //if there is one item not found, we can immediately break the loop by returning false
            if (!found)
            {
                return false;
            }
        }
        // if all found, we can return true
        return true;
    }

    //Getters
    public int getCapacity()
        {
            return capacity;
        }
    public ShoppingItem[] getStorage()
    {
        return storage;
    }


}