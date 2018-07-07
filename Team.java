import java.util.Scanner;

/**
 * The Teams for the World Cup games.
 * Sets and retunrns  each Team
 * 
 * 
 * @author (nusrat Mojumder)
 * @version (11.05.2018)
 */

public class Team
{
    private String name;
    private int ranking; 
    private int wonGames; 
    private int lostGames; 
    private int drawGames; 
    private int goalsScored;
    private int yellowCardScore;
    private int redCardScore;
    private PlayerCollection teamPlayers;

    /**
     * Default Constructor for objects of class Team
     */
    public Team()
    {
        name = "Country";
        ranking = 0;
        wonGames = 0;
        lostGames = 0;
        drawGames = 0;
        goalsScored = 0;
        yellowCardScore = 0;
        redCardScore = 0;
        teamPlayers = new PlayerCollection();
    }

    /**
     * User Defined Constructor for objects of class Team
     */
    public Team(String teamName, int teamRanking, int teamWonGames, int teamlostGames, 
    int teamdrawGames, int teamGoalsScored, int teamYellowCardScore, int teamRedCardScore, PlayerCollection teamPlayerCollection)
    {
        name = teamName;
        ranking = teamRanking;
        wonGames = teamWonGames;
        lostGames = teamlostGames;
        drawGames = teamdrawGames;
        goalsScored = teamGoalsScored;
        yellowCardScore = teamYellowCardScore;
        redCardScore = teamRedCardScore;
        teamPlayers = teamPlayerCollection;
    }

    /**
     * A method for displaying the players of team
     *
     * @param     none
     * @return    none
     */
    public void displayTeamPlayers()
    {
        teamPlayers.displayPlayers(name);
    }

    /**
     * A get method for the name Field
     *
     * @param     none
     * @return    name
     */
    public String getName()
    {
        return name;
    }

    /**
     * A get method for the ranking Field
     *
     * @param     none
     * @return    ranking
     */
    public int getRanking()
    {
        return ranking;
    }

    /**
     * A get method for the redCardScore Field
     *
     * @param     none
     * @return    redCardScore
     */
    public int getRedCardScore()
    {
        return redCardScore;
    }

    /**
     * A get method for the wonGames Field
     *
     * @param     none
     * @return    wonGames
     */
    public int getWonGames()
    {
        return wonGames;
    }

    /**
     * A get method for the lostGames Field
     *
     * @param     none
     * @return    lostGames
     */
    public int getLostGames()
    {
        return lostGames;
    }

    /**
     * A get method for the drawGames Field
     *
     * @param     none
     * @return    drawGames
     */
    public int getDrawGames()
    {
        return drawGames;
    }

    /**
     * A get method for the goalsScored Field
     *
     * @param     none
     * @return    goalsScored
     */
    public int getGoalsScored()
    {
        return goalsScored;
    }

    /**
     * A get method for the yellowCardScore Field
     *
     * @param     none
     * @return    yellowCardScore
     */
    public int getYellowCardScore()
    {
        return yellowCardScore;
    }

    /**
     * A get method for the teamPlayers Field
     *
     * @param     none
     * @return    teamPlayers
     */
    public PlayerCollection getTeamPlayers()
    {
        return teamPlayers;
    }

    /**
     * A set method for the name Field
     *
     * @param     teamName  a String value for the Team's name 
     * @return    nothing
     */
    public void setTeamName(String teamName)
    {
        name = teamName;
    }

    /**
     * A set method for the ranking Field
     *
     * @param     teamRanking  a int value for the Team's ranking 
     * @return    nothing
     */
    public void setTeamRanking(int teamRanking)
    {
        ranking = teamRanking;
    }

    /**
     * A set method for the failPlayPoints Field
     * 
     * @param     an integer value to update the fair play points of team
     * @return    nothing
     */
    public void setRedCardScore(int teamRedCardScore)
    {
        redCardScore = redCardScore + teamRedCardScore;
    }

    /**
     * A set method for the wonGames Field
     * Increaments the number of games won by team
     * @param     none
     * @return    nothing
     */
    public void setWonGames()
    {
        wonGames++;
    }

    /**
     * A set method for the lostGames Field
     * Increaments the number of games lost by team
     * @param     none
     * @return    nothing
     */
    public void setLostGames()
    {
        lostGames++;
    }

    /**
     * A set method for the drawGames Field
     * Increaments the number of games draw by team
     * @param     none
     * @return    nothing
     */
    public void setDrawGames()
    {
        drawGames++;
    }

    /**
     * A set method for the failPlayPoints Field
     * 
     * @param     an integer value to update the fair play points of team
     * @return    nothing
     */
    public void setYellowCardScore(int teamYellowCardScore)
    {
        yellowCardScore = yellowCardScore + teamYellowCardScore;
    }

    /**
     * A set method for the goalsScored Field
     * 
     * @param     an integer value to update the number of goals scored by team
     * @return    nothing
     */
    public void setGoalsScored(int teamGoalsScored)
    {
        goalsScored = goalsScored + teamGoalsScored;
    }

    /**
     * A set method for the teamPlayer Field
     *
     * @param     a PlayerCollection object
     * @return    nothing
     */
    public void setTeamPlayers(PlayerCollection teamPlayerCollection)
    {
        teamPlayers = teamPlayerCollection;
    }

    /**
     * A get method for creating the players of team
     *
     * @param     none
     * @return    none
     */
    public void inputTeamPlayers()
    {
        boolean createPlayerObj = false;
        for(int j = 1 ; j <= 2 ; j++)
        {
            System.out.println("\nInput name for Player " + j);
            System.out.println("**************************************");
            for(int i = 1 ; i <= 2; i++)
            {
                try
                {
                    Scanner sc = new Scanner(System.in);
                    createPlayerObj = teamPlayers.createPlayers(sc.nextLine());
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }

                if (createPlayerObj)   
                    break;
            }

            if (!createPlayerObj)
            {
                System.out.println("Player " + j + " created with Default Name");
                teamPlayers.createDefaultPlayers(name, j);
            }
        }
    }
}