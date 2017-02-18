import java.awt.RenderingHints.Key;
import java.util.*;

public class Evaluator {
	private Stack<Operand> operandStack;
	private Stack<Operator> operatorStack;

	private StringTokenizer tokenizer;
	private static final String DELIMITERS = "()+-*^/#! ";

	public Evaluator() {
		operandStack = new Stack<>();
		operatorStack = new Stack<>();
		Operator.fillHashMap();

	}

	public int eval(String expression) {
		expression = expression.replaceAll("\\s+", "");
		System.out.println("Expression: " + expression);
		Operator newOperator = null;
		String token;

		// The 3rd argument is true to indicate that the delimiters should be
		// used as tokens, too. But, we'll need to remember to filter out
		// spaces.
		this.tokenizer = new StringTokenizer(expression, DELIMITERS, true);

		// initialize operator stack - necessary with operator priority schema
		// the priority of any operator in the operator stack other than
		// the usual mathematical operators - "+-*/" - should be less than the
		// priority
		// of the usual operators

		// TODO Operator is abstract - this will need to be fixed:

		// When is it a good time to add the "!" operator? last because priority
		// level
		
		newOperator = Operator.getValueFromHashMap("#");
		newOperator = Operator.getValueFromHashMap("!");
		operatorStack.push(newOperator);
		 operatorStack.push(newOperator);

		while (this.tokenizer.hasMoreTokens()) {
			// filter out spaces
			if (!(token = this.tokenizer.nextToken()).equals(" ")) {
				// check if token is an operand
				if (Operand.check(token)) {
					// If an operand token is scanned, an Operand object is
					// created from the token, and pushed to the operand Stack

					operandStack.push(new Operand(token));
					
					// if( its the end of the tokenizer list){

					if (!this.tokenizer.hasMoreTokens()) {
						dOperations();
						break;
					}

				} else if (token.equals(")")) {
					do {
						Operator oldOpr = operatorStack.pop();
						Operand op2 = operandStack.pop();
						Operand op1 = operandStack.pop();
						operandStack.push(oldOpr.execute(op1, op2));
						if (operandStack.size() == 1) {
							break;
						}
					} while (operatorStack.peek().equals("("));

					operatorStack.pop();

					if (!this.tokenizer.hasMoreTokens()) {
						dOperations();
						break;
					}
				} else {

					// checking if token is valid
					if (!Operator.check(token)) {
						System.out.println("*****invalid token******");
						System.exit(1);
					}
					// if( its the end of the tokenizer list){

					if (!this.tokenizer.hasMoreTokens()) {
						dOperations();
						break;
					}

					newOperator = Operator.getValueFromHashMap(token);
					

					if (operatorStack.isEmpty()) {
						operatorStack.push(newOperator);
					} else {

						if (token.equals("(")) {
							operatorStack.push(newOperator);

						} else {
							while (operatorStack.peek().priority() >= newOperator
									.priority()) {
								Operator oldOpr = operatorStack.pop();
								Operand op2 = operandStack.pop();
								Operand op1 = operandStack.pop();
								operandStack.push(oldOpr.execute(op1, op2));

								if (operandStack.size() == 1) {
									break;
								}
							}
							operatorStack.push(newOperator);
						}
					}
				}
			}
		}
		
		int result = operandStack.peek().getValue();
		return result;
	}

	public void dOperations() {
		while (!operandStack.isEmpty()) {
			Operator oldOpr = operatorStack.pop();
			Operand op2 = operandStack.pop();
			Operand op1 = operandStack.pop();
			operandStack.push(oldOpr.execute(op1, op2));
			
			if (operatorStack.peek().equals("#")) {
				break;
			}
			if (operandStack.size() == 1) {
				break;
			}

		}
	}

}
