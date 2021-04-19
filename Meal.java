
/**
*  Main method for taking order and meal input from a user and returing the proper output
*
*/

public class Meal {
    
    public Meal() 
    {

    }

    public static void main (String args[])
    {   
        //Get our arguments from the terminal
        String output = "";
        if(args.length > 1)
        {   
            //split our order numbers separated by commas in the command line and put it into a string array
            String[] order = (args[1].toString()).split(",");

            //output the order if the user ordered breakfast
            if(args[0].equals("Breakfast"))
            {
                Breakfast b = new Breakfast(order);
                b.populateOrderMap();
                output = b.printOrder();
            }
            //output the order if the user ordered lunch
            else if(args[0].equals("Lunch"))
            {
                Lunch l = new Lunch(order);
                l.populateOrderMap();
                output = l.printOrder();
            }
            //output the order if the user ordered dinner
            else if(args[0].equals("Dinner"))
            {
                Dinner d = new Dinner(order);
                d.populateOrderMap();
                output = d.printOrder();
            }
            //output an error if the user tried to order a meal that doesn't exist
            else
            {
                output = "Error: Invalid meal entered. Please enter a valid order (ex. Breakfast 1,2,3)";
            }
        }
        //If the user entered no order parameters, return an error
            //note: would be done within the individual files, but speeds up runtime
        else
        {
            if(args[0].equals("Breakfast") || args[0].equals("Lunch"))
            {
                output = "Unable to process: Main is missing, side is missing";
            }
            else if(args[0].equals("Dinner"))
            {
                output = "Unable to process: Main is missing, side is missing, dessert is missing";
            }
            else
            {
                output = "Error: Invalid meal entered. Please enter a valid order (ex. Breakfast 1,2,3)";
            }
        }
        //print the order or the error
        System.out.println(output);
    }
}