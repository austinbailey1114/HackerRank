package lisftofdepths;

public class LinkedList {
	public class LinkedListNode {
		int data;
		LinkedListNode next;
	}
	
	public LinkedListNode root;
	
	public LinkedList(int data) {
		LinkedListNode rootNode = new LinkedListNode();
		rootNode.data = data;
		this.root = rootNode;
	}
	
	public void add(int data) {
		LinkedListNode newNode = new LinkedListNode();
		newNode.data = data;
		add(newNode);
	}
	
	public void add(LinkedListNode node) {
		LinkedListNode moveNode = root;
		while (moveNode.next != null) {
			moveNode = moveNode.next;
		}
		moveNode.next = node;
	}
	
	public String toString() {
		LinkedListNode moveNode  = root;
		String returnString = new String();
		returnString += root.data;
		moveNode = moveNode.next;
		while (moveNode != null) {
			returnString += "->" + moveNode.data;
			moveNode = moveNode.next;
		}
		return returnString;
	}
}
