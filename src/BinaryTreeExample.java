/**
 * Bridges demo program
 */

import bridges.connect.Bridges;
import bridges.base.BinTreeElement;

public class BinaryTreeExample {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		//create the Bridges object
		// Use YOUR API Sha1 key and username
		Bridges bridge = new Bridges(3, "YOUR USERNAME", "YOUR API KEY");

		// create elements
		// First parameter is String depicted when using mouseover with bridges animation
		// Second parameter is data object stored at that tree element
		BinTreeElement<String> root = new BinTreeElement<String>("M", "Mango");

		BinaryTree<String> tree = new BinaryTree<String>(root);
		
		// set the color and label of an Element
		root.setColor("red");
		root.setLabel("Root");

		BinTreeElement<String> fTree = new BinTreeElement<String>("F", "Fig");
		BinTreeElement<String> rTree = new BinTreeElement<String>("R", "Ramen");
		BinTreeElement<String> tTree = new BinTreeElement<String>("T", "Tea");

		// link elements
		rTree.setRight(tTree);
		
		root.setLeft(fTree);
		root.setRight(rTree);
		
		if (tree.getRoot() != null) {
			// make sure we have a data structure to visualize!
			
			//pass root element of data structure
			bridge.setDataStructure(root);

			//visualize data structure
			// THIS SHOULD BE THE LAST METHOD YOU CALL!
			bridge.visualize();
		}
	}

}
