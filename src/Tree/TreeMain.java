package Tree;

public class TreeMain {
	public static void main(String[] args) {
		
		Tree tree = new Tree();
		
		Node root = new Node();
		root.value = 1;
		
		tree.root = root;
		
		Node node = new Node();
		node.value = 30;
		tree.root.children.add(node);
		
		node = new Node();
		node.value = 40;
		tree.root.children.add(node);
		
		// add node 20 at node 30
		node = new Node();
		node.value = 20;
		Node findNode = tree.findNodeDFS(30);
		findNode.children.add(node);
		
		// add node 10 at node 30
		node = new Node();
		node.value = 10;
		findNode = tree.findNodeDFS(30);
		findNode.children.add(node);
		
		// add node 5 at node 10
		node = new Node();
		node.value = 5;
		findNode = tree.findNodeDFS(10);
		findNode.children.add(node);
		
		// add node 50 at node 40
		node = new Node();
		node.value = 50;
		findNode = tree.findNodeDFS(40);
		findNode.children.add(node);
		
		// add node 100 at node 1
		node = new Node();
		node.value = 100;
		findNode = tree.findNodeBFS(1);
		findNode.children.add(node);
		
		// Check
		
		findNode = tree.findNodeDFS(5);
		System.out.println(findNode.value);
		
		findNode = tree.findNodeBFS(100);
		System.out.println(findNode.value);

	}
}
