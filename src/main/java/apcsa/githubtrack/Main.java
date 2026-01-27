package apcsa.githubtrack;

// Implement your Main class (with the main method) here

public class Main
{
    public static void main(String[] args) {
        //initialize breakfastEssential Items
        ShoppingList breakfastEssentials = new ShoppingList();
        //test addToEnd here ---
        breakfastEssentials.addToEnd(new ShoppingItem("Eggs", 350 ));
        breakfastEssentials.addToEnd(new ShoppingItem("Zucchini", 275 ));
        breakfastEssentials.addToEnd(new ShoppingItem("Frozen Berries", 515 ));
        breakfastEssentials.addToEnd(new ShoppingItem("Smoked Salmon", 999 ));
        ShoppingCart bEssentialCart = new ShoppingCart("Heona", breakfastEssentials);

        //initialize dormRun Items
        ShoppingList dormRun = new ShoppingList();
        //test insertAt
        dormRun.insertAt(0, new ShoppingItem("Eggs", 350));
        dormRun.addToEnd(new ShoppingItem("Tissues", 100));
        dormRun.addToEnd(new ShoppingItem("Frozen Berries", 515));
        dormRun.insertAt(3, new ShoppingItem("Zucchini", 275));
        //test removeAt
        dormRun.addToEnd(new ShoppingItem("Yogurt", 450));
        dormRun.removeAt(4);
        dormRun.insertAt(4, new ShoppingItem("Smoked Salmon", 999));
        ShoppingCart dormRunCart = new ShoppingCart("Heona", dormRun);

        //checks if identical lists
        if (breakfastEssentials.isIdentical(dormRun))
        {
            System.out.println("Breakfast Essentials List is the same as DormRun!");
        } else {
            System.out.println("Breakfast Essentials List is NOT the same as Dorm Run!");
        }

        dormRun.removeAt(1); // remove tissues
        dormRun.removeAt(4); // remove salmon
        dormRun.getAt(0).buy(); // buy eggs
        dormRun.getAt(4).buy(); // tries to buy salmon that we removed
        //checks isCompleted
        if (dormRunCart.isCompleted())
        {
            System.out.println("Dorm Cart is Complete");
        } else {
            System.err.println("Dorm is NOT Complete");
        }

        //buys all items under breakfast essentials
        breakfastEssentials.goShopping();
        if (bEssentialCart.isCompleted())
        {
            System.out.println("Breakfast Essential Cart is Complete");
        } else {
            System.err.println("Breakfast Essential Cart is NOT Complete");
        }

        //gets Total number of Carts
        System.out.println(ShoppingCart.getTotalCartsReturned());
        //returns both carts
        bEssentialCart.returnCart();
        dormRunCart.returnCart();
        System.out.println(ShoppingCart.getTotalCartsReturned());

        //COMPARE
        System.out.println(breakfastEssentials.getAt(0).compareTo(dormRun.getAt(2)));

        //FINAL summary output
        boolean comp = dormRunCart.isCompleted();
        String isCompleted = "is not";
        if  (comp)
        {
            isCompleted = "is";
        }
        
        System.out.println("DormRun's cart contains: eggs, zucchini, frozen berries for a total of $" + dormRun.getTotalPrice() + " It " + dormRunCart.isCompleted() + " completed.");

        

    }
}