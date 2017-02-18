import java.util.logging.Level;

public class additionOperator extends Operator {

	int prioritylevel = 2;

	public additionOperator() {

	}

	@Override
	public int priority() {
		return this.prioritylevel;
	}

	@Override
	public Operand execute(Operand op1, Operand op2) {
		// String sumValue = "";
		int val = op1.getValue() + op2.getValue();

		// TODO Auto-generated method stub
		Operand sum = new Operand(Integer.toString(val));

		System.out.print("total: " + (op1.getValue() + op2.getValue()));
		System.out.println();

		// return new operator(sum);
		return sum;
	}
}
