public class poundSign extends Operator {
	static String token;

	int priorityLevel = 0;

	public poundSign() {

	}

	@Override
	public int priority() {
		// TODO Auto-generated method stub
		return priorityLevel;
	}

	@Override
	public Operand execute(Operand op1, Operand op2) {
		// TODO Auto-generated method stub
		System.out.println();

		return null;
	}

}
