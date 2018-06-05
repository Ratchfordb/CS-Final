import java.util.Scanner;
public class ChessGame
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to chess! To start a new game, type \"NEW,\" or type \"QUIT\" to quit.\nThis works at any time.");
        String input = scan.next();
        String input2 = scan.next();
        ChessBoard board = new ChessBoard();
        Piece[][] piece = new Piece[8][8];
        while(!input.equals("QUIT") && !input2.equals("QUIT"))
        {   
            board.retBoard(piece);
            //prints the current board every move
            for(int i = 0; i < 8; i++)
            {
                for(int j = 0; j < 8; j++)
                {
                    System.out.print(piece[i][j]);
                }
                System.out.println();
            }
            
            
            
            
            
            
            
            if(input.equals("NEW"))
            {
                board.newGame();
                System.out.println("Enter the position of the piece you want to move.");
                input = scan.next();
                }
            else if(input.length()>=2||input.substring(0,1).toUpperCase().compareTo("A")<0
            ||input.substring(0,1).toUpperCase().compareTo("Z") > 0 
            ||input.substring(1).compareTo("1")<0||input.substring(1).compareTo("8")>0)
            {
                System.out.println("Now enter the position you want to move it to.");
                input2 = scan.next();
                if(input2.length()>=2||input2.substring(0,1).toUpperCase().compareTo("A")<0
                ||input2.substring(0,1).toUpperCase().compareTo("Z") > 0 
                ||input2.substring(1).compareTo("1")<0||input2.substring(1).compareTo("8")>0)
                {
                    if(!board.nextMove(input, input2))
                    {
                        System.out.println("Please input a valid move. Enter the position of the piece you want to move again.");
                        input = scan.next();
                        input2 = "";
                    }
                    else if(board.isCheckmate())
                    {
                        System.out.println(board.getTurn() + " wins!");
                        input = scan.next();
                    }
                    else
                    {
                        System.out.println("Move comlpete. Enter the next position.");
                        input2 = "";
                        input = scan.next();
                    }
                }
            }
            else
            {
                System.out.println("Please input a valid position.");
                input = scan.next();
            }
        }
    }
}