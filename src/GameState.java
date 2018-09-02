class GameState {
	private GameState prev;
	public byte[] state;
  public String stateCondition;

	GameState(GameState _prev) {
		prev = _prev;
		state = new byte[22];
	}


  //Could make into a set state
  GameState(GameState _prev, byte[] newState) {
    prev = _prev;
    state = newState.clone();
  }

  //Retrieval Methods
  public byte[] getState() {
		return state;
	}

  public GameState getPrev() {
    return prev;
  }

	public String getStateCondition() {
		stateCondition = new String();
		for(int i = 0; i < 22; i = i + 2)
			stateCondition += "(" + state[i] + "," + state[i+1] + "), ";
		stateCondition += "\n";
		return stateCondition;
	}
}
