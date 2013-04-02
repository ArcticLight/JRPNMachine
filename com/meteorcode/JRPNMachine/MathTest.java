/**
 * 
 */
package com.meteorcode.JRPNMachine;

import com.meteorcode.JRPNMachine.StackMember.Operation;

/**
 * @author hawk
 *
 */
public class MathTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		java.util.Stack<StackMember> stack = new java.util.Stack<StackMember>();
		
		stack.push(new StackMember(1));
		stack.push(new StackMember(1));
		stack.push(new StackMember(Operation.ADD));
		
		RPNMachine.eval(stack);
		
		if (stack.peek().getValue() != 2.0) {
			System.err.println ("Unexpected value, " + stack.peek().getValue());
		}	else {
			System.out.println ("Expected value, " + stack.peek().getValue());
		}
		
		stack.push(new StackMember(4));
		stack.push(new StackMember(1));
		stack.push(new StackMember(Operation.ADD));
		
		RPNMachine.eval(stack);
		
		if (stack.peek().getValue() != 5.0) {
			System.err.println ("Unexpected value, " + stack.peek().getValue());
		}	else {
			System.out.println ("Expected value, " + stack.peek().getValue());
		}
		
		stack.push(new StackMember(5));
		stack.push(new StackMember(10));
		stack.push(new StackMember(Operation.MULTIPLY));
		
		RPNMachine.eval(stack);
		
		if (stack.peek().getValue() != 50.0) {
			System.err.println ("Unexpected value, " + stack.peek().getValue());
		}	else {
			System.out.println ("Expected value, " + stack.peek().getValue());
		}

	}

}
