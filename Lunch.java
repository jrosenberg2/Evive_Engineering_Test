
import java.util.Map;
import java.util.HashMap;

public class Lunch {
    //Predefined global variables to allow for easy menu changes
    String[] orders;
    public static final String MAININT = "1";
    public static final String SIDEINT = "2";
    public static final String DRINKINT = "3";
    public static final String MAIN = "Salad";
    public static final String SIDE = "Chips";
    public static final String DRINK = "Soda";
    public Map<String, Integer> items;

    public Lunch(String[] orders)
    {
        this.orders = orders;
        items = new HashMap<String, Integer>();
    }

    //Create a map detailing what was ordered and how much
    public void populateOrderMap()
    {
        for(String order : orders)
        {
            //If the main dish was ordered
            if(order.equals(MAININT))
            {
                //Count how much of the main dish was ordered
                if(items.containsKey(MAIN))
                {
                    items.replace(MAIN, items.get(MAIN), items.get(MAIN)+1);
                }
                else
                {
                    items.put(MAIN, 1);
                }

            }
            //If the side dish was ordered
            else if(order.equals(SIDEINT))
            {
                //Count how much of the side dish was ordered
                if(items.containsKey(SIDE))
                {
                    items.replace(SIDE, items.get(SIDE), items.get(SIDE)+1);
                }
                else
                {
                    items.put(SIDE, 1);
                }
            }
            //If the drink was ordered
            else if(order.equals(DRINKINT))
            {
                //Count how much of the drink was ordered
                if(items.containsKey(DRINK))
                {
                    items.replace(DRINK, items.get(DRINK), items.get(DRINK)+1);
                }
                else
                {
                    items.put(DRINK, 1);
                }
            }
            //If the user tried to order something that doesn't exist on the menu, throw an error.
            else
            {
                System.err.println("Did not enter a valid menu option");
                System.exit(1);
            }
        }
    }

    public String printOrder()
    {
        //StringBuilders to build output statement and booleans to check if order is valid
        StringBuilder sb = new StringBuilder();
        StringBuilder err = new StringBuilder();
        boolean check1 = false;
        boolean check2 = false;
        String output = "";

        //Must order a single main dish at lunch, otherwise error
        if(items.containsKey(MAIN))
        {
            sb.append(MAIN + ", ");
            if(items.get(MAIN) > 1)
            {
                return"Unable to process: " + MAIN + " cannot be ordered more than once";
            }
        }
        else
        {
            err.append("Unable to process: Main is missing");
            check1 = true;
        }

        //Must order at least a single side at lunch, but can order multiple, otherwise error
        if(items.containsKey(SIDE))
        {
            sb.append(SIDE);
            if(items.get(SIDE) > 1)
            {
                sb.append("(" + items.get(SIDE) + ")");
            }
        }
        else
        {
            //The error message changes depending on whether or not the main dish was properly ordered
            if(check1)
            {
                err.append(", side is missing");
            }
            else
            {
                err.append("Unable to process: Side is missing");
            }
            check2 = true;
        }

        //Can order a single drink at lunch, no more, otherwise error
        if(items.containsKey(DRINK))
        {
            sb.append(", " + DRINK);
            if(items.get(DRINK) > 1)
            {
                return "Unable to process: "+ DRINK + " cannot be ordered more than once";
            }
            
        }
        //If no drink was ordered, give water
        else
        {
            sb.append(", Water");
        }
        
        //if ordered incorrectly, return error, otherwise return correct order
        if(check1 || check2)
        {
            output = err.toString();
        }
        else
        {
            output = sb.toString();
        }
        return output;
    }
}
