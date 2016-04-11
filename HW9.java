import java.io.*;
import java.util.*;

import org.w3c.dom.Node;

public class HW9 {
	// used in twentyQuestions method
	public static Scanner userInput = new Scanner(System.in);

	@SuppressWarnings("unchecked")
	public static TreeNode<Integer> randomTree(int numNodes, int n) {
		if (userInput.nextInt((int) Math.pow(1, n)) == 0)
			return null;
		return new TreeNode(randomTree(numNodes, n - 1));
		// throw new
		// UnsupportedOperationException("remove this line when done");
	}

	public static <E> int replace(TreeNode<E> t, E oldValue, E newValue) {

		if (t == null)
			return t;
		TreeNode out = new TreeNode(t.getValue());
		out.left(copy(t.left(newValue)));
		out.right(copy(t.right(newValue)));
		return out;

	}

	public static <E> int countNodesAtDepth(TreeNode<E> t, int depth) {
		if (t == null) {
			// Since the tree is empty and there are no leaves,
			// the sum is zero.
			return 0;
		} else if (t.left == null && t.right == null) {
			// The node is a leaf, and there are no subtrees of node, so
			// the sum of the leaf depths is just the depth of this node.
			return depth;
		} else {
			// The node is not a leaf. Return the sum of the
			// the depths of the leaves in the subtrees.
			return countNodesAtDepth(t.left, depth + 1)
					+ countNodesAtDepth(t.right, depth + 1);
		}
		// throw new
		// UnsupportedOperationException("remove this line when done");
	}

	public static <E> boolean allSame(TreeNode<E> t) {
		if (t != null) {
			if (t.left != t.right)
				return false;
			else
				return (allSame(t.left) && allSame(t.right));
		}
		return true;
		// throw new
		// UnsupportedOperationException("remove this line when done");
	}

	public static <E> List<E> leafList(TreeNode<E> t) {
		throw new UnsupportedOperationException("remove this line when done");
	}

	public static <E> void reflect(TreeNode<E> t) {
		TreeNode<E> tmp = t.left;
		t.left = t.right;
		t.right = tmp;

		if (t.left != null)
			reflect(t.left);
		if (t.right != null)
			reflect(t.right);
	}

	public static <E> TreeNode<E> condense(TreeNode<E> t) {

		Node parent = null; 
		//Node root = null; 
		if ( t.left == null )    // If true, p has a right subtree
	       {
	          /* ========================================
		     Handle special situation: p is the root
		     ========================================= */
	          if ( t == null )
	          {
	             t = t.right;  // After root is deleted, BST = right tree of root
	          }

	          parent = myParent;     // myParent was set by findNode(x)....

	          /* ----------------------------------------------
	             Link p's RIGHT subtree to the parent node
	             ---------------------------------------------- */
	          if ( parent.left == p )
	          {  // Hang p's RIGHT tree to parent.left

	             parent.left  = p.right;   // Link p's right subtree to parent left
	          }
	          else
	          {  // Hang p's RIGHT tree to parent.right

	             parent.right = p.right;   // Link p's right subtree to parent right   
		  }

	          return;
	       }

	       /* ==================================================
	          We must do the same when p has a LEFT subtree

	          Case 1b: p has a left subtree
		  ================================================== */
	       if ( p.right == null )                 // If true, p has a left child
	       {
	          if ( p == root )
	          {
	             root = root.left;
	             return;
	          }

	          parent = myParent;     // myParent was set by findNode(x)....

	          /* ----------------------------------------------
	             Link p's left child as p's parent child
	             ---------------------------------------------- */
	          if ( parent.left == p )
	             parent.left = p.left;
	          else
	             parent.right = p.left;

	          return;
		
		
		throw new UnsupportedOperationException("remove this line when done");
	}

	public static <E> void save(TreeNode<E> t, String fileName) {
		try {
			PrintWriter output;
			output = new PrintWriter(new FileWriter(filename));

			BinarySearchTreeIterator<SkyThingy, String> iterator = new BinaryTreeIterator<SkyThingy, String>(
					bstree);
			iterator.setInorder();

			while (iterator.hasNext())
				output.printf("%s\n", iterator.next());

			output.close();

		} catch (IOException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static TreeNode<String> load(String fileName)
			throws FileNotFoundException {
		throw new UnsupportedOperationException("remove this line when done");
	}

	public static void twentyQuestions(TreeNode<String> t) {
	}
}