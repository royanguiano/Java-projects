
public class powerOperator extends Operator {

	private static String token;
	int priorityLevel;
	powerOperator pobj = new powerOperator();

	public powerOperator() {
		super(token);
		// TODO Auto-generated constructor stub
		pobj.priorityLevel = 3; 
	}

	@Override
	public int priority() {
		// TODO Auto-generated method stub
		return priorityLevel;
	}

	@Override
	public Operand execute(Operand op1, Operand op2) {
		// TODO Auto-generated method stub
		return null;
	}
}
