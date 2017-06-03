package Ex1;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class StarTrees extends Trees {
	public int numberOfVertices;
	public int steps;

	public StarTrees(int[] xTrees, int[] yTrees, int[] scaleTrees, int numberOfVertices, int steps) {
		super(xTrees, yTrees, scaleTrees);
		this.numberOfVertices = numberOfVertices;
		this.steps = steps;
	}

	public int getNumberOfVertices() {
		return numberOfVertices;
	}

	public void setNumberOfVertices(int numberOfVertices) {
		this.numberOfVertices = numberOfVertices;
	}

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < getxTrees().length; i++) {
			
			int[] xTrees = { getxTrees()[i], getxTrees()[i] + (30 * getScaleTrees()[i]),
					getxTrees()[i] + (60 * getScaleTrees()[i]) };
			int[] yTrees = { getyTrees()[i] + (60 * getScaleTrees()[i]), getyTrees()[i],
					getyTrees()[i] + (60 * getScaleTrees()[i]) };
			g.setColor(Color.GREEN);
			g.fillPolygon(xTrees, yTrees, 3);
			g.setColor(new Color(140, 75, 50));
			g.fillRect(getxTrees()[i] + (25 * getScaleTrees()[i]), getyTrees()[i] + (60 * getScaleTrees()[i]),
					10 * getScaleTrees()[i], 20 * getScaleTrees()[i]);
			
			Polygon p3 = RegularPolygon(5, 1000, getxTrees()[i] + 30, 0, (float) Math.PI / 5);
			g.fillPolygon(p3);
			

		}

	}

	public Polygon RegularPolygon(int vertices, float scale, int xOffset, int yOffset, float rotation) {

		int[] xpoints = new int[vertices];
		int[] ypoints = new int[vertices];

		for (int i = 0; i < vertices; i++) {
			xpoints[i] = xOffset + (int) Math.round(scale * Math.cos(rotation + 2 * i * Math.PI / vertices));
			ypoints[i] = yOffset + (int) Math.round(scale * Math.sin(rotation + 2 * i * Math.PI / vertices));
		}
		return new Polygon(xpoints, ypoints, vertices);
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("trees");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(700, 700);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		int[] treesX = { 0, 70, 140, 210, 280, 350, 420, 0, 70, 140, 210, 280, 350, 420, 50, 200 };
		int[] treesY = { 0, 0, 0, 0, 0, 0, 0, 100, 100, 100, 100, 100, 100, 100, 200, 200 };
		int[] scale = { 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 1, 1, 2, 2, 3 };
		Trees tree = new Trees(treesX, treesY, scale);
		frame.add(tree);
	}
}
