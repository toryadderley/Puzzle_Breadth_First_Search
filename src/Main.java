import java.util.*;
import java.io.*;

class Main {
	public static void main(String args[]) throws Exception {

		GameStateComparator comp = new GameStateComparator();
		TreeSet<GameState> subTree = new TreeSet<GameState>(comp);
		TreeSet<GameState> entireTree = new TreeSet<GameState>(comp);

		GameState initialState = new GameState(null);
		GameState goalState = new GameState(null);

		subTree.add(initialState);
		entireTree.add(initialState);

		BFS searcher = new BFS();
		goalState = searcher.searchGameStates(entireTree, subTree);

		GameState currentState = goalState;

		List<GameState> movesToGoalState = new ArrayList<GameState>();
		movesToGoalState.add(goalState);

		while(currentState != initialState){
			currentState = currentState.getPrev();
			movesToGoalState.add(currentState);
		}

		Collections.reverse(movesToGoalState);
		new Viz(movesToGoalState);

		try(Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("results.txt") , "utf-8"))){
			for(GameState gamestate : movesToGoalState)
				writer.write(gamestate.getStateCondition());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}


		System.out.println("Your AI worked. Number of moves taken: " + movesToGoalState.size());
		System.out.println("Working to add the Graphics.");

	}
}
