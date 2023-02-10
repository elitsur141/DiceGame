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


    public void paint(Graphics g) {
        // Displays the instructions
        g.setFont(new Font("SERIF", Font.PLAIN, 15));
        g.drawString("Instructions:", 20, 50);
        g.drawString("The goal of this game is to roll even sums using 2 6-sided dice.", 20, 70);
        g.drawString("Each time you roll an even number you get a point.", 20, 90);
        g.drawString("Get 5 points to win the game. You will be going against the computer.", 20, 110);
        g.drawString("Press the enter key to take a turn and run through the game.", 20, 130);
        g.drawString("Press enter to start!", 20, 150);
        g.drawString("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~", 20, 170);

        g.setFont(new Font("SanSarif Plain", Font.PLAIN, 25));
        // Displays the current dice
        game.getCurrentRound().getDice()[0].draw(g);
        game.getCurrentRound().getDice()[1].draw(g);

        // Display winner of round 3
        if (game.isR3done())
        {
            g.drawString("Round 3 winner: " + game.getRound3Winner(), 600, 140);

            // Display who won the game
            if (game.getWinner().equals(game.getUserName()))
            {
                g.drawString("You won the game!", 450, 600);
            }
            else if (game.getWinner().equals(game.getCompName()))
            {
                g.drawString("The computer won", 450, 600);
            }
            else
            {
                g.drawString(game.getWinner(), 450, 600);
            }
        }
        // Display winner of round 2
        else if (game.isR2done())
        {
            g.drawString("Round 2 winner: " + game.getRound2Winner(), 600, 110);
        }
        // Display winner of round 1
        else if (game.isR1done())
        {
            g.drawString("Round 1 winner: " + game.getRound1Winner(), 600, 80);
        }

    }
    public Image[] getImages()
    {
        return dieImages;
    }

}
