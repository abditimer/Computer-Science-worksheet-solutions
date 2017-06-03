package Ex1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;

/**
 * A solution to Exercise 1 of Worksheet 6.
 * <p>
 * This solution code is for christmas trees that are meant for computer games.
 * The trees are being made to put in the background scene. The task of this
 * exercise is to create christmas trees that come in some variation.
 * 
 * 
 * @author Abdikhaliq Timer
 * @version 19/12/16
 */
public class Trees extends JPanel {
	public int[] xTrees;
	public int[] yTrees;
	public int[] scaleTrees;
	/**
	 * @param yTrees
	 *            Is an Array that contains the y coordinates for the polygon
	 *            that forms the main section of the tree
	 * @param xTrees
	 *            Is an Array that contains the x coordinates for the polygon
	 *            that form the main section of the tree
	 * @param scaleTrees
	 *            Is an Array that contains the scales for the trees.
	 */
	public Trees(int[] xTrees, int[] yTrees, int[] scaleTrees) {
		super();
		this.xTrees = xTrees;
		this.yTrees = yTrees;
		this.scaleTrees = scaleTrees;
	}
	/**
	 * A getter that gets the x coordinates that will form the main section of the tree. 
	 * @return xTrees returns the x coordinates
	 */
	public int[] getxTrees() {
		return xTrees;
	}
	/**
	 * A getter that gets the y coordinates that will form the main section of the tree.
	 * @return yTrees returns the y coordinates
	 */
	public int[] getyTrees() {
		return yTrees;
	}
	/**
	 * A getter that will return the correct scales for each tree.
	 * @return
	 */
	public int[] getScaleTrees() {
		return scaleTrees;
	}
	/**
	 * This will override the paintComponent, allowing for the trees to be drawn.
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		/**
		 * A loop has been created that will allow for all the x and y coordinates to be looped over.
		 */
		for (int i = 0; i < getxTrees().length; i++) {
			/**
			 * The code will begin with drawing the top section of the tree first. 
			 * This means drawing the tree without the tree trunk, hence only the green section of the tree.
			 * <p>
			 * The below code shows coordinates for both the x and y within their complementary arrays.
			 * At a scale of 1, the top of the tree should have:
			 * a base width of 60 pixels, and a height of 60 pixels.
			 * <p>
			 * The calculation was done by taking the example diagram provided by the lecturer, and 
			 * identifying that the pixels of the tree given on the worksheet has x coordinates of o, 3 and 6.
			 * multiplying these values by 10 should provide large enough trees that can be easily viewed.
			 * <p>
			 * The y coordinates of the tree was worked out in a similar fashion, however, the y coordinates now are only needed on
			 * two y axis, when y is 0 and again at when y is 6. This was worked out using the worksheet provided.
			 */
			int[] xTrees = { getxTrees()[i], getxTrees()[i] + (30 * getScaleTrees()[i]), getxTrees()[i] + (60 * getScaleTrees()[i]) };
			int[] yTrees = { getyTrees()[i] + (60 * getScaleTrees()[i]), getyTrees()[i], getyTrees()[i] + (60 * getScaleTrees()[i]) };
			g.setColor(Color.GREEN);
			g.fillPolygon(xTrees, yTrees, 3);
			/**
			 * The tree trunk is similar to the triangle that forms the top of the tree, but the only difference is that it sits directly
			 * in the middle of the triangle. As the code uses ints only, I had to make sure the code allows the trunk to sit in the middle. 
			 * But by having multiplied the value of 0, 3 and 6 by 10, allows for easily manipulation of the code.
			 * <p>
			 * From the picture on the worksheet, I can identify that the tree has a width of 1 pixel, which I will take as 10.
			 * The height is 20 pixels.
			 * <p>
			 * Using the g.fillRect will allow us to create a tree trunk that is in the shape of a rectange. We set the x coordinate at the location which
			 * will be centre below the traingle tree top, whilst setting the y axis at the max of the tree.
			 */
			g.setColor(new Color(140, 75, 50));
			g.fillRect(getxTrees()[i] + (25 * getScaleTrees()[i]), getyTrees()[i] + (60 * getScaleTrees()[i]), 10 * getScaleTrees()[i], 20 * getScaleTrees()[i]); 
		}

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("trees");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		int[] treesX = { 0, 70, 140, 210, 280 };
		int[] treesY = { 200, 10, 400, 0, 0 };
		int[] scale = { 1, 1, 1, 1, 5};
		Trees tree = new Trees(treesX, treesY, scale);
		frame.add(tree);
	}

}