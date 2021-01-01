/**
 * The grid represents the game board.
 */
public class Grid {
	// Define the amount of rows and columns
	static int ROWS = 3;			// Rows
	static int COLUMNS = 3;		// Columns
 
	Box[][] board;								// Represents the game board as a grid
	int currentRow;								// Row that was played last
	int currentCol;								// Column that was played last
 
	
	// ********************* Constructor********************************************
	
   public Grid(int ROWS, int COLUMNS) {
      
      // TODO: Initialise the board array using ROWS and COLUMNS DONE 01/01
	   this.board = new Box [ROWS][COLUMNS];
      
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLUMNS; ++col) {
         }
       }
   }
 
   /**
    * Checks if the game has ended in a draw
    * One way to do this is to check that there are no empty positions left
    */
  // public boolean isDraw() {
	   
	   // TODO: Check whether the game has ended in a draw. 
	   // Hint: Use a nested loop (see the constructor for an example). Check whether any of the Boxes in the board grid are Player.Empty. If they are, it is not a draw.
	   // Hint: Return false if it is not a draw, return true if there are not empty positions left
	   

  // }
 
   /**
    * Return true if the turn player has won after making their move at the coordinate given
    */
   public boolean hasWon(Player player) {
	   // Row check
	   if(board[currentRow][0].content == player && board[currentRow][1].content == player && board[currentRow][2].content == player) {
		   return true;
	   }
	   // Column check

	   // TODO: Check if the currentCol is filled.
	   // Hint: Use the row code above as a starting point, remember that it goes board[row][column].
	   
	   // Diagonal check (check both directions
	   if(board[0][0].content == player && board[1][1].content == player && board[2][2].content == player) {
		   return true;
	   }
	   else if (board[0][2].content == player && board[1][1].content == player && board[2][0].content == player)  )

	   // TODO: Check the diagonal in the other direction DONE 01/01
	   
	   // No one has won yet
	   return false;
   }
 
   /**
    * Draws the tic-tac-toe board to the screen
    */
   public void display() {
      for (int row = 0; row < ROWS; ++row) {
         for (int col = 0; col < COLUMNS; ++col) {
        	 
        	 // Draw the contents of the box
        	 board[row][col].display();
        	 
        	 // Draw the vertical line
        	 if (col < COLUMNS - 1) System.out.print("|");
        	 
    	 }
         System.out.println();
         
         // Draw the horizontal line
         if (row < ROWS - 1) {
        	 System.out.println("-----------");
         }
      }
   }
}