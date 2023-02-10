/* Ella Litsur
2/8/23
This class keeps track of the attributes of each player
*/
import java.awt.*;

public class Die
{
    /** Instance Variables **/
    private GameViewer viewer;
    private int x, y;
    private int sides;
    private int lastRoll;

    /** Constructors **/
    public Die(GameViewer viewer, int x, int y) {
        this.viewer = viewer;
        this.x = x;
        this.y = y;
        sides = 6;
        lastRoll = 1;
    }

    public void setLastRoll(int latest)
    {
        this.lastRoll = latest;
    }

    // Rolls the die
    public int roll()
    {
        this.lastRoll = (int)(Math.random() * sides) + 1;
        return this.lastRoll;
    }
    // Draws the die
    public void draw(Graphics g)
    {
        g.drawImage(viewer.getImages()[this.lastRoll - 1], x, y, viewer);
    }
}