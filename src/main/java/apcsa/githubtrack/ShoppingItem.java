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
        price = initPrice*100; // stores price in pennies, therefore multiply by 100
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
        if (name.equals(other.getName()) && price == other.getPrice())
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
        if (name.equals(other.getName()))
        {
            //if yes, it'll check which price is larger and return the difference (positive or negative)
            if (price>other.getPrice())
            {
                return price - other.getPrice();
            } else if (price < other.getPrice())
            {
                return price - other.getPrice();
            }
            // if not larger or smaller, must be equal --> returns 0 as difference
            else {
                return 0;
            }
        }
        else {
            // if not names equal, prints an error message
            System.out.println("Different items!");
            return 0;
        }
    }

    //The getters to access attributes outside of the class
    public String getName()
    {
        return name;
    }
    public int getPrice()
    {
        return price;
    }
    public boolean getSold()
    {
        return sold;
    }



}