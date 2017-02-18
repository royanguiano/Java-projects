public class Operand {
	private Operand tempOperand;
	public String currentnumber = "";

	public Operand(String token) {
		this.currentnumber = token;
		return;
	}

	public Operand Operand(int value) {
		tempOperand = new Operand(currentnumber);
		return tempOperand; 
	}
 
	public int getValue() {
		return Integer.parseInt(currentnumber);
	}

	public static boolean check(String token) {
		// check if token is an number
		int operandNumber;

		try {
			operandNumber = Integer.parseInt(token);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			return false; 
		}
		return true; 
		
	}
}
