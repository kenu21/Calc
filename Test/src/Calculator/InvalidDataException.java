// For throw exception

package Calculator;

public class InvalidDataException extends Exception {
	
	private String exception;
	
	InvalidDataException(String str) {
		
		exception = str;
		
	}
	
	public String toString() {
		
		return exception;
	
	}
}