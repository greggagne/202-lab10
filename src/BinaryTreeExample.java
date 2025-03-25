/**
 * Bridges demo program
 */

import bridges.connect.Bridges;
import bridges.base.BinTreeElement;
import java.util.Iterator;

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
		BinTreeElement<String> root = new BinTreeElement< >("M", "Mango");

		BinaryTree<String> tree = new BinaryTree< >(root);
		
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

		// uncomment these operations as you implement each method

		//tree.printLevels();

		//System.out.println("The leftmost data is " + tree.getLeftMostData());

		//System.out.println("The rightmost data is " + tree.getRightMostData());

		//System.out.println("height = " + tree.getHeight());

		//System.out.println("size = " + tree.getSize());

		//System.out.println("removing left most data = " + tree.removeLeftMostNode());

		//System.out.println("removing right most data = " + tree.removeRightMostNode());

//		System.out.println("In order iteration");
//		for (String item: tree) {
//			System.out.println(item);
//		}

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
