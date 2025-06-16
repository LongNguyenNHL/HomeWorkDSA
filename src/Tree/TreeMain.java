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
		
//		Node currentNode = tree.root;
//		for (Node n : tree.root.children) {
//			if (n.value == 30) {
//				node = new Node();
//				node.value = 20;
//				n.children.add(node);
//			} else if (n.value == 40) {
//				node = new Node();
//				node.value = 10;
//				n.children.add(node);
//			}
//			
//			if (n.value != 9) {
//				currentNode = tree.root.children.get(0);
//			}
//			
//		}
		
		Node node20 = new Node();
		node20.value = 20;
		
		Node findNode = tree.findNode(30);
		findNode.children.add(node20);
	}
}
