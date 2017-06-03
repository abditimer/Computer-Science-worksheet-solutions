package Ex5;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import javax.swing.JOptionPane;

/**
 * This is a solution to worksheet 6 
 * <p>
 * Information about this code can be found detailed in the previous exercise.
 * 
 * @author Abdikhaliq Timer
 * @version 03/01/17
 */

public class DownloadListener extends HtmlReadGuiMain implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String s = UrlDownload.getText();
			String readString;
			try {
				URL url = new URL(s);
				BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
				BufferedWriter out = new BufferedWriter(new FileWriter(filename.getText()));
				int counter = 0;
				while ((readString = in.readLine()) != null) {
					counter++;
					out.write(counter + " " + readString + "\n");
				}

				in.close();
				out.close();

				Component frame = null;
				JOptionPane.showMessageDialog(frame, "Download complete");
			}


			catch (IOException e1) {
				Component frame = null;
				JOptionPane.showMessageDialog(frame, "Download failed");
			}
		}
	

	public static void main(String[] args) {
		HtmlReadGuiMain htmlRead = new HtmlReadGuiMain();

	}
}