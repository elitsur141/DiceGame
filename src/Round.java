/* Ella Litsur
2/8/23
This class is in charge of playing a round
*/
import java.util.Scanner;
public class Round
{
    // Instance variables for the round
    private Player player1;
    private Player player2;
    private Die d1, d2;
    private Die[] dice;
    private GameViewer viewer;

    public Round(Player play1, Player play2, GameViewer viewer)
    {
        player1 = play1;
        player2 = play2;
        d1 = new Die(viewer, 200, 250);
        d2 = new Die(viewer, 500, 250);
        this.viewer = viewer;
        // Initializes array of dice
        dice = new Die[2];
        dice[0] = d1;
        dice[1] = d2;
    }
    public Die[] getDice()
    {
        return dice;
    }
    // Plays a round
    public void playRound()
    {
        Scanner input = new Scanner(System.in);
        player1.setPoints(0);
        player2.setPoints(0);
        // While the round is not over
        while (player1.getPoints() < 5 && player2.getPoints() < 5)
        {
            // Player1 rolls dice
            int p1d1 = d1.roll();
            int p1d2 = d2.roll();
            //d1.setLastRoll(p1d1);
            //d2.setLastRoll(p1d2);
            int player1Roll = p1d1 + p1d2;
            viewer.repaint();
            System.out.println(player1.getName() + "'s turn:");
            // Print each roll and sum of rolls
            System.out.println("Die 1: " + p1d1);
            System.out.println("Die 2: " + p1d2);
            System.out.println("Number rolled: " + player1Roll);
            rolls(player1, player1Roll);
            input.nextLine();
            // Player2 rolls dice
            int p2d1 = d1.roll();
            int p2d2 = d2.roll();
            int player2Roll = p2d1 + p2d2;
            viewer.repaint();
            System.out.println(player2.getName() + "'s turn:");
            // Print each roll and sum of rolls
            System.out.println("Die 1: " + p2d1);
            System.out.println("Die 2: " + p2d2);
            System.out.println("Number rolled: " + player2Roll);
            rolls(player2, player2Roll);
            input.nextLine();
        }
    }

    // Gets the winner of the round
    public String getWinner()
    {
        // If the user won
        if (player1.getPoints() > player2.getPoints())
        {
            return player1.getName();
        }
        // If the computer won
        else if (player2.getPoints() > player1.getPoints())
        {
            return player2.getName();
        }
        // If tie
        else
        {
            return "It's a tie!";
        }
    }

    // Prints rolls of each player
    public void rolls(Player player, int playerRoll)
    {
        // If player rolls even number
        if (isEven(playerRoll))
        {
            System.out.println(player.getName() + " rolled an even number!");
            // player gets 1 point
            player.setPoints(player.getPoints() + 1);
            System.out.println(player + "\n");

        }
        // If player rolls odd number
        else
        {
            System.out.println(player.getName() + " rolled an odd number");
            System.out.println(player + "\n");
        }
    }

    // Checks to see if roll is even (return true if even)
    public boolean isEven(int roll)
    {
        // If even roll
        if (roll % 2 == 0)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}