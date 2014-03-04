import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class CloneGraph {
	
	static class UndirectedGraphNode {
		int label;
		ArrayList<UndirectedGraphNode> neighbors;
		
		UndirectedGraphNode(int x) {
			label = x;
			neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}
	
	public static UndirectedGraphNode Solution (UndirectedGraphNode node) {
		if (node == null)
			return null;
		
		LinkedList<UndirectedGraphNode> waitinglist = new LinkedList<>();
		Map<Integer, UndirectedGraphNode> copyMap = new HashMap<>();
		waitinglist.add(node);
		
		while (!waitinglist.isEmpty()){
			UndirectedGraphNode oriCurr = waitinglist.poll();
			UndirectedGraphNode newCurr;
			if (!copyMap.containsKey(oriCurr.label)) {
				newCurr = new UndirectedGraphNode(oriCurr.label);
				copyMap.put(oriCurr.label, newCurr);
			} else {
				newCurr = copyMap.get(oriCurr.label);
			}
			
			for (UndirectedGraphNode oriNeighbor : oriCurr.neighbors) {
				if (!copyMap.containsKey(oriNeighbor.label)) {
					UndirectedGraphNode newNode = new UndirectedGraphNode(oriNeighbor.label);
					newCurr.neighbors.add(newNode);
					copyMap.put(newNode.label, newNode);
					waitinglist.add(oriNeighbor);
				} else {
					newCurr.neighbors.add(copyMap.get(oriNeighbor.label));
				}
			}
			
		}
		
		return copyMap.get(node.label);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UndirectedGraphNode node0 = new UndirectedGraphNode(0);
		UndirectedGraphNode node1 = new UndirectedGraphNode(1);
		UndirectedGraphNode node2 = new UndirectedGraphNode(2);
		node0.neighbors.add(node1);
		node1.neighbors.add(node2);
		node2.neighbors.add(node2);
		
		Solution(node0);
		
	}

}
