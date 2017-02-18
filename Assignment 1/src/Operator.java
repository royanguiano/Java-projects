import java.util.HashMap;

public abstract class Operator {
	// The Operator class should contain an instance of a HashMap
	// This map will use keys as the tokens we're interested in,
	// and values will be instances of the Operators.

	private static HashMap<String, Operator> operators = new HashMap<String, Operator>();

	// Example:
	// Where does this declaration go?
	// What should its access level be?
	// Class or instance variable? Is this the right declaration?
	// HashMap operators = new HashMap();
	// operators.put( "+", new AdditionOperator() );
	// operators.put( "-", new SubtractionOperator() );

	public static void fillHashMap() {
		operators.put("#", new poundSign());
		operators.put("!", new exclamationMark());
		operators.put("+", new additionOperator());
		operators.put("-", new subtractionOperator());
		operators.put("/", new divisionOperator());
		operators.put("*", new multiplicationOperator());
		operators.put("^", new powerofOperator());
		operators.put("(", new leftBracket());
		operators.put(")", new rightBracket());

	}

	public static Operator getValueFromHashMap(String currentToken) {
		
		return operators.get(currentToken);

	}

	public Operator() {

		return;
	}

	public abstract int priority();

	public abstract Operand execute(Operand op1, Operand op2);

	public static boolean check(String token) {
		int operandNumber;
		try {
			operandNumber = Integer.parseInt(token);

			return false;
		} catch (NumberFormatException e) {
			// TODO: handle exception
			return true;
		}
	}
}