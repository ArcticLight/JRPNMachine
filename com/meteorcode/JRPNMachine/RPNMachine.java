/**
  * A Java reverse-polish notation calculator.
  * @author Hawk Weisman
  * @author Max Clive
  * 
  */

package com.meteorcode.JRPNMachine;

public class RPNMachine {
	
	/**
	 * Parses a String into a StackMember and pushes it to the given Stack
	 * @param inputString the String to be parsed
	 * @param stack the RPNMachine instruction stack to which StackMembers should be pushed.
	 */
	public void parseInput (String inputString, java.util.Stack<StackMember> stack) throws NumberFormatError {
		switch (inputString) {
			case "+":
				stack.push(new StackMember (Operation.ADD));
				break;
			case "-":
				stack.push(new StackMember (Operation.SUBTRACT));
				break;
			case "/":
				stack.push(new StackMember (Operation.DIVIDE));
				break;
			case "*":
				stack.push(new StackMember (Operation.MULTIPLY));
				break;
			case "%":
				stack.push(new StackMember (Operation.MODULO));
				break;
			case "delete":
				stack.push(new StackMember (Operation.DELETE));
				break;	
			default:
				stack.push(new StackMember (Double.parseDouble(inputString)));
				break;
		}
	}
		
	/**
	 * Evaluates the top member of the stack given as a parameter
	 * @param the stack to be evaluated
	 */
	public void eval (java.util.Stack<StackMember> stack) {
		StackMember current = stack.pop();
		double a, b;
		switch(current.getOp()) {
			case Operation.DATA:
				stack.push(current);
				break;
			case Operation.ADD:
				StackMember next = stack.pop();
				next.notData();
				a = next.getValue();
				next = stack.pop();
				next.notData();
				b = next.getValue();
				stack.push (new StackMember (a + b));
				break;
			case Operation.SUBTRACT:
				StackMember next = stack.pop();
				next.notData();
				a = next.getValue();
				next = stack.pop();
				next.notData();
				b = next.getValue();
				stack.push (new StackMember (a - b));
				break;
			case Operation.MULTIPLY:
				StackMember next = stack.pop();
				next.notData();
				a = next.getValue();
				next = stack.pop();
				next.notData();
				b = next.getValue();
				stack.push (new StackMember (a * b));
				break;
			case Operation.DIVIDE:
				StackMember next = stack.pop();
				next.notData();
				a = next.getValue();
				next = stack.pop();
				next.notData();
				b = next.datavalue();
				stack.push (new StackMember (a / b));
				break;
			case Operation.MODULO:
				StackMember next = stack.pop();
				next.notData();
				a = next.getValue();
				next = stack.pop();
				next.notData();
				b = next.datavalue();
				stack.push (new StackMember (a % b));
				break;
			case Operation.DELETE:
				stack.pop(next);
			}
		}
	}