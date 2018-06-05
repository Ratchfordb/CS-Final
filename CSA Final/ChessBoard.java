
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
    private boolean whiteToMove = true;
    private Piece[][] board;
    /**
     * Constructor for objects of class Board
     */
    public ChessBoard()
    {
       board = new Piece[8][8];
    }
    
    public void retBoard(Piece[][] temp)
    {
        
            for(int i = 0; i < 8; i++)
            {
                for(int j = 0; j < 8; j++)
                {
                    temp[i][j] = board[i][j];
                }
            }
    }
    
    //reminder that "true" is white
    public void newGame()
    {
            board[0][0] = new Rook("a8", false);
            board[0][7] = new Rook("h8", false);
            board[0][1] = new Knight("b8", false);
            board[0][6] = new Knight("g8", false);
            board[0][2] = new Bishop("c8", false);
            board[0][5] = new Bishop("f8", false);
            board[0][3] = new Queen("d8", false);
            board[0][4] = new King("e8", false);
            for(int c = 0; c<8; c++)
            {
                board[1][c] = new Pawn(positions[1][c], false);
                board[6][c] = new Pawn(positions[6][c], true);
            }
            board[7][0] = new Rook("a8", true);
            board[7][1] = new Knight("b8", true);
            board[7][6] = new Knight("g8", true);
            board[7][2] = new Bishop("c8", true);
            board[7][5] = new Bishop("f8", true);
            board[7][3] = new Queen("d8", true);
            board[7][4] = new King("e8", true);
            whiteToMove = true;
    }

    public boolean nextMove(String pos1, String pos2)
    {
        if(validMove(pos1, pos2))
        {
            board[getRow(pos2)][getCol(pos2)] = board[getRow(pos1)][getCol(pos1)];
            board[getRow(pos1)][getCol(pos1)] = null;
            whiteToMove = !whiteToMove;
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
        //if they choose the same tile
        if(pos1.equals(pos2))
        return false;
        
        if(board[getRow(pos1)][getCol(pos1)].getColor() == board[getRow(pos2)][getCol(pos2)].getColor())
        return false;
        
        
        //This if deals with if the selected piece is empty
        if(board[getRow(pos1)][getCol(pos1)]==null)
        {
            return false;
        }
        //This if deals with if the peice is a pawn.
        else if(board[getRow(pos1)][getCol(pos1)].getName()==null)
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
        //the peice is black
        else
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
    }
    
    public boolean knightValidMove(String pos1,String pos2)
    {
        if (getCol(pos1)==getCol(pos2)+1)
        {
            if((getRow(pos1)==getCol(pos2)+2)||getRow(pos1)==(getCol(pos2)-2))
            {
                return true;
            }
        }
        else if (getCol(pos1)==getCol(pos2)-1)
        {
            if((getRow(pos1)==getCol(pos2)+2)||getRow(pos1)==(getCol(pos2)-2))
            {
                return true;
            }
        }
        else if (getCol(pos1)==getCol(pos2)+2)
        {
            if((getRow(pos1)==getCol(pos2)+1)||getRow(pos1)==(getCol(pos2)-1))
            {
                return true;
            }
        }
        else if (getCol(pos1)==getCol(pos2)-2)
        {
            if((getRow(pos1)==getCol(pos2)+1)||getRow(pos1)==(getCol(pos2)-1))
            {
                return true;
            }
        }
        return false;
        
    }
    
    public boolean rookValidMove(String pos1,String pos2)
    {
        if(getCol(pos1) == getCol(pos2))
        {
            if(getRow(pos1) > getRow(pos2))
            {
                for(int i = 0; i < getRow(pos1)-getRow(pos2); i++)
                {
                    if(board[getCol(pos1)][getRow(pos1)-i]!=null)
                    return false;
                }
            }
            else if(getRow(pos1) < getRow(pos2))
            {
                
                for(int i = 0; i < getRow(pos2)-getRow(pos1); i++)
                {
                    if(board[getCol(pos1)][getRow(pos1)+i]!=null)
                    return false;
                }
            }
            return true;
        }
        else if(getRow(pos1) == getRow(pos2))
        {
            if(getCol(pos1) > getCol(pos2))
            {
                for(int i = 0; i < getCol(pos1)-getCol(pos2); i++)
                {
                    if(board[getCol(pos1)-i][getRow(pos1)]!=null)
                    return false;
                }
            }
            else if(getCol(pos1) < getCol(pos2))
            {
                
                for(int i = 0; i < getCol(pos2)-getCol(pos1); i++)
                {
                    if(board[getCol(pos1)+i][getRow(pos1)]!=null)
                    return false;
                }
            }
        }
        return false;
    }
    
    public boolean bishopValidMove(String pos1,String pos2)
    {
        String [] validPos = new String[13];
        int i = 0;
        if(getCol(pos1)==getCol(pos2))
        return false;
        if(getRow(pos1)==getRow(pos2))
        return false;
        
        //when pos2 is to the right of pos1
        if(getCol(pos1)<getCol(pos2))
        {
            //pos2 is above
            if(getRow(pos1)>getRow(pos2))
            {
                int y = getRow(pos1);
                int x = getCol(pos1);
                while(x <= 7 && y >= 0 && board[y][x] == null)
                {
                    validPos[i] = positions[y][x];
                    i++;
                    y--;
                    x++;
                }
            }
            //pos2 is below
            if(getRow(pos1)<getRow(pos2))
            {
                int y = getRow(pos1);
                int x = getCol(pos1);
                while(x <= 7 && y <= 7 && board[y][x] == null)
                {
                    validPos[i] = positions[y][x];
                    i++;
                    y++;
                    x++;
                }
            }
        }
        //when pos2 is to the left of pos1
        else
        {
            //pos2 is above
            if(getRow(pos1)>getRow(pos2))
            {
                int y = getRow(pos1);
                int x = getCol(pos1);
                while(x >= 0 && y >= 0 && board[y][x] == null)
                {
                    validPos[i] = positions[y][x];
                    i++;
                    y--;
                    x--;
                }
            }
            //pos2 is below
            if(getRow(pos1)<getRow(pos2))
            {
                int y = getRow(pos1);
                int x = getCol(pos1);
                while(x >= 0 && y <= 7 && board[y][x] == null)
                {
                    validPos[i] = positions[y][x];
                    i++;
                    y++;
                    x--;
                }
            }
        }
        for(int j = 0; i < validPos.length; i++)
        {
            if (validPos[j] == pos2)
            return true;
        }
        return false;
    }
    
    public boolean queenValidMove(String pos1,String pos2)
    {
        
        
        
        if(getCol(pos1) == getCol(pos2))
        {
            if(getRow(pos1) > getRow(pos2))
            {
                for(int i = 0; i < getRow(pos1)-getRow(pos2); i++)
                {
                    if(board[getCol(pos1)][getRow(pos1)-i]!=null)
                    return false;
                }
            }
            else if(getRow(pos1) < getRow(pos2))
            {
                
                for(int i = 0; i < getRow(pos2)-getRow(pos1); i++)
                {
                    if(board[getCol(pos1)][getRow(pos1)+i]!=null)
                    return false;
                }
            }
            return true;
        }
        else if(getRow(pos1) == getRow(pos2))
        {
            if(getCol(pos1) > getCol(pos2))
            {
                for(int i = 0; i < getCol(pos1)-getCol(pos2); i++)
                {
                    if(board[getCol(pos1)-i][getRow(pos1)]!=null)
                    return false;
                }
            }
            else if(getCol(pos1) < getCol(pos2))
            {
                
                for(int i = 0; i < getCol(pos2)-getCol(pos1); i++)
                {
                    if(board[getCol(pos1)+i][getRow(pos1)]!=null)
                    return false;
                }
            }
        }
        
        
        
        
        String [] validPos = new String[13];
        int i = 0;
        //when pos2 is to the right of pos1
        if(getCol(pos1)<getCol(pos2))
        {
            //pos2 is above
            if(getRow(pos1)>getRow(pos2))
            {
                int y = getRow(pos1);
                int x = getCol(pos1);
                while(x <= 7 && y >= 0 && (board[y][x] == null || board[y][x].getColor() != board[getRow(pos1)][getCol(pos1)].getColor()))
                {
                    validPos[i] = positions[y][x];
                    i++;
                    y--;
                    x++;
                }
            }
            //pos2 is below
            if(getRow(pos1)<getRow(pos2))
            {
                int y = getRow(pos1);
                int x = getCol(pos1);
                while(x <= 7 && y <= 7 && (board[y][x] == null || board[y][x].getColor() != board[getRow(pos1)][getCol(pos1)].getColor()))
                {
                    validPos[i] = positions[y][x];
                    i++;
                    y++;
                    x++;
                }
            }
        }
        //when pos2 is to the left of pos1
        else
        {
            //pos2 is above
            if(getRow(pos1)>getRow(pos2))
            {
                int y = getRow(pos1);
                int x = getCol(pos1);
                while(x >= 0 && y >= 0 && (board[y][x] == null || board[y][x].getColor() != board[getRow(pos1)][getCol(pos1)].getColor()))
                {
                    validPos[i] = positions[y][x];
                    i++;
                    y--;
                    x--;
                }
            }
            //pos2 is below
            if(getRow(pos1)<getRow(pos2))
            {
                int y = getRow(pos1);
                int x = getCol(pos1);
                while(x >= 0 && y <= 7 && (board[y][x] == null || board[y][x].getColor() != board[getRow(pos1)][getCol(pos1)].getColor()))
                {
                    validPos[i] = positions[y][x];
                    i++;
                    y++;
                    x--;
                }
            }
        }
        for(int j = 0; i < validPos.length; i++)
        {
            if (validPos[j] == pos2)
            return true;
        }
        return false;
    }
    
    public boolean kingValidMove(String pos1,String pos2)
    {
        return false;
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
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
               if (positions[j][i].equals(pos))
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
        for(int i = 0; i < 8; i++)
        {
            for(int j = 0; j < 8; j++)
            {
               if (positions[i][j].equals(pos))
               {
                   val = i;
               }
            }
        }
        return val;
    }
        //Okay before this method works properly you will need to instantiate a variable as follows
    // private boolean whiteToMove = true;
    //also add to the newGame() method a step at the end that goes
    // whiteToMove = true;
    //also at the end of the nextMove() method, add a step as follows
    // whiteToMove = !whiteToMove;
    public String getTurn()
    {
        if(whiteToMove)
            return "White";
        else
            return "Black";
    }
    
    //This only works if we make it so that the kingValidMove() method can deal with
    //OOB inputs in some capacity, but that should be possible (and actually not that hard).
    // **IMPORTANT**: Currently this method has no way of determining 
    // whether or not the king is in check at all,so we need to work on that
    //Another thing: make sure that if the initial and final positions 
    //are the same the move is invalid (in general)
    public boolean isCheckmate()
    {
        for(int r = 0; r<8; r++)
        {
            for(int c = 0; c<8; c++)
            {
                if(whiteToMove)
                {
                    if(board[r][c].getName().equals("K") && board[r][c].getColor())
                    {
                        if(!kingValidMove(positions[r][c], positions[r-1][c-1])
                        &&!kingValidMove(positions[r][c], positions[r-1][c])
                        &&!kingValidMove(positions[r][c], positions[r-1][c+1])
                        &&!kingValidMove(positions[r][c], positions[r][c-1])
                        &&!kingValidMove(positions[r][c], positions[r][c+1])
                        &&!kingValidMove(positions[r][c], positions[r+1][c-1])
                        &&!kingValidMove(positions[r][c], positions[r+1][c])
                        &&!kingValidMove(positions[r][c], positions[r+1][c+1]))
                        {
                            return true;
                        }
                    }
                }
                else
                {
                   if(board[r][c].getName().equals("K") && !board[r][c].getColor())
                    {
                        if(!kingValidMove(positions[r][c], positions[r-1][c-1])
                        &&!kingValidMove(positions[r][c], positions[r-1][c])
                        &&!kingValidMove(positions[r][c], positions[r-1][c+1])
                        &&!kingValidMove(positions[r][c], positions[r][c-1])
                        &&!kingValidMove(positions[r][c], positions[r][c+1])
                        &&!kingValidMove(positions[r][c], positions[r+1][c-1])
                        &&!kingValidMove(positions[r][c], positions[r+1][c])
                        &&!kingValidMove(positions[r][c], positions[r+1][c+1]))
                        {
                            return true;
                        }
                    } 
                }
            }
        }
        return false;
    }
    
    public boolean inCheck(String kingPos)
    {
        for(int r = 0; r<8; r++)
        {
            for(int c = 0; c<8; c++)
            {
                if(validMove(positions[r][c], kingPos))
                {
                    return true;
                }
            }
        }
        return false;
    }
}
