package khalidsCode;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/** HtmlReadGuiInner allows the user to obtain a html file of a specified website
 *  and save it to a given file. This class uses Inner Classes to achieve the
 *  above
 * 
 * @author Khalid Ramadan */

public class HtmlReadGuiInner extends JPanel {

/** The text fields and Download button are declared as field variables below */
	
	private JTextField textFieldURL, textFieldFile;
	private JButton downloadButton;

/** The constructor for the class simply contains the setUp method that decides
 *  the layout for the GUI */
	
	public HtmlReadGuiInner() {

		setUp();
		
	}

/** setUp() decides the layout for the GUI using the declared field variables */
	
	public void setUp() {

/** GridLayout g1 is used to help layout the textfields and Download buttons
 *  properly */
		
		GridLayout g1 = new GridLayout(3, 1);

/** textFieldURL is the textfield that takes the user's URL */
		
		textFieldURL = new JTextField("Please enter URL, starting the url with http");
		textFieldURL.setFont(new Font("Arial", Font.PLAIN, 20));
		add(textFieldURL);

/** textFieldURL is the textfield that takes the user's chosen filename which will be 
 *  the filename of the created html file */
		
		textFieldFile = new JTextField("Please enter filename");
		textFieldFile.setFont(new Font("Arial", Font.PLAIN, 20));
		add(textFieldFile);

/** downloadButton is the button that, upon being pressed, will cause the program to 
 *  obtain the specified url's html file and create a file with the filename written in
 *  by the user. The ActionListener for the button is in the inner class below */
		
		downloadButton = new JButton("DOWNLOAD");
		downloadButton.setFont(new Font("Arial", Font.PLAIN, 20));
		add(downloadButton);
		downloadButton.addActionListener(new DownloadListener());

/** The layout is set here following the addition of the JTextFields and JButton */
		
		setLayout(g1);

	}

/** The DownloadListener inner class implements the ActionListener interface. It was
 *  created in order for the Gui to read in the html file of the specified url once the
 *  user presses the download button */
	
	private class DownloadListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
/** The following strings inputHTML & outputFile are the strings of text contained within 
 *  each respective JTextField upon the user pressing the button */
			
			String inputHTML  = textFieldURL.getText();
			String outputFile = textFieldFile.getText();

/** As the program concerns itself with I/O, the rest of the code is contained within a try-catch
 *  block */
			
			try {

/** Here, a URL object is created from the user's specified url */
				
				URL url = new URL(inputHTML);

/** BufferedReader readIn reads in the html file from the above URL object whilst BufferedWriter writeOut
 *  writes out the html code that is read in to a file with filename outputFile*/
				
				BufferedReader readIn = new BufferedReader(new InputStreamReader(url.openStream()));
				BufferedWriter writeOut = new BufferedWriter(new FileWriter(outputFile));

				String htmlLine;

/** The following while-loop reads in each line and writes out the exact same line to outputFile and subsequently
 *  skips to the next line. The loop continues to execute until readIn reaches the last line */
				
				while ((htmlLine  = readIn.readLine())!= null) {
					
					writeOut.write("" + htmlLine + "\n");
				}

/** Once outputFile has been fully written up, the BufferedReader/Writer are closed here */
				
				readIn.close();
				writeOut.close();

/** The following catches are for when the user inputs text that isn't a url in textFieldURL or when the 
 *  program fails to write out the html file to the specified file */
				
			} catch (MalformedURLException e1) {
				System.out.print("Whoops, it doesn't seem like you've put in a correct html url (or maybe there's connectivity issues)");
				System.exit(0);
				
			} catch (IOException e1) {
				System.out.print("Whoops, seems the IOException took issue with ya file, m8");
				System.exit(0);
			}

/** If the file has been successfully written out to outputFile, the following statement is printed and the program
 *  terminates */
			
			System.out.println("Your file has been succesfully created");
			System.exit(0);
		}

	}

	public static void main(String[] args) {

		HtmlReadGuiInner gui = new HtmlReadGuiInner();
		JFrame frame = new JFrame("Read HTML File");

		frame.add(gui);
		frame.setSize(600, 550);
		frame.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}