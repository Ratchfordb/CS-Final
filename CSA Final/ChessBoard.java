
/**
 * Write a description of class Board here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ChessBoard
{
    // instance variables - replace the example below with your own
    private String[][] positions = {{"a8","b8","c8","d8","e8","f8","g8","h8"},
                                    {"a7","b7","c7","d7","e7","f7","g7","h7"},
                                    {"a6","b6","c6","d6","e6","f6","g6","h6"},
                                    {"a5","b5","c5","d5","e5","f5","g5","h5"},
                                    {"a4","b4","c4","d4","e4","f4","g4","h4"},
                                    {"a3","b3","c3","d3","e3","f3","g3","h3"},
                                    {"a2","b2","c2","d2","e2","f2","g2","h2"},
                                    {"a1","b1","c1","d1","e1","f1","g1","h1"}};
    private boolean white = true;
    private boolean black = false;
    private Piece[][] board;
    /**
     * Constructor for objects of class Board
     */
    public ChessBoard()
    {
       board = new Piece[8][8];
    }
    
    //reminder that "true" is white
    public void newGame()
    {
            board[0][0] = new Rook("a8", black);
            board[0][7] = new Rook("h8", black);
            board[0][1] = new Knight("b8", black);
            board[0][6] = new Knight("g8", black);
            board[0][2] = new Bishop("c8", black);
            board[0][5] = new Bishop("f8", black);
            board[0][3] = new Queen("d8", black);
            board[0][4] = new King("e8", black);
            for(int c = 0; c<8; c++)
            {
                board[0][c] = new Pawn(positions[0][c], black);
                board[7][c] = new Pawn(positions[7][c], white);
            }
            board[7][0] = new Rook("a8", white);
            board[7][1] = new Knight("b8", white);
            board[7][6] = new Knight("g8", white);
            board[7][2] = new Bishop("c8", white);
            board[7][5] = new Bishop("f8", white);
            board[7][3] = new Queen("d8", white);
            board[7][4] = new King("e8", white);
    }

    public void nextMove(String pos1, String pos2)
    {
        if(validMove(pos1, pos2) == true)
        {
            
        }
    }
    
    public boolean validMove(String pos1, String pos2)
    {
        boolean val = false;
        return val;
    }
    
    /**
     * Method to return the collum of a position. 
     * converts the string, for example "a1" into 0
     * 
     * 
     */
    public int getCol(String pos)
    {
        int val = -1;
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board.length; j++)
            {
               if (positions[j][i] == pos)
               {
                   val = i;
               }
            }
        }
        return val;
    }
    
    /**
     * Method to return the row of a position. 
     * converts the string, for example "a1" into 0
     * 
     * 
     */
    public int getRow(String pos)
    {
        int val = -1;
        for(int i = 0; i < board.length; i++)
        {
            for(int j = 0; j < board.length; j++)
            {
               if (positions[i][j] == pos)
               {
                   val = i;
               }
            }
        }
        return val;
    }
}
