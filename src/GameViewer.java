/* Ella Litsur
2/8/23
This class is the front end of the game and draws what is happening
in the game on a separate window
*/
import javax.swing.*;
import java.awt.*;

public class GameViewer extends JFrame
{
    private Game game;
    private Image[] dieImages;
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    private final int TEXT_XY = 600;
    private final int INTRO_TEXT_X = 20;
    public GameViewer(Game g)
    {
        this.game = g;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Dice Game");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
        // Makes an array of die images
        dieImages = new Image[6];
        for (int i = 0; i < dieImages.length; i++)
        {
            dieImages[i] = new ImageIcon("Resources/" + (i+1) + ".png").getImage();
        }
    }

    // Displays the front end of the game
    public void paint(Graphics g) {
        // Displays the instructions
        g.setColor(Color.black);
        g.setFont(new Font("SERIF", Font.PLAIN, 15));
        g.drawString("Instructions:", INTRO_TEXT_X, 50);
        g.drawString("The goal of this game is to roll even sums using 2 6-sided dice.", INTRO_TEXT_X, 70);
        g.drawString("Each time you roll an even number you get a point.", INTRO_TEXT_X, 90);
        g.drawString("Get 5 points to win the game. You will be going against the computer.", INTRO_TEXT_X, 110);
        g.drawString("Press the enter key to take a turn and run through the game.", INTRO_TEXT_X, 130);
        g.drawString("Press enter to start!", INTRO_TEXT_X, 150);
        g.drawString("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~", INTRO_TEXT_X, 170);

        if (game.getCurrentRound() != null)
        {
            // Displays the current dice
            game.getCurrentRound().getDice()[0].draw(g);
            game.getCurrentRound().getDice()[1].draw(g);
        }

        g.setFont(new Font("SanSarif Plain", Font.PLAIN, 25));
        if (game.isR3done())
        {
            // Display winner of round 3
            g.drawString("Round 3 winner: " + game.getRound3Winner(), TEXT_XY, 140);

            // Display who won the game
            g.setFont(new Font("SanSarif Plain", Font.BOLD, 50));
            // If user won the game
            if (game.getWinner().equals(game.getUserName()))
            {
                g.setColor(Color.green);
                g.drawString("You won the game!", 250, TEXT_XY);
            }
            // If computer won the game
            else if (game.getWinner().equals(game.getCompName()))
            {
                g.setColor(Color.red);
                g.drawString("The computer won :(", 240, TEXT_XY);
            }
            // If it's a tie
            else
            {
                g.setColor(Color.blue);
                g.drawString(game.getWinner(), 400, TEXT_XY);
            }
            g.setFont(new Font("SanSarif Plain", Font.PLAIN, 35));
            g.setColor(Color.orange);
            g.drawString("Thank you for playing!", 280, 700);
        }
        // Display winner of round 2
        else if (game.isR2done())
        {
            g.drawString("Round 2 winner: " + game.getRound2Winner(), TEXT_XY, 110);
        }
        // Display winner of round 1
        else if (game.isR1done())
        {
            g.drawString("Round 1 winner: " + game.getRound1Winner(), TEXT_XY, 80);
        }

    }
    public Image[] getImages()
    {
        return dieImages;
    }

}
