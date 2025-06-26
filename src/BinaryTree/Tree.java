package BinaryTree;

import java.util.ArrayList;

public class Tree {
	Node root;
	
	public boolean isBalance(Node root) {
		Node currentNode = root; // 1
		ArrayList<Node> NodeListLeft = new ArrayList<>();
		ArrayList<Node> NodeListRight = new ArrayList<>();
		int countLeft = 0;
		int countRight = 0;
		
		if (currentNode.left != null) {
			NodeListLeft.add(currentNode.left); // {2}
			countLeft++;
		}
		
		if (currentNode.right != null) {
			NodeListRight.add(currentNode.right); // {3}
			countRight++;
		}
		
		while (!NodeListLeft.isEmpty()) {
			currentNode = NodeListLeft.remove(NodeListLeft.size() - 1);
			if (currentNode.right != null) {
				NodeListLeft.add(currentNode.right); // {5} -> {5,8}
			}
			
			if (currentNode.left != null) {
				NodeListLeft.add(currentNode.left); // {5,4} -> {5,6} -> {5,8,7}
			}
			
			if (currentNode.left != null || currentNode.right != null) {
				countLeft++; // 2 -> 3
			}
		}
		
		while (!NodeListRight.isEmpty()) {
			currentNode = NodeListRight.remove(NodeListRight.size() - 1); // 3 -> 4 -> 6
			if (currentNode.right != null) {
				NodeListRight.add(currentNode.right); // {5} -> {5,7}
			}
			
			if (currentNode.left != null) {
				NodeListRight.add(currentNode.left); // {5,4} -> {5,7,6} -> {5,7} -> {5,8}
			}
			
			if (currentNode.left != null || currentNode.right != null) {
				countRight++; // 2 -> 3
			}
		}
		System.out.println(countLeft);
		System.out.println(countRight);
		if (Math.abs(countLeft - countRight) >= 2) {
			return false;
		}
		
		return true;
	}
	
	
	public ArrayList<Node> findImbalanceNode() {
		return null;
	}
}
