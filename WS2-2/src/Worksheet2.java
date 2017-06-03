/**
 * 
 * Solutions to Worksheet 2: Recursion and Tress(parts A and B)
 * Assessed Exercise: 19% of the Spring term continuous Assessment
 * Assigned: Friday 20 January
 * Due date: Monday 30th January
 * 
 * This uses Tree class provided. The following solutions do not use
 * assignment statements to change the value of any variable. Recursion is the main
 * vehicle behind which the following computations are done. 
 * @author Abdikhaliq Timer
 * @version 2017-01-28
 */

/**
 * <b>Part A: Binary Trees and Binary Search Trees</b>
 */

public class Worksheet2 implements Worksheet2Interface {
	/**
	 * <b>Exercise 1: Negate a tree</b> Exercise 1: Negate a tree (5%) This
	 * method changes all the signs in front of a number within a tree, and
	 * returns the same tree with all the signs switched, hence for example: 4
	 * will change into -4.
	 * 
	 * @param t
	 *            A binary tree which you would like to switch the signs of the
	 *            values for
	 * @return A binary tree where all the values signs have been switched.
	 */
	public static Tree negateAll(Tree t) {
		// Base case: When the tree is empty, return the same tree
		if (t.isEmpty())
			return new Tree();
		// recursive function: creates a new tree that recursively goes through
		// the the nodes, switched the signs of the root node.
		else
			return new Tree(-t.getValue(), negateAll(t.getLeft()), negateAll(t.getRight()));

	}

	/**
	 * <b>Exercise 2: Mirror image (10%)</b> Given a tree a, this method will
	 * construct and return a tree that is the mirror of tree a,along the
	 * left-right axis. Here is an example: - 10 to - 2 | | 5 - 5 - | | - 2 - 10
	 * 
	 * 
	 * @param t
	 *            Tree t which will be mirrored
	 * @return A tree which is mirrored along its left-right axis
	 */
	public static Tree mirror(Tree t) {
		if (t.isEmpty())
			return new Tree();
		else
			return new Tree(t.getValue(), mirror(t.getRight()), mirror(t.getLeft()));
	}

	/**
	 * <b>Exercise 3: Postorder traversal (10%)</b> Given a tree a, this method
	 * will produce and return a list containing the values in a, by traversing
	 * the nodes in <b>postorder</b>, for example, for each node all the values
	 * in the left subtree are listed first, then all the values on the right
	 * subtree, and then finally the value in the node itself.
	 * 
	 * @param t
	 *            This is a tree which will have its nodes traversed through
	 * @return A list that includes all the numbers from the traversed tree
	 */
	public static List postorder(Tree t) {
		if (t.isEmpty())
			return List.empty();
		else
			return ListOps.append(postorder(t.getLeft()), ListOps.addToEnd(postorder(t.getRight()), t.getValue()));

	}

	/**
	 * <b>Exercise 4: Check for positive (5%)</b> This method is a boolean
	 * method, that checks a tree to see whether all the values within the tree
	 * are positive. Positives are >=0.
	 * 
	 * @param a
	 *            A tree which will be checked for positive values
	 * @return A true statement if all the values in the tree are positive,
	 *         otherwise it will return false
	 */
	public static boolean allPositive(Tree a) {
		if (a.isEmpty())
			return true;
		else if (a.getValue() < 0)
			return false;
		else
			return allPositive(a.getLeft()) && allPositive(a.getRight());
	}

	/**
	 * <b>Exercise 5: Test for the search tree property (10%)</b> The following
	 * method identifies if a is a Binary Search Tree, where
	 * <ul>
	 * <li>all the values stored in the left subtree of the node must be less
	 * than the value at the node</li>
	 * <li>all the values on the right of the subtree must be greater than the
	 * value at the node</li>
	 * </ul>
	 * This method takes in a tree, and returns a boolean value indicating
	 * whether the tree is a binary search tree.
	 * 
	 * @param a
	 *            a Tree which will be checked
	 * @return Inidicates whether the tree passed into the tree is a binary
	 *         search tree
	 */
	public static boolean isSearchTree(Tree a) {
		if (a.isEmpty())
			return true;
		else if (a.getLeft().isEmpty() && a.getRight().isEmpty())
			return isSearchTree(a.getRight());
		else if (a.getLeft().isEmpty())
			return isSearchTree(a.getRight());
		else if (a.getRight().isEmpty())
			return isSearchTree(a.getLeft());
		else if ((a.getLeft().getValue() > a.getValue()) || (a.getRight().getValue() < a.getValue()))
			return false;
		else
			return (isSearchTree(a.getLeft()) && isSearchTree(a.getRight()));
		
		
		
		
		
		
		/*if (a.isEmpty())
			return true;
		else if (a.getLeft().isEmpty() && a.getRight().isEmpty())
			return true;
		else if (a.getLeft().isEmpty() && (a.getRight().getValue() > a.getValue()))
			return true;
		else if (a.getRight().isEmpty() && (a.getLeft().getValue() < a.getValue()))
			return true;
		else if ((a.getLeft().getValue() > a.getValue()) || (a.getRight().getValue() < a.getValue()))
			return false;
		
		else
			return isSearchTree(a.getLeft()) && isSearchTree(a.getRight());*/
	}

	/**
	 * <b>Exercise 6: Traversing binary search trees (10%)</b> This method
	 * traverses through a given tree, and prints the values of the values in
	 * the descending order.
	 * 
	 * @param a
	 *            A binary search tree of integers a.
	 */
	public static void printDescending(Tree a) {
		if (a.isEmpty())
			System.out.print("");
		else if (a.getLeft().isEmpty() && a.getRight().isEmpty())
			System.out.print(a.getValue());
		else {
			printDescending(a.getRight());
			System.out.print(" " + a.getValue() + " ");
			printDescending(a.getLeft());
		}
	}

	/**
	 * <b>Exercise 7: Maximum value in a search tree (10%)</b> Requirement: The
	 * tree must be a binary search tree in order to find the max. This method
	 * returns the maximum value in a tree.
	 * 
	 * @param a
	 *            A <b>Binary Search Tree</b>
	 * @return The maximum value of the tree.
	 */
	public static int max(Tree a) {
		if (a.isEmpty())
			throw new IllegalStateException("Cant find the maximum of an empty Tree");
		else if (a.getRight().isEmpty())
			return a.getValue();
		else
			return Math.max(a.getValue(), max(a.getRight()));

	}

	/**
	 * This method requires a Binary Search Tree, where it deletes the value x
	 * from the tree a. The original tree of a is not altered, isntead a new
	 * tree is printed.
	 * 
	 * @param x
	 *            The integer which you would like to delete from the tree
	 * @param a
	 *            The binary search tree for which you would like to delete the
	 *            value from
	 * @return a new tree that is has had the value x removed.
	 */
	public static Tree delete(int x, Tree a) {
		if (a.isEmpty())
			return a;
		else if (a.getLeft().isEmpty() && a.getRight().isEmpty()) {
			if (x == a.getValue())
				return new Tree();
			else
				return a;
		} else if (x == a.getValue())
			return new Tree(max(a.getLeft()), delete(max(a.getLeft()), a.getLeft()), a.getRight());

		else if (x > a.getValue())
			return new Tree(a.getValue(), a.getLeft(), delete(x, a.getRight()));
		else
			return new Tree(a.getValue(), delete(x, a.getLeft()), a.getRight());

	}

	/**
	 * This method checks the height-balance property of any tree, which returns
	 * a boolean whether the tree is in fact a Height balanced tree.
	 * 
	 * @param a
	 *            a Tree for which you would like to check the height balance
	 * @return A boolean statement showing whether the tree is balanced or not.
	 */
	public static boolean isHeightBalanced(Tree a) {
		//if tree is empty
		if (a.isEmpty())
			return true;
		//if it satisfies the height balance property 
		else if (Math.abs(a.getLeft().getHeight() - a.getRight().getHeight()) <= 1)
			return isHeightBalanced(a.getLeft()) && isHeightBalanced(a.getRight());
		else
			return false;
	}
	/*
	 * Finds the height of the tree, from the root node
	 */
	private static int height(Tree t) {
		return t.getHeight();
	}

	/**
	 * This method is used for double rotations;  
	 * where a node has been inserted into the right subtree 
	 * of the left subtree. The aim of this method is to do the following:
	 * 
	 *      C                
	 *     /             B
	 *    A      -->    / \  
	 *   /             A   C  
 	 *  A            
	 *    
	 * @param a Tree which will be rotated and balanced
	 * @return
	 * 
	 * Requires: Only be called when its found to be unbalanced
	 */
	public static Tree rightRotation(Tree a) {
		//if its balanced
		if (isHeightBalanced(a))
			return a;
		else {
			//So now its not balanced
			//check if it needs A single/double rotation
			if (a.getLeft().height > a.getRight().getHeight()) {
				//Its not forked, hence single right rotation
				return new Tree(a.getLeft().getValue(), 
						a.getLeft().getLeft(), 
						new Tree(a.getValue(), a.getLeft().getRight(), a.getRight()));
			} else {
				//assume that the left-rights height is more than the rights height
				assert ((a.getLeft().getRight().getHeight()) > a.getRight().getHeight());
				//Perform doble rotation
				return new Tree(a.getLeft().getRight().getValue(),
						new Tree(a.getLeft().getValue(),a.getLeft().getLeft(), a.getLeft().getRight()),
						new Tree(a.getValue(), a.getLeft().getRight(), a.getRight()));
			}
		}
	}

	/**
	 * This method is used for double rotations;  
	 * where a node has been inserted into the right subtree 
	 * of the left subtree. The aim of this method is to do the following:
	 * 
	 *       C     
	 *        \                    B
	 *         B       -->        / \  
	 *          \                A   C
 	 *           A            
	 *    
	 * @param unrotatedTree Tree which will be rotated and balanced
	 * @return Tree which has been rotated
	 */
	public static Tree leftRotation(Tree a) {
		//first check if its height balanced
		if (isHeightBalanced(a))
			return a;
		else {
			//check for the single rotation
			if (a.getRight().getHeight() > a.getLeft().getHeight()) {
				// perform a single rotation
				return new Tree(a.getRight().getValue(),
						new Tree(a.getValue(), a.getLeft(), a.getRight().getLeft()),
						a.getRight().getRight());
			} else {
				//make sure its a fork
				assert a.getRight().getLeft().getHeight() > a.getLeft().getHeight();
				//do double rotation
				return new Tree(a.getRight().getLeft().getValue(),
						 new Tree(a.getValue(), a.getLeft(), a.getRight().getLeft().getLeft()),
								 new Tree(a.getRight().getValue(), a.getRight().getLeft().getRight(), a.getRight()));
			}
		}
	}



	/**
	 * This is a method that will insert a value into an already height balanced Tree.
	 * Hence it is a requirement that an AVL tree is submitted. 
	 * AVL trees dont have duplicates
	 * @param x The value which you would like to insert
	 * @param a A height balanced Tree
	 * @return A tree with x inserted into the tree and balanced
	 */
	public static Tree insertHB(int x, Tree a) { 
		if (a.isEmpty())
			return new Tree(x);
		else if (x <= a.getValue()) {
			//first need to insert the value
			Tree newLeft = insertHB(x, a.getLeft());
			//now we balance it
			return rightRotation(new Tree(a.getValue(), newLeft, a.getRight()));
		} else {
			//first need to insert the value
			Tree newRight = insertHB(x, a.getRight());
			//now we balance it
			return leftRotation(new Tree(a.getValue(), a.getLeft(),newRight ));
		}
	}
	/**
	 * This method removes a value from the tree. This method checks to make sure
	 * that the tree contains the number, it then removes it and makes sure that the 
	 * tree is correct.
	 * @param x The value which you would like to remove
	 * @param a an AVL tree which you would like to remove a value from
	 * @return a tree with the value removed 
	 */
	public static Tree deleteHB(int x, Tree a) {
		//if empty
				if(a.empty){
					throw new IllegalStateException("deleteHB: value is not in the tree");
				}
				else {
					if(x > a.getValue()) {
						//create a new tree to recursively find where to delete the number
						Tree newRightTree = deleteHB(x, a.getRight());
						//rotate the node which is wrong
						return leftRotation(new Tree(a.getValue(),a.getLeft(), newRightTree));
					} else if (x < a.getValue()) {
						//create a new tree to recursively find where to delete the number
						Tree newLeftTree = deleteHB(x, a.getLeft());
						//rotate the node which is wrong
						return rightRotation(new Tree(a.getValue(), newLeftTree, a.getRight()));
					} 
					//When the value we want to delete is =
					else {
						//For <b>Efficiency</b> ONLY REPLACE IF WE HAVE 2 NODES
						//if left is empty just push right tree up fam
						if (a.getLeft().isEmpty()) {
							return a.getRight();
						//if right tree is empty fam push up left one
						} else if (a.getRight().isEmpty()) {
							return a.getLeft();
						} else {
							//We can either get the max of the left
							//or the min of the right
							int maxLeft = max(a.getLeft());
							return rightRotation(new Tree(maxLeft, deleteHB(maxLeft, a.getLeft()), a.getRight()));
						}
					}
				}
	}
	/**
	 * Below are some main method tests that helped me solve the above code, it has been commented out.
	 * The Tests are very indepth, but the following code let me <b>Visualise</b> the code.
	 */
	public static void main(String[] args) {
		/*Tree test21 = new Tree(10, new Tree(9, new Tree(8, new Tree(), new Tree()), new Tree()), new Tree());
		System.out.println(isHeightBalanced(test21));
		Tree test = new Tree(1, new Tree(5), new Tree());
		System.out.println(test.getHeight());
		System.out.println("---------------Exercise 1---------------");
		Tree negateAllCheck1 = new Tree(2, new Tree(-3), new Tree(-5));
		Tree negateAllCheck2 = new Tree(10, new Tree(5, new Tree(2), new Tree(6)),
				new Tree(15, new Tree(14), new Tree(20)));
		System.out.println(negateAllCheck1);
		System.out.println(negateAll(negateAllCheck1));
		System.out.println(negateAllCheck2);
		System.out.println(negateAll(negateAllCheck2));
		System.out.println("---------------Exercise 2---------------");
		Tree mirrorCheck1 = new Tree(2, new Tree(3), new Tree(5));
		Tree mirrorCheck2 = new Tree(10, new Tree(5, new Tree(2), new Tree(6)),
				new Tree(15, new Tree(14), new Tree(20)));
		System.out.println((mirrorCheck1));
		System.out.println(mirror(mirrorCheck1));
		System.out.println((mirrorCheck2));
		System.out.println(mirror(mirrorCheck2));
		System.out.println("---------------Exercise 3---------------");
		Tree postorderCheck = new Tree(10, new Tree(5, new Tree(2), new Tree(6)),
				new Tree(15, new Tree(14), new Tree(20)));
		System.out.println(postorderCheck);
		System.out.println(postorder(postorderCheck));
		System.out.println("---------------Exercise 4---------------");
		Tree allPositiveCheck = new Tree(2, new Tree(3), new Tree(5));
		System.out.println(allPositiveCheck);
		System.out.println(allPositive(allPositiveCheck));
		*/
		
	/*	System.out.println("---------------Exercise 5---------------");
		Tree isSearchTreeCheck = new Tree(2, new Tree(1), new Tree(3));
		Tree isSearchTreeCheck2 = new Tree(20, new Tree(1), new Tree(30, new Tree(45), new Tree()));
		Tree t1 = new Tree(100,new Tree(80,new Tree(),
				new Tree(90,new Tree(82),new Tree())),new Tree(200,new Tree(150,
				new Tree(),new Tree(149)),new Tree()));
		System.out.println(t1);
		System.out.println(isSearchTree(t1));
		
		
		System.out.println("---------------Exercise 6 - shown as it is not in the JUNIT tests ---------------");
		Tree printDescendingCheck = new Tree(2, new Tree(1), new Tree(3));
		Tree printDescendingCheck2 = new Tree(10, new Tree(5), new Tree(20, new Tree(15), new Tree(25)));
		System.out.println(printDescendingCheck);
		System.out.println("In descending order is:");
		printDescending(printDescendingCheck);
		System.out.println();
		System.out.println(printDescendingCheck2);
		System.out.println("In descending order is:");
		printDescending(printDescendingCheck2);
		System.out.println();
		*/
		
		/*System.out.println("---------------Exercise 7---------------");
		Tree maxCheck = new Tree(2, new Tree(1), new Tree(3));
		Tree maxCheck2 = new Tree(10, new Tree(5), new Tree(20, new Tree(15), new Tree(25)));
		System.out.println(max(maxCheck) + "Should return 3");
		System.out.println(max(maxCheck2) + "Should return 25");
		System.out.println("---------------Exercise 8---------------");
		Tree deleteCheck1 = new Tree(2, new Tree(1), new Tree(3));
		Tree deleteCheck2 = new Tree(10, new Tree(5), new Tree(20, new Tree(15), new Tree(25)));
		System.out.println(deleteCheck1 + "\n this should delete 2");
		System.out.println(delete(2, deleteCheck1));
		System.out.println(deleteCheck2 + "\n this should delete 20");
		System.out.println(delete(20, deleteCheck2));
		System.out.println("---------------Exercise 9---------------");
		Tree isHeightBalancedCheck = new Tree(20, new Tree(10, new Tree(5, new Tree(1), new Tree()), new Tree()),
		new Tree(30));
		System.out.println(isHeightBalancedCheck);
		System.out.println(isHeightBalanced(isHeightBalancedCheck));
		*/
		System.out.println("---------------Exercise 10 INSERT---------------"); 
		Tree insertcheck1 = new Tree(3, new Tree(2), new Tree());
		//System.out.println(insertcheck1);
		//System.out.println(insertHB(1, insertcheck1));
		
		Tree insertcheck2 = new Tree(5, new Tree(4, new Tree(3), new Tree()), new Tree(10, new Tree(), new Tree()));
		//System.out.println(insertcheck2);
		//System.out.println(insertHB(2, insertcheck2));
		//System.out.println("---------------------");
		Tree t1 = new Tree(60, new Tree(50, new Tree(40), new Tree(55)), new Tree(80, new Tree(70), new Tree(90))); 
		Tree t2 = insertHB(38, t1);
		Tree t3 = insertHB(39, t2);
		System.out.println(t2); 
		System.out.println(t3); 
		
		
		Tree insertCheck3 = new Tree(5, new Tree(3, new Tree(1), new Tree()), new Tree(8, new Tree(4), new Tree(10, new Tree(), new Tree(30))));
		//System.out.println(insertCheck3);
		//System.out.println(deleteHB(1, insertCheck3));
	
		System.out.println("---------------------");
		Tree insertCheck4 = new Tree(20, new Tree(4, new Tree(), new Tree(15)), new Tree());
		System.out.println("---------------------");
		//System.out.println(leftRightRotation(insertCheck4));
		
	}
}
