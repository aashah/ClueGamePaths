package csci306.cluegame;

import java.util.LinkedList;
import java.util.TreeSet;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class TestCluePaths {

	
	private IntBoard testBoard;
	
	@Before
	public void initBoard() {
		testBoard = new IntBoard();
		testBoard.calcAdjacencies();
	}
	
	@Test
	public void testAdjacency() {
		LinkedList testAdjacencyList = testBoard.getAdjList(0);
		Assert.assertTrue(testAdjacencyList.contains(4));
		Assert.assertTrue(testAdjacencyList.contains(1));
		Assert.assertEquals(2, testAdjacencyList.size());
	}
	
	@Test
	public void testTargets() {
		testBoard.calcTargets(3, 3);
		TreeSet targets= testBoard.getTargets();
		Assert.assertEquals(6, targets.size());
		Assert.assertTrue(targets.contains(0));
		Assert.assertTrue(targets.contains(5));
		Assert.assertTrue(targets.contains(10));
		Assert.assertTrue(targets.contains(15));
		Assert.assertTrue(targets.contains(2));
		Assert.assertTrue(targets.contains(7));
	}

}
