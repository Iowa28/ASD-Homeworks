package asd7;

public class AVLTree { // extends AVLtree from BinaryNotSearcTree was problematic
	private Node root;
	private int rootHeight;
	
	public AVLTree() {
		this.root = null;
		this.rootHeight = 0;
	}
	
	protected class Node { 
		protected Node parent;
		protected int data;
		protected Node left;
		protected Node right;
		protected int height;

		public Node(int value) {
			this.parent = null;
			this.data = value;
			this.left = null;
			this.right = null;
			this.height = 1;
		}
		
		public void setHeight(int newHeight) {
			this.height = newHeight;
		}
	}
	
	public void add(int value) {
		Node newNode = new Node(value);
		if (rootHeight == 0) {
			this.root = newNode;
			rootHeight = 1;
			return;
		}
		Node node = root;
		Node parent = null;
		for (int i = 1; i <= rootHeight; i++) { // sorting the tree in height
			if (node.data < value) {
				if (node.right == null) {
					newNode.parent = node;
					node.right = newNode;
					if (i == rootHeight) {
						rootHeight++;
					}
					this.root = balance(newNode); // adding and balancing from 
					break;
				} else {
					parent = node;
					node = node.right;
					node.parent = parent;
				}
			} else if (node.data > value) {
				if (node.left == null) {
					newNode.parent = node;
					node.left = newNode;
					if (i == rootHeight) {
						rootHeight++;
					}
					this.root = balance(newNode);
					break;
				} else {
					parent = node;
					node = node.left;
					node.parent = parent;
				}
			} else {
				System.out.println("Tree already contains " + value + ".");
				break;
			}
		}
	}
	
	private Node balance(Node node) {
		while (node.parent != null) {
			node = node.parent;
			Node right = node.right;
			Node left = node.left;
			if (right.height - left.height > 1) { // left < right
				if (right.left.height <= right.right.height) {
					node = rotateLeftSmall(node);
				} else {
					node = rotateLeftBig(node);
				}
			} else if (left.height - right.height > 1) { // right < left
				if (left.left.height <= left.right.height) {
					node = rotateRightSmall(node);
				} else {
					node = rotateRightBig(node);
				}
			}
		}
		return node;
	}
	
	private Node rotateLeftSmall(Node node) {
		Node parent = node.parent;
		Node right = node.right;
		right.parent = parent;
		node.right = right.left;
		right.left = node;
		right.height++;
		node.parent = right;
		node.height--;
		return node;
	}
	
	private Node rotateLeftBig(Node node) { // it's confusing ... But I did as in the picture on Wiki
		Node parent = node.parent;
		Node right = node.right;
		Node newParent = right.left;
		newParent.parent = parent;
		node.right = newParent.left;
		right.left = newParent.right;
		newParent.left = node;
		right.parent = newParent;
		right.height--;
		newParent.right = right;
		newParent.height++;
		node.parent = newParent;
		node.height = node.height - 2;
		return node;
	}
	
	private Node rotateRightSmall(Node node) {
		Node parent = node.parent;
		Node left = node.left;
		node.left = left.right;
		left.parent = parent;
		left.right = node;
		left.height++;
		node.parent = left;
		node.height--;
		return node;
	}
	
	private Node rotateRightBig(Node node) {
		Node parent = node.parent;
		Node left = node.left;
		Node newParent = left.right;
		node.left = newParent.right;
		left.right = newParent.left;
		newParent.parent = parent;
		newParent.left = node;
		left.parent = newParent;
		left.height--;
		newParent.right = left;
		newParent.height++;
		node.parent = newParent;
		node.height = node.height - 2;
		return node;
	}
	
	public void remote(int value) {
		Node node = root;
		while (node.data != value) {
			if (value >= node.data) {
				if (node.right == null) {
					System.err.println("There is no such number in the tree!");
				} else {
					node = node.right;
				}
			} else {
				if (node.left == null) {
					System.err.println("There is no such number in the tree!");
				} else {
					node = node.left;
				}
			}
		}
		Node nodeToReplace = findMax(node.left);
		node.data = nodeToReplace.data;
		Node parent = nodeToReplace.parent;
		parent.left = null;
		this.root = balance(parent);
	}
	
	private Node findMax(Node node) {;
		while(node.right != null) {
			node = node.right;
		}
		return node;
	}
}
