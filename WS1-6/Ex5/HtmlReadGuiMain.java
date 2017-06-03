package Ex5;

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
 * This is a solution to worksheet 6 
 * <p>
 * Information about this code can be found detailed in the previous exercise.
 * 
 * @author Abdikhaliq Timer
 * @version 03/01/17
 */

public class HtmlReadGuiMain extends JFrame {
	
	public JTextField UrlDownload, filename;
	public JButton buttonDownload;

	public HtmlReadGuiMain() {

		setTitle("Read HTML file");
		Container pane = getContentPane();
		pane.setLayout(new GridLayout(3, 0));
		
		JTextField downloadURL = new JTextField("Please enter URL");
		pane.add(downloadURL);

		JTextField filename = new JTextField("Please enter filename");
		pane.add(filename);

		buttonDownload = new JButton("Download");
		buttonDownload.addActionListener(new DownloadListener());
		pane.add(buttonDownload);

		setSize(300, 250); 
		setVisible(true); 
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE); 

	}

}
