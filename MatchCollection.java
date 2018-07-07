import java.util.ArrayList;
/**
 * The Players for each Individual Team.
 * Sets and retunrns the name and number of goals for each player
 * 
 * 
 * @author (nusrat Mojumder)
 * @version (3.05.2018)
 */

public class MatchCollection
{
    private ArrayList<ArrayList<Team>> matchCollection;

    /**
     * Default Constructor for objects of class MatchCollection
     */
    public MatchCollection()
    {
        matchCollection = new ArrayList<ArrayList<Team>>();
    }

    /**
     * User Defined Constructor for objects of class MatchCollection
     */
    public MatchCollection(ArrayList<ArrayList<Team>> matchTeams)
    {
        matchCollection = matchTeams;
    }

    public void setMatchCollection(ArrayList<Team> matchTeams)
    {
        matchCollection.add(matchTeams);
    }

    public ArrayList<ArrayList<Team>> getMatchCollection()
    {
        return matchCollection;
    }

    /**
     * A method for the creating the team pairs for priliminary round mtches
     *
     * @param     none
     * @return    nothing
     */
    public void createMatches(ArrayList<Team> matchTeams)
    {
        for (Team team1 : matchTeams)
        {
            for (Team team2 : matchTeams)
            {
                boolean matchNotAllowed = false;

                if(team1 == team2)
                    matchNotAllowed = true;
                else
                {
                    for (ArrayList<Team> existingMatches : matchCollection)
                    {
                        if (existingMatches.contains(team1) && existingMatches.contains(team2))
                        {
                            matchNotAllowed = true;
                            break;
                        }
                    }
                }

                if(matchNotAllowed == false)
                {
                    ArrayList<Team> currentMatch = new ArrayList<Team>();
                    currentMatch.add(team1);
                    currentMatch.add(team2);
                    setMatchCollection(currentMatch);
                }

            }
        }
        System.out.println("Priliminary Matches have been set Succesfully");
    }

    public void displayMatches()
    {
        int i=1;
        for (ArrayList<Team> existingMatches : matchCollection)
        {
            System.out.println("Match "+i);

            for(Team currentTeam : existingMatches)
                System.out.println(currentTeam.getName());
            i++;
        }

    }

    public ArrayList<Team> returnCurrentmatch(int currentmatchIndex)
    {
        return matchCollection.get(currentmatchIndex);
    }
}

