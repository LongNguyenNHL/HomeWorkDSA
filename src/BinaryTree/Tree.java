package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;

public class Tree {
	Node root;
	
	// Check node is balance or not 
	public boolean isBalance(Node node) {
		if (node == null) {
			return true;
		}
		
		Node currentNode = node; // 1
		LinkedList<Node> NodeListLeft = new LinkedList<>();
		LinkedList<Node> NodeListRight = new LinkedList<Node>();
		int heightLeft = 0;
		int heightRight = 0;
		
		if (currentNode.left != null) {
			NodeListLeft.add(currentNode.left); // {2}
			heightLeft++;
		}
		
		if (currentNode.right != null) {
			NodeListRight.add(currentNode.right); // {3}
			heightRight++;
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
				heightLeft++; // 2 -> 3
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
				heightRight++; // 2 -> 3
			}
		}
		if (Math.abs(heightLeft - heightRight) >= 2) {
			return false;
		}
		
		return true;
	}
	
	// Return List of Imbalance Node
	public ArrayList<Node> findImbalanceNode(Node node) {
		ArrayList<Node> imbalanceNode = new ArrayList<Node>();

		if (node == null) {
			return imbalanceNode;
		}
		
		LinkedList<Node> nodeList = new LinkedList<Node>();
		nodeList.add(node);
		
		while (!nodeList.isEmpty()) {
			Node currentNode = nodeList.remove(0);
			
			if (!isBalance(currentNode)) {
				imbalanceNode.add(currentNode);
			}
			
			if (currentNode.left != null) {
				nodeList.add(currentNode.left);
			}
			
			if (currentNode.right != null) {
				nodeList.add(currentNode.right);
			}
		}
		return imbalanceNode;
	}
	
	public Node findNode(int value) {
		LinkedList<Node> nodeList = new LinkedList<Node>();
		nodeList.add(root);
		
		while (!nodeList.isEmpty()) {
			Node currentNode = nodeList.remove(0);
			
			if (currentNode.value == value) {
				return currentNode;
			}
			
			if (currentNode.left != null) {
				nodeList.add(currentNode.left);
			}
			
			if (currentNode.right != null) {
				nodeList.add(currentNode.right);
			}
		}
		return null;
	}
}
