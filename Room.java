import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * * @author Ivana San Pedro
 * @version 2025.03.24
 */

public class Room 
{
    private String description;
    public Item item1;
    public Item item2;
    private HashMap<String, Room> exits; 

    // stores exits of this room.

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description, Item item1, Item item2) 
    {
        this.description = description;
        this.item1 = item1;
        this.item2 = item2;
        //String desc1 = item2.getDescription();

        exits = new HashMap<>();
        //items = new HashSet<>();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * Returns true if the current room has an item
     * @param none
     * @return item: current item in the room
     */
    public boolean hasItem(){
        return item2 != null;
    }

    /**
     * @return The short description of the room
     * (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     *     You are in the kitchen.
     *     Exits: north west
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        String desc = "Current room: " + description + ".\n";
        String exit = "\n" + getExitString();
        if (item1 == null){
            return desc  + "Items in room: " + exit;
        }
        else if (item2 == null) 
        {
            return desc + "Items in room: " +  item1.getItemName() + exit;
        }
        else if ((item1 != null) && (item2 != null))
        {
            return desc + "Items in room: " + item1.getItemName() + "  " + item2.getItemName() + exit;
        }
        return desc;
    }
    
    /**
     * Adds a new item to a room
     *
     * @param  item: item to be added 
     * @return none
     */
    public void addItem(Item item)
    {
        this.item2 = item;
    }


    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction) 
    {
        return exits.get(direction);
    }
    
    /**
     * Returns the first item that was made
     *
     * @param: none
     * @return item: returns the first item in the room
     */
    public Item getItem1(){
        return item1;
    }
    
    /**
     * Returns the second item that was made
     *
     * @param: none
     * @return item: returns the second item in the room
     */
    public Item getItem2(){
        return item2;
    }
}

