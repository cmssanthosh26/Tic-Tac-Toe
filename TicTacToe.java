package samplegame;
import java.util.Scanner;
public class TicTacToe {
    private char[][] board;
    private Scanner scanner;
    public TicTacToe()
    {
        this.board=new char[][]{
            {'-','-','-'},
            {'-','-','-'},
            {'-','-','-'}
        };
        scanner=new Scanner(System.in);
    }
    
    private void displayBoard()
    {
        for(int i=0;i<this.board.length;i++)
        {
            for(int j=0;j<this.board.length;j++)
            {
                System.out.printf("%-5c",this.board[i][j]);
            }
            System.out.println();
        }
    }
    
    private char isWon()
    {
        for(int i=0;i<this.board.length;i++)
        {
            if(this.board[i][0]!='-' && this.board[i][0] == this.board[i][1] && this.board[i][0] == this.board[i][2])
                return this.board[i][0];
        }
        
        for(int i=0;i<this.board.length;i++)
        {
            if(this.board[0][i]!='-' && this.board[0][i] == this.board[1][i] && this.board[0][i] == this.board[2][i])
                return this.board[0][i];
        }
        
        if(this.board[0][0]!='-' && this.board[0][0]==this.board[1][1] && this.board[0][0]==this.board[2][2])
            return this.board[0][0];
        
        if(this.board[0][2]!='-' && this.board[0][2]==this.board[1][1] && this.board[0][2]==this.board[2][0])
            return this.board[0][2];
        
        return ' ';
    }
    
    private boolean isTied()
    {
        for(int i=0;i<this.board.length;i++)
        {
            for(int j=0;j<this.board.length;j++)
            {
                if(this.board[i][j]=='-')
                    return false;
            }
        }
        return true;
    }
    
    private void playGame()
    {
        System.out.println("Welcome to Tic-Tac-Toe game");
        System.out.println("Enter your name, player1");
        String player1 = scanner.nextLine();
        System.out.println("Enter your name, player2");
        String player2 = scanner.nextLine();
        boolean isWhichPlayer = true;
        boolean isFinishTheGame = false; 
        
        while(!isFinishTheGame)
        {
            char ch=' ';
            int row=0,col=0;
            
            while(true)
            {
                if(isWhichPlayer)
                {
                    ch='X';
                    System.out.println(player1+", it's your turn and your symbol is X");
                }
                else
                {
                    ch='0';
                    System.out.println(player2+", it's your turn and your symbol is O");
                }

                System.out.println("Enter the row number");
                row=scanner.nextInt();
                System.out.println("Enter the column name");
                col=scanner.nextInt();
                
                if(row < 0 || row >= this.board.length || col < 0 || col >= this.board.length)
                {
                    System.out.println(" Please enter the correct coordinate ");
                }
                
                else if(this.board[row][col]!='-')
                {
                    System.out.println(" You entered cell coordinate is already filled. please enter other position ");
                }
                else
                    break;
            }
            
            this.board[row][col]=ch;
            this.displayBoard();
            char result=this.isWon();
            if(result!=' ')
            {
                if(result == 'X')
                {
                    System.out.println(player1+" won the match");
                }
                else
                {
                    System.out.println(player2+" won the match");
                }
                isFinishTheGame=true;
            }
            else if(this.isTied())
            {
                System.out.println("The match is tied");
                isFinishTheGame=true;
            }
            else
            {
                isWhichPlayer = !isWhichPlayer;
            }
        }
        
    }
    
    public static void main(String[] args)
    {
        TicTacToe t=new TicTacToe();
        t.displayBoard();
        t.playGame();
    }
}
