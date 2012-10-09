package csci306.cluegame;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeSet;

public class IntBoard {
    private static final int ROWS = 4;
    private static final int COLS = 4;
    private TreeSet<Integer> targets;
    private Map<Integer, LinkedList<Integer>> adjacencies;
    
    private LinkedList<Integer> seen;
   
   
    public IntBoard() {
        adjacencies = new HashMap<Integer, LinkedList<Integer>>();
        targets = new TreeSet<Integer>();
        
        seen = new LinkedList<Integer>();
    }
   
    public void calcAdjacencies() {
        for( int r = 0; r < ROWS; r++) {
            for(int c = 0; c < COLS; c++) {
                int currentIndex = calcIndex(r, c);
                LinkedList<Integer> adj = new LinkedList<Integer>();

                if (r > 0)
                    adj.add(calcIndex(r -1, c));
                if (c > 0)
                    adj.add(calcIndex(r, c -1));
                if (r < (ROWS -1))
                    adj.add(calcIndex(r +1, c));
                if (c < (COLS -1))
                    adj.add(calcIndex(r, c +1));
               
                adjacencies.put(currentIndex, adj);
            }
        }
    }
   
    public void printAdjancies() {
        for (int i = 0; i < adjacencies.size(); ++i) {
            System.out.print(i + "=>");
           
            LinkedList<Integer> adj = adjacencies.get(i);
            for (int j : adj) {
                System.out.print(j + "=>");
            }
            System.out.print("\n");
        }
    }
   
    public void calcTargets(int start, int numSteps) {
    	seen.push(start);
    	System.out.println("We're at : " + start + " numsteps: " + numSteps);
    	if (numSteps == 0) {
    		targets.add(start);
    		return;
    	}
    	LinkedList<Integer> adjList = getAdjList(start);
    	
    	for (int i : adjList) {
    		if (!seen.contains(i)) {
    			calcTargets(i, numSteps -1);
    			seen.pop();
    		}
    	}
    	
    	
    }
    
    public void printTargets() {
    	for (int i : targets) {
    		System.out.println("Target: " + i);
    	}
    }
   
    public TreeSet<Integer> getTargets() {
        return targets;       
    }
   
    public LinkedList<Integer> getAdjList(int whichAdjList) {
        return adjacencies.get(whichAdjList);      
    }
   
    public int calcIndex(int row, int col) {
        return (row * COLS) + col;
    }
   
}
