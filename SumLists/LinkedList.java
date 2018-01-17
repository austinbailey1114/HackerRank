package linkedlists;

public class LinkedList<T> {
	public class Node<K> {
		K data;
		Node<K> next;
	}
	public Node<T> head;
	
	public LinkedList(T data) {
		Node<T> rootNode = new Node<T>();
		rootNode.data = data;
		this.head = rootNode;
	}
	
	public void insert(T data) {
		Node<T> moveNode = this.head;
		while (moveNode.next != null) {
			moveNode = moveNode.next;
		}
		Node<T> newNode = new Node<T>();
		newNode.data = data;
		moveNode.next = newNode;
	}
	
	public void removeHead() {
		if (this.head == null) {
			throw new NullPointerException("No head remaining");
		} else if (this.head.next == null) {
			this.head = null;
			return;
		}
		Node<T> tempNode = this.head;
		this.head = this.head.next;
		tempNode.next = null;
	}
	
	public boolean isEmpty() {
		return this.head == null;
	}
	
	
	
	
}
