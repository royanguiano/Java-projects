import java.util.concurrent.PriorityBlockingQueue;


public class rightBracket extends Operator {
	int priorityLevel = 5;

	@Override
	public int priority() {
		// TODO Auto-generated method stub
		return priorityLevel;
	}

	@Override
	public Operand execute(Operand op1, Operand op2) {
		// TODO Auto-generated method stub
		System.out.println("R");
		return null;
	}

}
