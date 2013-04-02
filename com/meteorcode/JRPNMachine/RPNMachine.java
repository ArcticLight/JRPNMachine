/**
  * A Java reverse-polish notation calculator.
  * @author Hawk Weisman
  * @author Max Clive
  * 
  */

package com.meteorcode.JRPNMachine;

import com.meteorcode.JRPNMachine.StackMember.Operation;

public class RPNMachine {
	
	protected static java.util.Stack<StackMember> instructionStack = new java.util.Stack<StackMember>();
	
	/**
	 * Parses a String into a StackMember and pushes it to the instructionStack, and then evals the stack.
	 * @param inputString the String to be parsed
	 */
	public static void eval (String inputString) throws NumberFormatException {
		switch (inputString) {
			case "+":
				instructionStack.push(new StackMember (Operation.ADD));
				break;
			case "-":
				instructionStack.push(new StackMember (Operation.SUBTRACT));
				break;
			case "/":
				instructionStack.push(new StackMember (Operation.DIVIDE));
				break;
			case "*":
				instructionStack.push(new StackMember (Operation.MULTIPLY));
				break;
			case "%":
				instructionStack.push(new StackMember (Operation.MODULO));
				break;
			case "delete":
				instructionStack.push(new StackMember (Operation.DELETE));
				break;	
			default:
				instructionStack.push(new StackMember (Double.parseDouble(inputString)));
				break;
		}
		eval();
	}
		
	/**
	 * Evaluates the stack
	 */
	public static void eval () {
		StackMember current = instructionStack.pop();
		double a, b;
		switch(current.getOp()) {
			case DATA:
				instructionStack.push(current);
				break;
			case ADD:
				b = nextValue();
				a = nextValue();
				instructionStack.push (new StackMember (a + b));
				break;
			case SUBTRACT:
				b = nextValue();
				a = nextValue();
				instructionStack.push (new StackMember (a - b));
				break;
			case MULTIPLY:
				b = nextValue();
				a = nextValue();
				instructionStack.push (new StackMember (a * b));
				break;
			case DIVIDE:
				b = nextValue();
				a = nextValue();
				instructionStack.push (new StackMember (a / b));
				break;
			case MODULO:
				b = nextValue();
				a = nextValue();
				instructionStack.push (new StackMember (a % b));
				break;
			case DELETE:
				instructionStack.pop();
			}
		}
	
	
	/**
	 * shows the state of the stack
	 * @return the state of the stack
	 */
	public String showState () {
		return instructionStack.toString();
	}
	
	/**
	 * gets the next operand on the instructionStack.
	 * @return the next operand on the instructionStack
	 * @throws ArithmeticException if the next operand on the instructionStack is not data.
	 */
	private static double nextValue () {
		StackMember next = instructionStack.pop();
		next.notData();
		return next.getValue();
	}
}