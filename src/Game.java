/* Ella Litsur
2/8/23
This class has all the logic that is used to play the game
*/
import java.util.Scanner;

public class Game
{
    private String userName;
    private String compName;
    private String winner;
    private String round1Winner;
    private String round2Winner;
    private String round3Winner;
    private Round round1;
    private Round round2;
    private Round round3;
    private boolean r1done;
    private boolean r2done;
    private boolean r3done;
    private GameViewer viewer;

    public Game()
    {
        viewer = new GameViewer(this);
        r1done = false;
        r2done = false;
        r3done = false;
    }

    public Round getRound1() {
        return round1;
    }

    public Round getRound2() {
        return round2;
    }

    public Round getRound3() {
        return round3;
    }

    public String getWinner()
    {
        return winner;
    }
    public String getRound1Winner()
    {
        return round1Winner;
    }

    public String getRound2Winner() {
        return round2Winner;
    }

    public String getRound3Winner() {
        return round3Winner;
    }
    public boolean isR1done()
    {
        return r1done;
    }
    public boolean isR2done()
    {
        return r2done;
    }
    public boolean isR3done()
    {
        return r3done;
    }
    public String getUserName()
    {
        return userName;
    }
    public String getCompName()
    {
        return compName;
    }
    // plays the game
    public void playGame()
    {
        Game.instructions();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name:");
        userName = input.nextLine();
        compName = "Computer";
        System.out.println("\n");

        // Creates user and computer players
        Player user = new Player(userName);
        Player comp = new Player(compName);
        // makes 3 rounds
        round1 = new Round(user, comp);
        round2 = new Round(user, comp);
        round3 = new Round(user, comp);

        // Plays the first round
        System.out.println("***Round 1*** \n");
        round1.playRound();
        round1Winner = round1.getWinner();
        r1done = true;
        viewer.repaint();
        System.out.println("Round 1 winner: " + round1Winner + "\n");
        input.nextLine();

        // Plays the second round
        System.out.println("***Round 2*** \n");
        round2.playRound();
        round2Winner = round2.getWinner();
        r2done = true;
        viewer.repaint();
        System.out.println("Round 2 winner: " + round2Winner + "\n");
        input.nextLine();

        // Plays the third round
        System.out.println("***Round 3*** \n");
        round3.playRound();
        round3Winner = round3.getWinner();
        r3done = true;
        viewer.repaint();
        System.out.println("Round 3 winner: " + round3Winner + "\n");
        input.nextLine();
        displayResults();

    }

    // Displays who won each round
    public void displayResults()
    {
        String congratulateUser = "You won the game! 🥳 \n";
        int userScore = 0;
        int compScore = 0;
        // Calculates scores after round 1
        if (round1Winner.equals(userName))
        {
            userScore++;
        }
        else if (round1Winner.equals(compName))
        {
            compScore++;
        }
        // Calculates scores after round 2
        if (round2Winner.equals(userName))
        {
            userScore++;
        }
        else if (round2Winner.equals(compName))
        {
            compScore++;
        }
        // Calculates scores after round 3
        if (round3Winner.equals(userName))
        {
            userScore++;
        }
        else if (round3Winner.equals(compName))
        {
            compScore++;
        }

        // Finds winner of game
        if (userScore > compScore)
        {
            winner = userName;
        }
        else if (compScore > userScore)
        {
            winner = compName;
        }
        else if (userScore == compScore)
        {
            winner = "It's a tie!";
        }
        // Prints winner of each round and winner of game
        System.out.println("** Final Results **\n");
        System.out.println("Round 1 winner: " + round1Winner + "\n");
        System.out.println("Round 2 winner: " + round2Winner + "\n");
        System.out.println("Round 3 winner: " + round3Winner + "\n");
        // If it's not a tie
        if (userScore != compScore)
        {
            System.out.println("Winner: " + winner);
            // If user won
            if (winner.equals(userName))
            {
                System.out.println(congratulateUser);
                System.out.println("Thank you for playing! \n");
            }
            // If computer won
            else
            {
                System.out.println("Thank you for playing! \n");
            }
        }
        // If it's a tie
        else
        {
            System.out.println(winner);
        }
    }

    // prints instructions for game
    public static void instructions()
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Instructions:");
        System.out.println("The goal of this game is to roll even sums ");
        System.out.println("using 2 6-sided dice.");
        System.out.println("Each time you roll an even number you get a point.");
        System.out.println("Get 5 points to win the game. You will be going against the computer");
        System.out.println("Press the enter key to roll.");
        System.out.println("Press enter to start!");
        input.nextLine();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println();
    }
    // creates a game and runs it
    public static void main(String[] args)
    {
        Game game = new Game();
        game.playGame();
    }

}