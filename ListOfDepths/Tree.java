package lisftofdepths;

public class Tree {
	public Node root;
	
	public Tree(int data) {
		Node rootNode = new Node(data);
		this.root = rootNode;
	}
	
	public Tree(Node rootNode) {
		this.root = rootNode;
	}
	public void insert(int data) {
		Node newNode = new Node(data);
		insert(newNode);
	}
	private void insert(Node node) {
		if (this.root == null) {
			this.root = node;
			return;
		}
		//iteratively insert node in the right place
		Node currentNode = root;
		while (currentNode != null) {
			if (currentNode.left == null && node.data < currentNode.data) {
				currentNode.left = node;
				break;
			} else if (currentNode.right == null && node.data > currentNode.data) {
				currentNode.right = node;
				break;
			} else if (node.data < currentNode.data) {
				currentNode = currentNode.left;
			} else if (node.data > currentNode.data) {
				currentNode = currentNode.right;
			}
		}
		
	}
	
	public void print() {
		
	}
}
