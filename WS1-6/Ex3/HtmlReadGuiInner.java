package Ex3;

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
 * This is a solution to Exercise 3 on Worksheet 6.
 * <p>
 * This code will create a GUI that will allow a user to download a HTML file of
 * their choice to a local file of their choice. Hence, two things will be
 * needed
 * <ul>
 * <li>the user will need to fill in a URL of the html file they want to
 * download</li>
 * <li>name the file</li>
 * </ul>
 * 
 * @author Abdikhaliq Timer
 * @version 29/12/16
 */

public class HtmlReadGuiInner extends JFrame {
	private JTextField downloadURL;
	private JTextField fileName;
	private JButton downloadButton;

	public HtmlReadGuiInner() {
		/**
		 * setTitle allows me to set the title for the frame that will have my
		 * button within it.
		 */
		setTitle("HTML File Reader");
		Container contentPane = getContentPane();
		/**
		 * The following allows for the contentPane to be split into three
		 * sections for my button.
		 */
		contentPane.setLayout(new GridLayout(3, 0));
		/**
		 * The the top sections of the content pane needs to have text
		 * indicating what the fields are about
		 */
		downloadURL = new JTextField("Please enter URL");
		contentPane.add(downloadURL);
		fileName = new JTextField("Please enter filename");
		contentPane.add(fileName);
		/**
		 * The last content pane will house the button, this is where we add an actionListener.
		 */
		downloadButton = new JButton("Download");
		downloadButton.addActionListener(new ButtonListener());
		contentPane.add(downloadButton);
		/**
		 * This sets the correct sizing and visibility of the frame.
		 */
		setSize(600, 300); 
		setVisible(true); 
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 

	}
	/**
	 * This is the inner class that will implement the ActionListener in the code above.
	 *
	 */
	public class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			String urlText = downloadURL.getText();
			String readString;
			
			try {
				URL url = new URL(urlText);
				BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
				BufferedWriter out = new BufferedWriter(new FileWriter(fileName.getText()));
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
		}
	}

	public static void main(String[] args) {
		HtmlReadGuiInner htmlInner = new HtmlReadGuiInner();

	}
}