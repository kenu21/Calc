// Demonstrate a simple calculator

package Calculator;

import java.util.Scanner;
import static Calculator.Roman.*;
import static Calculator.Validation.*;
import static Calculator.Calculations.*;

public class DemoTest {
	
	public static void main(String[] args) {
		
		int num1; // The first digit;
		int num2; // The second digit;
		int num3; // The three digit;
		int aResult; // Result for Arabic numerals;
		String rResult; // // Result for Roman numerals; 
		String operation1;
		String operation2;
		String inputedData;
		boolean arabic; // true - Arabic, false - not Arabic.
		Scanner sc;

		for(;;) {
			System.out.println("This is a calculator.");
			System.out.println("It can work with some operations.");
			System.out.println("It can work with Arabic numerals and Roman numerals from I to X");
			System.out.println("For quit press q");

			// do while the first operand is invalid
			do {
				System.out.println("Input the first digit:");
				sc = new Scanner(System.in);
				inputedData = sc.nextLine();
				inputedData = inputedData.toUpperCase();
			
				// if user inputed "q" or "Q" then  quit
				if(inputedData.equals("Q")) return;
		
				// if the first operand is invalid then throw exception
				try {
					if(!isValidFirstNumber(inputedData)) {
						throw new InvalidDataException("Invalid Data!");
					}
				}
				catch(InvalidDataException e) {
					System.out.println(e);
				}
			
			} while(!isValidFirstNumber(inputedData));	
		
		
		
			arabic = isArabic(inputedData); // check inputed date is Arabic numerals or not.
			if(arabic) num1 = Integer.parseInt(inputedData);
			else num1 = romanToArabic(inputedData);
		
			// do while the first operation is invalid
			do {
				System.out.println("Input an operation. Only + - * /");
				sc = new Scanner(System.in);
				operation1 = sc.nextLine();
			
				// if user inputed "q" or "Q" then to quit.
				if(operation1.equals("Q") || operation1.equals("q")) return;
			
				// if the first operation is invalid then throw exception
				try {
					if(!isValidOneOperation(operation1)) {
						throw new InvalidDataException("Invalid Data!"); 
					}
				}
				catch(InvalidDataException e) {
					System.out.println(e);
				}
			} while(!isValidOneOperation(operation1));
		
			// do while the second operand is invalid
			do {
				System.out.println("Input the second digit:");
				sc = new Scanner(System.in);
				inputedData = sc.nextLine();
				inputedData = inputedData.toUpperCase();
			
				// if user inputed "q" or "Q" then quit
				if(inputedData.equals("Q")) return;
			
				// if the second operand is invalid then throw exception
				try {
					if(!isValidSecondNumber(inputedData, arabic)) {
						throw new InvalidDataException("Invalid Data!"); 
					}
				}
				catch(InvalidDataException e) {
					System.out.println(e);
				}
			} while(!isValidSecondNumber(inputedData, arabic));
		
			if(arabic) num2 = Integer.parseInt(inputedData);
			else num2 = romanToArabic(inputedData);
		
			// do while the second operation is invalid.
			do {
				System.out.println("Input an operation. Only + - * / =");
				operation2 = sc.nextLine();
			
				// if user press "q" or "Q" then to quit.
				if(operation2.equals("Q") || operation2.equals("q")) return;
			
				// if the second operation is invalid then throw exception
				try {
					if(!isValidSecondOperation(operation2)) {
						throw new InvalidDataException("Invalid Data!"); 
					}
				}
				catch(InvalidDataException e) {
					System.out.println(e);
				}
			} while(!isValidSecondOperation(operation2));
		
			// if user inputed "=" then count and print result
			if(operation2.equals("=")) {
				aResult = opWithTwo(num1, num2, operation1); // count result
			
				// if user inputed Arabic numerals then print Arabic result;
				if(arabic) {
					System.out.println("Result: " + aResult);
				}
			
				// if user inputed Roman numerals then print Roman result;
				else {
					rResult = arabicToRoman(aResult);
					System.out.println("Result: " + rResult);
				}
			}
		
			// if user inputed not "=" then to continue input
			else {
			
				// do while the last operand is invalid
				do {
					System.out.println("Input three digit:");
					sc = new Scanner(System.in);
					inputedData = sc.nextLine();
					inputedData = inputedData.toUpperCase();
				
					// if user inputed "q" or "Q" then quit
					if(inputedData.equals("Q")) return;

					// if the last operand is invalid then throw exception
					try {
						if(!isValidThirdNumber(inputedData, arabic)) {
							throw new InvalidDataException("Invalid Data!"); 
						}
					}
					catch(InvalidDataException e) {
						System.out.println(e);
					}
				} while(!isValidThirdNumber(inputedData, arabic));
			
				if(arabic) num3 = Integer.parseInt(inputedData);
				else num3 = romanToArabic(inputedData);
			
				// count result
				aResult = opWithThree(num1, num2, num3, operation1, operation2);
			
				// if user inputed Arabic numerals then print Arabic result;
				if(arabic) {
					System.out.println("Result: " + aResult);
				}
			
				// if user inputed Roman numerals then print Roman result;
				else {
					rResult = arabicToRoman(aResult);
					System.out.println("Result: " + rResult);
				}
			}
		}
	}
}