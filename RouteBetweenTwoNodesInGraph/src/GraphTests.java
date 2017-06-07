import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GraphTests {
 
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void twoNodesPathFromStartToFinishShouldReturnTrue() 
	{
		Node start = new Node(5);
		Node finish = new Node(0);
		Node[] neighborListStart = {finish};
		start.addOutgoingConnections(neighborListStart);
		assertEquals(true,start.doesPathExist(start,finish));
	}
	
	@Test
	public void twoNodesPathFromFinishToStartShouldReturnFalse()
	{
		Node start = new Node(5);
		Node finish = new Node(0);
		Node[] neighborListFinish = {start};
		finish.addOutgoingConnections(neighborListFinish);
		assertEquals(false,start.doesPathExist(start, finish));
	}
	
	@Test
	public void threeNodesNoPathBetweenAnyNodeShouldReturnFalse()
	{
		Node start = new Node(5);
		Node one = new Node(3);
		Node finish = new Node(0);
		assertEquals(false,start.doesPathExist(start, finish));
	}
	
	@Test
	public void threeNodesNoPathBetweenStartAndFinishShouldReturnFalse()
	{
		Node start = new Node(5);
		Node one = new Node(3);
		Node finish = new Node(0);
		
		Node[] startOutgoingList = {one};
		start.addOutgoingConnections(startOutgoingList);
		Node[] finishOutgoingList = {one};
		finish.addOutgoingConnections(finishOutgoingList);
		Node[] oneIncommingList = {start,finish};
		one.addIncomingList(oneIncommingList);
		
		assertEquals(false,start.doesPathExist(start, finish));	
	}
	
	@Test
	public void threeNodesPathBetweenStartAndFinishExistsShouldReturnTrue()
	{
		Node start = new Node(5);
		Node one = new Node(3);
		Node finish = new Node(0);
		
		Node[] startOutgoingList = {one};
		start.addOutgoingConnections(startOutgoingList);
		Node[] finishOutgoingList = {one};
		finish.addOutgoingConnections(finishOutgoingList);
		Node[] finishIncomingList = {one};
		finish.addIncomingList(finishIncomingList);
		Node[] oneIncomingList = {start,finish};
		one.addIncomingList(oneIncomingList);
		Node[] oneOutgoingList = {finish};
		one.addOutgoingConnections(oneOutgoingList);
		
		assertEquals(true,start.doesPathExist(start, finish));	
	}

}
