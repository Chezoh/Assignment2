import java.util.Scanner;				// Scanner required for player input

/**
 * The main class for the game Tic-Tac-Toe.
 * Controls the flow of the game, allowing each player to enter an option until the game ends.
 */

public class GameMain {
	private static Scanner scanner = new Scanner(System.in);  // Scanner for input
	
	private Grid grid;					// The game board
	private boolean gameOver;			// Whether game is playing or over
	private Player winner;				// Winner of the game
	private Player currentPlayer;		// Current player (enum)
 
   /**
    * Constructor
    * Sets up the game. Creates the grid and sets the values of the variables before calling the play method.
    */
   public GameMain() {
	   // Create the grid
	   // TODO: Create a new instance of the "Grid"class
	   grid = new Grid();
	   
	   // Reset the game variables to their defaults
	   currentPlayer = Player.X; // Player X moves first
	   gameOver = false;
	   winner = null;
	   // TODO: Assign the default values for currentPlayer (Player.X), gameOver (false), and winner (null)

	   // Begin playing the game
	   
	   // TODO: Call the "play()" method
	   play();
   }
   
   /**
    * Controls the game play, rotates between player turns until a winner is decided.
    */
   public void play() {
	   do {
	         playerMove(currentPlayer);			// Have the player perform their move
	         grid.display();					// Display the current game board
	         checkForWinner(currentPlayer);		// Checks if the game has been won
	         
	         // Display results if game is over
	         if(gameOver) {
	        	 if(winner == Player.X) {
		        	 System.out.println("Player X wins!");
		         }
	        	 else if(winner == Player.O) {
	        		 System.out.println("Player O wins!");  
	        	 }
	        	 // TODO: Display result if player O wins  DONE 01/01
	        	 else if (winner == null) {
	        		 System.out.println("It is a draw!");
	        	 }
	        	 // TODO: Display result if it was a draw
	         }
	         
	         // Switch turn to the next player
	         if(currentPlayer == Player.X) {
	        	 currentPlayer = Player.O;
	         } else {
	        	 currentPlayer = Player.X;
	         }
	         
	      } while (!gameOver);  // repeat until game-over
   }
 
   /** 
    * Handles the player making their move, checks if the move is valid before making it.
    */
  public void playerMove(Player turnPlayer) {
	   
      boolean validInput = false;
      
      do {
    	  // Display instructions to the player
         if (turnPlayer == Player.X) {
            System.out.print("Player 'X', enter your move (row[1-3] column[1-3]): ");
         } else {
        	 if (turnPlayer == Player.O) {
        		 System.out.println("Player 'O', enter your move (row[1-3] column [1-3]");
        	 }
        	 // TODO: Inform Player 'O' to enter their move DONE 01/01
         }
         // Obtains input from the player for both row and column
         int row = scanner.nextInt();
         int col = scanner.nextInt();
         
         // Decrease the value entered by 1 to compensate for the array index starting at 0
         row--;
         col--;
      
        //  Verify the values the player entered are valid (position is valid and empty)
       if (row >= 0 && row < Grid.ROWS && col >= 0 && col < Grid.COLUMNS && grid.board[row][col].content == Player.EMPTY) {
      	 grid.board[row][col].content = turnPlayer;
      	 grid.currentRow = row;
      	 grid.currentCol = col;
       	 validInput = true;
        } else {
        	 System.out.println("Move not vaild. Please try again.");
        	 // TODO: Display an error message that the move was not valid. DONE 01/01
        }
         
     } while (!validInput);   // Repeat until input is valid
   }
 
   /**
    * Checks if the game has ended
    */
   public void checkForWinner(Player turnPlayer) {
      if (grid.hasWon(turnPlayer)) {
    	  gameOver = (turnPlayer == Player.X);
    	  }
    	  // TODO: Set gameOver and winner appropriately
       else if (grid.isDraw()) {
    	  gameOver = true;
       }
      }
    	  

    	  // TODO: Set gameOver and winner appropriately
      
   
 
   /**
    * The main() method
    */
   public static void main(String[] args) {
	   new GameMain();
	   // TODO: Add a loop to restart the game once it has finished
	   
	   // TODO: Then update the loop to ask the player if they want to play again, exit if they do not
	   
	  
	}
}