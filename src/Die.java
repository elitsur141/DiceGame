/* Ella Litsur
2/8/23
This class keeps track of the attributes of each player
*/
public class Die
{
    /** Instance Variables **/
    private int sides;
    private int lastRoll;

    /** Constructors **/
    public Die() {
        sides = 6;
        lastRoll = 1;
    }

    public int getLastRoll()
    {
        return lastRoll;
    }

    // Rolls the die
    public int roll()
    {
        lastRoll = (int)(Math.random()*sides) + 1;
        return lastRoll;
    }

}