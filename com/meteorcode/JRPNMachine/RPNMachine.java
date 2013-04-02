/**
  * A Java reverse-polish notation calculator.
  * @author Hawk Weisman
  * @author Max Clive
  * 
  */

package com.meteorcode.JRPNMachine;

import com.meteorcode.JRPNMachine.StackMember.Operation;

public class RPNMachine {
	
	/**
	 * Parses a String into a StackMember and pushes it to the given Stack
	 * @param inputString the String to be parsed
	 * @param stack the RPNMachine instruction stack to which StackMembers should be pushed.
	 */
	public void parseInput (String inputString, java.util.Stack<StackMember> stack) throws NumberFormatException {
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
		StackMember next;
		double a, b;
		switch(current.getOp()) {
			case DATA:
				stack.push(current);
				break;
			case ADD:
				next = stack.pop();
				next.notData();
				a = next.getValue();
				next = stack.pop();
				next.notData();
				b = next.getValue();
				stack.push (new StackMember (a + b));
				break;
			case SUBTRACT:
				next = stack.pop();
				next.notData();
				a = next.getValue();
				next = stack.pop();
				next.notData();
				b = next.getValue();
				stack.push (new StackMember (a - b));
				break;
			case MULTIPLY:
				next = stack.pop();
				next.notData();
				a = next.getValue();
				next = stack.pop();
				next.notData();
				b = next.getValue();
				stack.push (new StackMember (a * b));
				break;
			case DIVIDE:
				next = stack.pop();
				next.notData();
				a = next.getValue();
				next = stack.pop();
				next.notData();
				b = next.getValue();
				stack.push (new StackMember (a / b));
				break;
			case MODULO:
				next = stack.pop();
				next.notData();
				a = next.getValue();
				next = stack.pop();
				next.notData();
				b = next.getValue();
				stack.push (new StackMember (a % b));
				break;
			case DELETE:
				stack.pop();
			}
		}
	}