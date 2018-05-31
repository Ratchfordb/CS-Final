------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE:
PURPOSE OF PROJECT:
VERSION or DATE:
HOW TO START THIS PROJECT:
AUTHORS:
USER INSTRUCTIONS:



        //This if deals with if the selected piece is empty
        if(board[getRow(pos1)][getCol(pos1)]==null)
        {
            return false;
        }
        //This if deals with if the peice is a pawn.
        else if(board[getRow(pos1)][getCol(pos1)].getName().equals(""))
        {
            Pawn temp = (Pawn) board[getRow(pos1)][getCol(pos1)];
            //checks if the pawn is within one row
            if(getRow(pos2) == (getRow(pos1)+1)||(getRow(pos2) == (getRow(pos1)-1)))
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
                    if (getCol
                }
            }
            //check if the pawn is at the start, in which case it can move two spaces forward
            else if(temp.hasMoved==false)
            {
            }
            //If the pawn has already moved, and is pos2 is two spaces away, returns false.
            else
            {
                return false;
            }
        }
        return false;