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
	
	// DFS - Version 2 - Leaf to Branch 
	// Sửa bài dùng linked list
	public Node findNodeDFSVersion2 (int value) {
		ArrayList<Node> listChildren = new ArrayList<>();
		ArrayList<Node> listSeenChildren = new ArrayList<>();
		listChildren.add(root);
		
		while (!listChildren.isEmpty()) {
			Node currentNode = listChildren.get(listChildren.size() - 1);
			
			if (!listSeenChildren.containsAll(currentNode.children)) {
				for (int i = currentNode.children.size() - 1 ; i >= 0; i--) {
					listChildren.add(currentNode.children.get(i));
				}
			} else {
				if (currentNode.value == value) {
					return currentNode;
				} else {
					listSeenChildren.add(listChildren.remove(listChildren.size() - 1));
				}
			}
		}
		return null;
	}
	
	public Node findNodeDFSVersion3(Node node, int value) {
		if (node == null) {
			return null;
			}
		for (Node child : node.children) {
			Node found = findNodeDFSVersion3(child, value);
			if (found != null) {
				return found;
			}
		}
		
		if (node.value == value) {
			return node;
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
