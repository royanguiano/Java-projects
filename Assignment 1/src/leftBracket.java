
public class leftBracket extends Operator {
	int priorityLevel =  1; 

	@Override
	public int priority() {
		// TODO Auto-generated method stub
		return priorityLevel;
	}

	@Override
	public Operand execute(Operand op1, Operand op2) {
		// TODO Auto-generated method stub
		System.out.println("L");
		return null;
	}


}
