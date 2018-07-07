import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileReader;
import java.io.PrintWriter;

/**
 * The Players for each Individual Team.
 * Sets and returns the name and number of goals for each player
 * 
 * 
 * @author (nusrat Mojumder)
 * @version (13.05.2018)
 */

public class Game
{
    private TeamCollection teams;
    private MatchCollection matches;
    private boolean playedPriliminary;

    /**
     * Default Constructor for objects of class Game
     */
    public Game()
    {
        teams = new TeamCollection();
        matches = new MatchCollection();
        playedPriliminary = false;
    }

    /**
     * User Defined Constructor for objects of class Game
     */
    public Game(TeamCollection gameTeams, MatchCollection gameMatches)
    {
        teams = gameTeams;
        matches = gameMatches;
        playedPriliminary = false;
    }

    public void insertMenu()
    {
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("A. Play Preliminary Stage");
        menu.add("B. Play Final");
        menu.add("C. Display Teams");
        menu.add("D. Display Players");
        menu.add("E. Display Cup Result");
        menu.add("X. Close");

        Menu.setMenu(menu);
    }

    public void outputStatistics(String gameStatistics)
    {
        try
        {
            PrintWriter outputFile = new PrintWriter("statistics.txt");
            outputFile.println(gameStatistics);
            outputFile.close();
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
    }

    public void startGame()
    {        
        System.out.println("****WELCOME TO WORLD CUP FOOTBALL****\n");
        System.out.println("**************************************");
        System.out.println("*************CREATE TEAMS*************");
        System.out.println("**************************************");
        inputTeams();
        insertMenu();
        chooseMenuOption();
    }

    public void chooseMenuOption()
    {

        while(true)
        {
            System.out.println("\nChoose One option from the following");
            Menu.displayMenu();

            switch (Menu.getMenuoption().trim().toUpperCase())
            {
                case "A" : System.out.println("You've chosen to play Priliminary Round\n");
                matches.createMatches(teams.getTeamCollection());
                playGame("priliminary round");
                break;

                case "B" : System.out.println("You've chosen to Play Final Round\n");
                if(!playedPriliminary)
                    System.out.println("Preliminary stage has not been played yet\nPress A to play Priliminary Round\n");
                else
                    playGame("final round");;
                break;

                case "C" : System.out.println("You've chosen to Display the Teams\n"); 
                teams.displayTeams();
                break;

                case "D" : System.out.println("You've chosen to Display the Players\n"); 
                teams.displayTeamPlayers();
                break;

                case "E" : System.out.println("You've chosen to Display Cup Result\n"); 
                break;

                case "X" : System.out.println("You've chosen to Close Program\n");
                outputStatistics("This is game stats");
                System.exit(0);
                break;

                default : System.out.println("Invalid Input try again\n"); 
                break;
            }
        }
    }

    public void playGame(String roundType)
    {
        if(roundType.equals("priliminary round"))
        { 
            for (int i = 0; i < matches.getMatchCollection().size() - 1 ; i++)
            {
                System.out.println("**************************************");

                System.out.println("PRILIMINARY ROUND - MATCH " + i);
                matches.returnCurrentmatch(i);

                teams.playMatch(matches.returnCurrentmatch(i).get(0), matches.returnCurrentmatch(i).get(1));

                System.out.println("**************************************\n");
            }

            playedPriliminary = true;
            System.out.println("Priliminary Round Completed, Press B to play Final");
        }
        else  if(roundType.equals("final round"))
        { 
            System.out.println("**************************************");
            System.out.println("FINAL ROUND");
            System.out.println("**************************************\n");
        }
    }

    public void inputTeams()
    {
        String fileName = "teams.txt";
        try
        {
            FileReader inputFile = new FileReader(fileName);
            Scanner parser = new Scanner(inputFile);

            while(parser.hasNext())
            {
                String teamData = parser.nextLine();
                teams.createTeams(teamData);
            }

            System.out.println("Teams created Successfully\n");

            inputFile.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
