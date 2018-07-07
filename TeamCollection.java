import java.util.ArrayList;

/**
 * The is a collection of Players for each team
 * Sets the Players assigned to each team
 * 
 * 
 * @author (nusrat Mojumder)
 * @version (11.05.2018)
 */

public class TeamCollection
{
    private ArrayList<Team> teamCollection;

    /**
     * Default Constructor for objects of class TeamCollection
     */
    public TeamCollection()
    {
        teamCollection = new ArrayList<>();
    }

    /**
     * User-Defined Constructor for objects of class TeamCollection
     */
    public TeamCollection(ArrayList<Team> gameTeamCollection)
    {
        teamCollection = gameTeamCollection;
    }

    /**
     * An Accessor get method for the teamCollection Field
     *
     * @param     none
     * @return    the teamCollection field 
     */
    public ArrayList<Team> getTeamCollection()
    {
        return teamCollection;
    }

    /**
     * A Mutator set method for the teamCollection Field
     *
     * @param     newTeam  a Team class object to add to the arraylist
     * @return    nothing
     */
    public void setTeamCollection(Team newTeam)
    {
        teamCollection.add(newTeam);
    }

    /**
     * A method for the creating the teams for teamCollection Field
     *
     * @param     teamdata  a String value containing team data read from file
     * @return    nothing
     */
    public void createTeams(String teamData)
    {
        Team currentTeam = new Team();

        String[] teamString = teamData.split(",");
        currentTeam.setTeamName(teamString[0]);
        currentTeam.setTeamRanking(Integer.parseInt(teamString[1]));

        System.out.println("\n**************************************");
        System.out.println("ENTER PLAYER NAMES FOR "+currentTeam.getName().toUpperCase());
        System.out.println("**************************************");

        currentTeam.inputTeamPlayers();
        setTeamCollection(currentTeam);
    }

    /**
     * A method to display a Team's current status
     *
     * @param     none
     * @return    nothing
     */
    public void displayTeams()
    {
        System.out.println("**************************************");
        System.out.println("************World Cup Teams***********\n");
        System.out.println("Played\tWon\tLost\tDrawn\tGoals\tPoints\tFairplay Score");

        System.out.println("****************************************************************************\n");

        for (Team team : teamCollection)
        {
            int playedGames = team.getWonGames() + team.getLostGames() + team.getDrawGames();
            int totalPoints = (team.getWonGames() * 3) + (team.getDrawGames() * 1);
            int fairplayScore = (team.getRedCardScore() * 2) + team.getYellowCardScore();

            System.out.println(playedGames + "\t" + team.getWonGames() + "\t" + team.getLostGames() + "\t" + team.getDrawGames() 
                + "\t" + team.getGoalsScored() + "\t" + totalPoints + "\t" + fairplayScore + "\t\t" + team.getName());
        }
    }

    /**
     * A method to sort Team with points
     *
     * @param     none
     * @return    nothing
     */
    public ArrayList<Team> sortTeams()
    {
        ArrayList<Team> sortedteamList = new ArrayList<>();

        for (Team team : teamCollection)
        {
            int totalPoints = (team.getWonGames() * 3) + (team.getDrawGames() * 1);
        }

        return sortedteamList;
    }

    /**
     * A method to display a Players of all teams
     *
     * @param     none
     * @return    nothing
     */
    public void displayTeamPlayers()
    {
        System.out.println("************World Cup Players***********");
        for (Team team : teamCollection)
        {
            team.displayTeamPlayers();
        }
        System.out.println("**************************************\n");
    }

    public void playMatch(Team team1, Team team2)
    {
        int team1Goals = 0;
        int team2Goals = 0;
        int team1RedCard = 0;
        int team2RedCard = 0;
        int team1YellowCard = 0;
        int team2YellowCard = 0;
        RandomNumber randomNumber = new RandomNumber();

        if (team1.getRanking() > team2.getRanking())
        {
            team1Goals = randomNumber.generateRandomNumber(0, (5 + (randomNumber.generateRandomNumber(0,2))));
            team2Goals = randomNumber.generateRandomNumber(0, ((5 - (team1.getRanking() - team2.getRanking())) + 
                    (randomNumber.generateRandomNumber(0,2))));
        }
        else
        {
            team2Goals = randomNumber.generateRandomNumber(0, (5 + (randomNumber.generateRandomNumber(0,2))));
            team1Goals = randomNumber.generateRandomNumber(0, ((5 - (team1.getRanking() - team2.getRanking())) + 
                    (randomNumber.generateRandomNumber(0,2))));
        }

        assignPlayerGoals(team1, team1Goals);
        assignPlayerGoals(team2, team2Goals);

        team1RedCard = assignRedCard(team1);
        team1YellowCard = assignYellowCard(team1);

        team2RedCard = assignRedCard(team2);
        team2YellowCard = assignYellowCard(team2);

        team1.setGoalsScored(team1Goals);
        team2.setGoalsScored(team2Goals);

        team1.setRedCardScore(team1RedCard);
        team1.setYellowCardScore(team1YellowCard);

        team2.setRedCardScore(team2RedCard);
        team2.setYellowCardScore(team2YellowCard);

        if(team1Goals > team2Goals)
        {
            team1.setWonGames();
            team2.setLostGames();
        }
        else if(team1Goals < team2Goals)
        {
            team2.setWonGames();
            team1.setLostGames();
        }
        else
        {
            team1.setDrawGames();
            team2.setDrawGames();
        }

        displayGameResult(team1, team2, team1Goals, team2Goals, team1RedCard, team2RedCard, team1YellowCard, team2YellowCard);
    }

    public void assignPlayerGoals(Team currentTeam, int teamGoals)
    {
        RandomNumber randomNumber = new RandomNumber();
        int player1Goals = randomNumber.generateRandomNumber(0, teamGoals);
        int player2Goals = teamGoals - player1Goals;

        currentTeam.getTeamPlayers().getPlayerCollection().get(0).setGoals(player1Goals);
        currentTeam.getTeamPlayers().getPlayerCollection().get(1).setGoals(player2Goals);
    }

    public void displayGameResult(Team team1, Team team2, int team1Goals, int team2Goals,
    int team1RedCard, int team2RedCard, int team1YellowCard, int team2YellowCard)
    {
        System.out.println("Game Result : \n" + team1.getName() +" "+ team1Goals + " : " + team2.getName() +" "+ team2Goals);
        System.out.println("Cards Awarded : \n" + team1.getName() +" - " + team1RedCard + " red Card, " + team1YellowCard + " yellow Cards");
        System.out.println(team2.getName() +" - " + team2RedCard + " red Card, " + team2YellowCard + " yellow Cards");
    }

    /**
     * Generate number netween 1 and 10
     * If number generated between 1 to 2, likely to get red card
     * Then Generate another number between 1 and 2 to count how many red cards
     *
     * @param     currentTeam the Team for which card is being generated
     * @return    an integer value denoting the number of card assigned to a Team
     */
    public int assignRedCard(Team currentTeam)
    {
        RandomNumber randomNumber = new RandomNumber();
        int redCardProbability = randomNumber.generateRandomNumber(1, 10);

        if(redCardProbability >= 1 && redCardProbability <= 2)
            return randomNumber.generateRandomNumber(1, 2);

        return 0;
    }

    /**
     * Generate number netween 1 and 10
     * If number generated between 1 to 2, likely to get yellow card
     * Then Generate another number between 1 and 2 to count how many yellow cards
     *
     * @param     currentTeam the Team for which card is being generated
     * @return    an integer value denoting the number of card assigned to a Team
     */
    public int assignYellowCard(Team currentTeam)
    {
        RandomNumber randomNumber = new RandomNumber();
        int yellowCardProbability = randomNumber.generateRandomNumber(1, 10);

        if(yellowCardProbability >= 1 && yellowCardProbability <= 4)
            return randomNumber.generateRandomNumber(1, 4);

        return 0;
    }

}
