
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
    public int weight;
    public String name, description;

    /**
     * Constructor for objects of class Item
     */
    public Item(String name, String description, int weight)
    {
        this.name = name;
        this.description = description;
        this.weight = weight;
    }

    // /**
     // * An example of a method - replace this comment with your own
     // *
     // * @param  y  a sample parameter for a method
     // * @return    the sum of x and y
     // */
    // public Item (String n, String d, int w)
    // {
        // name = n;
        // description = d;
        // weight = w;
    // }

    /**
     * This method returns the description of the item.
     *
     * @param none
     * @return description: description of the item
     */
    public String getDescription()
    {
        return description;
    }
    
    /**
     * This method returns the weight of the item.
     *
     * @param none
     * @return weight: weight of the item
     */
    public int getWeight()
    {
        return weight;
    }
    
    /**
     * This method returns the name of the item.
     *
     * @param none
     * @return name: name of the item
     */
    public String getItemName()
    {
        return name;
    }
    

}
