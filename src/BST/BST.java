package BST;

import java.util.ArrayList;

public class BST {
	Node root;
	
	public void buildBST (int[] nums) {
		for (int value : nums) {
			root = insert(root, value);
		}
	}
	
	// Build BST by AVL Tree
	// Để Insert N phần từ thì tôns O(nlog(n))
	// Insert: Time Complexity O(logN); Space Complexity: O(logN)
	private Node insert(Node node, int value) {
		if (node == null) {
			return new Node(value);
		}
		
		if (value < node.value) {
			node.left = insert(node.left,value);
		} else if (value > node.value) {
			node.right = insert(node.right,value);
		}
		
		// Update height 
		node.height = Math.max(height(node.left), height(node.right) + 1);
		
		int balance = height(node.left) - height(node.right);
		
		// value > node.value.right -> R; balance < -1 -> R => RR
		// Rotate left
		if (balance < - 1 && value > node.right.value) {
			return rotateLeft(node);
		}
		
		// value < node.value.right -> L; balance < -1 -> R => RL
		if (balance < - 1 && value < node.right.value) {
			node.right = rotateRight(node.right);
			return rotateLeft(node);
		}
		// value < node.value.left -> L; balance > 1 -> L => LL
		if (balance > 1 && value < node.left.value) {
			return rotateRight(node);
		}
		
		// value > node.value.left -> R; balance > 1 -> L => LR
		if (balance > 1 && value > node.left.value) {
			node.left = rotateLeft(node.left);
			return rotateRight(node);
		}
		
		return node;
	}
	
	private Node rotateLeft(Node node) {
		Node alternativeNode = node;
		node = node.right;
		alternativeNode.right = node.left;
		node.left = alternativeNode;
		return node;
	}
	
	private Node rotateRight(Node node) {
		Node alternativeNode = node;
		node = node.left;
		alternativeNode.left = node.right;
		node.right = alternativeNode;
		return node;
	}
	private int height(Node node) {
		if (node == null) {
			return 0;
		}
		return node.height;
	}
	
	public void printBST() {
		if (root == null) return;
		
		ArrayList<Node> nodeList = new ArrayList<Node>();
		nodeList.add(root);
		while (nodeList.size() > 0) {
			Node currentNode = nodeList.removeFirst();
			System.out.print(currentNode.value + " ");

			if (currentNode.left != null) {
				nodeList.add(currentNode.left);
			}
			if (currentNode.right != null) {
				nodeList.add(currentNode.right);
			}
		}
		System.out.println();
	}
	
	// Time Complexity & Space Complexity: O(logN)
	public Node findNode(int value) {
		if (root == null) {
			return null;
		}
		
		ArrayList<Node> nodeList = new ArrayList<Node>();
		nodeList.add(root);
		while (nodeList.size() > 0) {
			Node currentNode = nodeList.removeFirst();
			if (currentNode.value == value) {
				return currentNode;
			} else if (currentNode.value > value) {
				nodeList.add(currentNode.left);
			} else {
				nodeList.add(currentNode.right);
			}
		}
		return null;
	}
}
