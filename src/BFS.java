import java.util.Iterator;
import java.util.TreeSet;

public class BFS {

  public GameState searchGameStates(TreeSet<GameState> entireTree, TreeSet<GameState> subTree) {
    GameStateComparator comp = new GameStateComparator();
    GameState finalState = new GameState(null);
    finalState.state[0] = 4;
    finalState.state[1] = -2;
    GameState winningState = new GameState(null);

    TreeSet<GameState> newSubTree = new TreeSet<GameState>(comp);
    boolean didreachgoal = false;
    ValidStateChecker check = new ValidStateChecker();


    Iterator<GameState> iterator = subTree.iterator();


    while(iterator.hasNext()) {
      GameState parentState = iterator.next();
      byte[] stateArray = parentState.getState().clone();

      //GameState Statte = parentState.clone();

      //Change all  X and Y values of a State
      for(int i = 0; i < 22; i++) {

        stateArray[i] = (byte)(stateArray[i] + 1);
        GameState newChildState = new GameState(parentState, stateArray);

        if(check.isValid(newChildState)) {
          if (newChildState.getState()[0] == finalState.state[0] && newChildState.getState()[1] == finalState.state[1]){
            didreachgoal = true;
            winningState = newChildState; //might need to change
          }

          if(entireTree.add(newChildState))
            newSubTree.add(newChildState);
        }
        stateArray[i] = (byte)(stateArray[i] - 1);
      }

      //Change all  X and Y values of a State
      for(int i = 0; i < 22; i++) {

        stateArray[i] = (byte)(stateArray[i] - 1);
        GameState newChildState = new GameState(parentState, stateArray);

        if(check.isValid(newChildState)){
          if (newChildState.getState()[1] == finalState.state[1]){
            didreachgoal = true;
            winningState = newChildState; //might need to change
          }

          if(entireTree.add(newChildState))
            newSubTree.add(newChildState);
        }
        stateArray[i] = (byte)(stateArray[i] + 1);
      }
  }

  if(!newSubTree.isEmpty() && !didreachgoal)
  winningState = searchGameStates(entireTree, newSubTree);

  return winningState;
 }
}
