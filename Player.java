/**
 * The Players for each Individual Team.
 * Sets and retunrns the name and number of goals for each player
 * 
 * 
 * @author (nusrat Mojumder)
 * @version (3.05.2018)
 */

public class Player
{
    private String name;
    private int goals;

    /**
     * Default Constructor for objects of class Player
     */
    public Player()
    {
        name = "Player";
        goals = 0;
    }

    /**
     * User Defined Constructor for objects of class Player
     */
    public Player(String playerName)
    {
        try{
            if (nameValidation(playerName))
            {
                System.out.println("Name Accepted\n");
                name = playerName; 
            }
            else
            {
                System.out.println("Name not Accepted\n");
                throw new IllegalArgumentException();
            }
        }
        catch (IllegalArgumentException e)
        {
            System.out.println(e + "\n");
        }

        goals = 0;
    }

    /**
     * A method to return the Player's current status
     *
     * @param     none
     * @return    a Srtring value returning Player's Name and Number of Goals
     */
    public String display()
    {
        return "Player Name is : " + name + "\nTotal goals scored : " + goals;
    }

    /**
     * An Accessor method to return the Player's name
     *
     * @param     none
     * @return    a Srtring value returning Player's Name
     */
    public String getName()
    {
        return name;
    }

    /**
     * An Accessor method to return the Player's goals
     *
     * @param     none
     * @return    an integer value returning Player's Number of Goals
     */
    public int getGoals()
    {
        return goals;
    }

    /**
     * A Mutator method to update the Player's Goals
     *
     * @param     playerGoals an integer value to set Player's goals
     * @return    nothing
     */
    public void setGoals(int playerGoals)
    {
        goals = goals + playerGoals;
    }

    /**
     * A Mutator method to set the Player's Name
     *
     * @param     playerName an integer value to set the Player's Name
     * @return    nothing
     */
    public void setName(String playerName)
    {
        name = playerName;
    }

    /**
     * A to check if the Player's Name is made of alphabetic characters
     *
     * @param     playerName a String value containing the name input
     * @return    a boolean value indicating if name is alphabetical
     */
    public boolean isStringAlphabetic(String playerName)
    {
        for (char ch : playerName.toCharArray())
        {
            if (Character.isDigit(ch))
            {
                return false;
            }
        }

        return true;
    }

    /**
     * A to check if the Player's Name contains more than occurance of a certain character
     *
     * @param     playerName a String value containing the name input
     * @param     playerName a String value containing the specific Character
     * @return    a boolean value indicating if certain charcter is repeated
     */
    public boolean isCharacterOccuranceRepeated(String playerName, Character charToCheck)
    {
        int count = 0;

        for (char ch : playerName.toCharArray())
        {
            if(ch == charToCheck)
                count++;
        }

        if (count > 1)
            return false;

        return true;
    }

    /**
     * A method to validate the Player's Name
     * Minimum name length is 2 characters and assumed max length is 8 characters
     *
     * @param     checkName a String value that is Player's name
     * @return    a boolean value to indicate if the name is valid or not
     */
    public boolean nameValidation(String name)
    {
        name = name.trim();

        if (name.length() < 2 || name.length() > 8)
        {
            System.out.println("Name has to be within 2 to 8 Characters");
            return false;
        }
        else if (!isStringAlphabetic(name))
        {
            System.out.println("Name should contain only alphabetic characters");
            return false;
        }
        else if (name.indexOf('-') == 0 || name.indexOf('-') == (name.length() - 1))
        {
            System.out.println("Can't have - at the beginning or end of name");
            return false;
        }
        else if (!isCharacterOccuranceRepeated(name,'-'))
        {
            System.out.println("Can't have more than one '-' in name\n");
            return false;
        }

        return true;
    }
}
