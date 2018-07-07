import java.util.ArrayList;

/**
 * The is a collection of Players for each team
 * Sets the Players assigned to each team
 * 
 * 
 * @author (nusrat Mojumder)
 * @version (11.05.2018)
 */

public class PlayerCollection
{
    private ArrayList<Player> playerCollection;

    /**
     * Default Constructor for objects of class PlayerCollection
     */
    public PlayerCollection()
    {
        playerCollection = new ArrayList<>();
    }

    /**
     * User-Defined Constructor for objects of class PlayerCollection
     */
    public PlayerCollection(ArrayList<Player> playersOfTeam)
    {
        playerCollection = playersOfTeam;
    }

    /**
     * An Accessor get method for the playerCollection Field
     *
     * @param     none
     * @return    the playerCollection field 
     */
    public ArrayList<Player> getPlayerCollection()
    {
        return playerCollection;
    }

    /**
     * A Mutator set method for the playerCollection Field
     *
     * @param     newPlayer  a Player class object to add to the arraylist
     * @return    nothing
     */
    public void setPlayerCollection(Player newPlayer)
    {
        playerCollection.add(newPlayer);
    }

    /**
     * A method for the creating the players from user input
     *
     * @param     playerName  a String value containing players name
     * @return    a boolean value indicating if name was accepted and player was created or not
     */
    public boolean createPlayers(String playerName)
    {
        Player currentPlayer = new Player();

        for (Player existingPlayer : playerCollection )
        {
            if(existingPlayer.getName().equals(playerName))
            {
                System.out.println("Player name already exists in team");
                return false;
            }
        }

        if (!(currentPlayer.nameValidation(playerName)))
        {
            System.out.println("Invalid Name");
            return false;
        }
        else
        {
            System.out.println("Name Accepted, Player Added");
            currentPlayer.setName(playerName);
            setPlayerCollection(currentPlayer);
        }

        return true;
    }

    /**
     * A method for the creating the players by defauklt values
     *
     * @param     teamName  a String value containing teams name
     * @param     playerNo  a int value containing player number
     * @return    nothing
     */
    public void createDefaultPlayers(String teamName, int playerNo)
    {
        Player currentPlayer = new Player();
        currentPlayer.setName("Player"+playerNo+"-"+teamName);
        setPlayerCollection(currentPlayer); 
    }

    /**
     * A get method for displaying the players added in the playerCollection Field
     *
     * @param  none
     * @return nothing
     */
    public void displayPlayers(String teamName)
    {
        for (Player currentPlayer : playerCollection)
            System.out.println(currentPlayer.getName() + "(" + teamName + ")" + "-" + currentPlayer.getGoals());
    }
}
