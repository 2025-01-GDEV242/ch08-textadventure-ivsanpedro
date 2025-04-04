import java.util.ArrayList;
/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Ivana San Pedro
 * @version 2025.03.24
 */

public class Game 
{
    private Parser parser;
    private Room currentRoom;
    private ArrayList<Item> items;

    /**
     * Create the game and initialise its internal map.
     */
    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {
        Room NewYork,California,Maine,Florida,Alaska,Nevada,Idaho,Illinois;

        items = new ArrayList<Item>();
        //Create the items
        //NY
        Item hotdog = new Item("hotdog", "hotdog with mustard and ketchup", 2);
        Item MetroCard = new Item("MetroCard", "MetroCard for the subway", 1);
        //CA
        Item smoothie = new Item("smoothie", "smoothie from Erewhon", 2);
        Item sunglasses = new Item("sunglasses", "Prada sunglasses", 1);
        //FL
        Item towel = new Item("beach towel", "blue and white striped beach towel", 3);
        Item umbrella = new Item("umbrella", "raindbow beach umbrella", 10);
        //Idaho
        Item potato = new Item("potato", "russet potato", 1);
        //Nevada
        Item boulder = new Item("boulder", "big boulder", 300);
        //Illinois
        Item pizza = new Item("pizza", "deep dish pizza", 2);
        //Alaska
        Item icicle = new Item("icicle", "large sharp icicle", 4);
        //Maine
        Item lobster = new Item("lobster", "red lobster", 5);

        // Create the rooms
        NewYork = new Room("in the New York subway", hotdog, MetroCard);
        California = new Room("in Los Angeles", smoothie, sunglasses);
        Maine = new Room("inside a lighthouse in Maine", lobster, null);
        Florida = new Room("at a beach in Florida", towel, umbrella);
        Alaska = new Room("at a National Park", icicle, null);
        Nevada = new Room("at the Grand Canyon",boulder, null);
        Idaho = new Room("in a potato farm in Idaho", potato, null);
        Illinois = new Room("right next to Cloud Gate", pizza, null);

        // initialise room exits
        Florida.setExit("south", Nevada);
        Florida.setExit("east", NewYork);

        NewYork.setExit("east", California);
        NewYork.setExit("south", Idaho);
        NewYork.setExit("west", Florida);

        California.setExit("west", NewYork);
        California.setExit("south", Maine);
        California.setExit("east", Illinois);

        Illinois.setExit("west", California);
        Illinois.setExit("south", Alaska);

        Nevada.setExit("north", Florida);
        Nevada.setExit("east", Idaho);

        Idaho.setExit("west", Nevada);
        Idaho.setExit("east", Maine);
        Idaho.setExit("north", NewYork);

        Maine.setExit("west", Idaho);
        Maine.setExit("east", Alaska);
        Maine.setExit("north", California);

        Alaska.setExit("west", Maine);
        Alaska.setExit("north", Illinois);

        currentRoom = NewYork;  // start game in NewYork
    }

    /**
     *  Main play routine.  Loops until end of play.
     */
    public void play() 
    {            
        printWelcome();

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type '" + CommandWord.HELP + "' if you need help.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
                break;

            case LOOK:
                printLook();
                break;
                
            case HELP:
                printHelp();
                break;

            case GO:
                goRoom(command);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp() 
    {
        System.out.println("You are lost. You are alone. You wander");
        System.out.println("around America.");
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    /**
     * "Look" was entered. 
     * Print out the setting of the room the player is currently in. 
     */
    private void printLook() 
    {
        System.out.println("You are " + currentRoom.getShortDescription());
        System.out.println();
        System.out.println("Your command words are:");
        parser.showCommands();
    }
    
    /** 
     * Try to go in one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
