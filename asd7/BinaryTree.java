package asd7;
import asd1.QueueR;

public class BinaryTree { // not BinarySearchTree!!!
	private Node root;
	private int height;
	
	public BinaryTree() {
		this.root = null;
		this.height = 0;
	}
	
	private class Node {
		protected Node parent;
		protected int data;
		protected Node left;
		protected Node right;
		
		public Node(int value) {
			this.parent = null;
			this.data = value;
			this.left = null;
			this.right = null;
		}
	}
	
	// add parents!!! - added 20:13
	public void add(int value) {
		Node newNode = new Node(value);
		if (height == 0) {
			this.root = newNode;
			height = 1;
			return;
		}
		Node node = root;
		Node parent = null;
		for (int i = 1; i <= height; i++) {
			if (node.left == null) {
				newNode.parent = node;
				node.left = newNode;
				if (i == height) {
					height++;
				}
				break;
			} else if (node.right == null) {
				newNode.parent = node;
				node.right = newNode;
				if (i == height) {
					height++;
				}
				break;
			} else {
				parent = node;
				int random = (int) (Math.random()*2); // random or left(0) or right(1)
				node = random == 0 ? node.left: node.right;
				node.parent = parent;
			}
		}
	}
	
	public void printDFC() {
		DFC(root);
		System.out.println();
	}
	
	private void DFC(Node e) {
		System.out.print(e.data + " ");
		if (e.left != null) {
			DFC(e.left);
		}
		if (e.right != null) {
			DFC(e.right);
		}
	}
	
	public void printBFC() {
		QueueR<Node> queue = BFC(root);
		while (queue.size() > 0) {
			System.out.print(queue.pop().data + " ");
		}
		System.out.println();
	}
	
	private QueueR<Node> BFC(Node first) {
		QueueR<Node> queue = new QueueR<>();
		QueueR<Node> values = new QueueR<>();
		queue.add(first);
		
		while (queue.size() > 0) {
			Node node = queue.pop();
			values.add(node);
			
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
		return values;
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.add(8);
		tree.add(10);
		tree.add(5);
		tree.add(11);
		tree.add(7);
		tree.add(4);
		tree.add(8);
		tree.printBFC();
	}
}
