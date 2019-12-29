package io.spandiar.binarytrees;

public class MyBinaryTree {
	
	private BinaryNode rootNode;
	
	public BinaryNode getRootNode() {
		return rootNode;
	}

	private static class BinaryNode {
		int key;
		String value;
		BinaryNode left, right;
		
		public BinaryNode(int key, String value) {
			this.key = key;
			this.value = value;
			this.left = null;
			this.right = null;
		}
		
		public BinaryNode() {
			// TODO Auto-generated constructor stub
		}	
	}
	
	public void insertNode(int key, String value) {
		BinaryNode nodeToInsert = new BinaryNode(key, value);
		insertNode(nodeToInsert);
	}
	
	public void insertNode(BinaryNode nodeToInsert) {
		
		if(rootNode == null) {
			rootNode = nodeToInsert;
		} else {
			insertNode(rootNode, nodeToInsert);
		}
	}
	
	public void insertNode(BinaryNode currentNode, BinaryNode nodeToInsert) {
		
		if(currentNode.key < nodeToInsert.key) {
			// add to right
			if(currentNode.right == null) {
				currentNode.right = nodeToInsert;
			} else {
				insertNode(currentNode.right, nodeToInsert);
			}
		} else if (currentNode.key > nodeToInsert.key){
			// add to left
			if(currentNode.left == null) {
				currentNode.left = nodeToInsert;
			} else {
				insertNode(currentNode.left, nodeToInsert);
			}
		}
	}
	
	
	
	public BinaryNode searchNode(BinaryNode node, int key) {
		
		if(node.key == key) {
			return node;
		} else if(node.key > key) {
			// search left
			return searchNode(node.left, key);
		} else if (node.key < key) {
			// search right
			return searchNode(node.right, key);
		}
		return null;
	}
	
	public BinaryNode searchNode(int key) {
		
		if(rootNode.key == key) {
			return rootNode;
		} else {
			return (searchNode(rootNode, key));
		}
	}
	
	public BinaryNode min(BinaryNode rootNode) {
		if(rootNode.left==null) {
			return rootNode;
		} else {
			return min(rootNode.left);
		}
	}
	
	public BinaryNode max(BinaryNode rootNode) {
		if(rootNode.right==null) {
			return rootNode;
		} else {
			return max(rootNode.right);
		}
	}
	
	public void deleteNode(int key) {
		deleteNode(rootNode, key);
	}
	
	public BinaryNode deleteNode(BinaryNode nodeToDelete, int key) {
		if(nodeToDelete.key < key) {
			nodeToDelete.right = deleteNode(nodeToDelete.right, key);
		} else if (nodeToDelete.key > key) {
			nodeToDelete.left = deleteNode(nodeToDelete.left, key);
		} else if(nodeToDelete.key == key) {
			// found the node
			if(nodeToDelete.left == null && nodeToDelete.right == null) {
				nodeToDelete = null;
			} else if(nodeToDelete.left == null) {
				nodeToDelete = nodeToDelete.right;
			} else if(nodeToDelete.right == null) {
				nodeToDelete = nodeToDelete.left;
			} else {
				// find min on the right
				BinaryNode minRight = min(nodeToDelete.right);
				System.out.println("Min on the right is: " + minRight.key);
				
				// copy this over to the node to be deleted
				nodeToDelete.key = minRight.key;
				nodeToDelete.value = minRight.value;
				
				// delete min on the right
				deleteNode(nodeToDelete.right, nodeToDelete.key);
			}
		}
		return nodeToDelete;
	}
	
	public void printPreOrderTraversal() {
		printPreOrderTraversal(rootNode);
	}
	
	public void printPreOrderTraversal(BinaryNode node) {
		if(node != null) {
			System.out.println(node.key);
			printPreOrderTraversal(node.left);
			printPreOrderTraversal(node.right);
		}
	}
	

	public static void main(String[] args) {
		
		String value;
		MyBinaryTree myTree = new MyBinaryTree();
		
		myTree.insertNode(9, "nine");
		myTree.insertNode(12, "twelve");
		myTree.insertNode(21, "twenty one");
		myTree.insertNode(7, "seven");
		myTree.insertNode(14, "fourteen");
		myTree.insertNode(3, "three");
		myTree.insertNode(15, "fifteen");
		myTree.insertNode(1, "one");
		myTree.insertNode(13, "thirteen");
		myTree.insertNode(5, "five");
		myTree.insertNode(11, "eleven");
		myTree.insertNode(2, "two");
		myTree.insertNode(4, "four");
		
		myTree.printPreOrderTraversal();
		
		value = myTree.searchNode(1).value; 
		System.out.println("Value of key 1 is: " + value);

		value = myTree.searchNode(5).value;
		System.out.println("Value of key 5 is: " + value);

		System.out.println("Min value in the tree is: " +
				myTree.min(myTree.getRootNode()).value);
		System.out.println("Max value in the tree is: " +
				myTree.max(myTree.getRootNode()).value);


		myTree.deleteNode(1);
		myTree.deleteNode(5);
		myTree.deleteNode(12);

		System.out.println("After deleting some nodes");
		System.out.println("Min value in the tree is: " + myTree.min(myTree.getRootNode()).value);
		System.out.println("Max value in the tree is: " + myTree.max(myTree.getRootNode()).value);
		
		myTree.printPreOrderTraversal();
	}
}
