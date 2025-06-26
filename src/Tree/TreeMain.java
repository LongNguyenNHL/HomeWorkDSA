package Tree;

public class TreeMain {
	public static void main(String[] args) {
		
		Tree tree = new Tree();
		
		Node root = new Node();
		root.value = 1;
		
		tree.root = root;
		
		Node node = new Node();
		node.value = 2;
		tree.root.children.add(node);
		
		node = new Node();
		node.value = 3;
		tree.root.children.add(node);
		
		node = new Node();
		node.value = 4;
		tree.root.children.add(node);
		
		// add node 5 at node 2
		node = new Node();
		node.value = 5;
		Node findNode = tree.findNodeDFSVersion2(2);
		findNode.children.add(node);
		
		// add node 6 at node 2
		node = new Node();
		node.value = 6;
		findNode = tree.findNodeDFSVersion2(2);
		findNode.children.add(node);
		
		// add node 7 at node 3
		node = new Node();
		node.value = 7;
		findNode = tree.findNodeDFSVersion2(3);
		findNode.children.add(node);
		
		// add node 10 at node 3
		node = new Node();
		node.value = 10;
		findNode = tree.findNodeDFSVersion2(3);
		findNode.children.add(node);
		
		// add node 8 at node 6
		node = new Node();
		node.value = 8;
		findNode = tree.findNodeDFSVersion3(root, 6);
		findNode.children.add(node);
		
//		// add node 9 at node 6
//		node = new Node();
//		node.value = 9;
//		findNode = tree.findNodeDFSVersion2(6);
//		findNode.children.add(node);
		

		
		// Check
		
		findNode = tree.findNodeDFSVersion2(4);
		
		if (findNode != null) {
			System.out.println(findNode.value);
		} else {
			System.out.println("Not have value in tree");
		}
	}
}
