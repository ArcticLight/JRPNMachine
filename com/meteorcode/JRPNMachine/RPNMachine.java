/**
  * A Java reverse-polish notation calculator.
  * 
  * @version 2.0
  * @author Hawk Weisman
  * @author Max Clive
  * 
  */

package com.meteorcode.JRPNMachine;

import com.meteorcode.JRPNMachine.StackMember.Operation;

public class RPNMachine {
	
	public final String R_VERSION = "2.0";
	
	protected java.util.Stack<StackMember> instructionStack;
	
	/**
	 * 0-param constructor
	 */
	public RPNMachine () {
		this.instructionStack = new java.util.Stack<StackMember>();
	}
	
	/**
	 * Parses a String into a StackMember and pushes it to the instructionStack, and then evals the stack.
	 * @param inputString the String to be parsed
	 */
	public void eval (String inputString) throws NumberFormatException {
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
			case "^":
				instructionStack.push(new StackMember (Operation.POWER));
				break;
			case "c":
				instructionStack.push(new StackMember (Operation.CLEAR));
				break;	
			case "clear":
				instructionStack.push(new StackMember (Operation.CLEAR));
				break;	
			case "ca":
				instructionStack.push(new StackMember (Operation.CLEAR_ALL));
				break;	
			case "clearall":
				instructionStack.push(new StackMember (Operation.CLEAR_ALL));
				break;	
			default:
				instructionStack.push(new StackMember (inputString));
				break;
		}
		eval();
	}
		
	/**
	 * Evaluates the stack
	 */
	public void eval () {
		StackMember current = instructionStack.pop();
		Value a;
		Value b;
		switch(current.getOp()) {
			case DATA:
				instructionStack.push(current);
				break;
			case ADD:
				b = nextValue();
				a = nextValue();
				instructionStack.push (new StackMember (Value.add(a, b)));
				break;
			case SUBTRACT:
				b = nextValue();
				a = nextValue();
				instructionStack.push (new StackMember (Value.subtract(a, b)));
				break;
			case MULTIPLY:
				b = nextValue();
				a = nextValue();
				instructionStack.push (new StackMember (Value.multiply(a, b)));
				break;
			case DIVIDE:
				b = nextValue();
				a = nextValue();
				instructionStack.push (new StackMember (Value.divide(a, b)));
				break;
			case POWER:
				b = nextValue();
				a = nextValue();
				instructionStack.push (new StackMember (Value.power(a, b)));
				break;
			case CLEAR:
				instructionStack.pop();
				break;
			case CLEAR_ALL:
				while (!instructionStack.isEmpty())
					instructionStack.pop();
				break;
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
	 * shows the next value on the stack
	 * @return the next value on the stack.
	 */
	public Value showNextValue () {
		StackMember next = instructionStack.peek();
		next.notData();
		return next.getValue();
	}
	
	/**
	 * pops the next operand on the instructionStack.
	 * @return the next operand on the instructionStack
	 * @throws ArithmeticException if the next operand on the instructionStack is not data.
	 */
	private Value nextValue () {
		StackMember next = instructionStack.pop();
		next.notData();
		return next.getValue();
	}
}