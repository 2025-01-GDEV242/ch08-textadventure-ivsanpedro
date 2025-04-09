import java.util.ArrayList;
/**
 * Class Player - A player in an adventure game
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game. 
 * 
 * Player represents a person that travels through the adventure game. 
 * Player has the ability to pick up items in the rooms.
 *
 * @author Ivana San Pedro
 * @version 2025.03.24
 */
public class Player
{
    String name;
    Room currentRoom;
    ArrayList<Item> playerItems;
    /**
     * Constructor for objects of class Player
     */
    public Player()
    {
        playerItems = new ArrayList<Item>();
    }

    /**
     * Adds the item the player picked up
     * to an array list which stores their item(s)
     *
     * @param  item
     */
    public void storeItem(Item item)
    {
        playerItems.add(item);
    }
}
