
/**
 * Abstract class Piece - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Piece
{
    // instance variables - replace the example below with your own
    private String name;
    private boolean color;
    private String pos;
    private int points;

    public Piece(String thePos, boolean isWhite, int thePoints, String theName)
    {
        pos = thePos;
        color = isWhite;
        points = thePoints;
        name = theName;
    }
    
    public void setPos(String position)
    {   pos = position;
    }
    
    public String getPos()
    {    return pos;
    }   
    
    public int getPoints()
    {
        return points;
    }
    
    public String getName()
    {   return name;   
    }
    
    public boolean getColor()
    {   return color;   
    }
}
