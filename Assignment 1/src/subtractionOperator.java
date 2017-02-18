public class subtractionOperator extends Operator {
	int priorityLevel = 2;

	public subtractionOperator() {

	}

	@Override
	public int priority() {
		// TODO Auto-generated method stub
		return priorityLevel;
	}

	@Override
	public Operand execute(Operand op1, Operand op2) {
		// String sumValue = "";
				int val = op1.getValue() - op2.getValue();

				// TODO Auto-generated method stub
				Operand sum = new Operand(Integer.toString(val));

				System.out.print("total: " + (op1.getValue() - op2.getValue()));
				System.out.println();
				// return new operator(sum);
				return sum;
	}
}
