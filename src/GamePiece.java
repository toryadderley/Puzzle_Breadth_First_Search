class GamePiece {

  private int id, size;
	private int xPos1, yPos1;
  private int xPos2, yPos2;
	private int xPos3, yPos3;
  private int xPos4, yPos4;

	//GamePiece with three Blocks
	public GamePiece(int newid, int newsize, int newxPos1, int newyPos1, int newxPos2, int newyPos2, int newxPos3, int newyPos3) {
		id = newid;
		size = newsize;
		xPos1 = newxPos1;
		yPos1 = newyPos1;
		xPos2 = newxPos2;
		yPos2 = newyPos2;
		xPos3 = newxPos3;
		yPos3 = newyPos3;
	}

	//GamePiece with four Blocks
	public GamePiece(int newid, int newsize, int newxPos1, int newyPos1, int newxPos2, int newyPos2, int newxPos3, int newyPos3, int newxPos4, int newyPos4) {
		id = newid;
		size = newsize;
		xPos1 = newxPos1;
		yPos1 = newyPos1;
		xPos2 = newxPos2;
		yPos2 = newyPos2;
		xPos3 = newxPos3;
		yPos3 = newyPos3;
		xPos4 = newxPos4;
		yPos4 = newyPos4;
	}

	public int getId() {
		return id;
	}

	public int getSize() {
		return size;
	}

	public int getxPos1() {
		return xPos1;
	}

	public int getxPos2() {
		return xPos2;
	}

	public int getxPos3() {
		return xPos3;
	}

	public int getxPos4() {
		return xPos4;
	}

	public int getyPos1() {
		return yPos1;
	}

	public int getyPos2() {
		return yPos2;
	}

	public int getyPos3() {
		return yPos3;
	}

	public int getyPos4() {
		return yPos4;
	}

}
