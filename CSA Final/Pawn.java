
/**
 * Write a description of class Pawn here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Pawn extends Piece
{
    // instance variables - replace the example below with your own
    private int points;
    private String name = "";
    private boolean color;
    private String pos;

    public Pawn(String thePos, boolean theColor)
    {
        super(thePos,theColor);
        points = 1;
    }
    
}
