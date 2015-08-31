import java.util.*;
import java.lang.Math;
import java.lang.Exception;

public class Calculate {

	private static final String MESSAGE_NO_OF_ARGS = "Incorrect number of arguments";
	private static final String MESSAGE_INVALID = "Invalid inputs";
	private static final String MESSAGE_DIV_ZERO = "Division by zero";
	
	public static void main(String[] args) {
		System.out.println(runProgram(args));
	}

	private static String runProgram(String[] args) {
		if (args.length != 3) {
			return MESSAGE_NO_OF_ARGS;
		} else {
			try {
				int operand1 = Integer.parseInt(args[0]);
				int operand2 = Integer.parseInt(args[2]);
				return getOperation(args, args[1]);
			} catch (NumberFormatException e) {
				return MESSAGE_INVALID;
			}
		}
	}

	private static String getOperation(String[] args, String operator) {
		switch (operator) {
		case "+":
			return String.valueOf(Integer.parseInt(args[0]) + Integer.parseInt(args[2]));
		case "-":
			return String.valueOf(Integer.parseInt(args[0]) - Integer.parseInt(args[2]));
		case "*":
			return String.valueOf(Integer.parseInt(args[0]) * Integer.parseInt(args[2]));
		case "/":
			try {
				return String.valueOf(Integer.parseInt(args[0]) / Integer.parseInt(args[2]));
			} catch (ArithmeticException e) {
				return MESSAGE_DIV_ZERO;
			}
		case "**":
			return String.valueOf((int)Math.pow(Integer.parseInt(args[0]), Integer.parseInt(args[2])));
		default:
			return MESSAGE_INVALID;
		}
	}
}
