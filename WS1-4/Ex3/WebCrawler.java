import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * This is a solution to Exercise 3 on Worksheet 4 given to us by Manfred.
 * <p>
 * As one of the more challenging questions on the Worksheet, this is a program
 * designed to crawl through a website and extract links to other sites out of
 * the webpage. This program does just that, via the method collectUrls.
 * 
 * @author Abdikhaliq Timer
 * @version 14/10/12;
 *
 */
public class WebCrawler {
	/**
	 * This is a method that crawls through a website, which is specified as a
	 * parameter, and returns the various links in a arrayList.
	 * 
	 * @param urlString
	 *            The webpage you would like to crawl through.
	 * @return return the links to all other sites found on the urlString
	 *         provided.
	 */
	public static ArrayList<String> collectUrls(String urlString) {

		ArrayList<String> urlCollection = new ArrayList<>();
		String readString;
		/**
		 * This is needed to make sure a string is provided, hence the program
		 * can catch an exception if one is found, due to the I/O nature of this
		 * program.
		 */
		try {
			URL url = new URL(urlString);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			while ((readString = in.readLine()) != null) {
				
				if (readString.split("<a href=").length > 1) {
					String removeLeft = "";
					String removeRight = "";
					removeLeft = readString.split("<a href=\"")[1];
					removeRight = removeLeft.split("\">")[0];
					urlCollection.add(removeRight);
				}
			}
			in.close();

		} catch (IOException e) {
			System.out.println("File not found.");
		}

		return urlCollection;
	}
}
