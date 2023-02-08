/* Ella Litsur
2/8/23
This class keeps track of the attributes of each player
*/
public class Player {

    // Instance variables for player
    private String name;
    private int points;

    public Player(String theName)
    {
        name = theName;
        points = 0;
    }

    // Returns name of the player
    public String getName()
    {
        return name;
    }

    // returns player's points
    public int getPoints()
    {
        return points;
    }

    // sets player's points to a specific number
    public void setPoints(int numPoints)
    {
        points = numPoints;
    }

    //
    public String toString()
    {
        return name + "'s points: " + points;
    }
}

