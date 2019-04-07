// For translate Arabic numerals to Roman numerals and vice versa.

package Calculator;

import java.util.TreeMap;

public class Roman {
	
	// translate Roman numerals from I to X to Arabic numerals
	public static int romanToArabic(String str) {
		
		switch(str) {
			case "I":
				return 1;
			case "II":
				return 2;
			case "III":
				return 3;
			case "IV":
				return 4;
			case "V":
				return 5;
			case "VI":
				return 6;
			case "VII":
				return 7;
			case "VIII":
				return 8;
			case "IX":
				return 9;
			case "X":
				return 10;
			default:
				return 0;
		}	
		
	}
	
	private static TreeMap<Integer, String> map = new TreeMap<>();
	
	  static {

	        map.put(1000, "M");
	        map.put(900, "CM");
	        map.put(500, "D");
	        map.put(400, "CD");
	        map.put(100, "C");
	        map.put(90, "XC");
	        map.put(50, "L");
	        map.put(40, "XL");
	        map.put(10, "X");
	        map.put(9, "IX");
	        map.put(5, "V");
	        map.put(4, "IV");
	        map.put(1, "I");

	    }
	  
	  	// Translate Arabic numerals from 1 till 1000 to Roman numerals
	    public static String arabicToRoman(int num) {
	    	
	    	// if try translate a numeral < 1 or > 1000 throw exception.
	    	try {
	    		if(num < 1 || num > 1000) {
	    			throw new InvalidDataException("1>Value>1000");
	    		}
	    	}
	    	catch(InvalidDataException e) {
	    		System.out.println(e);
	    		return "Not value";
	    	}
	    	
	        int i =  map.floorKey(num);
	        if(num == i ) { // if numerals is in TreeMap then get it.
	            return map.get(num);
	        }
	        
	        /*
	        	if numerals isn't in TreeMap then
	     		get the greatest key less than given key and + recursion 
	         */
	        return map.get(i) + arabicToRoman(num-i);
	    }
}