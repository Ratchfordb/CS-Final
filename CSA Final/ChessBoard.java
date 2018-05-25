
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

    public boolean nextMove(String pos1, String pos2)
    {
        if(validMove(pos1, pos2))
        {
            board[getRow(pos2)][getCol(pos2)] = board[getRow(pos1)][getCol(pos1)];
            board[getRow(pos1)][getCol(pos1)] = null;
            return true;
        }
        return false;
    }
    
    /**
     * Method determines if the selected move is a valid move.
     * returns a boolean, true if valid, false if invalid.
     * 
     * 
     */
    public boolean validMove(String pos1, String pos2)
    {
        //This if deals with if the selected piece is empty
        if(board[getRow(pos1)][getCol(pos1)]==null)
        {
            return false;
        }
        //This if deals with if the peice is a pawn.
        else if(board[getRow(pos1)][getCol(pos1)].getName().equals(""))
        {
            return pawnValidMove(pos1, pos2);
        }
        //This if deals with the peice being a rook
        else if(board[getRow(pos1)][getCol(pos1)].getName().equals("R"))
        {
            return rookValidMove(pos1, pos2);
        }
        //This if deals with the peice being a knight
        else if(board[getRow(pos1)][getCol(pos1)].getName().equals("N"))
        {
            return knightValidMove(pos1, pos2);
        }
        //This if deals with the peice being a bishop
        else if(board[getRow(pos1)][getCol(pos1)].getName().equals("B"))
        {
            return bishopValidMove(pos1, pos2);
        }
        //This if deals with the peice being a queen
        else if(board[getRow(pos1)][getCol(pos1)].getName().equals("Q"))
        {
            return queenValidMove(pos1, pos2);
        }
        //This if deals with the peice being a king
        else if(board[getRow(pos1)][getCol(pos1)].getName().equals("K"))
        {
            return kingValidMove(pos1, pos2);
        }
        else
        return false;
    }
    
    public boolean pawnValidMove(String pos1,String pos2)
    {
        //if there is no peice, returns false
        if(board[getRow(pos1)][getCol(pos1)]==null)
        return false;
        
        Pawn temp = (Pawn) board[getRow(pos1)][getCol(pos1)];
        //checks if peice is white or black
        
        if(temp.getColor()==true)
        {
            //checks if the pawn is within one row
            if(getRow(pos2) == (getRow(pos1)+1))
            {
                //checks if there is a piece in pos2
                if(board[getRow(pos2)][getCol(pos2)]==null)
                {
                    //if not, checks if they are in same collom, and if they are then the move is valid.
                    if (getCol(pos1) == getCol(pos2))
                        return true;
                        //if there is no peice in front of the pawn, and they are trying to move diagonal,
                        //then the move is invalid and returns false.
                    else
                        return false;
                }
                //There is a peice in pos2
                else
                {
                    //if there is a peice and it one up and to the right/left,
                    //then the move is valid
                    if (getCol(pos1) == (getCol(pos2) + 1)||getCol(pos1) == (getCol(pos2) - 1))
                    {
                        return true;
                    }
                    //the peice is not diagonal, return false.
                    else 
                    return false;
                }
            }
            //check if the pawn is at the start, in which case it can move two spaces forward
            else if(temp.hasMoved==false)
            {
                return true;
            }
            //If the pawn has already moved, and is pos2 is two spaces away, returns false.
            else
            {
                return false;
            }
        }
        //the peice is black
        else
        {
            //checks if the pawn is within one row
            if(getRow(pos2) == (getRow(pos1)-1))
            {
                //checks if there is a piece in pos2
                if(board[getRow(pos2)][getCol(pos2)]==null)
                {
                    //if not, checks if they are in same collom, and if they are then the move is valid.
                    if (getCol(pos1) == getCol(pos2))
                        return true;
                        //if there is no peice in front of the pawn, and they are trying to move diagonal,
                        //then the move is invalid and returns false.
                    else
                        return false;
                }
                //There is a peice in pos2
                else
                {
                    //if there is a peice and it one up and to the right/left,
                    //then the move is valid
                    if (getCol(pos1) == (getCol(pos2) + 1)||getCol(pos1) == (getCol(pos2) - 1))
                    {
                        return true;
                    }
                    //the peice is not diagonal, return false.
                    else 
                    return false;
                }
            }
            //check if the pawn is at the start, in which case it can move two spaces forward
            else if(temp.hasMoved==false)
            {
                return true;
            }
            //If the pawn has already moved, and is pos2 is two spaces away, returns false.
            else
            {
                return false;
            }
        }
    }
    
    public boolean knightValidMove(String pos1,String pos2)
    {
        Knight temp = (Knight) board[getRow(pos1)][getCol(pos1)];
        if (
    }
    
    public boolean rookValidMove(String pos1,String pos2)
    {
        
    }
    
    public boolean bishopValidMove(String pos1,String pos2)
    {
        
    }
    
    public boolean queenValidMove(String pos1,String pos2)
    {
        
    }
    
    public boolean kingValidMove(String pos1,String pos2)
    {
        
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
