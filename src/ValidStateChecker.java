import java.util.*;
//Class is used to check if a gamestate is valid
public class ValidStateChecker {
	//Variable for checking valid state boolean[x][y], origin top left
	//2D boolean arrays to check if a gamestate is valid
	//10x10 to draw the board, every X x Y feild contains a boolean value
	//true values are valid spaces, false values are invalid spaces

	// HOW DO YOU SAVE WHAT coordinates IS TRUE AND FALSE AFTER MAKING CHILD FROM PARENT STATE
	private boolean[][] filledSpaces = new boolean[10][10];
	private boolean[][] initialFilledSpaces = new boolean[10][10];
	private boolean filled = true;
	private boolean empty = false;
	private GamePiece[] gamePieces; // Array of Shape objects

	public ValidStateChecker() {
		MakeInitialBoard();
		MakeGamePieces();
	}

	// Initialize Black Game Squares of Array on puts on them on the board
	public void MakeInitialBoard() { //Change name of function
		for(int x = 0; x < 10; x++)
		{
			for(int y = 0; y < 10; y++)
			{
				initialFilledSpaces[x][y] = empty; //all of these coordinates are empty
			}
		}

		//Black Squares
		for(int i = 0; i < 10; i++) {
			initialFilledSpaces[0][i] = filled;
			initialFilledSpaces[9][i] = filled;
			initialFilledSpaces[i][0] = filled;
			initialFilledSpaces[i][9] = filled;
		}

		initialFilledSpaces[1][1] = filled;
		initialFilledSpaces[1][7] = filled;
		initialFilledSpaces[1][8] = filled;
		initialFilledSpaces[1][2] = filled;
		initialFilledSpaces[2][1] = filled;
		initialFilledSpaces[2][8] = filled;
		initialFilledSpaces[7][8] = filled;
		initialFilledSpaces[7][1] = filled;
		initialFilledSpaces[8][1] = filled;
		initialFilledSpaces[8][2] = filled;
		initialFilledSpaces[8][7] = filled;
		initialFilledSpaces[8][8] = filled;
		initialFilledSpaces[3][4] = filled;
		initialFilledSpaces[4][3] = filled;
		initialFilledSpaces[4][4] = filled;
	}

	//Creates List of GamePieces
	public void MakeGamePieces() {
		//GamePieces start in top right corner
		//Each element number corresponds with a block number
		gamePieces = new GamePiece[11];
		gamePieces[0] = new GamePiece(0, 4, 1, 3, 2, 3, 1, 4, 2, 4); //Red
		gamePieces[1] = new GamePiece(1, 3, 1, 5, 1, 6, 2, 6); //Green
		gamePieces[2] = new GamePiece(2, 3, 2, 5, 3, 5, 3, 6); //Purple
		gamePieces[3] = new GamePiece(3, 3, 3, 7, 3, 8, 4, 8); //Pink
		gamePieces[4] = new GamePiece(4, 3, 4, 7, 5, 7, 5, 8); //Yellow
		gamePieces[5] = new GamePiece(5, 3, 6, 7, 7, 7, 6, 8); //Brownish
		gamePieces[6] = new GamePiece(6, 4, 5, 4, 4, 5, 5, 5, 5, 6);
		gamePieces[7] = new GamePiece(7, 4, 6, 4, 6, 5, 6, 6, 7, 5);
		gamePieces[8] = new GamePiece(8, 3, 8, 5, 8, 6, 7, 6);
		gamePieces[9] = new GamePiece(9, 3, 6, 2, 6, 3, 5, 3);
		gamePieces[10] = new GamePiece(10, 3, 5, 1, 6, 1, 5, 2);

	}

	//Check if move is valid for Game, returns true if valid
	public boolean isValid(GameState state) {

		for(int i = 0; i < 10; i++) {
			//makes copy of the board into filledspace array
			//You'd have to update the board for each current state that gets added to the array
			filledSpaces[i] = initialFilledSpaces[i].clone();
		}
		//enhancedforloop that iterates through the GamePieceList ArrayList
		for(GamePiece gamepiece : gamePieces) {
			if(isSpaceFilled(gamepiece, state)) //Checks if space in board is filled
				return false; //invalid
		}
		return true; //valid
	}

	//Returns True if the space is already filled, and fills the space if not
	public boolean isSpaceFilled(GamePiece gamePiece, GameState gs) {

		int id, size;
		int x1, x2, x3, x4;
		int y1, y2, y3, y4;

		id = gamePiece.getId();
		size = gamePiece.getSize();
		x1 = gamePiece.getxPos1(); y1 = gamePiece.getyPos1();
		x2 = gamePiece.getxPos2(); y2 = gamePiece.getyPos2();
		x3 = gamePiece.getxPos3(); y3 = gamePiece.getyPos3();
		x4 = gamePiece.getxPos4(); y4 = gamePiece.getyPos4();


		if(size == 3) { //multiply by two because byte array have 22 elements but there are 11 ids
			if(filledSpaces[gs.state[2*id] + x1 ][y1 + gs.state[2*id + 1]]) //if a filled space,
				return true;
			else                      //return value of (0,1) and add to x1 and y1 of block of object
				filledSpaces[gs.state[2*id] + x1][y1 + gs.state[2*id + 1]] = true; //if not filled then make filled

			if(filledSpaces[x2 + gs.state[2*id]][y2 + gs.state[2*id + 1]])
				return true;
			else
				filledSpaces[x2 + gs.state[2*id]][y2 + gs.state[2*id + 1]] = true;

			if(filledSpaces[x3 + gs.state[2*id]][y3 + gs.state[2*id + 1]])
				return true;
			else
				filledSpaces[x3 + gs.state[2*id]][y3 + gs.state[2*id + 1]] = true;
		}

		else if(size == 4)	{
			if(filledSpaces[gs.state[2*id] +x1 ][y1 + gs.state[2*id + 1]])
				return true;
			else
				filledSpaces[gs.state[2*id] + x1][y1 + gs.state[2*id + 1]] = true;

			if(filledSpaces[x2 + gs.state[2*id]][y2 + gs.state[2*id + 1]])
				return true;
			else
				filledSpaces[x2 + gs.state[2*id]][y2 + gs.state[2*id + 1]] = true;

			if(filledSpaces[x3 + gs.state[2*id]][y3 + gs.state[2*id + 1]])
				return true;
			else
				filledSpaces[x3 + gs.state[2*id]][y3 + gs.state[2*id + 1]] = true;

			if(filledSpaces[x4 + gs.state[2*id]][y4 + gs.state[2*id + 1]])
				return true;
			else
				filledSpaces[x4 + gs.state[2*id]][y4 + gs.state[2*id + 1]] = true;
		}
		return false;
	}

}
