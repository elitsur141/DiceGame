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
    private final int WINDOW_WIDTH = 1000;
    private final int WINDOW_HEIGHT = 800;
    public GameViewer(Game g)
    {
        this.game = g;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("Dice Game");
        this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        this.setVisible(true);
    }


    public void paint(Graphics g)
    {
        g.setFont(new Font("SERIF", Font.PLAIN, 15));
        g.drawString("Instructions:", 20, 50);

        // Display winner of round 1
        if (game.isR1done())
        {
            g.drawString("Round 1 winner: " + game.getRound1Winner(), 700, 80);
        }
        // Display winner of round 2
        if (game.isR2done())
        {
            g.drawString("Round 2 winner: " + game.getRound2Winner(), 700, 100);
        }
        // Display winner of round 3
        if (game.isR3done())
        {
            g.drawString("Round 3 winner: " + game.getRound3Winner(), 700, 120);

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
    }
}
