package Ex6;

/**
 * This class draws simple Christmas trees in a panel with different sizes.
 * 
 * @author Viola Marku
 * @version 2016-01-03
 */
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

public class Trees extends JPanel {
	
	public int[] xTrees; //@param xTrees indicates an array containing the x coordinates of the bounding boxes forming the body of the tree
	public int[] yTrees; //@param yTrees indicates an array containing the y coordinates of the bounding boxes forming the body of the tree
	public int[] scaleTrees; //@param scaleTrees indicates an array containing the scales for each tree
	
	//Constructor for each different tree
	public Trees(int[] xTrees, int[] yTrees, int[] scaleTrees) {
		super();
		this.xTrees = xTrees;
		this.yTrees = yTrees;
		this.scaleTrees = scaleTrees;
	}
	
	//Get methods for the coordinates and scale
	public int[] getXTrees() {
		return xTrees;
	}
	
	public int[] getYTrees() {
		return yTrees;
	}
	
	public int[] getScaleTrees() {
		return scaleTrees;
	}
	
	public void paintComponent(Graphics g) { //The actual method of the drawing
		super.paintComponent(g);
		//This loop will create a set of trees big as the number of indexes in one of the arrays (here xTree)
		for (int i=0; i<getXTrees().length; i++){
			//At scale 1 the tree size should be 60 pixels wide at base and high 60 pixels
			int[] xTrees = {getXTrees()[i], getXTrees()[i]+(30*getScaleTrees()[i]), getXTrees()[i]+(60*getScaleTrees()[i])};
			int[] yTrees = {getYTrees()[i]+(60*getScaleTrees()[i]), getYTrees()[i], getYTrees()[i]+(60*getScaleTrees()[i])};
			g.setColor(Color.GREEN); //Here we set the colour green for the top
			g.fillPolygon(xTrees, yTrees, 3);
			
			//Trunk of the tree. at scale 1 should be 10 pixels wide and 20 pixels high.
			g.setColor(new Color(140, 75, 50));
			g.fillRect(getXTrees()[i]+(30*getScaleTrees()[i])-(5*getScaleTrees()[i]), getYTrees()[i]+(60*getScaleTrees()[i]), 10*getScaleTrees()[i], 20*getScaleTrees()[i]); //x, y, w, h
		}

	}
	//main method
	public static void main (String[] args) {
		JFrame frame = new JFrame("trees"); //creates new frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //upon closure by the user, the frame will close too
		frame.setSize(700, 700); //size of the frame
		frame.setVisible(true); //frame is visible
		frame.setLocationRelativeTo(null); 

		int[] treesX = {0, 100};
		int[] treesY = {200, 100};
		int[] scale = {1, 2};
		Trees tree = new Trees(treesX, treesY, scale);
		frame.add(tree);
	}

}
	
