package khalidsCode;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

import ex1.Trees;

/** The StarTrees class is the sub-class of Trees and adds on a star polygon to each tree
 *  according to the number of vertices and steps skipped between each connected vertex
 *  (both numbers are referred to as numberOfVertices & steps respectively)
 *  
 *  @author Khalid Ramadan */

public class StarTrees extends Trees {
	
/** The variables numberOfVertices (number of vertices each star polygon will have) & steps 
 *  (number of steps between each connected vertex) are declared here */
	
	private int numberOfVertices, steps;

/** The constructor for the class uses the inherites 3 arrays xTrees, yTrees 
 *  & scaleTrees in addition to the two integers numberOfVertices & steps
 * 	
 *  @param xTrees	  		=	The x-coordinates for a given tree or set of trees
 *  @param yTrees	  		=	The y-coordinates for a given tree or set of trees
 *  @param scaleTrees 		=	The scalings for a given tree or set of trees
 *  				   			(e.g. a scaling of 2 for a tree means the tree is 
 *  							twice as large as a tree with a scaling of 1
 *  @param numberOfVertices =	Number of vertices of each star polygon 
 *  @param steps			=	Steps between each connected vertex in the star */
	
	public StarTrees(int[] xTrees, int[] yTrees, int[] scaleTrees, int numberOfVertices,
					 int steps) {
		
		super(xTrees, yTrees, scaleTrees);
		this.numberOfVertices = numberOfVertices;
		this.steps = steps;
	
	}
	
	public void paintComponent(Graphics g){
		
/** As StarTrees inherits the paintComponent from Trees (by super.paintComponent(g)), the trees 
 *  will already be drawn for each (x,y) pair in the arrays for each Trees/StarTrees object  */
		
		super.paintComponent(g);

/** Integers n & s are introduced simply to help with the layout of the code below */
		
		int n = numberOfVertices; int s = steps;
		
/** The arrays xStarCoordinates & xStaryoordinates will store the x and y coordinates of each
 *  vertex within the star polygon. Naturally, as n specifies the number of vertices, both 
 *  arrays are of size n */
		
		int [] xStarCoordinates = new int[n], yStarCoordinates= new int[n];

/** The for-loop goes through each pair of (x,y) coordinates (i.e. the trees) and generates a 
 *  star polygon for each */
		
		for(int i=0; i<getxTrees().length; i++){

/** Integers x & y are introduced simply to help with the layout of the code whilst unit will be
 *  the given length of the lines that will form the star polygon. Note that the length is dependent
 *  upon the specified scaling for each tree */
			
			int x = getxTrees()[i] ; int y = getyTrees()[i]; 
			int unit = 9 * getScaleTrees()[i];
			
/** For each given tree, this nested for-loop will update the arrays xStarCoordinates & yStarCoordinates
 *  with the respective coordinates for each vertex of the star */
			
			for(int j=0; j<n; j++){ 
				
/** To calculate each vertex coordinate, first note that each vertex lies on a circle centered at the given 
 *  (x,y) pair of the tree. In addition, each vertex is uniformly spaced out along the circumference of this
 *  circle. Hence, (2*Math.PI)/n obtains the angle between any adjacent pair of vertices. Multiplying this
 *  quantity with j will give the angle made from the right-hand horizontal (itself from the (x,y) coordinate)
 *  to the j-th vertex. Finally, taking the cosine and sine of this argument will give the x & y coordinate of
 *  the vertex respectively. Note that the (x,y) coordinates need to be added on in order to have the star polygon
 *  centered at the tip of the tree */
				
				xStarCoordinates[j] = (int) (x + (unit * Math.cos(((2*Math.PI)/n)*j)));
				yStarCoordinates[j] = (int) (y + (unit * Math.sin(((2*Math.PI)/n)*j)));	
				
			}
	
/** As the coordinates of each vertex of the star polygon has been computed, the below for-loop	cycles through
 *  each vertex and draws a line between itself and the vertex that is s steps away, by drawing a line from the 
 *  jth vertex to the (j+s)th vertex. Naturally, for vertices whose index is within the last n elements of arrays 
 *  xStarCoordinates & yStarCoordinates, this would normally result in an out-of-bounds exception. Hence the use of
 *  %n to help it cycle back to the required vertex (e.g. if the 8th (and last) vertex needs to connect back to 
 *  the 2nd vertex, (j+s)%n=(8+2)%8=2 as required */ 
			
			g.setColor(Color.BLACK);
			
			for(int j=0; j<n; j++){
				
				g.drawLine( xStarCoordinates[j]		 ,yStarCoordinates[j],
							xStarCoordinates[(j+s)%n],yStarCoordinates[(j+s)%n]);	
				
			}		
		}	
	}
	
	public static void main(String[] args) {
		
		int[] a= {50, 200};
		int[] b= {50, 200};
		int[] c= {1, 5};		
		
		StarTrees test = new StarTrees(a,b,c,11,4);
		JFrame frame = new JFrame("Christmas Trees + Stars");
		
		frame.add(test);
		frame.setSize(600, 500);
		
		frame.setVisible(true);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}