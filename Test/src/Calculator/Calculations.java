package Calculator;

public class Calculations {
	
	// for only two operand
	public static int opWithTwo(int a, int b, String str) {
		
		switch(str) {
			case "+":
				return a + b;
			case "-":
				return a - b;
			case "*":
				return a * b;
			case "/":
				if(b != 0) return a / b;
				else {
					try {
						throw new InvalidDataException("try / by 0");
					}
					catch (InvalidDataException e) {
						System.out.println(e);
						return 0;
					}
				}
			default:
				return 0;
		}
	}
	
	// for three operand
	public static int opWithThree(int a, int b, int c, String oneOperation, String twoOperation) {
		
		switch(oneOperation) {
			case "+":
				switch(twoOperation) {
					case "+":
						return a + b + c;
					case "-":
						return a + b - c;
					case "*":
						return a + b * c;
					case "/":
						if(c != 0) 	return a + b / c;
						else {
							try {
								throw new InvalidDataException("try / by 0");
							}
							catch (InvalidDataException e) {
								System.out.println(e);
								return 0;
							}
						}
					default:
						return 0;
				}
			case "-":
				switch(twoOperation) {
					case "+":
						return a - b + c;
					case "-":
						return a - b - c;
					case "*":
						return a - b * c;
					case "/":
						if(c != 0) return a - b / c;
						else {
							try {
								throw new InvalidDataException("try / by 0");
							}
							catch (InvalidDataException e) {
								System.out.println(e);
								return 0;
							}
						}
					default:
						return 0;
				}
			case "*":
				switch(twoOperation) {
					case "+":
						return a * b + c;
					case "-":
						return a * b - c;
					case "*":
						return a * b * c;
					case "/":
						if(c != 0) return a * b / c;
						else {
							try {
								throw new InvalidDataException("try / by 0");
							}
							catch (InvalidDataException e) {
								System.out.println(e);
								return 0;
							}
						}
					default:
						return 0;
				}
			case "/":
				switch(twoOperation) {
					case "+":
						if(b != 0) return a / b + c;
						else {
							try {
								throw new InvalidDataException("try / by 0");
							}
							catch (InvalidDataException e) {
								System.out.println(e);
								return 0;
							}
						}
					case "-":
						if(b != 0) return a / b - c;
						else {
							try {
								throw new InvalidDataException("try / by 0");
							}
							catch (InvalidDataException e) {
								System.out.println(e);
								return 0;
							}
						}
					case "*":
						if(b != 0) return (a / b) * c;
						else {
							try {
								throw new InvalidDataException("try / by 0");
							}
							catch (InvalidDataException e) {
								System.out.println(e);
								return 0;
							}
						}
					case "/":
						if((b != 0) && (c != 0)) return a / b / c;
						else {
							try {
								throw new InvalidDataException("try / by 0");
							}
							catch (InvalidDataException e) {
								System.out.println(e);
								return 0;
							}
						}
					default:
						return 0;
				}
			default:
				return 0;
		}
	}
}