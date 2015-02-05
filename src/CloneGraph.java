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
		if (node == null)   return null;
        
        LinkedList<UndirectedGraphNode> toVisit = new LinkedList<>();
        // <original, new> pair
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        
        toVisit.add(node);
        UndirectedGraphNode copy = new UndirectedGraphNode(node.label);
        map.put(node, copy);
        
        while (!toVisit.isEmpty()) {
            UndirectedGraphNode oldNode = toVisit.poll();
            UndirectedGraphNode newNode = map.get(oldNode);
            for (UndirectedGraphNode neighbor : oldNode.neighbors) {
                if (map.containsKey(neighbor)) {
                    newNode.neighbors.add(map.get(neighbor));
                } else {
                    UndirectedGraphNode newNeighbor = new UndirectedGraphNode(neighbor.label);
                    map.put(neighbor, newNeighbor);
                    newNode.neighbors.add(newNeighbor);
                    toVisit.add(neighbor);
                }
            }
        }
        return copy;
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
