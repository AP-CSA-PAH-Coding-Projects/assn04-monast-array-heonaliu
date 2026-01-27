package apcsa.githubtrack;

// Implement your ShoppingItem class here
public class ShoppingItem
{
    //attributes
    private String name;
    private int price;
    private boolean sold;

    // constructor to initialize my object
    public ShoppingItem(String initName, int initPrice)
    {
        name = initName;
        price = initPrice; // stores price in pennies, therefore multiply by 100
        sold = false; //automatically sets sold to false
    }

    // sets sold to buy when bought
    public void buy()
    {
        this.sold = true;
    }

    // checks if name of object equals the other item using getName() getter to access the name attribute && checks the price with the getPrice() method
    public boolean equals(ShoppingItem other)
    {
        if (name.equals(other.getName()) && (double)price/100 == other.getPrice())
        {
            System.out.println("Items with same name and price should be equal");
            return true;
        }
        else {
            if (name.equals(other.getName()))
            {
                System.out.println("Items with same name but different price should not be equal");
                return false;
            }

            return false;
        }
    }

    //made my own helper function to compare the names of two items
    public boolean nameEquals(String s)
    {
        if (name.equals(s))
            {
                return true;
            }
            else {
                return false;
            }

    }

    // compares my item price to the same kind of item
    public double compareTo(ShoppingItem other)
    {
        //checks if names are equal
        if (nameEquals(other.getName()))
        {
            double myPrice = (double) price / 100.0;
            //if prices aren't equal, then return the difference
           if (myPrice==other.getPrice())
            {
                return 0;
            } 
            else{
                // should return a positive or negative number depending on how expensive
                return myPrice - other.getPrice();
            }
        }
        else {
            // if not names equal, prints an error message
            System.out.println("Error: Different items!");
            return 0;
        }
    }

    //The getters to access attributes outside of the class
    public String getName()
    {
        return name;
    }
    public double getPrice()
    {
        return price/100.0;
    }
    public boolean isSold()
    {
        return sold;
    }



}