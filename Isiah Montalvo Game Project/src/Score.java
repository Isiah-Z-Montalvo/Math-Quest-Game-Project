import java.io.*;
import javax.swing.*;

public class Score {
	
	public void writeScores(String name, int score) throws IOException{
		File data = new File("C:\\Users\\Swift\\Desktop\\Scores.txt");
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(data, true)));	
		
		out.println("Name: " + name + "|" + "High Score: " + score);
		out.close();
	}
	
	public void readScores() throws IOException{
		File data = new File("C:\\Users\\Swift\\Desktop\\Scores.txt");
		if (data.exists()) {
			BufferedReader read = new BufferedReader(new FileReader(data));
			String line = read.readLine();
			while(line != null) {
				JOptionPane.showMessageDialog(null, line);
				line = read.readLine();
			}
			read.close();
		}
		else
			JOptionPane.showMessageDialog(null, "File not found!");
	}
}
