package Ex4;

import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.awt.*;

/**
 * This is a solution to Exercise 4 on Worksheet 6.
 * <p>
 * The details of this exercise can be found on the previous question, as they
 * are the same except that this solution provides an inner class that uses
 * functions.
 * 
 * @author Abdikhaliq Timer
 * @version 03/01/17
 */

public class HtmlReadGuiLambda extends JFrame {
	private JTextField downloadURL;
	private JTextField filename;
	private JButton downloadButton;

	public HtmlReadGuiLambda() {
		setTitle("HTML File Reader"); 
		Container contentPane = getContentPane();
		contentPane.setLayout(new GridLayout(3, 0));

		downloadURL = new JTextField("Please enter URL");
		contentPane.add(downloadURL);
		filename = new JTextField("Please enter filename");
		contentPane.add(filename);

		downloadButton = new JButton("Download");
		contentPane.add(downloadButton);
		
		setSize(600, 300);
		setVisible(true); 
		setLocationRelativeTo(null); 
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		/**
		 * Unlike Exercise 3, this code will provide a button that is implement lambda functions. 
		 */
		downloadButton.addActionListener(( e) -> { //dont have to write the type
			String urlText = downloadURL.getText();
			String readString;
			try {
				URL url = new URL(urlText);
				BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
				BufferedWriter out = new BufferedWriter(new FileWriter(filename.getText()));
				int counter = 0;
				while ((readString = in.readLine()) != null) {
					counter++;
					out.write(counter + " " + readString + "\n");
				}
				in.close();
				out.close();
				Component messageFrame = null;
				JOptionPane.showMessageDialog(messageFrame, "Download successful!");
			}
			catch (IOException e1) {
				Component messageFrame = null;
				JOptionPane.showMessageDialog(messageFrame, "failed to download. Please try again.");
			}
		});
	}

	public static void main(String[] args) {
		HtmlReadGuiLambda htmlLambda = new HtmlReadGuiLambda();
	}
}
