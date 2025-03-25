/**
 * Implementation of a binary tree using Bridges
 * 
 */
import bridges.base.BinTreeElement;
import java.util.Iterator;

public class BinaryTree<T> implements Iterable<T> {
	// the root of the binary tree
	private BinTreeElement<T> root;

	/**
	 * sets the root of this binary tree
	 * @param root
	 */
	public BinaryTree(BinTreeElement<T> root) {
		this.root = root;
	}
	
	/**
	 * Returns the root of a tree.
	 * @return
	 */
	public BinTreeElement<T> getRoot() {
		return root;
	}

	/**
	 * prints out the level that each node appears.
	 * also sets the color of each node to yellow
	 */
	public void printLevels() {
		/**
		 * We start at the root and do an inorder traversal
		 */
		printLevelHelper(root,0);
	}

	/**
	 * Helper method to print the levels
	 * @param node
	 * @param level
	 */
	private void printLevelHelper(BinTreeElement<T> node, int level) {
		if (node != null) {
			printLevelHelper(node.getLeft(), level + 1);
			System.out.println(node.getValue()); // i.e. "visit"

			// now set the node to yellow as well as set the label to the level
			// YOUR CODE GOES HERE

			printLevelHelper(node.getRight(), level + 1);
		}
	}

	/**
	 * Highlights the left most node to green and
	 * returns the value associated with the node.
	 * @return
	 */
	public T getLeftMostData() {
		if (root == null)
			return null;
		else
			return getLeftMostHelper(root);
	}

	/**
	 * Helper method to get the value and highlight the
	 * node to green.
	 * @param node
	 * @return
	 */
	private T getLeftMostHelper(BinTreeElement<T> node) {
		// YOUR CODE GOES HERE

		return null;
	}
	
	/**
	 * Returns the size of the tree (as the number of elements)
	 * 
	 * @return
	 */
	public int getSize() {
		
		// YOUR CODE GOES HERE

		return -1;
	}

	/**
	 * Returns the height of the tree.
	 * 
	 * @return
	 */
	public int getHeight() {

		// YOUR CODE GOES HERE
		
		return -1;
	}
	
	
	/**
	 * Highlights the right most node to green and
	 * returns the value associated with the node.
	 * @return
	 */
	public T getRightMostData() {

		// YOUR CODE GOES HERE

		return null;
	}


	/**
	 * Removes and returns the left most node in the tree
	 * @return
	 */
	public T removeLeftMostNode() {
		if (root == null)
			return null;
		else if (root.getLeft() == null) {
			// special case - the root is the left most node

			T data = root.getValue();

			root = root.getRight();

			return data;
		}
		else {
			// call helper method
			return removeLeftMostNodeHelper(root);
		}
	}

	/**
	 * Private helper method to remove the left most node in the tree
	 * @param node
	 * @return
	 */
	private T removeLeftMostNodeHelper(BinTreeElement<T> node) {
		if ((node.getLeft()).getLeft() == null) {
			// node is the parent whose reference must be adjusted

			// node.getLeft() is a reference to the left-most node

			// retrieve the value
			T data = node.getLeft().getValue();

			// we must adjust the left child of node so that it
			// now refers to the right child of the node being deleted
			node.setLeft((node.getLeft()).getRight());

			return data;
		}
		else {
			// continue going left
			return removeLeftMostNodeHelper(node.getLeft());
		}
	}

	
	/**
	 * Removes and returns the right most node in the tree
	 * @return
	 */
	public T removeRightMostNode() {

		// YOUR CODE GOES HERE

		return null;
	}


	public Iterator<T> iterator() {
		return new OrderIterator();
	}

	/**
	 * private inner class that handles an iteration
	 */
	private class OrderIterator implements Iterator<T>
	{
		private T[] elements;
		private int next;

		private OrderIterator() {
			// create an array large enough to hold all elements in the tree
			elements = (T[])new Object[getSize()];
			next = 0;

			// now perform an inorder traversal
			traverse(root);

			// reset next back to the beginning of the array
			next = 0;
		}

		private void traverse(BinTreeElement<T> node) {
			// TO-DO
			// This method currently performs a preorder traversal
			// modify it so that it performs an inorder traversal
			if (node != null) {
				elements[next++] = node.getValue();	// "visit"
				traverse(node.getLeft());			// traverse left subtree
				traverse(node.getRight());			// traverse right subtree
			}
		}

		public boolean hasNext() {
			return (next < getSize());
		}

		public T next() {
			return elements[next++];
		}
	}

}
