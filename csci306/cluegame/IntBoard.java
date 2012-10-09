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
   
   
    public IntBoard() {
        adjacencies = new HashMap<Integer, LinkedList<Integer>>();
        targets = new TreeSet<Integer>();
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
                if (r < ROWS)
                    adj.add(calcIndex(r +1, c));
                if (c < COLS)
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
        }
    }
   
    public void calcTargets(int start, int numSteps) {
       
    }
   
    public TreeSet<Integer> getTargets() {
        return new TreeSet<Integer>();       
    }
   
    public LinkedList<Integer> getAdjList(int whichAdjList) {
        return new LinkedList<Integer>();       
    }
   
    public int calcIndex(int row, int col) {
        return (row * COLS) + col;
    }
   
}
