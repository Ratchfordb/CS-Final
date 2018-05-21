
/**
 * Abstract class Piece - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Piece
{
    // instance variables - replace the example below with your own
    private int points;
    private String name;
    private boolean color;
    private String pos;

    public Piece(String thePos, boolean isWhite)
    {
        pos = thePos;
        color = isWhite;
    }
    
    public String getPos()
    {    return pos;
    }   
    
    public int getPoints()
    {   return points;
    }
    
    public String getName()
    {   return name;   
    }
    
    public boolean getColor()
    {   return color;   
    }
}
