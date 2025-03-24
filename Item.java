
/**
 * Item - Item(s) in a room in an adventure game. 
 * 
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.
 *
 * An "item" is held by each room. Each item has a description and weight. An item's weight can
 * be used later to determine whether it can be picked up or not. 
 *
 * @author Ivana San Pedro
 * @version 2025.03.24
 */
public class Item
{
    // instance variables - replace the example below with your own
    private int weight;
    private String description;

    /**
     * Constructor for objects of class Item
     */
    public Item()
    {
        // initialise instance variables
        x = 0;
    }

    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return x + y;
    }
}
