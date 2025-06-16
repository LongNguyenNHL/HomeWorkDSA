package Tree;

import java.util.ArrayList;

public class Tree {
	Node root;
	
	//DFS
	public Node findNode(int value) {
		ArrayList<Node> listChildren = null;
		listChildren.add(root);
		ArrayList<Node> listSeenChildren = null;
	
		for (int i = 0; i < listChildren.size(); i++) {
			Node currentNode = listChildren.get(i);
			if (currentNode.value == value) {
				return currentNode;
			} else {
				addListChildren(listChildren, currentNode);
				removeChildren(listChildren);
				listSeenChildren.add(currentNode);
			}
		}
		
		
		return null;
	}
	
	public static void addListChildren(ArrayList<Node> listChildren, Node currentNode) {
		for (int i = 0; i < currentNode.children.size(); i++) {
			listChildren.add(currentNode.children.get(i));
		}
	}
	
	public static void removeChildren(ArrayList<Node> listChildren) {
		listChildren.remove(listChildren.size() - 1);
	}
	
//	public Node findNode(int value) {
//		Node currentNode = root;
//		int countNode = 0;
//		for (Node n : currentNode.children) {
//			if (n.value == value) {
//				return n;
//			} else {
//				countNode++;
//			}
//		}
//		int currentIndexNode = 0;
//		findNodeInChildren(currentNode, currentIndexNode, value);
//		return null;
//	}
//	
//	public static Node findNodeInChildren(Node currentNode, int currentIndexNode, int value) {
//		int temporaryIndexNode = 0;
//		Node temporaryNode;
//		if (temporaryIndexNode < currentNode.children.size()) {
//			temporaryNode = currentNode.children.get(temporaryIndexNode);
//			if (temporaryNode.value == value) {
//				return temporaryNode;
//			} else {
//				return findNodeInChildren(currentNode, ++temporaryIndexNode, value);
//			}
//		} 
//		
//		temporaryIndexNode = 0;
//		temporaryNode = currentNode.children.get(temporaryIndexNode);
//		
//		if (currentIndexNode < currentNode.children.size()) {
//			currentNode = currentNode.children.get(currentIndexNode); //currentIndex = 0
//			return findNodeInChildren(currentNode, currentIndexNode++, value); //(30, 0, 50)
//		} else {
//			
//		}
//
//		return currentNode;
//	}
}
