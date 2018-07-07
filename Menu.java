import java.util.ArrayList;
import java.util.Scanner;

/**
 * Write a description of class Menu here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Menu
{
    static ArrayList<String> menuString;
    /**
     * Constructor for objects of class Menu
     */
    public Menu()
    {
        menuString = new ArrayList<String>();
    }

    /**
     * User-defined Constructor for objects of class Menu
     */
    public Menu(ArrayList<String> menuText)
    {
        menuString = menuText;
    }

    public static void setMenu(ArrayList<String> menuText)
    {
        menuString = menuText;
    }

    public static ArrayList<String> getMenu()
    {
        return menuString;
    }

    public static void displayMenu()
    {
        for(String option : menuString)
        {
            System.out.println(option);
        }
    }

    public static String getMenuoption()
    {
        Scanner sc = new Scanner(System.in);
        return sc.next();
    }
}
