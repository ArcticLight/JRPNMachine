/**
  * A Java reverse-polish notation calculator.
  * @author Hawk Weisman
  * @author Max Clive
  * 
  */

package com.meteorcode.JRPNMachine;

public class RPNMachine {
		
	/**
	 * Evaluates the top member of the stack given as a parameter
	 * @param the stack to be evaluated
	 */
	public void eval (java.util.Stack<StackMember> stack) {
		StackMember current = stack.pop();
		switch(current.op) {
			case DATA:
				stack.push(current);
				break;
			case ADD:
				StackMember next = stack.pop();
				next.notData();
				double a = next.getValue();
				next = stack.pop();
				next.notData();
				double b = next.getValue();
				stack.push (new StackMember (a + b));
				break;
			case SUBTRACT:
				StackMember next = stack.pop();
				next.notData();
				double a = next.getValue();
				next = stack.pop();
				next.notData();
				double b = next.getValue();
				stack.push (new StackMember (a - b));
				break;
			case MULTIPLY:
				StackMember next = stack.pop();
				next.notData();
				double a = next.getValue();
				next = stack.pop();
				next.notData();
				double b = next.getValue();
				stack.push (new StackMember (a * b));
				break;
			case DIVIDE:
				StackMember next = stack.pop();
				next.notData();
				double a = next.getValue();
				next = stack.pop();
				next.notData();
				double b = next.datavalue();
				stack.push (new StackMember (a / b));
				break;
			case MODULO:
				StackMember next = stack.pop();
				next.notData();
				double a = next.getValue();
				next = stack.pop();
				next.notData();
				double b = next.datavalue();
				stack.push (new StackMember (a % b));
				break;
		}
	}
}
