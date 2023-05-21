package algoULinkedList;

public class LinkedListOperations {
	static class Node{
		int data;
		Node next;
		public Node(int data) {
			super();
			this.data = data;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head = null;
		Node first = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		Node forth = new Node(4);
		Node fifth = new Node(5);
		head = first;
		first.next = second;
		second.next = third;
		third.next = forth;
		forth.next = fifth;
		traverse(head);
		insert(30,head,3);
		traverse(head);
		insert(10,head,1);
		traverse(head);
		delete(3,head);
		traverse(head);
		search(30,head);
	}

	private static void search(int target, Node head) {
		// TODO Auto-generated method stub
		while(head != null && head.data != target) {
			head = head.next;
		}
		if(head == null) {
			System.out.println(target+" Not found");
		}else {
			System.out.println(target+" found");
		}
	}

	private static void delete(int pos, Node head) {
		// TODO Auto-generated method stub
		Node curr = head;
		Node prev = null;
		int count = 1;
		while(count<pos && curr != null) {
			prev = curr;
			curr = curr.next;
			count++;
		}
		//System.out.println(curr.data+" "+prev.data);
		prev.next = curr.next;
		curr.next = null;
	}

	private static void insert(int data, Node head, int pos) {
		// TODO Auto-generated method stub
		Node newNode = new Node(data);
		Node curr = head;
		int count = 1;
		while(count<pos && curr != null) {
			curr = curr.next;
			count++;
		}
		if(count != pos) {
			System.out.println("Not possible to insert");
		}else {
			newNode.next = curr.next;
			curr.next = newNode;
		}
	}

	private static void traverse(Node head) {
		// TODO Auto-generated method stub
		Node curr = head;
		while(curr!=null) {
			if(curr.next != null)
				System.out.print(curr.data+" -> ");
			else
				System.out.print(curr.data);
			curr = curr.next;
		}
		System.out.println();
	}

}
