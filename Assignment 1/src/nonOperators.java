
public class nonOperators extends Operator{

	private static String token;
	String currenttoken;
	Operator nonOperator = new nonOperators();
	int priorityLevel; 
	

	public nonOperators() {
		super(token);
	
	}

	@Override
	public int priority() {
		return priorityLevel;
		// TODO Auto-generated method stub
	
	}

	@Override
	public Operand execute(Operand op1, Operand op2) {
		// TODO Auto-generated method stub
		return null;
	}
}
