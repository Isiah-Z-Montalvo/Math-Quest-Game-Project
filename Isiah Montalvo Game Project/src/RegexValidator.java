/*************************************************************************************************************************************************************************
Name: Isiah Montalvo
Course: CS170
Lab 4: Lab 4
Submission Date: 10:00pm, Wednesday (04/14)
Brief Description: RegexValidator class that takes in user submitted information and verifies them to conform to a unified format.
*************************************************************************************************************************************************************************/
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*; // Imports

public class RegexValidator {
	boolean valid;
	
	public String validateText(String prompt) {
		String regex = "[0-9]*";
		do {
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(prompt);
			valid = m.matches();
			if (valid == false) {
				JOptionPane.showMessageDialog(null, "Numbers Only!");
				break;
			}
		}while (valid != true);
		return prompt;
	}
	
	public String validateName(String prompt) { // Validates names using Regex
		//String name;
		String regex = "[A-Z][a-z]*"; // Only intended format
		do {
		Pattern p = Pattern.compile(regex);
		
		//name = JOptionPane.showInputDialog(prompt);// Compiles and matches regex with the user submitted string and repeats if false
		
		//Matcher m = p.matcher(name);
		Matcher m = p.matcher(prompt);
		valid = m.matches();
		
		if (valid == false) {
			JOptionPane.showMessageDialog(null, "Error: Please Properly Capitalize Name");
		}
		}
		while(valid != true);
		//return name;
		return prompt;
	}
	
	public String validateEmail(String prompt) { // Validates email formats using Regex
		String email;
		String regex = "^([A-Za-z0-9]+\\.)+[A-Za-z0-9]+@([A-Za-z]+\\.)+[A-Za-z]{3}$"; // Only intended format
		do {
			Pattern p = Pattern.compile(regex);
			
			email = JOptionPane.showInputDialog(prompt);
			
			Matcher m = p.matcher(email);// Compiles and matches regex with the user submitted string and repeats if false
			valid = m.matches();
			
			if (valid == false) {
				JOptionPane.showMessageDialog(null, "Error: Please enter valid email formatting");
			}
			}
			while(valid != true);
		return email;
	}
	
	public String validateMailing(String prompt) { // Validates mailing using Regex
		String mailing;
		String regex = "^[0-9 ]*+[A-Z][a-z ]*+([A-Z][a-z]*+\\, )+([A-Z][a-z]*+\\, )+[A-Z ]{3}+[0-9]{5}$"; // Only intended format
		do {
			Pattern p = Pattern.compile(regex);
			
			mailing = JOptionPane.showInputDialog(prompt);
			
			Matcher m = p.matcher(mailing);// Compiles and matches regex with the user submitted string and repeats if false
			valid = m.matches();
			
			if (valid == false) {
				JOptionPane.showMessageDialog(null, "Error: Please enter a valid mailing format");
			}
			}
			while(valid != true);
		return mailing;
	}
	
	public char validateChar(String prompt) { // Validates Chars using Regex
		String s;
		char validated;
		String regex = "^[yn]$"; // Only allows lowercase y and n
		do {
			Pattern p = Pattern.compile(regex);
			
			s = JOptionPane.showInputDialog(prompt); // Compiles and matches regex with the user submitted string and repeats if false
			
			Matcher m = p.matcher(s);
			valid = m.matches();
			
			if (valid == false) {
				JOptionPane.showMessageDialog(null, "Error: Enter in format of y/n");
			}
			}
			while(valid != true);
		validated = s.charAt(0);
		return validated;
	}
}
