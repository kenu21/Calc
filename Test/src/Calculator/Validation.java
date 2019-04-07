// Validation data

package Calculator;

import java.util.Scanner;

public class Validation {
	
	// check the first operand
	public static boolean isValidFirstNumber(String str) {
		
		Scanner sc = new Scanner(str);
		
		// if str has only one int then return true.
		// If str has int and something else then return false; 
		if(sc.hasNextInt()) {
				sc.nextInt();
				if(!sc.hasNext()) return true;
				else return false;
		}
		// if str has Roman numerals from I till X then return true; else - false; 
		else {
			switch(str) {
				case "I":
				case "II":
				case "III":
				case "IV":
				case "V":
				case "VI":
				case "VII":
				case "VIII":
				case "IX":
				case "X":
					return true;
				default:
					return false;
			}			
		}
	}
	
	// check the second operand
	public static boolean isValidSecondNumber(String str, boolean b) {
		
		// if the second operand has invalid data then return false;
		if(!isValidFirstNumber(str)) return false;	
		
		/*
			if the first operand and the second operand have
			equal type numerals then return true. Else - false.
		 */
		if(b && isArabic(str)) return true;
		else if(!b && !isArabic(str)) return true;
		else return false;
	}

	// check the last operand
	public static boolean isValidThirdNumber(String str, boolean b) {
	
		// if the last operand has invalid data then return false;
		if(!isValidFirstNumber(str)) return false;
		
		/*
			if the first operand and the last operand have
			equal type numerals then return true. Else - false.
		 */
		if(b && isArabic(str)) return true;
		else if(!b && !isArabic(str)) return true;
		else return false;
	}

	// Is str Arabic numeral or not?
	public static boolean isArabic(String str) {
	
		Scanner sc = new Scanner(str);
		
		// if str has only one int (Arabic) then return true.
		// If str has int and something else then return false; 
		if(sc.hasNextInt()) { 
			sc.nextInt();
			if(!sc.hasNext()) return true;
			else return false;
		}
		else return false;
	}

	// if the first operation is valid then return true; else - false;
	public static boolean isValidOneOperation(String str) {
	
		switch(str) {
			case "+":
			case "-":
			case "*":
			case "/":
				return true;
			default:
				return false;
		}
	}

	// if the second operation is valid then return true; else - false;
	public static boolean isValidSecondOperation(String str) {
	
		switch(str) {
			case "+":
			case "-":
			case "*":
			case "/":
			case "=":
				return true;
			default:
				return false;
		}
	}
}