import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Lab 8
 *
 * Driver, runs user through
 * the process of battling Contestants.
 *
 * @author Stephen
 * @version 2018-03-12
 */
public class Driver
{
    /**
     * Arena in which Contestants battle and from which we can get information about Contestants.
     */
    private static RPSArena arena;
    
    /**
     * Prompts the user to either choose Contestants to battle or
     * list all Contestants choosing a certain hand choice.  Prints out information about
     * the chosen Contestants or all Contestants in contestantMap.
     *
     * @param args Command line arguments.
     * @throws IOException Error during I/O operation.
     */
    public static void main(String[] args) throws IOException 
    {
        // Setup program to read user input.
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in));

        String input; // The user's input.
        String contestantChoice1; // The first Contestant chosen by the user.
        String contestantChoice2; // The second Contestant chosen by the user.
        int menuChoice; // The menu option chosen by the user.

        // Set up the arena:
        arena = new RPSArena();

        //print the menu options
        System.out.println("As master of the Rock-Paper-Scissors arena, you may choose two Contestants to fight"
                + "against each other. You may also view their information.\nPlease select an option:");

        System.out.println("1: Choose two Contestants to battle");
        System.out.println("2: List all Contestants with a specified hand choice");

        while (true) // Loop until the user chooses a valid menu option.
        {
            try
            {
                input = br.readLine();
                menuChoice = Integer.parseInt(input);
                
                if (menuChoice <= 0 || menuChoice > 2)
                {
                    System.out.println("Please choose either 1 or 2.");
                }
                else
                {
                    break;
                }
            }
            catch (NumberFormatException e)
            {
                System.out.println("Please enter an integer.");
            } 
        }
        
        switch(menuChoice)
        {
            case 1:
            {
                // List the Superheroes that the user can choose from.
                System.out.println(
                    "Please choose from the following Contestant: " +
                    arena.getContestantAbbreivations());

                contestantChoice1 = br.readLine().toUpperCase();
                Contestant contestant1 = arena.getContestant(contestantChoice1);
                
                // Loop until the user has entered a valid abbreviated heros' name.
                while (contestant1 == null)
                {
                    System.out.println(
                        "Please choose one of the Contestants listed.");

                    contestantChoice1 = br.readLine().toUpperCase();
                    contestant1 = arena.getContestant(contestantChoice1);
                }

                System.out.printf("You choose %s.\n", contestant1);
                
                // List the Contestants that the user can choose from.
                System.out.println(
                    "Please choose another Contestant from the following Contestants: " +
                    arena.getContestantAbbreivations());

                contestantChoice2 = br.readLine().toUpperCase();
                Contestant contestant2 = arena.getContestant(contestantChoice2);
                
                // Loop until the user has entered a valid abbreviated heros' name.
                while (contestant2 == null)
                {
                    System.out.println(
                        "Please choose one of the Contestants listed.");

                    contestantChoice2 = br.readLine().toUpperCase();
                    contestant2 = arena.getContestant(contestantChoice2);
                }

                System.out.printf("You choose %s.\n", contestant2);
                
                // Battle the Contestants and print the result:
                
                Contestant victor = RPSArena.battleContestants(contestant1, contestant2);

                if (victor == null)
                {
                    System.out.println("The battle was a tie!");
                }
                else
                {
                    System.out.printf("%s was the victor!", victor.name().toLowerCase());
                }

                break;
            }

            case 2:
            {
                String stringChoice = null;
                HandChoice choice = null;
                
                // Loop until the user has entered a valid abbreviated heros' name.
                while (choice == null)
                {
                    try {
                        System.out.println(
                            "Select hand choice: ROCK, PAPER, SCISSORS");
    
                        stringChoice = br.readLine().toUpperCase();
                        choice = HandChoice.valueOf(stringChoice);
                    }
                    catch (IllegalArgumentException e) {
                        System.out.println("Please select a proper hand choice.");
                    }
                }
                
                //List the Contestants with this hand choice.:
                System.out.println(arena.listContestantsWithHandChoice(choice));
                
                break;
            }
        }
        //test git
    }
}
