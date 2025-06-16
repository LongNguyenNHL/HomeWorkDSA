package Tree;

import java.util.ArrayList;

public class Tree {
	Node root;
	
	// DFS - Depth-First Search
	public Node findNodeDFS (int value) {
		ArrayList<Node> listChildren = new ArrayList<>();
		listChildren.add(root);
		
		while (!listChildren.isEmpty()) {
			Node currentNode = listChildren.remove(listChildren.size() - 1);
			
			if (currentNode.value == value) {
				return currentNode;
			}
			
			for (int i = currentNode.children.size() - 1; i >= 0; i--) {
				listChildren.add(currentNode.children.get(i));
			}
		}
		return null;
	}
	
	// BFS - Breadth-First Search
	public Node findNodeBFS (int value) {
		ArrayList<Node> listChildren = new ArrayList<>();
		listChildren.add(root);
		
		while (!listChildren.isEmpty()) {
			Node currentNode = listChildren.remove(0);
			
			if (currentNode.value == value) {
				return currentNode;
			}
			
			for (int i = 0 ; i < currentNode.children.size(); i++) {
				listChildren.add(currentNode.children.get(i));
			}
		}
		return null;
	}
}
